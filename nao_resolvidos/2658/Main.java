import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new FileReader("input.txt"));
        BufferedWriter writer = new BufferedWriter(new FileWriter("output.txt"));
        long startTime = System.nanoTime(), endTime;
        double durationSeconds;
        /*------------------------------------------------------*/

        int nTeclas, nAcordes, a, b;
        Piano piano;
        nTeclas = sc.nextInt();
        nAcordes = sc.nextInt();
        piano = new Piano(nTeclas);

        for (int acorde = 0; acorde < nAcordes; acorde++) {
            a = sc.nextInt();
            b = sc.nextInt();
            piano.tocarAcorde(a, b);
        }

        /*------------------------------------------------------*/
        endTime = System.nanoTime();
        durationSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("Tempo de execução: %.3f segundos%n", durationSeconds);
        writer.write(piano.toString());
        writer.close();
        sc.close();
    }
}

class Piano {

    private final Tecla[] teclas;

    Piano(int nTeclas) {
        teclas = new Tecla[nTeclas];
        for(int i = 0; i < nTeclas; i++) {
            teclas[i] = new Tecla();
        }
    }

    void tocarAcorde(int a, int b) {

        int f = -1, maxFrequencia = -1;
        int[] frequenciaDaNota = new int[9];
        for(int i = a; i <= b; i++) {
            int nota, frequencia;
            nota = teclas[i].getNota();
            frequencia = ++frequenciaDaNota[nota];
            if(frequencia > maxFrequencia || (frequencia == maxFrequencia && nota > f)) {
                f = nota;
                maxFrequencia = frequencia;
            }
        }

        for(int i = a; i <= b; i++) {
            teclas[i].alterarNota(f);
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Tecla tecla : teclas) {
            sb.append(tecla.getNota()).append("\n");
        }
        return sb.toString();
    }

}

class Tecla {
    private int nota;

    Tecla() {
        this.nota = 1;
    }

    void alterarNota(int f) {
        this.nota = (this.nota + f) % 9;
    }

    int getNota() {
        return this.nota;
    }

}