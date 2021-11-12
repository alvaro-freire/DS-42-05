/**
 * TITLE: Software Design B2
 * SUBTITLE: Exercise 2
 * @author Mateo Díaz Allegue @login mateo.diaz
 * @author Álvaro Freire Ares @login alvaro.freirea
 * GROUP: 4.2
 * DATE: 12 / 11 / 2021
 */

package e2;

public class SortByPrecioTotal implements SortBy {

    /**
     * Two instances of Anuncio are compared by its
     * total prize.
     *
     * @param a1 Instance of Anuncio
     * @param a2 Instance of anuncio
     * @return Zero if they are equals, 1 if a1 is greater
     * and -1 if a2 is smaller
     */
    @Override
    public int compare(Anuncio a1, Anuncio a2) {
        int at1, at2;

        at1 = a1.getPrecioBase() + a1.getPrecioPlaza() * a1.getNumPlazas();
        at2 = a2.getPrecioBase() + a2.getPrecioPlaza() * a2.getNumPlazas();

        return Integer.compare(at1, at2);
    }

}
