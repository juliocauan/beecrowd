import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    // Limite definido pelo problema (1 <= x,y <= 10^6) + margem de 2
    static final int LIMITE = 1_000_002;
    
    // Aloca array de 0 até LIMITE de booleanos para saber se N é primo
    static final boolean[] PRIMOS = new boolean[LIMITE + 1];

    // Aloca array de 0 até LIMITE de inteiros que representa a QUANTIDADE de primos gêmeos
    // entre 0 e N
    static final int[] GEMEOS = new int[LIMITE + 1];

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int N = sc.nextInt(), x, y, aux;
        
        // Precomputa todas as saídas possíveis
        precomputarPrimos();
        precomputarGemeos();

        while (N-- != 0) {
            x = sc.nextInt();
            y = sc.nextInt();

            // Ordena para x < y
            if (x > y) {
                aux = x;
                x = y;
                y = aux;
            }

            // A QUANTIDADE de primos gêmeos entre X e Y é
            // a subtração da QUANTIDADE de Y pela QUANTIDADE de X-1
            sb.append(GEMEOS[y] - GEMEOS[x-1]).append("\n");
        }
        
        System.out.print(sb.toString());
        sc.close();
    }

    // Algoritmo de Crivo de Eratóstenes
    static void precomputarPrimos() {

        // Assume que todos os números são primos
        Arrays.fill(PRIMOS, true);

        // Define que 0 e 1 não são primos
        PRIMOS[0] = false;
        PRIMOS[1] = false;

        // Itera de 2 até raiz quadrada de LIMITE
        for (int p = 2; p * p <= LIMITE; p++) {

            // Se p for PRIMO, todos os seus múltiplos não são primos
            // Faça isso até i chegar em LIMITE
            if (PRIMOS[p]) {
                for (int i = p * p; i <= LIMITE; i += p) {
                    PRIMOS[i] = false;
                }
            }
        }
    }

    // N só é primo gêmeo se N for primo e
    // N + 2 OU N - 2 também for primo
    static boolean ehPrimoGemeo(int x) {
        if (PRIMOS[x] && (PRIMOS[x + 2] || PRIMOS[x - 2]))
            return true;

        return false;
    }

    // Algoritmo que calcula a QUANTIDADE de primos gêmeos entre 0 e N
    static void precomputarGemeos() {

        // 0 e 1 não são primos gêmeos
        GEMEOS[0] = 0;
        GEMEOS[1] = 0;

        // Itera de 2 até LIMITE
        for (int i = 2; i <= LIMITE; i++) {
            
            // A QUANTIDADE de primos gêmeos de N é, pelo menos, a mesma de N-1
            GEMEOS[i] = GEMEOS[i-1];

            // Se N for primo gêmeo, a QUANTIDADE de primos gêmeos de N é 1 a mais que N-1
            if (ehPrimoGemeo(i))
                GEMEOS[i]++;
        }
    }

}