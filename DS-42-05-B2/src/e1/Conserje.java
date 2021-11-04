package e1;

import java.util.Objects;

public class Conserje extends Personal {

    /* constructor */
    public Conserje(String nombre, String apellidos, int edad, int destroyedHorrocruxes) {

        if (nombre == null || apellidos == null) {
            throw new IllegalArgumentException();
        }

        setNombre(nombre);
        setApellidos(apellidos);
        setEdad(edad);
        setDestroyedHorrocruxes(destroyedHorrocruxes);
    }

    /* cálculo de la recompensa */
    @Override
    public float recompensa() {
        return getDestroyedHorrocruxes() * 65;
    }

    @Override
    public int salario() {
        return 160;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conserje conserje = (Conserje) o;
        return (getSalario() == conserje.getSalario() &&
                Objects.equals(getNombre(), conserje.getNombre()) &&
                Objects.equals(getApellidos(), conserje.getApellidos()) &&
                getEdad() == conserje.getEdad() &&
                getDestroyedHorrocruxes() == conserje.getDestroyedHorrocruxes());
    }

}
