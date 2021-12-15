package e2;

import java.util.*;

public class StrongDependency implements TaskOrder {

    private final Map<Node, List<Node>> map;

    StrongDependency(List<Dependence> document) {
        Graphic graph = new Graphic();
        map = graph.makeGraph(document);
    }

    @Override
    public List<Character> order(List<Dependence> document) {
        List<Character> result = new ArrayList<>();
        List<Node> available = new ArrayList<>();
        int size = map.keySet().size();
        int i = 0;

        while (i < size) {
            /* get a list of nodes with no parents
             * and order it alphabetically: */
            available.addAll(noParents(map));
            available = sortAlphabetically(available);

            /* remove the first node: */
            map.remove(available.get(0));

            /* add it to the result: */
            result.add(available.get(0).getName());

            available.clear();
            i++;
        }

        return result;
    }

    private List<Node> noParents(Map<Node, List<Node>> map) {
        List<Node> result = new ArrayList<>();

            for (Node node : map.keySet()) {
                if (!hasParent(node, map)) {
                    result.add(node);
                }
            }

        return result;
    }

    private boolean hasParent(Node node, Map<Node, List<Node>> map) {
        /* checks if any element of the graph has "node" as a child: */
        for (Node parent : map.keySet()) {
            for (Node child : map.get(parent)) {
                if (child == node) {
                    return true;
                }
            }
        }
        return false;
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
