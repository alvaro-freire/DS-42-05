package e1;

public class Docente extends Personal {

    public enum Asignatura {
        Historia(200),
        Tranformaciones(400),
        Defensa(500),
        Herbologia(250),
        Pociones(350);

        private final int sueldo;

        Asignatura(int sueldo) { this.sueldo = sueldo; }

        public int getSueldo() { return sueldo; }
    }

    Asignatura asignatura;

    /* constructor */
    public Docente(String nombre, String apellidos, int edad, int destroyedHorrocruxes, Asignatura asignatura) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.edad = edad;
        this.destroyedHorrocruxes = destroyedHorrocruxes;
        this.asignatura = asignatura;
    }

    /* cálculo de la recompensa */
    @Override
    public float recompensa() {
        float reward;

        reward = this.destroyedHorrocruxes * 50;
        if (asignatura == Asignatura.Defensa) {
            reward *= 0.75;
        }
        return reward;
    }

    @Override
    public int salario() {
        return this.asignatura.getSueldo();
    }
}
