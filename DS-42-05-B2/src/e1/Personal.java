package e1;

public abstract class Personal extends Integrante {

    private int salario;

    public int getSalario() {
        return salario;
    }

    public void setSalario(int salario) {
        this.salario = salario;
    }

    public abstract int salario();

    public abstract boolean equals(Object obj);

}
