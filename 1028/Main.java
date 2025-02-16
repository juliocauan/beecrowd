import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            int f1, f2;
            f1 = sc.nextInt();
            f2 = sc.nextInt();
            System.out.println(calcularMDC(f1, f2));
        }
        sc.close();
    }

    static int calcularMDC(int a, int b) {
        int temp;
        if(b > a) {
            temp = a;
            a = b;
            b = temp;
        }

        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        return a;
    }
 
}