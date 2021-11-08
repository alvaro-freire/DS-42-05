package e1;

import java.util.Objects;

public class Guardabosques extends Personal {

    /* constructor */
    public Guardabosques(String nombre, String apellidos, int edad, int destroyedHorrocruxes) {

        if (nombre == null || apellidos == null) {
            throw new NullPointerException();
        }

        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setDestroyedHorrocruxes(destroyedHorrocruxes);
    }

    /* cálculo de la recompensa */
    @Override
    public float recompensa() {
        return this.getDestroyedHorrocruxes() * 75;
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
        return (getSalario() == guardabosques.getSalario() &&
                Objects.equals(getNombre(), guardabosques.getNombre()) &&
                Objects.equals(getApellidos(), guardabosques.getApellidos()) &&
                getEdad() == guardabosques.getEdad() &&
                getDestroyedHorrocruxes() == guardabosques.getDestroyedHorrocruxes());
    }

}
