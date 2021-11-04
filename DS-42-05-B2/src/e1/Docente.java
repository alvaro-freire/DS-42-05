package e1;

import java.util.Objects;

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

    private Asignatura asignatura;

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    /* constructor */
    public Docente(String nombre, String apellidos, int edad, int destroyedHorrocruxes, Asignatura asignatura) {

        if (nombre == null || apellidos == null || asignatura == null) {
            throw new IllegalArgumentException();
        }

        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setDestroyedHorrocruxes(destroyedHorrocruxes);
        setAsignatura(asignatura);
    }

    /* cálculo de la recompensa */
    @Override
    public float recompensa() {
        float reward;

        reward = getDestroyedHorrocruxes() * 50;
        if (asignatura == Asignatura.Defensa) {
            reward *= 0.75;
        }
        return reward;
    }

    @Override
    public int salario() {
        return this.asignatura.getSueldo();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Docente docente = (Docente) o;
        return (getSalario() == docente.getSalario() &&
                Objects.equals(getNombre(), docente.getNombre()) &&
                Objects.equals(getApellidos(), docente.getApellidos()) &&
                getEdad() == docente.getEdad() &&
                getDestroyedHorrocruxes() == docente.getDestroyedHorrocruxes());
    }

}
