package e1;

import java.util.Objects;

public class Estudiante extends Residente {

    /* constructor */
    public Estudiante(String nombre, String apellidos, int edad, int destroyedHorrocruxes, House casa) {

        if (nombre == null || apellidos == null || casa == null) {
            throw new IllegalArgumentException();
        }

        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setDestroyedHorrocruxes(destroyedHorrocruxes);
        setCasa(casa);
    }

    /* cálculo de la recompensa */
    @Override
    public float recompensa() {
        int reward;

        reward = getDestroyedHorrocruxes() * 90;
        if (getCasa() == House.Slytherin) {
            reward *= 2;
        }
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Estudiante estudiante = (Estudiante) o;
        return (getCasa() == estudiante.getCasa() &&
                Objects.equals(getNombre(), estudiante.getNombre()) &&
                Objects.equals(getApellidos(), estudiante.getApellidos()) &&
                getEdad() == estudiante.getEdad() &&
                getDestroyedHorrocruxes() == estudiante.getDestroyedHorrocruxes());
    }

}
