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

public abstract class Personal extends Integrante {

    private int salario;

    public int getSalario() {
        return salario;
    }

    public abstract int salario();

    public abstract boolean equals(Object obj);

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salario);
    }
}
