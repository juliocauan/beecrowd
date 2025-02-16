import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        t *= 2;
        t *= 2;
        System.out.println(t);
        sc.close();
    }
 
}