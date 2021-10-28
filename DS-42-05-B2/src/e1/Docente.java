package e1;

public class Docente extends Personal {

    public enum Asignatura {
        Historia("Historia"),
        Tranformaciones("Tranformaciones"),
        Defensa("Defensa"),
        Herbologia("Herbología"),
        Pociones("Pociones");

        private final String materia;

        Asignatura(String materia) { this.materia = materia; }

        public String getMateria() { return materia; }
    }

    public int recompensa() {
        return this.destroyedHorrocruxes * 50;
    }
}
