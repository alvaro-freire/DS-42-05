package e2;

public class SortByPrecioTotal implements SortBy {

    @Override
    public int compare(Anuncio a1, Anuncio a2) {
        int at1, at2;

        at1 = a1.getPrecioBase() + a1.getPrecioPlaza() * a1.getNumPlazas();
        at2 = a2.getPrecioBase() + a2.getPrecioPlaza() * a2.getNumPlazas();

        return Integer.compare(at1, at2);
    }

}
