import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) throws IOException {
        // Scanner sc = new Scanner(System.in);
        Scanner sc = new Scanner(new FileReader("input.txt"));
        int N, max, pathSize;

        while ((N = Integer.parseInt(sc.nextLine())) != 0) {
            List<Vertice> vertices = new ArrayList<>();
            max = 0;

            for(int i = 0; i < N; i++) {
                vertices.add(new Vertice(sc.nextLine()));
            }

            vertices.sort((a, b) -> {
                int aLength = a.name.length(), bLength = b.name.length();
                if(aLength == bLength)
                    return 0;
                return aLength > bLength ? 1 : -1; 
            });

            for(int i = 0; i < N - 1; i++) {
                Vertice currentVertice = vertices.get(i);
                for(int j = i+1; j < N; j++){
                    Vertice otherVertice = vertices.get(j);
                    currentVertice.addAresta(otherVertice);
                }
            }

            List<Vertice> fontes = vertices.stream().filter(Vertice::isFonte).toList();
            List<Vertice> sumidouros = vertices.stream().filter(Vertice::isSumidouro).toList();

            for(Vertice fonte : fontes) {
                pathSize = fonte.getLargestPath();
                if(pathSize > max)
                    max = pathSize;
            }

            System.out.println(max);
        }

        sc.close();
    }
 
}

class Vertice {

    private final List<Vertice> saidas = new ArrayList<>();
    private int entradas;
    final String name;

    Vertice(String name) {
        this.name = name;
        this.entradas = 0;
    }

    void addAresta(Vertice otherVertice) {
        boolean isSubstring = name.length() < otherVertice.name.length() && otherVertice.name.contains(name);
        if(isSubstring) {
            saidas.add(otherVertice);
            otherVertice.entradas++;
        }
    }

    boolean isFonte() {
        return entradas == 0;
    }
    
    boolean isSumidouro() {
        return saidas.isEmpty();
    }

    void transitiveReductionTo(List<Vertice> sumidouros) {
        boolean hasDirectConnection = false, hasIndirectConnection = false;
        hasDirectConnection = this.hasDirectPathTo(sumidouros);
        for(Vertice saida : this.saidas) {
            if(saida.hasPathTo(sumidouros)) {
                hasIndirectConnection = true;
                break;
            }
        }
        if(hasDirectConnection && hasIndirectConnection) {
            this.saidas.removeAll(sumidouros);
        }
    }

    private boolean hasPathTo(List<Vertice> sumidouros) {
        boolean hasPathTo = this.hasDirectPathTo(sumidouros);
        if(!hasPathTo) {
            for(Vertice saida : this.saidas) {
                if(saida.hasPathTo(sumidouros)) {
                    hasPathTo = true;
                    break;
                }
            }
        }
        return hasPathTo;
    }

    private boolean hasDirectPathTo(List<Vertice> sumidouros) {
        boolean hasPathTo = false;
        if(!this.saidas.isEmpty()){
            for(Vertice sumidouro : sumidouros) {
                if(this.saidas.contains(sumidouro)) {
                    hasPathTo = true;
                    break;
                }
            }
        }
        return hasPathTo;
    }

    int getLargestPath() {
        if(this.saidas.isEmpty())
            return 1;
        int max = 0;
        for(Vertice saida : this.saidas) {
            max = Math.max(max, 1 + saida.getLargestPath());
        }
        return max;
    }

}