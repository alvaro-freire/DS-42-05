package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HierarchicalOrder implements TaskOrder {

    private final Graphic graph = new Graphic();

    @Override
    public List<Character> order(List<Dependence> document) {
        Map<Node, List<Node>> map = graph.makeGraph(document);
        List<Character> result = new ArrayList<>();
        List<Character> aux = new ArrayList<>();

        for (int i = 0; i <= graph.maxLevel(); i++) {
            for (Node node : map.keySet()) {
                if (node.getLevel() == i) {
                    aux.add(node.getName());
                }
            }
            aux.sort(null);
            result.addAll(aux);
        }

        return result;
    }
}
