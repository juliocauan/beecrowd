import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        Integer.parseInt(sc.nextLine());
        for(String a : sc.nextLine().split("b")) {
            int length = a.length();
            count += length > 1 ? length : 0;
        }
        System.out.println(count);
        sc.close();
    }
 
}