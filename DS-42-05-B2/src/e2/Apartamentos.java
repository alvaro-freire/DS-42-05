package e2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Apartamentos {

    private List<Anuncio> anuncioList = new ArrayList<>();

    private SortBy comparador;

    /* constructor */
    public Apartamentos() { this.comparador = null; }

    public List<Anuncio> getList() { return anuncioList; }

    public void setComparador(SortBy comparador) { this.comparador = comparador; }

    public SortBy getComparador() { return comparador; }

    public void addAnuncio(Anuncio anuncio) {

        if (anuncio == null) {
            throw new IllegalArgumentException();
        }

        for (Anuncio a : anuncioList) {
            if (a.equals(anuncio)) {
                throw new IllegalArgumentException();
            }
        }

        anuncioList.add(anuncio);
    }

    public void removeAnuncio(Anuncio anuncio) {

        for (Anuncio a : anuncioList) {
            if (a.equals(anuncio)) {
                anuncioList.remove(anuncio);
                return;
            }
        }
        throw new IllegalArgumentException();
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

}
