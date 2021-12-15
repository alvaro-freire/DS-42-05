package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphicTest {

    Graphic graph = new Graphic();
    List<Dependence> document = new ArrayList<>();

    @BeforeEach
    public void setUp() {
        // setting up the nodes
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        Node J = new Node('J');

        // setting up the "document" with
        // its dependencies (X -> Y):
        document.add(new Dependence(C, A));
        document.add(new Dependence(C, F));
        document.add(new Dependence(A, B));
        document.add(new Dependence(A, D));
        document.add(new Dependence(B, E));
        document.add(new Dependence(D, E));
        document.add(new Dependence(F, E));
        document.add(new Dependence(G, F));
        document.add(new Dependence(G, H));
        document.add(new Dependence(F, J));
        document.add(new Dependence(H, J));

        // adding edges to the graph
        graph.makeGraph(document);

        // prints the adjacency matrix that represents the graph
        System.out.println(graph.toString());

        // prints the weights of each node in the matrix
        graph.showLevels();

        // counts the number of vertices in the graph
        graph.countVertices();

        // counts the number of edges in the graph
        graph.countEdges();

        // checks whether an edge is present or not between the two specified vertices
        graph.containsEdge(C, A);
        graph.containsEdge(C, F);
        // checks whether vertex is present or not
        graph.containsVertex(H);
        graph.containsVertex(J);
    }


    @Test
    void test() {
        List<Character> hierarchical = Arrays.asList('C', 'G', 'A', 'F', 'H', 'B', 'D', 'E', 'J');
        List<Character> weakDep = Arrays.asList('C', 'A', 'B', 'D', 'E', 'F', 'G', 'H', 'J');
        List<Character> strongDep = Arrays.asList('C', 'A', 'B', 'D', 'G', 'F', 'E', 'H', 'J');

        assertEquals(hierarchical, new HierarchicalOrder(document).order(document));
        assertEquals(weakDep, new WeakDependency(document).order(document));
        assertEquals(strongDep, new StrongDependency(document).order(document));
    }
}
