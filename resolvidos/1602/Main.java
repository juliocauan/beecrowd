import java.io.IOException;
import java.util.Scanner;

public class Main {

    static int[] tabela = new int[2000000];
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N, hiperprimos, temp;

        while (sc.hasNext()) {
            N = sc.nextInt();
            hiperprimos = 0;

            if(tabela[N-1] != 0) {
                System.out.println(tabela[N-1]);
                continue;
            }

            for(int i = 2; i <= N; i++) {
                if(tabela[i-1] != 0) {
                    hiperprimos = tabela[i-1];
                    continue;
                }

                temp = i;
                if(isQuadradoPerfeito(i)) {
                    temp = getDivisoresQuadradoPerfeito(i);
                }

                if(isPrimo(temp)) {
                    hiperprimos++;
                }
                
                tabela[i-1] = hiperprimos;
            }
            
            System.out.println(hiperprimos);
        }

        sc.close();
    }

    static boolean isPrimo(int x) {
        if(x <= 1) return false;
        if(x == 2) return true;
        if(x % 2 == 0) return false;

        for(int i = 3; i * i <= x; i += 2) {
            if(x % i == 0) return false;
        }

        return true;
    }

    static boolean isQuadradoPerfeito(int x) {    
        int raiz = (int) Math.sqrt(x);
        return raiz * raiz == x;
    }

    static int getDivisoresQuadradoPerfeito(int x) {
        int raiz = (int) Math.sqrt(x);
        int divisores = 3;

        for (int i = 2; i < raiz; i++) {
            if (x % i == 0) {
                divisores += 2;
            }
        }
        
        return divisores;
    }
 
}