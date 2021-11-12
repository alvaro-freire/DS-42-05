/**
 * TITLE: Software Design B2
 * SUBTITLE: Exercise 2
 * @author Mateo Díaz Allegue @login mateo.diaz
 * @author Álvaro Freire Ares @login alvaro.freirea
 * GROUP: 4.2
 * DATE: 12 / 11 / 2021
 */

package e2;

import java.util.Comparator;

public interface SortBy extends Comparator<Anuncio> {

    int compare(Anuncio a1, Anuncio a2);

}
