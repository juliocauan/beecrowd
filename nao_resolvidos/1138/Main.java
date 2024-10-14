import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        StringBuilder sb = new StringBuilder();
        int a, b;
        int[] frequencia = new int[10];
        while (true) {
            a = sc.nextInt();
            b = sc.nextInt();
            if(a == 0 && b == 0) break;

            for(int i = 0; i < 10; i++) {
                frequencia[i] = 0;
            }

            for(int i = a; i <= b; i++) {
                int number = i;
                while (number > 0) {
                    int digit = number % 10;
                    frequencia[digit]++;
                    number /= 10;
                }
            }

            for(int digito : frequencia) {
                sb.append(digito).append(" ");
            }
            sb.deleteCharAt(sb.length()-1).append("\n");
        }

        writer.write(sb.toString());
        writer.close();
        sc.close();
    }
 
}