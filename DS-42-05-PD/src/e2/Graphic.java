package e2;

import java.util.*;

public class Graphic {

    private final Map<Node, List<Node>> map = new HashMap<>();

    public void addNewVertex(Node v) {
        map.put(v, new LinkedList<Node>());
    }

    public Map<Node, List<Node>> makeGraph(List<Dependence> document) {
        Node x, y;

        for (Dependence dependence : document) {
            x = dependence.getParent();
            y = dependence.getChild();

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
    public void countVertices() {
        System.out.println("Total number of vertices: " + map.keySet().size());
    }

    //the method counts the number of edges
    public void countEdges() {
        //variable to store number of edges
        int count = 0;
        for (Node x : map.keySet()) {
            count = count + map.get(x).size();
        }

        System.out.println("Total number of edges: " + count);
    }

    //checks a graph has vertex or not
    public void containsVertex(Node x) {
        if (map.containsKey(x)) {
            System.out.println("The graph contains " + x.getName() + " as a vertex.");
        } else {
            System.out.println("The graph does not contain " + x.getName() + " as a vertex.");
        }
    }

    //checks a graph has edge or not
    //where s and d are the two parameters that represent source(vertex) and destination (vertex)
    public void containsEdge(Node x, Node y) {
        if (map.get(x).contains(y)) {
            System.out.println("The graph has an edge between " + x.getName() + " and " + y.getName() + ".");
        } else {
            System.out.println("There is no edge between " + x.getName() + " and " + y.getName() + ".");
        }
    }

    // checks if there are negative levels and
    // puts all of them in the correct way ( >= 0 )
    public void checkLevels() {
        int levelUp;
        for (Node node : map.keySet()) {
            if (node.getLevel() < 0) {
                levelUp = node.getLevel() * -1;
                for (Node nodeUp : map.keySet()) {
                    nodeUp.addLevel(levelUp);
                }
                break;
            }
        }
    }

    public void showLevels() {
        StringBuilder builder = new StringBuilder();
        checkLevels();

        //foreach loop that iterates over the keys
        for (Node v : map.keySet()) {
            builder.append(v.getName());
            builder.append(" --> ");
            builder.append(v.getLevel());
            builder.append("\n");
        }

        //prints the adjacency matrix that represents the graph
        System.out.println("Level of each node in the graph:\n" + builder);
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

        builder.append("Adjacency List for the graph:\n");

        //foreach loop that iterates over the keys
        for (Node v : map.keySet()) {
            builder.append(v.getName()).append(" --> ");
            //foreach loop for getting the vertices
            for (Node w : map.get(v)) {
                builder.append(w.getName()).append(" ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }
}
