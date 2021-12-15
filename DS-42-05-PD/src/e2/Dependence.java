package e2;

public class Dependence {

    private final Node parent;
    private final Node child;

    Dependence(Node x, Node y) {
        this.parent = x;
        this.child = y;
    }

    public Node getParent() {
        return parent;
    }

    public Node getChild() {
        return child;
    }
}
