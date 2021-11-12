/**
 * TITLE: Software Design B2
 * SUBTITLE: Exercise 1
 * @author Mateo Díaz Allegue @login mateo.diaz
 * @author Álvaro Freire Ares @login alvaro.freirea
 * GROUP: 4.2
 * DATE: 12 / 11 / 2021
 */

package e1;

import java.util.Objects;

public abstract class Residente extends Integrante {

    private House casa;

    public enum House {
        Gryffindor,
        Hufflepuff,
        Ravenclaw,
        Slytherin
    }

    public void setCasa(House casa) {
        this.casa = casa;
    }

    public House getCasa() {
        return casa;
    }

    public abstract boolean equals(Object obj);

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), casa);
    }
}
