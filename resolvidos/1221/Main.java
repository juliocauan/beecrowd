import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int n;
        long x;
        n = sc.nextInt();
        while (n-- != 0) {
            x = sc.nextLong();
            System.out.println(isPrime(x) ? "Prime" : "Not Prime");
        }
        sc.close();
    }

    static boolean isPrime(long x) {
        if (x <= 1) return false;
        if (x == 2) return true;
        if (x % 2 == 0) return false;
        
        for (long i = 3; i * i <= x; i += 2) {
            if (x % i == 0) return false;
        }
        
        return true;
    }
 
}