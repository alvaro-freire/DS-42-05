/**
 * TITLE: Software Design B2
 * SUBTITLE: Exercise 2
 * @author Mateo Díaz Allegue @login mateo.diaz
 * @author Álvaro Freire Ares @login alvaro.freirea
 * GROUP: 4.2
 * DATE: 12 / 11 / 2021
 */

package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Apartamentos {

    private final List<Anuncio> anuncioList = new ArrayList<>();

    private SortBy comparador;

    /* constructor */
    public Apartamentos() {
        this.comparador = null;
    }

    public List<Anuncio> getList() {
        return anuncioList;
    }

    public void setComparador(SortBy comparador) {
        this.comparador = comparador;
    }

    public SortBy getComparador() {
        return comparador;
    }

    /**
     * An anuncio is added to the list anuncioList.
     *
     * @param anuncio Instance of Anuncio
     */
    public void addAnuncio(Anuncio anuncio) {

        /* se comprueba si el parámetro es válido */
        if (anuncio == null) {
            throw new NullPointerException();
        }

        /* se comprueba si el anuncio ya está en la lista */
        for (Anuncio a : anuncioList) {
            if (a.equals(anuncio)) {
                throw new IllegalArgumentException();
            }
        }

        anuncioList.add(anuncio);
    }

    /**
     * An anuncio is removed from anuncioList.
     *
     * @param anuncio Instance of Anuncio
     */
    public void removeAnuncio(Anuncio anuncio) {

        /* se comprueba si el parámetro es válido */
        if (anuncio == null) {
            throw new NullPointerException();
        }

        /* se comprueba si existe ese anuncio en la lista */
        for (Anuncio a : anuncioList) {
            if (a.equals(anuncio)) {
                anuncioList.remove(anuncio);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * Anuncio at index position is returned.
     *
     * @param index Instance of Anuncio
     * @return The anuncio corresponding at index
     */
    public Anuncio getAnuncio(int index) {

        /* se comprueba si la lista está vacía o si el index es válido */
        if (anuncioList.isEmpty() || index < 0 || index >= anuncioList.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return anuncioList.get(index);
    }

    /**
     * anuncioList is cleared.
     *
     * @return void
     */
    public void clearList() {
        anuncioList.clear();
    }

    public void sortList() {

        /* si el comparador es null se ordena
        * por su orden predeterminado(numRef) */
        if (comparador == null) {
            Collections.sort(anuncioList);
        } else {
            /* sino se ordena con la ordenación pertinente */
            anuncioList.sort(comparador);
        }

    }

    /**
     * String with information of each anuncio
     * in anuncioList is returned.
     *
     * @return String with anuncios information
     */
    public String toString() {
        int i, totalPrize;
        String string = "";

        for (i = 0; i < anuncioList.size(); i++) {
            totalPrize = anuncioList.get(i).getPrecioBase() +
                    anuncioList.get(i).getPrecioPlaza() * anuncioList.get(i).getNumPlazas();
            string = string.concat("Anuncio " + i + ":\n\tNº Ref.: " + anuncioList.get(i).getNumReferencia() +
                    "\n\tPrecio base: " + anuncioList.get(i).getPrecioBase() + "\n\tPrecio plazas: " +
                    anuncioList.get(i).getPrecioPlaza() + "\n\tNº plazas: " + anuncioList.get(i).getNumPlazas() +
                    "\n\tPrecio total: " + totalPrize + "\n\tTamaño: " + anuncioList.get(i).getTamano() +
                    "\n\tCódigo postal: " + anuncioList.get(i).getCp() + "\n");
        }

        return string;
    }

}
