package e1;

import java.util.Objects;

public class Conserje extends Personal {

    /* constructor */
    public Conserje(String nombre, String apellidos, int edad, int destroyedHorrocruxes) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.destroyedHorrocruxes = destroyedHorrocruxes;
    }

    /* cálculo de la recompensa */
    @Override
    public float recompensa() {
        return this.destroyedHorrocruxes * 65;
    }

    @Override
    public int salario() {
        return 160;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conserje conserje = (Conserje) o;
        return (salario == conserje.salario &&
                Objects.equals(nombre, conserje.nombre) &&
                Objects.equals(apellidos, conserje.apellidos) &&
                edad == conserje.edad &&
                destroyedHorrocruxes == conserje.destroyedHorrocruxes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salario);
    }

}
