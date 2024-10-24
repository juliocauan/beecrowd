import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N, custoPorDia, lucro, maxLucro, lucroDoDia[];
        while(sc.hasNextInt()) {
            N = sc.nextInt();
            custoPorDia = sc.nextInt();
            lucroDoDia = new int[N];
            maxLucro = 0;

            for(int i = 0; i < N; i++)
                lucroDoDia[i] = sc.nextInt() - custoPorDia;
            
            for(int a = 0; a < N; a++) {
                lucro = 0;
                for(int b = a; b < N; b++) {
                    lucro += lucroDoDia[b];
                    if(lucro > maxLucro) maxLucro = lucro;
                }
            }

            sb.append(maxLucro).append("\n");
        }

        System.out.print(sb.toString());
        sc.close();
    }
 
}