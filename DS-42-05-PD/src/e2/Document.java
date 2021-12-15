package e2;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private final List<Dependence> document;

    Document(List<Dependence> document) {

        if (document == null) {
            throw new NullPointerException();
        }

        this.document = new ArrayList<>(document);
    }

    public List<Dependence> getDocument() {
        return new ArrayList<>(document);
    }

    public Document addDependences(List<Dependence> dependences) {
        List<Dependence> document1 = getDocument();

        for (Dependence dependence : dependences) {
            if (!document1.contains(dependence)) {
                document1.add(dependence);
            }
        }

        return new Document(document1);
    }

    public Document removeDependences(List<Dependence> dependences) {
        List<Dependence> document1 = getDocument();

        for (Dependence dependence : dependences) {
            document1.remove(dependence);
        }

        return new Document(document1);
    }
}
