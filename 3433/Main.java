import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N, carta1Joao, carta2Joao, carta1Maria, carta2Maria, totalJoao = 0, totalMaria = 0, cartaFinal = -1;
        int[] cartas = new int[13];

        for(int i = 0; i < 13; i++)
            cartas[i] = 4;

        N = sc.nextInt();

        carta1Joao = sc.nextInt();
        carta2Joao = sc.nextInt();

        totalJoao += ((carta1Joao >= 10) ? 10 : carta1Joao) + ((carta2Joao >= 10) ? 10 : carta2Joao);
        
        carta1Maria = sc.nextInt();
        carta2Maria = sc.nextInt();
        totalMaria += ((carta1Maria >= 10) ? 10 : carta1Maria) + ((carta2Maria >= 10) ? 10 : carta2Maria);

        cartas[carta1Joao - 1]--;
        cartas[carta2Joao - 1]--;
        cartas[carta1Maria - 1]--;
        cartas[carta2Maria - 1]--;

        while (N-- != 0) {
            int proximaCarta = sc.nextInt();
            int valorCarta = (proximaCarta >= 10) ? 10 : proximaCarta;
            cartas[proximaCarta - 1]--;
            totalMaria += valorCarta;
            totalJoao += valorCarta;
        }

        for(int i = 0; i < 13; i++) {
            int valorCarta = (i >= 10) ? 10 : (i + 1);
            if(cartas[i] == 0) continue;
            if(valorCarta + totalMaria > 23) break;
            if( (valorCarta + totalMaria == 23) || (valorCarta + totalJoao > 23) ) {
                cartaFinal = valorCarta;
                break;
            } 
        }

        System.out.println(cartaFinal);

        sc.close();
    }
 
}