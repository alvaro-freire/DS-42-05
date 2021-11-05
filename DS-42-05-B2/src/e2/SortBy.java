package e2;

import java.util.Comparator;

public interface SortBy extends Comparator<Anuncio> {

    int compare(Anuncio a1, Anuncio a2);

}
