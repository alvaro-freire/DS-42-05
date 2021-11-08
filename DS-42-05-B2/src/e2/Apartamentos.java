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

    public void addAnuncio(Anuncio anuncio) {

        if (anuncio == null) {
            throw new NullPointerException();
        }

        for (Anuncio a : anuncioList) {
            if (a.equals(anuncio)) {
                throw new IllegalArgumentException();
            }
        }

        anuncioList.add(anuncio);
    }

    public void removeAnuncio(Anuncio anuncio) {

        if (anuncio == null) {
            throw new NullPointerException();
        }

        for (Anuncio a : anuncioList) {
            if (a.equals(anuncio)) {
                anuncioList.remove(anuncio);
                return;
            }
        }
        throw new IllegalArgumentException();
    }

    public Anuncio getAnuncio(int index) {

        if (anuncioList.isEmpty() || index < 0 || index >= anuncioList.size()) {
            throw new ArrayIndexOutOfBoundsException();
        }

        return anuncioList.get(index);
    }

    public void clearList() {
        anuncioList.clear();
    }

    public void sortList() {

        if (comparador == null) {
            Collections.sort(anuncioList);
        } else {
            anuncioList.sort(comparador);
        }

    }

    public String toString() {
        String string = "";
        int i, totalPrize;

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
