package e2;

import java.util.List;

public class WeakDependency implements TaskOrder {

    private final Graphic graph = new Graphic();

    @Override
    public List<Character> order(List<Dependence> document) {
        return null;
    }
}
