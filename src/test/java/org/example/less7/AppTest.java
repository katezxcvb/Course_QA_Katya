package org.example.less7;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.example.TestBase;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class AppTest extends TestBase
{

    @Test void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    // ---------- Факториал
    @Test
    void testFactorialOf5() {
        assertEquals(120, App.getFactorial(5));
    }

    @Test
    void testFactorialOf0() {
        assertEquals(1, App.getFactorial(0));
    }

    //Площадь треугольника
    @Test
    void testTriangleArea() {
        assertEquals(6.0, App.calculateTriangle(3, 4, 5), 0.0001);
    }

    @Test
    void testTriangleImpossible() {
        assertTrue(Double.isNaN(App.calculateTriangle(1, 2, 10)));
    }

    // Арифметические операции
    @Test
    void testAddition() {
        assertEquals(7, App.calculate(3, 4, '+'));
    }

    @Test
    void testSubtraction() {
        assertEquals(-1, App.calculate(3, 4, '-'));
    }

    @Test
    void testMultiplication() {
        assertEquals(12, App.calculate(3, 4, '*'));
    }

    @Test
    void testDivision() {
        assertEquals(2, App.calculate(10, 5, '/'));
    }

    @Test
    void testDivisionByZero() {
        assertThrows(IllegalArgumentException.class,
                () -> App.calculate(10, 0, '/'));
    }

    @Test
    void testUnknownOperation() {
        assertThrows(IllegalArgumentException.class,
                () -> App.calculate(5, 5, '%'));
    }

    // Сравнение чисел
    @Test
    void testCompareGreater() {
        assertEquals("a больше b", App.compareInts(5, 3));
    }

    @Test
    void testCompareLess() {
        assertEquals("a меньше b", App.compareInts(3, 5));
    }

    @Test
    void testCompareEqual() {
        assertEquals("a равно b", App.compareInts(4, 4));
    }

}

