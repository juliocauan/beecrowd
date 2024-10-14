import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while(sc.hasNextInt()) {
            int N = sc.nextInt();
            sc.nextLine();
            for(int test = 0; test < N; test++) {
                char[] word = sc.nextLine().toCharArray();
                sb.setLength(0);
                for(int i = 0; i < word.length; i++) {
                    if(Character.isLetter(word[i])){
                        word[i] += 3;
                    }
                }
                word = sb.append(word).reverse().toString().toCharArray();
                for(int i = word.length/2; i < word.length; i++) {
                    word[i] -= 1;
                }
                System.out.println(word);
            }
        }
        
        sc.close();
    }
 
}