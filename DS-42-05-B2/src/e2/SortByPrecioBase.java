package e2;

public class SortByPrecioBase implements SortBy {

    @Override
    public int compare(Anuncio a1, Anuncio a2) {
        return Integer.compare(a1.getPrecioBase(), a2.getPrecioBase());
    }

}
