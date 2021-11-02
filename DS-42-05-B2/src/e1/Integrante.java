package e1;

public abstract class Integrante {

    public String nombre;
    public String apellidos;
    public int edad;
    public int destroyedHorrocruxes;

    public String getNombre() {
        return nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public int getDestroyedHorrocruxes() {
        return destroyedHorrocruxes;
    }

    public abstract float recompensa();
}
