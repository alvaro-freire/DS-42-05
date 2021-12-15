package e2;

import java.util.*;

public class Graphic {

    private final Map<Node, List<Node>> map = new HashMap<>();
    private final Document document;
    private TaskOrder order;

    Graphic(Document document) {

        if (document == null) {
            throw new NullPointerException();
        }

        this.document = document;
    }

    public Document getDocument() {
        return document;
    }

    public void setOrder(TaskOrder order) {
        this.order = order;
    }

    public List<Character> order() {
        return order.order(document.getDocument());
    }

    public void addNewVertex(Node v) {
        map.put(v, new LinkedList<>());
    }

    public Map<Node, List<Node>> makeGraph() {

        for (Dependence dependence : document.getDocument()) {
            Node x = dependence.getParent();
            Node y = dependence.getChild();

            if (!map.containsKey(x)) {
                addNewVertex(x);
                if (!map.containsKey(y)) {
                    x.setLevel(0);
                } else {
                    for (Node node : map.keySet()) {
                        if (node.getName() == y.getName()) {
                            x.setLevel(node.getLevel() - 1);
                            break;
                        }
                    }
                }
            } else {
                for (Node node : map.keySet()) {
                    if (node.getName() == x.getName()) {
                        x.setLevel(node.getLevel());
                        break;
                    }
                }
            }

            if (!map.containsKey(y)) {
                addNewVertex(y);
                if (map.get(x).isEmpty()) {
                    y.setLevel(x.getLevel() + 1);
                } else {
                    y.setLevel(map.get(x).get(0).getLevel());
                }
            } else {
                for (Node node : map.keySet()) {
                    if (node.getName() == y.getName()) {
                        y.setLevel(node.getLevel());
                        break;
                    }
                }
            }


            map.get(x).add(y);
        }

        return map;
    }

    //the method counts the number of vertices
    public String countVertices() {
        return "Total number of vertices: " + map.keySet().size();
    }

    public String showLevels(int maxLevel) {
        StringBuilder builder = new StringBuilder();
        List<Character> nodes = new ArrayList<>();

        builder.append("Levels in the graph:\n");

        //foreach loop that iterates over the levels:
        for (int i = 0; i <= maxLevel; i++) {
            builder.append("Level ").append(i).append(" --> ");
            for (Node node : map.keySet()) {
                if (node.getLevel() == i) {
                    nodes.add(node.getName());
                }
            }
            nodes.sort(null);

            for (Character character : nodes) {
                builder.append(character).append(" ");
            }

            nodes.clear();

            builder.append("\n");
        }

        return builder.toString();
    }

    public int maxLevel() {
        int max = 0, aux;

        for (Node node : map.keySet()) {
            aux = node.getLevel();
            if (aux > max) {
                max = aux;
            }
        }

        return max;
    }

    //prints the adjacency list of each vertex
    //here we have overridden the toString() method of the StringBuilder class
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        List<Character> parents = new ArrayList<>();

        builder.append("Adjacency List for the graph:\n");

        //foreach loop that iterates over the keys
        for (Node v : map.keySet()) {
            parents.add(v.getName());
        }

        parents.sort(null);

        for (Character parent : parents) {
            for (Node v : map.keySet()) {
                if (parent == v.getName()) {
                    builder.append(parent).append(" --> ");
                    for (Node w : map.get(v)) {
                        builder.append(w.getName()).append(" ");
                    }
                    builder.append("\n");
                }
            }
        }

        return (builder.toString());
    }
}