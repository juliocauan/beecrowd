import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        long a, b;
        while (sc.hasNextLong()) {
            a = sc.nextLong();
            b = sc.nextLong();
            sb.append((a ^ b)).append("\n");
        }
        System.out.print(sb.toString());
        sc.close();
    }
 
}