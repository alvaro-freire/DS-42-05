package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphicTest {

    Graphic graph = new Graphic();

    @BeforeEach
    public void setUp() {
        Node A = new Node('A');
        Node B = new Node('B');
        Node C = new Node('C');
        Node D = new Node('D');
        Node E = new Node('E');
        Node F = new Node('F');
        Node G = new Node('G');
        Node H = new Node('H');
        Node J = new Node('J');

        //adding edges to the graph
        graph.addNewEdge(C, A);
        graph.addNewEdge(C, F);
        graph.addNewEdge(A, B);
        graph.addNewEdge(A, D);
        graph.addNewEdge(B, E);
        graph.addNewEdge(D, E);
        graph.addNewEdge(F, E);
        graph.addNewEdge(G, F);
        graph.addNewEdge(G, H);
        graph.addNewEdge(F, J);
        graph.addNewEdge(H, J);

        //prints the adjacency matrix that represents the graph
        System.out.println("Adjacency List for the graph:\n" + graph.toString());

        //counts the number of vertices in the graph
        graph.countVertices();

        //counts the number of edges in the graph
        graph.countEdges();

        //checks whether an edge is present or not between the two specified vertices
        graph.containsEdge(C, A);
        graph.containsEdge(C, F);
        //checks whether vertex is present or not
        graph.containsVertex(H);
        graph.containsVertex(J);
    }


    @Test
    void test() {
    }
}
