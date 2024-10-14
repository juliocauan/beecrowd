import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        StringBuilder output = new StringBuilder();
        String senha;
        Cadeado cadeado;
        
        while (true) {
            senha = sc.nextLine();
            if(senha.equals("*")) break;
            cadeado = new Cadeado(senha);
            output.append(cadeado.getQtdPassos()).append("\n");
        }

        writer.write(output.toString());
        writer.close();
        sc.close();
    }
 
}

class Cadeado {
    private final int[] passosDoCaractere;

    Cadeado(String senha) {
        this.passosDoCaractere = new int[senha.length()];
        for(int i = 0; i < senha.length(); i++){
            int passos = (int) (senha.charAt(i) - 97);
            passosDoCaractere[i] = passos <= 13 ? passos : passos - 26;
        }
    }

    int getQtdPassos() {
        int a, b, passos = 0;

        while (!isResolvido()) {
            a = b = 0;

            for(a = 0; a < passosDoCaractere.length; a++) {
                if(passosDoCaractere[a] != 0) {
                    break;
                }
            }

            for(b = a+1; b < passosDoCaractere.length; b++) {
                if( (passosDoCaractere[b] > 0 && passosDoCaractere[a] < 0) || 
                    (passosDoCaractere[b] < 0 && passosDoCaractere[a] > 0) ||
                    (passosDoCaractere[b] == 0)) {
                    break;
                }
            }
            
            mover(a, b);
            passos++;
        }

        return passos;
    }

    private boolean isResolvido() {
        for(int passos : passosDoCaractere)
            if(passos != 0) return false;
        return true;
    }

    private void mover(int a, int b) {
        for(int i = a; i < b; i++) {
            if(passosDoCaractere[i] > 0)
                passosDoCaractere[i]--;
            else
                passosDoCaractere[i]++;
        }
    }

}