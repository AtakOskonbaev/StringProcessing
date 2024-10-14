import org.example.StringProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StringProcessorTest {
    @Test
    void isStrongPassword()
    {
        StringProcessor stringProcessor = new StringProcessor();

        assertTrue(stringProcessor.isStrongPassword("Password1!"), "Not strong enough");
        assertFalse(stringProcessor.isStrongPassword("password"), "Not strong enough");
        assertFalse(stringProcessor.isStrongPassword("PASSWORD123"), "Not strong enough");
        assertFalse(stringProcessor.isStrongPassword("123456!"), "Not strong enough");
        assertFalse(stringProcessor.isStrongPassword("Pass1"), "Not strong enough");
    }

    @Test
    void calculateDigits()
    {
        StringProcessor stringProcessor = new StringProcessor();

        assertEquals(3, stringProcessor.calculateDigits("Hello123"), "Wrong answer");
        assertEquals(5, stringProcessor.calculateDigits("12345"), "Wrong answer");
        assertEquals(0, stringProcessor.calculateDigits("abc!@#"), "Wrong answer");
        assertEquals(3, stringProcessor.calculateDigits("a1b2c3"), "Wrong answer");
        assertEquals(0, stringProcessor.calculateDigits(""), "Wrong answer");
    }

    @Test
    void calculateWords()
    {
        StringProcessor stringProcessor = new StringProcessor();

        assertEquals(2, stringProcessor.calculateWords("Hello world"), "Wrong answer");
        assertEquals(2, stringProcessor.calculateWords("   leading spaces"), "Wrong answer");
        assertEquals(2, stringProcessor.calculateWords("multiple   spaces"), "Wrong answer");
        assertEquals(0, stringProcessor.calculateWords(""), "Wrong answer");
        assertEquals(1, stringProcessor.calculateWords("One-word"), "Wrong answer");
    }

    @Test
    void calculateExpression()
    {
        StringProcessor stringProcessor = new StringProcessor();

        assertEquals(21, stringProcessor.calculateExpression("(1 + 2) * (3 + 4)"), "Wrong answer");
        assertEquals(22, stringProcessor.calculateExpression("10 + 2 * 6"), "Wrong answer");
        assertEquals(212, stringProcessor.calculateExpression("100 * 2 + 12"), "Wrong answer");
        assertEquals(1400, stringProcessor.calculateExpression("100 * (2 + 12)"), "Wrong answer");
        assertEquals(100, stringProcessor.calculateExpression("100 * (2 + 12) / 14"), "Wrong answer");
    }
}
