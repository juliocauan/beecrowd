import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        
        while (sc.hasNextLine()) {
            String regex = sc.nextLine().replace(".", "");
            MatcherTask.pattern = Pattern.compile(regex);
            int P = Integer.parseInt(sc.nextLine());

            List<CompletableFuture<String>> events = new ArrayList<>();
            
            for(int i = 0; i < P; i++) {
                events.add(MatcherTask.matches(sc.nextLine()));
            }

            List<String> results = CompletableFuture.allOf(events.toArray(new CompletableFuture<?>[P]))
                .thenApply(v -> events.stream().map(CompletableFuture::join).collect(Collectors.toList())).join();

            for (int i = 0; i < P; i++) {
                System.out.println(results.get(i));
            }

            System.out.println();
        }

        MatcherTask.asyncExecutor.shutdownNow();
        sc.close();
    }
 
}

class MatcherTask {
    static Pattern pattern;
    final static ExecutorService asyncExecutor = Executors.newFixedThreadPool(150);

    static CompletableFuture<String> matches(String word) {
        CompletableFuture<String> cf = new CompletableFuture<>();
        asyncExecutor.execute(() -> cf.complete(pattern.matcher(word).matches() ? "Y" : "N"));
        return cf;
    }

}