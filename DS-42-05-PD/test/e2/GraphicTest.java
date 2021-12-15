package e2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphicTest {

    private final Graphic graph = new Graphic();
    private final Graphic graph1 = new Graphic();
    private final Graphic graph2 = new Graphic();
    private final List<Dependence> dependences = new ArrayList<>();

    private Document document;
    Node A, B, C, D, E, F, G, H, J;

    private List<Character> hierarchical = Arrays.asList('C', 'G', 'A', 'F', 'H', 'B', 'D', 'E', 'J');
    private List<Character> weakDep = Arrays.asList('C', 'A', 'B', 'D', 'E', 'F', 'G', 'H', 'J');
    private List<Character> strongDep = Arrays.asList('C', 'A', 'B', 'D', 'G', 'F', 'E', 'H', 'J');

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
        dependences.clear();
        dependences.add(new Dependence(C, A));
        dependences.add(new Dependence(C, F));
        dependences.add(new Dependence(A, B));
        dependences.add(new Dependence(A, D));
        dependences.add(new Dependence(B, E));
        dependences.add(new Dependence(D, E));
        dependences.add(new Dependence(F, E));
        dependences.add(new Dependence(G, F));
        dependences.add(new Dependence(G, H));
        dependences.add(new Dependence(F, J));
        dependences.add(new Dependence(H, J));

        document = new Document(dependences);

        // adding edges to the graph
        graph.makeGraph(document.getDocument());

        // setting up the tasks lists in order
        hierarchical = Arrays.asList('C', 'G', 'A', 'F', 'H', 'B', 'D', 'E', 'J');
        weakDep = Arrays.asList('C', 'A', 'B', 'D', 'E', 'F', 'G', 'H', 'J');
        strongDep = Arrays.asList('C', 'A', 'B', 'D', 'G', 'F', 'E', 'H', 'J');
    }

    @Test
    void test() {
        Document document1, document2;
        Dependence newDependence = new Dependence(E, new Node('X'));

        /* create a new dependence in the
         * document and make another graph: */
        dependences.add(newDependence);
        document1 = document.addDependences(dependences);
        graph1.makeGraph(document1.getDocument());

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

        assertEquals("Total number of vertices: 10", graph1.countVertices());


        dependences.clear();
        /* try to remove a dependence in a document */
        dependences.add(newDependence);
        document2 = document1.removeDependences(dependences);
        graph2.makeGraph(document2.getDocument());

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
                        "J --> \n", graph2.toString());

        assertEquals(
                "Levels in the graph:\n" +
                        "Level 0 --> C G \n" +
                        "Level 1 --> A F H \n" +
                        "Level 2 --> B D \n" +
                        "Level 3 --> E J \n", graph2.showLevels(graph2.maxLevel()));

        assertEquals("Total number of vertices: 9", graph2.countVertices());
    }


    @Test
    void testEquals() {
        assertEquals(hierarchical, new HierarchicalOrder(document.getDocument()).order(document.getDocument()));
        assertEquals(weakDep, new WeakDependency(document.getDocument()).order(document.getDocument()));
        assertEquals(strongDep, new StrongDependency(document.getDocument()).order(document.getDocument()));

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
