/**
 * TITLE: Software Design B2
 * SUBTITLE: Exercise 2
 * @author Mateo Díaz Allegue @login mateo.diaz
 * @author Álvaro Freire Ares @login alvaro.freirea
 * GROUP: 4.2
 * DATE: 12 / 11 / 2021
 */

package e2;

import java.util.Objects;

public class Anuncio implements Comparable<Anuncio> {

    private int numReferencia;

    private int precioBase;

    private int precioPlaza;

    private int numPlazas;

    private int tamano;

    private int cp;

    /* constructor */
    public Anuncio(int numReferencia, int precioBase, int precioPlaza, int numPlazas, int tamano, int cp) {

        if (numReferencia < 0 || precioBase < 0 || precioPlaza < 0 || numPlazas < 0 || tamano < 0 || cp < 0) {
            throw new IllegalArgumentException();
        }

        this.numReferencia = numReferencia;
        this.precioBase = precioBase;
        this.precioPlaza = precioPlaza;
        this.numPlazas = numPlazas;
        this.tamano = tamano;
        this.cp = cp;

    }

    /* getters y setters */
    public int getNumReferencia() {
        return numReferencia;
    }

    public void setNumReferencia(int numReferencia) {

        if (numReferencia < 0) {
            throw new IllegalArgumentException();
        }

        this.numReferencia = numReferencia;
    }

    public int getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(int precioBase) {

        if (precioBase < 0) {
            throw new IllegalArgumentException();
        }

        this.precioBase = precioBase;
    }

    public int getPrecioPlaza() {
        return precioPlaza;
    }

    public void setPrecioPlaza(int precioPlaza) {

        if (precioPlaza < 0) {
            throw new IllegalArgumentException();
        }

        this.precioPlaza = precioPlaza;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {

        if (numPlazas < 0) {
            throw new IllegalArgumentException();
        }

        this.numPlazas = numPlazas;
    }

    public int getTamano() {
        return tamano;
    }

    public void setTamano(int tamano) {

        if (tamano < 0) {
            throw new IllegalArgumentException();
        }

        this.tamano = tamano;
    }

    public int getCp() {
        return cp;
    }

    public void setCp(int cp) {

        if (cp < 0) {
            throw new IllegalArgumentException();
        }

        this.cp = cp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anuncio anuncio = (Anuncio) o;
        return (precioBase == anuncio.getPrecioBase() &&
                precioPlaza == anuncio.getPrecioPlaza() &&
                numPlazas == anuncio.getNumPlazas() &&
                tamano == anuncio.getTamano() &&
                cp == anuncio.getCp());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPrecioBase(), getPrecioPlaza(),
                getNumPlazas(), getTamano(), getCp());
    }

    /**
     * An instance of Anuncio is compared to another by its
     * reference number.
     *
     * @param o Instance of Anuncio
     * @return Zero if they are equals, 1 if the calling object
     * is greater and -1 if the calling object is smaller
     */
    @Override
    public int compareTo(Anuncio o) {
        return Integer.compare(numReferencia, o.numReferencia);
    }

}
