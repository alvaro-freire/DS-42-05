package e2;

import java.lang.reflect.Array;

public class Slopes {
    /**
     * Traverses the slope map making the right and down movements and
     * returns the number of trees found along the way .
     *
     * @param slopeMap A square matrix representing the slope with spaces
     *                 represented as "." and trees represented as "#".
     * @param right    Movement to the right
     * @param down     Downward movement
     * @return Number of trees
     * @throws IllegalArgumentException if the matrix is incorrect because :
     *                                  - It is not square .
     *                                  - It has characters other than "." and "#"
     *                                  - right >= number of columns or right < 1
     *                                  - down >= number of rows of the matrix or down < 1
     */
    public static int downTheSlope(char[][] slopeMap, int right, int down) {
        int x = 0, y = 0, tree = 0;

        /* Se recorre el mapa para corroborar que sea válido */
        for (char[] chars : slopeMap) {
            for (char aChar : chars) {
                if ((aChar != '.' && aChar != '#') || slopeMap.length != chars.length)
                    return -1;
            }
        }

        if (slopeMap[0][0] == '#') {
            tree++;
        }

        while (y < slopeMap.length) {
            for (int a = 0; a < right; a++) {
                x++;
                if (x == slopeMap[0].length) {
                    x = 0;
                }
                if (slopeMap[y][x] == '#') {
                    tree++;
                }
            }
            for (int b = 0; b < down; b++) {
                y++;
                if (y >= slopeMap.length) {
                    break;
                }
                if (slopeMap[y][x] == '#') {
                    tree++;
                }
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

        return 0;
    }
}
