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
        assertEquals(-1, Slopes.downTheSlope(invalidCharacter, 1, 1));
        assertEquals(-1, Slopes.downTheSlope(nonSquareMap1, 1, 1));
        assertEquals(-1, Slopes.downTheSlope(nonSquareMap2, 1, 1));
        assertEquals(5, Slopes.downTheSlope(map, 1, 1));
        assertEquals(6, Slopes.downTheSlope(miniMap, 2, 1));
    }

    @Test
    void jumpTheSlope() {
        assertEquals(0, Slopes.jumpTheSlope(null, 3, 0));
    }
}