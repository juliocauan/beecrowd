import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int NC = sc.nextInt(), caso = 0, n, k, i;
        List<Integer> suicidas = new ArrayList<>();
        
        while (++caso <= NC) {
            n = sc.nextInt();
            k = sc.nextInt() - 1;
            suicidas.clear();
            for(i = 1; i <= n; i++)
                suicidas.add(i);
            i = 0;

            while (suicidas.size() > 1) {
                i = (i + k) % suicidas.size();
                suicidas.remove(i);
            }
            
            sb.append("Case ").append(caso).append(": ").append(suicidas.get(0)).append("\n");
        }

        System.out.print(sb.toString());
        sc.close();
    }
}