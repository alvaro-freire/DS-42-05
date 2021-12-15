package e1;

public final class Billete {

    private final String origen;
    private final String destino;
    private final int precio;
    private final Date fecha;

    Billete (String origen, String destino, int precio, Date fecha) {

        if (origen == null || destino == null || fecha == null) {
            throw new NullPointerException();
        }

        if (precio < 0) {
            throw new IllegalArgumentException();
        }

        this.origen = origen;
        this.destino = destino;
        this.precio = precio;
        this.fecha = fecha;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDestino() {
        return destino;
    }

    public int getPrecio() {
        return precio;
    }

    public Date getFecha() {
        return fecha;
    }

    @Override
    public String toString() {
        return "\n\tBillete {\n" +
                "\t\torigen = '" + origen + "'\n" +
                "\t\tdestino = '" + destino + "'\n" +
                "\t\tprecio = " + precio + '\n' +
                "\t\tfecha = " + fecha +
                "\n\t}\n";
    }
}
