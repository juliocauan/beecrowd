import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.next());
        while (N-- != 0) {
            int N1, N2, D1, D2, X = 0, Y = 0, mdc;
            char op;
            N1 = Integer.parseInt(sc.next());
            sc.next();
            D1 = Integer.parseInt(sc.next());
            op = sc.next().charAt(0);
            N2 = Integer.parseInt(sc.next());
            sc.next();
            D2 = Integer.parseInt(sc.next());

            switch (op) {
                case '-':
                    X = N1*D2 - N2*D1;
                    Y = D1*D2;
                    break;
                case '+':
                    X = N1*D2 + N2*D1;
                    Y = D1*D2;
                    break;
                case '*':
                    X = N1*N2;
                    Y = D1*D2;
                    break;
                case '/':
                    X = N1*D2;
                    Y = N2*D1;
                    break;
            }

            System.out.print(X + "/" + Y + " = ");
            mdc = calcMdc(X, Y);
            System.out.println(X/mdc + "/" + Y/mdc);
        }
        sc.close();
    }

    static int calcMdc(int a, int b) {
        int temp;
        if(b > a) {
            temp = b;
            b = a;
            a = temp;
        }

        while(b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }

        return Math.abs(a);
    }
 
}
