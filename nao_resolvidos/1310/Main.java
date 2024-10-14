import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int nDias, custoPorDia, lucro, maxLucro, a, b, temp, receita[];
        while(sc.hasNextInt()) {
            nDias = sc.nextInt();
            custoPorDia = sc.nextInt();
            receita = new int[nDias];
            maxLucro = 0;
            a = b = temp = -1;
            for(int i = 0; i < nDias; i++) {
                receita[i] = sc.nextInt();
                if(receita[i] > custoPorDia && a == b) {
                    if(a == -1) a = b = i;
                    else if(b == a) b = temp = i;
                }
            }

            System.out.println(maxLucro);
        }
        sc.close();
    }
 
}