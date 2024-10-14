import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int B, N;
        B = sc.nextInt();
        N = sc.nextInt();
        while(!( B == 0 & N == 0 )) {
            boolean isPossible = true;
            int[] R = new int[B];
            for(int i = 0; i < R.length; i++) {
                R[i] = sc.nextInt();
            }
            for(int line = 0; line < N; line++) {
                int D, C, V;
                D = sc.nextInt();
                C = sc.nextInt();
                V = sc.nextInt();
                R[D-1] -= V;
                R[C-1] += V;
            }
            for(int i = 0; i < R.length; i++) {
                if(R[i] < 0) {
                    isPossible = false;
                    break;
                }
            }
            if(isPossible) {
                System.out.println("S");
            } else {
                System.out.println("N");
            }
            B = sc.nextInt();
            N = sc.nextInt();
        }
        sc.close();
    }
 
}