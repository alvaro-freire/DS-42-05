package e2;

public class Dependence {

    private final Node x;
    private final Node y;

    Dependence(Node x, Node y) {
        this.x = x;
        this.y = y;
    }

    public Node getX() {
        return x;
    }

    public Node getY() {
        return y;
    }
}
