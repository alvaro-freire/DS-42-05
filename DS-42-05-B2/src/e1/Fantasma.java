package e1;

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
}
