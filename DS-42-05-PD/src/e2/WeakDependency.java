package e2;

import java.util.*;

public class WeakDependency implements TaskOrder {

    private final Map<Node, List<Node>> map;

    WeakDependency(List<Dependence> document) {
        Graphic graph = new Graphic();
        map = graph.makeGraph(document);
    }

    @Override
    public List<Character> order(List<Dependence> document) {
        List<Node> available = new ArrayList<>();
        List<Character> result = new ArrayList<>();
        int size = map.keySet().size();

        /* add the first available nodes: */
        for (Node node : map.keySet()) {
            if (node.getLevel() == 0) {
                available.add(node);
            }
        }

        available = sortAlphabetically(available);

        result.add(available.get(0).getName());

        while (result.size() < size) {
            for (Node node : map.get(available.get(0))) {
                if (!available.contains(node) && !result.contains(node.getName())) {
                    available.add(node);
                }
            }
            map.remove(available.get(0));

            available.remove(0);
            available = sortAlphabetically(available);
            result.add(available.get(0).getName());
        }

        return result;
    }

    public List<Node> sortAlphabetically(List<Node> list) {
        list.sort(new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return Character.compare(o1.getName(), o2.getName());
            }
        });

        return list;
    }
}
