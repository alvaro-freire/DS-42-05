package e2;

public class Node {

    private final char name;

    private final int level;

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


}
