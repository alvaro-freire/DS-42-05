package e1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringCountTest {

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void countWords() {
        assertEquals(0, StringCount.countWords(null));
        assertEquals(2, StringCount.countWords("Hello World"));
        assertEquals(1, StringCount.countWords("Hello World"));
        assertEquals(2, StringCount.countWords("Hello World"));
    }

    @Test
    void countChar() {

    }

    @Test
    void countCharIgnoringCase() {

    }

    @Test
    void isPasswordSafe() {

    }
}