package e1;

import java.util.Objects;

public class Fantasma extends Residente {

    /* constructor */
    public Fantasma(String nombre, String apellidos, int edad, int destroyedHorrocruxes, House casa) {

        if (nombre == null || apellidos == null || casa == null) {
            throw new NullPointerException();
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

        reward = getDestroyedHorrocruxes() * 80;
        if (getCasa() == House.Slytherin) {
            reward *= 2;
        }
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fantasma fantasma = (Fantasma) o;
        return (getCasa() == fantasma.getCasa() &&
                Objects.equals(getNombre(), fantasma.getNombre()) &&
                Objects.equals(getApellidos(), fantasma.getApellidos()) &&
                getEdad() == fantasma.getEdad() &&
                getDestroyedHorrocruxes() == fantasma.getDestroyedHorrocruxes());
    }
}
