package e1;

public abstract class Residente extends Integrante {

    private House casa;

    public enum House {
        Gryffindor,
        Hufflepuff,
        Ravenclaw,
        Slytherin
    }

    public void setCasa(House casa) { this.casa = casa; }

    public House getCasa() { return casa; }

    public abstract boolean equals(Object obj);

}
