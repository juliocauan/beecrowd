import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Scanner;

public class Main {

    private final static int MOD = 1713371337;
 
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        StringBuilder sb = new StringBuilder();
        long D1, D2, x, y, n, maior;
        while (true) {
            D1 = sc.nextLong();
            D2 = sc.nextLong();
            x = y = n = 0;
            if(D1 == 0 && D2 == 0) break;
            maior = D1 > D2 ? D1 : D2;
            do {
                x = (x+maior) % D1;
                y = (y+maior) % D2;
                n = (n+maior) % MOD;
            } while(x != 0 || y != 0);
            sb.append(n).append("\n");
            // System.out.println(n);
        }

        writer.write(sb.toString());
        writer.close();
        sc.close();
    }
 
}
