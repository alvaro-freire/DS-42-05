package e1;

import java.util.Objects;

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
        this.fecha = new Date(fecha.getDay(), fecha.getMonth(), fecha.getYear());
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
        return new Date(fecha.getDay(), fecha.getMonth(), fecha.getYear());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || o.getClass() != getClass()) return false;
        Billete billete = (Billete) o;
        return getPrecio() == billete.getPrecio() &&
                getOrigen().equals(billete.getOrigen()) &&
                getDestino().equals(billete.getDestino()) &&
                getFecha().equals(billete.getFecha());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOrigen(), getDestino(), getPrecio(), getFecha());
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
