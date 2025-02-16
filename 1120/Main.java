import java.io.IOException;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String failedDigit, contractValue;
        while (!((failedDigit = sc.next()).equals("0") & (contractValue = sc.next()).equals("0"))) {
            String digitedValue = contractValue.replace(failedDigit, "");
            if(digitedValue.isEmpty()) {
                digitedValue += "0";
            }
            BigInteger realValue = new BigInteger(digitedValue);
            System.out.println(realValue);
        }
        sc.close();
    }
 
}