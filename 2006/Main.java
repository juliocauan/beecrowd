import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt(), acertos = 0;
        for(int i = 0; i < 5; i++) {
            if(sc.nextInt() == T)
                acertos++;
        }
        System.out.println(acertos);
        sc.close();
    }
 
}