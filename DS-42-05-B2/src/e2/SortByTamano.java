/**
 * TITLE: Software Design B2
 * SUBTITLE: Exercise 2
 * @author Mateo Díaz Allegue @login mateo.diaz
 * @author Álvaro Freire Ares @login alvaro.freirea
 * GROUP: 4.2
 * DATE: 12 / 11 / 2021
 */

package e2;

public class SortByTamano implements SortBy {

    @Override
    public int compare(Anuncio a1, Anuncio a2) {
        return Integer.compare(a1.getTamano(), a2.getTamano());
    }

}
