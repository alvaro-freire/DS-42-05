/*
 * TITLE: Software Design
 * SUBTITLE: exercise 4
 * AUTHOR 1: Mateo Díaz Allegue LOGIN 1: mateo.diaz
 * AUTHOR 2: Álvaro Freire Ares LOGIN 2: alvaro.freirea
 * GROUP: 4.2
 * DATE: 08 / 10 / 2021
 */

package e2;

public class Slopes {
    /**
     * Goes through the map and check if it
     * is valid and also if movements are .
     *
     * @param slopeMap A square matrix representing the slope with spaces
     *                 represented as "." and trees represented as "#".
     * @param right    Movement to the right
     * @param down     Downward movement
     *
     */
    private static void mapCheck(char[][] slopeMap, int right, int down) {
        for (char[] chars : slopeMap) {
            for (char aChar : chars) {
                if ((aChar != '.' && aChar != '#') || slopeMap.length != chars.length)
                    throw new IllegalArgumentException();
            }
        }

        if (right >= slopeMap.length || right < 0 || down >= slopeMap[0].length || down < 1) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     *
     * @param slopeMap A square matrix representing the slope with spaces
     *                 represented as "." and trees represented as "#".
     * @param right    Movement to the right
     * @param down     Downward movement
     * @return Number of trees
     */
    public static int downTheSlope(char[][] slopeMap, int right, int down) {
        int x = 0, y = 0, tree = 0;

        mapCheck(slopeMap, right, down);

        /* Se comprueba si en la posición de partida hay un árbol */
        if (slopeMap[0][0] == '#')
            tree++;

        /* Se realiza el algoritmo para recorrer el mapa
         * realizando los movimientos correspondientes */
        while (y < slopeMap.length) {
            /* movements to the right: */
            for (int a = 0; a < right; a++) {
                x++;
                if (x == slopeMap[0].length)
                    x = 0;
                if (slopeMap[y][x] == '#')
                    tree++;
            }
            /* movements down: */
            for (int b = 0; b < down; b++) {
                y++;
                if (y >= slopeMap.length)
                    break;
                if (slopeMap[y][x] == '#')
                    tree++;
            }
        }
        return tree;
    }

    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     * Since it " jumps " from the initial position to the final position ,
     * only takes into account the trees on those initial / final positions .
     * *
     * Params , return value and thrown expections as in downTheSlope ...
     */
    public static int jumpTheSlope(char[][] slopeMap, int right, int down) {
        int x = 0, y = 0, tree = 0;

        mapCheck(slopeMap, right, down);

        if (slopeMap[0][0] == '#') {
            tree++;
        }

        /* Se realiza el algoritmo para recorrer el mapa
         * realizando los movimientos correspondientes */
        while (y < slopeMap.length) {
            /* movements to the right: */
            for (int a = 0; a < right; a++) {
                x++;
                if (x == slopeMap[0].length) {
                    x = 0;
                }
            }
            /* movements down: */
            for (int b = 0; b < down; b++) {
                y++;
                if (y >= slopeMap.length) {
                    break;
                }
            }
            if (y < slopeMap.length && slopeMap[y][x] == '#') {
                tree++;
            }
        }
        return tree;
    }
}
