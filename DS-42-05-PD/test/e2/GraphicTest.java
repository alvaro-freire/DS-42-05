package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphicTest {

    Graphic graph = new Graphic();
    Graphic graph1 = new Graphic();
    List<Dependence> document = new ArrayList<>();
    Node A, B, C, D, E, F, G, H, J;
    List<Character> hierarchical = Arrays.asList('C', 'G', 'A', 'F', 'H', 'B', 'D', 'E', 'J');
    List<Character> weakDep = Arrays.asList('C', 'A', 'B', 'D', 'E', 'F', 'G', 'H', 'J');
    List<Character> strongDep = Arrays.asList('C', 'A', 'B', 'D', 'G', 'F', 'E', 'H', 'J');

    @BeforeEach
    public void setUp() {
        // setting up the nodes
        A = new Node('A');
        B = new Node('B');
        C = new Node('C');
        D = new Node('D');
        E = new Node('E');
        F = new Node('F');
        G = new Node('G');
        H = new Node('H');
        J = new Node('J');

        // setting up the "document" with
        // its dependencies (X -> Y):
        document.clear();
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

        // setting up the tasks lists in order
        hierarchical = Arrays.asList('C', 'G', 'A', 'F', 'H', 'B', 'D', 'E', 'J');
        weakDep = Arrays.asList('C', 'A', 'B', 'D', 'E', 'F', 'G', 'H', 'J');
        strongDep = Arrays.asList('C', 'A', 'B', 'D', 'G', 'F', 'E', 'H', 'J');
    }

    @Test
    void test() {
        document.add(new Dependence(E, new Node('X')));

        graph1.makeGraph(document);

        assertEquals(
                "Adjacency List for the graph:\n" +
                        "A --> B D \n" +
                        "B --> E \n" +
                        "C --> A F \n" +
                        "D --> E \n" +
                        "E --> X \n" +
                        "F --> E J \n" +
                        "G --> F H \n" +
                        "H --> J \n" +
                        "J --> \n" +
                        "X --> \n", graph1.toString());

        assertEquals(
                "Levels in the graph:\n" +
                        "Level 0 --> C G \n" +
                        "Level 1 --> A F H \n" +
                        "Level 2 --> B D \n" +
                        "Level 3 --> E J \n" +
                        "Level 4 --> X \n", graph1.showLevels(graph1.maxLevel()));
    }


    @Test
    void testEquals() {
        assertEquals(hierarchical, new HierarchicalOrder(document).order(document));
        assertEquals(weakDep, new WeakDependency(document).order(document));
        assertEquals(strongDep, new StrongDependency(document).order(document));

        assertEquals(
                "Adjacency List for the graph:\n" +
                        "A --> B D \n" +
                        "B --> E \n" +
                        "C --> A F \n" +
                        "D --> E \n" +
                        "E --> \n" +
                        "F --> E J \n" +
                        "G --> F H \n" +
                        "H --> J \n" +
                        "J --> \n", graph.toString());

        assertEquals(
                "Levels in the graph:\n" +
                        "Level 0 --> C G \n" +
                        "Level 1 --> A F H \n" +
                        "Level 2 --> B D \n" +
                        "Level 3 --> E J \n", graph.showLevels(graph.maxLevel()));

        assertEquals("Total number of vertices: 9", graph.countVertices());
    }
}
