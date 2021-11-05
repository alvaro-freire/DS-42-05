package e1;

public abstract class Integrante {

    private String nombre;
    private String apellidos;
    private int edad;
    private int destroyedHorrocruxes;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getDestroyedHorrocruxes() {
        return destroyedHorrocruxes;
    }

    public void setDestroyedHorrocruxes(int destroyedHorrocruxes) {
        this.destroyedHorrocruxes = destroyedHorrocruxes;
    }

    public abstract float recompensa();

    public abstract boolean equals(Object obj);
}
