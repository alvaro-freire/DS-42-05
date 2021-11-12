/**
 * TITLE: Software Design B2
 * SUBTITLE: Exercise 2
 * @author Mateo Díaz Allegue @login mateo.diaz
 * @author Álvaro Freire Ares @login alvaro.freirea
 * GROUP: 4.2
 * DATE: 12 / 11 / 2021
 */

package e2;

public class SortByCp implements SortBy {

    /**
     * Two instances of Anuncio are compared by its
     * cp field.
     *
     * @param a1 Instance of Anuncio
     * @param a2 Instance of anuncio
     * @return Zero if they are equals, 1 if a1 is greater
     * and -1 if a2 is smaller
     */
    @Override
    public int compare(Anuncio a1, Anuncio a2) {
        return Integer.compare(a1.getCp(), a2.getCp());
    }

}
