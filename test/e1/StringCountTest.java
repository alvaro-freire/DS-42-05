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
        assertEquals(1, StringCount.countWords("Hello"));
        assertEquals(2, StringCount.countWords("Hello World"));
        assertEquals(5, StringCount.countWords("a b c d e "));
    }

    @Test
    void countChar() {
        assertEquals(0, StringCount.countChar(null, 'c'));
        assertEquals(1, StringCount.countChar("xyx", 'y'));
        assertEquals(2 , StringCount.countChar("platano y manzana", ' '));
        assertEquals(5 , StringCount.countChar("platano y manzana", 'a'));
    }

    @Test
    void countCharIgnoringCase() {

    }

    @Test
    void isPasswordSafe() {

    }
}