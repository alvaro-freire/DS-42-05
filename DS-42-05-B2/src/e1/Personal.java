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
