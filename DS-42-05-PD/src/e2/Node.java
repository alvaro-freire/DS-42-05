package e2;

public class Node {

    private final char name;

    private int level;

    Node(char name) {
        this.name = name;
        this.level = 0;
    }

    public char getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int n) {
        level = n;
    }

}
