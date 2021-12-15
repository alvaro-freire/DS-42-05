package e2;

import java.util.*;

public class WeakDependency implements TaskOrder {

    private final Map<Node, List<Node>> map;

    WeakDependency(List<Dependence> document) {

        if (document == null) {
            throw new NullPointerException();
        }

        map = new Graphic().makeGraph(document);
    }

    @Override
    public List<Character> order(List<Dependence> document) {
        List<Node> available = new ArrayList<>();
        List<Character> result = new ArrayList<>();
        int size = map.keySet().size();

        if (document == null) {
            throw new NullPointerException();
        }

        /* add the first available nodes: */
        for (Node node : map.keySet()) {
            if (node.getLevel() == 0) {
                available.add(node);
            }
        }

        available.sort(Comparator.comparingInt(Node::getName));

        result.add(available.get(0).getName());

        /* add to the result list the rest of nodes in order */
        while (result.size() < size) {
            for (Node node : map.get(available.get(0))) {
                if (!available.contains(node) && !result.contains(node.getName())) {
                    available.add(node);
                }
            }
            map.remove(available.get(0));

            available.remove(0);
            available.sort(Comparator.comparingInt(Node::getName));
            result.add(available.get(0).getName());
        }

        return result;
    }
}
