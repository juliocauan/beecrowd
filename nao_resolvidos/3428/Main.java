import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int nBaloes, minTiros;
        minTiros = nBaloes = sc.nextInt();
        Balao[] baloes = new Balao[nBaloes];
        for(int i = 0; i < nBaloes; i++) {
            baloes[i] = new Balao(i+1, sc.nextInt());
        }

        sc.close();
    }
 
}

class Balao {
    int posicao, altura;

    Balao(int posicao, int altura) {
        this.posicao = posicao;
        this.altura = altura;
    }
}
