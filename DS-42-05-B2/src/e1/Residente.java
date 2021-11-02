package e1;

public abstract class Residente extends Integrante {

    public House casa;

    public enum House {
        Gryffindor("Gryffindor"),
        Hufflepuff("Hufflepuff"),
        Ravenclaw("Ravenclaw"),
        Slytherin("Slytherin");

        private final String casa;

        House(String casa) { this.casa = casa; }

        public String getHouse() { return casa; }

    }

}
