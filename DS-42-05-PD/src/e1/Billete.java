package e1;

public class Billete {

    private final String origen;
    private final String destino;
    private final int precio;
    private final Date fecha;

    Billete (String origen, String destino, int precio, Date fecha) {
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
        return "\t\tBillete {\n" +
                "\t\t\torigen = '" + origen + "'\n" +
                "\t\t\tdestino = '" + destino + "'\n" +
                "\t\t\tprecio = " + precio + '\n' +
                "\t\t\tfecha = " + fecha +
                "\n\t\t}";
    }
}
