package test;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Test {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int N, max;
        LinkedList<String> strings = new LinkedList<>();

        while (true) {
            N = Integer.parseInt(sc.nextLine());
            if(N == 0) break;

            strings.clear();
            max = 0;

            for(int i = 0; i < N; i++) {
                strings.add(sc.nextLine());
            }

            // max = Math.max(max, fonte.getLargestPath());

            System.out.println(max);
        }

        sc.close();
    }
 
}
