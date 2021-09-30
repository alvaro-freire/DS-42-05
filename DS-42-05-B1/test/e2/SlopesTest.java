package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SlopesTest {
    char[][] map = {
            {'.', '.', '#', '#', '.', '.', '.', '.', '.', '.', '.'},
            {'#', '.', '.', '.', '#', '.', '.', '.', '#', '.', '.'},
            {'.', '#', '.', '.', '.', '.', '#', '.', '.', '#', '.'},
            {'.', '.', '#', '.', '#', '.', '.', '.', '#', '.', '#'},
            {'.', '#', '.', '.', '.', '#', '#', '.', '.', '#', '.'},
            {'.', '.', '#', '.', '#', '#', '.', '.', '.', '.', '.'},
            {'.', '#', '.', '#', '.', '#', '.', '.', '.', '.', '#'},
            {'.', '#', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '#', '#', '.', '.', '.', '#', '.', '.', '.'},
            {'#', '.', '.', '.', '#', '#', '.', '.', '.', '.', '#'},
            {'.', '#', '.', '.', '#', '.', '.', '.', '#', '.', '#'}
    };

    char[][] miniMap = {
            {'.', '.', '#', '.', '#'},
            {'#', '.', '.', '.', '.'},
            {'#', '#', '.', '.', '#'},
            {'#', '#', '.', '.', '.'},
            {'.', '#', '.', '#', '.'}
    };

    char[][] nonSquareMap1 = {
            {'.'},
            {'#', '.'},
            {'.', '#', '.'}
    };
    char[][] nonSquareMap2 = {
            {'.', '#', '.'},
            {'.', '#'},
            {'#', '.'}
    };
    char[][] invalidCharacter = {
            {'.', '.', '.'},
            {'#', '#', '.'},
            {'.', '#', 'a'}
    };

    @Test
    void downTheSlope() {
        //assertEquals(-1, Slopes.downTheSlope(invalidCharacter, 1, 1));
        //assertEquals(-1, Slopes.downTheSlope(nonSquareMap1, 1, 1));
        //assertEquals(-1, Slopes.downTheSlope(nonSquareMap2, 1, 1));
        //assertEquals(5, Slopes.downTheSlope(map, 1, 1));
        //assertEquals(6, Slopes.downTheSlope(miniMap, 2, 1));

        assertEquals( 5, Slopes.downTheSlope(map,  1,  1));
        assertEquals(17, Slopes.downTheSlope(map,  3,  1));
        assertEquals(18, Slopes.downTheSlope(map,  5,  1));
        assertEquals(30, Slopes.downTheSlope(map,  7,  1));
        assertEquals( 4, Slopes.downTheSlope(map,  1,  2));
        assertEquals(10, Slopes.downTheSlope(map, 10, 10));

        assertEquals( 0, Slopes.downTheSlope(miniMap,  1,  1));
        assertEquals( 7, Slopes.downTheSlope(miniMap,  3,  2));
        assertEquals( 6, Slopes.downTheSlope(miniMap,  4,  3));
    }

    @Test
    void jumpTheSlope() {
        assertEquals(0, Slopes.jumpTheSlope(null, 3, 0));
    }
}