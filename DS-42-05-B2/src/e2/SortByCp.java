package e2;

public class SortByCp implements SortBy {

    @Override
    public int compare(Anuncio a1, Anuncio a2) {
        return Integer.compare(a1.getCp(), a2.getCp());
    }

}
