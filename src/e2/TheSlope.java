package e2;

import java.lang.reflect.Array;

public class TheSlope {
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
                    return 0;
            }
        }

        while (y <= slopeMap.length) {
            for (; x <= right; x++) {
                if (x == slopeMap[0].length) {
                    x = 0;
                }
                if (slopeMap[y][x] == '#')
                    tree++;
            }
            if (down == 0) {
             return tree;
            } else {
                y++;
                for (; y <= down; y++) {
                    if (slopeMap[y][x] == '#')
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
