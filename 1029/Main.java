import java.util.Scanner;

public class Main {

    private static int calls;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(), X, fib;
        while (N-- != 0) {
            calls = -1;
            X = sc.nextInt();
            fib = fib(X);
            System.out.println(String.format("fib(%d) = %d calls = %d", X, calls, fib));
        }
        sc.close();
    }

    private static int fib(int n) {
        calls++;
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n-1) + fib(n-2);
    }
}