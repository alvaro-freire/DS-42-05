package e1;

import java.util.Objects;

public class Guardabosques extends Personal {

    /* constructor */
    public Guardabosques(String nombre, String apellidos, int edad, int destroyedHorrocruxes) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.destroyedHorrocruxes = destroyedHorrocruxes;
    }

    /* cálculo de la recompensa */
    @Override
    public float recompensa() {
        return this.destroyedHorrocruxes * 75;
    }

    @Override
    public int salario() {
        return 180;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guardabosques guardabosques = (Guardabosques) o;
        return (salario == guardabosques.salario &&
                Objects.equals(nombre, guardabosques.nombre) &&
                Objects.equals(apellidos, guardabosques.apellidos) &&
                edad == guardabosques.edad &&
                destroyedHorrocruxes == guardabosques.destroyedHorrocruxes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salario);
    }

}
