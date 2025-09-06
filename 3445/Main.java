import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N, casa, trabalho;
        boolean choveuIda, choveuVolta;
        
        N = Integer.parseInt(sc.next());
        casa = Integer.parseInt(sc.next());
        trabalho = Integer.parseInt(sc.next());

        while (N-- != 0) {
            choveuIda = sc.next().equals("Y");
            choveuVolta = sc.next().equals("Y");
            
            if(choveuIda || trabalho == 0) {
                casa--;
                trabalho++;
                System.out.print("Y");
            } else {
                System.out.print("N");
            }

            System.out.print(" ");

            if(choveuVolta || casa == 0) {
                casa++;
                trabalho--;
                System.out.println("Y");
            } else {
                System.out.println("N");
            }

        }
        
        sc.close();
    }
 
}