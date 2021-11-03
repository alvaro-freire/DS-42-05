package e1;

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
}
