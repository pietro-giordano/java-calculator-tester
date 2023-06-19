package calculator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private Calculator calc;
    @BeforeEach
    public void init() {
        calc = new Calculator();
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        assertEquals(5, calc.add(3, 2), "La somma deve essere 5");
    }

    @org.junit.jupiter.api.Test
    void testSubstract() {
        assertEquals(5, calc.substract(8, 3), "Il risultato deve essere 5");
    }

    @org.junit.jupiter.api.Test
    void testMultiply() {
        assertEquals(30, calc.multiply(10, 3), "Il risultato deve essere 30");
    }

    @org.junit.jupiter.api.Test
    void testDivide() {
        assertEquals(2, calc.divide(6, 3), "Il risultato deve essere 2");
    }

    @org.junit.jupiter.api.Test
    void testDivideForZero() {
        assertThrows(ArithmeticException.class, () -> calc.divide(10, 0), "Deve tirare ArithmeticException se si divide per zero");
    }
}