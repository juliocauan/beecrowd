import java.io.IOException;
import java.util.Scanner;

public class Main {

    private final static int MOD = 1713371337;
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long D1, D2;
        while (true) {
            D1 = sc.nextLong();
            D2 = sc.nextLong();
            if(D1 == 0 && D2 == 0) break;
            sb.append(mmc(D1, D2) % MOD).append("\n");
        }

        System.out.print(sb.toString());
        sc.close();
    }

    private static long mdc(long a, long b){
        while(b != 0){
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
    
    private static long mmc(long a, long b){
        return a * (b / mdc(a, b));
    }
 
}
