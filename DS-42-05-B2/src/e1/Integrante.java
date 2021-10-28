package e1;

public abstract class Integrante {

    public String nombre;
    public String apellidos;
    public int edad;
    public int destroyedHorrocruxes;

    public String getName() {
        return this.nombre;
    }

    public int getAge() {
        return this.edad;
    }

    public abstract int recompensa();
}
