package e2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TheSlopeTest {

    @Test
    void downTheSlope() {
        assertEquals(0, TheSlope.downTheSlope(null, 3, 0));
    }

    @Test
    void jumpTheSlope() {
        assertEquals(0, TheSlope.jumpTheSlope(null, 3, 0));
    }
}