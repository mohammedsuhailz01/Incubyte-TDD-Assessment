import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {
    @Test
    public void testEmptyString() {
        StringCalculator calc = new StringCalculator();
        assertEquals(0, calc.add(""));
    }
    @Test
    public void testSingleNumber() {
        StringCalculator calc = new StringCalculator();
        assertEquals(1, calc.add("1"));
    }
    @Test
    public void testMultipleNumbers() {
        StringCalculator calc = new StringCalculator();
        assertEquals(10, calc.add("1,2,3,4"));
    }
    @Test
    public void testNewLinesBetweenNumbers() {
        StringCalculator calc = new StringCalculator();
        assertEquals(6, calc.add("1\n2,3"));
    }
    @Test
    public void testCustomDelimiter() {
        StringCalculator calc = new StringCalculator();
        assertEquals(3, calc.add("//;\n1;2"));
    }
    @Test
    public void testNegativeNumbers() {
        StringCalculator calc = new StringCalculator();
        Exception exception = assertThrows(IllegalArgumentException.class, () -> calc.add("1,-2,3,-4"));
        assertEquals("Negative numbers not allowed: -2,-4", exception.getMessage());
    }
}