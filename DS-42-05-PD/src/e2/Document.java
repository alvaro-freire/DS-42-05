package e2;

import java.util.List;

public class Document {

    private List<String> dependencias;

    Document(List<String> dependencias) {
        this.dependencias = dependencias;
    }

    public void addTarea(char x, char y) {
        String dependencia = x + " -> " + y + "\n";

        dependencias.add(dependencia);
    }

}
