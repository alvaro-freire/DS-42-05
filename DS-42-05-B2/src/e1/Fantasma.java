package e1;

import java.util.Objects;

public class Fantasma extends Residente {

    /* constructor */
    public Fantasma(String nombre, String apellidos, int edad, int destroyedHorrocruxes, House casa) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.destroyedHorrocruxes = destroyedHorrocruxes;
        this.casa = casa;
    }

    /* cálculo de la recompensa */
    @Override
    public float recompensa() {
        int reward;

        reward = this.destroyedHorrocruxes * 80;
        if (casa == House.Slytherin) {
            reward *= 2;
        }
        return reward;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fantasma fantasma = (Fantasma) o;
        return (casa == fantasma.casa &&
                Objects.equals(nombre, fantasma.nombre) &&
                Objects.equals(apellidos, fantasma.apellidos) &&
                edad == fantasma.edad &&
                destroyedHorrocruxes == fantasma.destroyedHorrocruxes);
    }
}
