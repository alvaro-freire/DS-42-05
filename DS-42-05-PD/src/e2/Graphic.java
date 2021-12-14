package e2;

import java.util.*;

public class Graphic {

    private final Map<Node, List<Node>> map = new HashMap<>();

    public void addNewVertex(Node v) {
        map.put(v, new LinkedList<Node>());
    }

    public void addNewEdge(Node x, Node y) {
        if (!map.containsKey(x)) {
            addNewVertex(x);
            x.setLevel(0);
        } else {
            for (Node node : map.keySet()) {
                if (node.getName() == x.getName()) {
                    x.setLevel(node.getLevel());
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
                }
            }
        }



        map.get(x).add(y);
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

    //prints the adjacencyS list of each vertex
    //here we have overridden the toString() method of the StringBuilder class
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
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
