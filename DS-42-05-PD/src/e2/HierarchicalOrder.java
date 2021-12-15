package e2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HierarchicalOrder implements TaskOrder {

    private final Map<Node, List<Node>> map;
    private final Graphic graph;

    HierarchicalOrder(Document document) {

        if (document == null) {
            throw new NullPointerException();
        }

        graph = new Graphic(document);
        map = graph.makeGraph();
    }

    @Override
    public List<Character> order(List<Dependence> document) {
        List<Character> result = new ArrayList<>();
        List<Character> aux = new ArrayList<>();

        if (document == null) {
            throw new NullPointerException();
        }

        /* iterate map by levels */
        for (int i = 0; i <= graph.maxLevel(); i++) {
            for (Node node : map.keySet()) {
                if (node.getLevel() == i) {
                    aux.add(node.getName());
                }
            }

            /* order level alphabetically */
            aux.sort(null);
            result.addAll(aux);
            aux.clear();
        }

        return result;
    }
}
