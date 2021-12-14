package e2;

import java.util.*;

public class Graphic {

    private final Map<Character, List<Character>> map = new HashMap<>();

    public void addNewVertex(Character v) {
        map.put(v, new LinkedList<Character>());
    }

    public void addNewEdge(Character x, Character y) {
        if (!map.containsKey(x)) {
            addNewVertex(x);
        }

        if (!map.containsKey(y)) {
            addNewVertex(y);
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
        for (Character x : map.keySet()) {
            count = count + map.get(x).size();
        }

        System.out.println("Total number of edges: " + count);
    }

    //checks a graph has vertex or not
    public void containsVertex(Character x) {
        if (map.containsKey(x)) {
            System.out.println("The graph contains " + x + " as a vertex.");
        } else {
            System.out.println("The graph does not contain " + x + " as a vertex.");
        }
    }

    //checks a graph has edge or not
    //where s and d are the two parameters that represent source(vertex) and destination (vertex)
    public void containsEdge(Character x, Character y) {
        if (map.get(x).contains(y)) {
            System.out.println("The graph has an edge between " + x + " and " + y + ".");
        } else {
            System.out.println("There is no edge between " + x + " and " + y + ".");
        }
    }

    //prints the adjacencyS list of each vertex
    //here we have overridden the toString() method of the StringBuilder class
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        //foreach loop that iterates over the keys
        for (Character v : map.keySet()) {
            builder.append(v.toString()).append(" --> ");
            //foreach loop for getting the vertices
            for (Character w : map.get(v)) {
                builder.append(w.toString()).append(" ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }
}
