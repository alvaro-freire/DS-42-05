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
        assertThrows(IllegalArgumentException.class, () -> Slopes.downTheSlope(nonSquareMap1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> Slopes.downTheSlope(nonSquareMap2, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> Slopes.downTheSlope(invalidCharacter, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> Slopes.downTheSlope(map, 11, 1));
        assertThrows(IllegalArgumentException.class, () -> Slopes.downTheSlope(map, 1, 11));
        assertThrows(IllegalArgumentException.class, () -> Slopes.downTheSlope(map, -1, 1));
        assertThrows(IllegalArgumentException.class, () -> Slopes.downTheSlope(map, 1, 0));
    }

    @Test
    void jumpTheSlope() {
        assertEquals(2, Slopes.jumpTheSlope(map, 1, 1));
        assertEquals(7, Slopes.jumpTheSlope(map, 3, 1));
        assertEquals(3, Slopes.jumpTheSlope(map, 5, 1));
        assertEquals(4, Slopes.jumpTheSlope(map, 7, 1));
        assertEquals(2, Slopes.jumpTheSlope(map, 1, 2));
        assertEquals(1, Slopes.jumpTheSlope(map, 10, 10));

        assertEquals( 0, Slopes.jumpTheSlope(miniMap,  1,  1));
        assertEquals( 1, Slopes.jumpTheSlope(miniMap,  3,  2));
        assertEquals( 0, Slopes.jumpTheSlope(miniMap,  4,  3));

        assertThrows(IllegalArgumentException.class, () -> Slopes.jumpTheSlope(nonSquareMap1, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> Slopes.jumpTheSlope(nonSquareMap2, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> Slopes.jumpTheSlope(invalidCharacter, 1, 1));
        assertThrows(IllegalArgumentException.class, () -> Slopes.jumpTheSlope(map, 11, 1));
        assertThrows(IllegalArgumentException.class, () -> Slopes.jumpTheSlope(map, 1, 11));
        assertThrows(IllegalArgumentException.class, () -> Slopes.jumpTheSlope(map, -1, 1));
        assertThrows(IllegalArgumentException.class, () -> Slopes.jumpTheSlope(map, 1, 0));
    }
}