package e2;

public class SortByTamano implements SortBy {

    @Override
    public int compare(Anuncio a1, Anuncio a2) {
        return Integer.compare(a1.getTamano(), a2.getTamano());
    }

}
