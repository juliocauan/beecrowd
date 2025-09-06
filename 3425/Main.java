import java.io.IOException;
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int p = 0, q = 0;
        int l1 = sc.nextInt();
        int r1 = sc.nextInt();
        int l2 = sc.nextInt();
        int r2 = sc.nextInt();
        int l3 = sc.nextInt();
        int r3 = sc.nextInt();

        q = (r1 - l1) * (r2 - l2) * (r3 - l3);

        for(int i = l1; i <= r1; i++)
            for(int j = l2; j <= r2; j++)
                for(int k = l3; k <= r3; k++)
                    if((i ^ j ^ k) == 1)
                        p++;
        
        System.out.println((p * (1.0 / q)) % (Math.pow(10, 9) + 7));
        sc.close();
    }
 
}