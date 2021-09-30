package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheSlopeTest {
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
        assertEquals(0, TheSlope.downTheSlope(invalidCharacter, 1, 1));
        assertEquals(0, TheSlope.downTheSlope(nonSquareMap1, 1, 1));
        assertEquals(0, TheSlope.downTheSlope(nonSquareMap2, 1, 1));
        assertEquals(1, TheSlope.downTheSlope(map, 1, 1));
        assertEquals(1, TheSlope.downTheSlope(miniMap, 1, 1));
    }

    @Test
    void jumpTheSlope() {
        assertEquals(0, TheSlope.jumpTheSlope(null, 3, 0));
    }
}