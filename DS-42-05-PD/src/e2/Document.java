package e2;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private final List<Dependence> document;

    Document(List<Dependence> document) {
        this.document = new ArrayList<>(document);
    }

    public List<Dependence> getDocument() {
        return new ArrayList<>(document);
    }

    public void addDependences(List<Dependence> dependences) {
        for (Dependence dependence : dependences) {
            if (!document.contains(dependence)) {
                document.add(dependence);
            }
        }
    }

}
