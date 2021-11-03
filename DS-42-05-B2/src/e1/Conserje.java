package e1;

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
}
