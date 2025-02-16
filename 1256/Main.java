import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- != 0) {
            int M, C;
            TabelaHash tabela;
            M = sc.nextInt();
            C = sc.nextInt();
            tabela = new TabelaHash(M);
            for(int i = 0; i < C; i++) {
                tabela.add(sc.nextInt());
            }

            System.out.print(tabela.toString());
            if(N != 0) System.out.println();
        }
        sc.close();
    }
 
}

class TabelaHash {

    private final List<List<Integer>> tabela = new ArrayList<>();
    private final int size;

    TabelaHash(int size) {
        this.size = size;
        for(int i = 0; i < size; i++) {
            tabela.add(new ArrayList<>());
        }
    }

    void add(int key) {
        int endereco = key % this.size;
        tabela.get(endereco).add(key);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < tabela.size(); i++) {
            sb.append(i).append(" -> ");
            List<Integer> enderecos = tabela.get(i);
            for(Integer chave : enderecos) {
                sb.append(chave).append(" -> ");
            }
            sb.append("\\\n");
        }
        return sb.toString();
    }

}