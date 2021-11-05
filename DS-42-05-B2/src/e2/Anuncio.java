package e2;

public class Anuncio implements Comparable<Anuncio> {

    private int numReferencia;

    private int precioBase;

    private int precioPlaza;

    private int numPlazas;

    private int tamano;

    private int cp;

    /* constructor */
    public Anuncio(int numReferencia, int precioBase, int precioPlaza, int numPlazas, int tamano, int cp) {
            this.numReferencia = numReferencia;
            this.precioBase = precioBase;
            this.precioPlaza = precioPlaza;
            this.numPlazas = numPlazas;
            this.tamano = tamano;
            this.cp = cp;
    }

    /* getters y setters */
    public int getNumReferencia() { return numReferencia; }
    public void setNumReferencia(int numReferencia) { this.numReferencia = numReferencia; }

    public int getPrecioBase() { return precioBase; }
    public void setPrecioBase(int precioBase) { this.precioBase = precioBase;}

    public int getPrecioPlaza() { return precioPlaza; }
    public void setPrecioPlaza(int precioPlaza) { this.precioPlaza = precioPlaza; }

    public int getNumPlazas() { return numPlazas; }
    public void setNumPlazas(int numPlazas) { this.numPlazas = numPlazas; }

    public int getTamano() { return tamano; }
    public void setTamano(int tamano) { this.tamano = tamano; }

    public int getCp() { return cp; }
    public void setCp(int cp) { this.cp = cp; }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() == o.getClass()) return false;
        Anuncio anuncio = (Anuncio) o;
        return (precioBase == anuncio.getPrecioBase() &&
                precioPlaza == anuncio.getPrecioPlaza() &&
                numPlazas == anuncio.getNumPlazas() &&
                tamano == anuncio.getTamano() &&
                cp == anuncio.getCp());
    }

    @Override
    public int compareTo(Anuncio o) {
        return Integer.compare(numReferencia, o.numReferencia);
    }

}
