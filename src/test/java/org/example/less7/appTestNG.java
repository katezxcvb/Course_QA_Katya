package org.example.less7;

import org.example.TestBase;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class appTestNG extends TestBase {

    @BeforeMethod
    public void setUp() {
        System.out.println(">>> Подготовка перед тестом");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("<<< Очистка после теста");
    }

    // ---------- ТЕСТЫ ДЛЯ ФАКТОРИАЛА ----------
    @Test
    public void testFactorialOf5() {
        Assert.assertEquals(App.getFactorial(5), 120);
    }

    @Test
    public void testFactorialOf0() {
        Assert.assertEquals(App.getFactorial(0), 1);
    }

    // ---------- ТЕСТЫ ДЛЯ ПЛОЩАДИ ТРЕУГОЛЬНИКА ----------
    @Test
    public void testTriangleArea() {
        Assert.assertEquals(App.calculateTriangle(3, 4, 5), 6.0, 0.0001);
    }

    @Test
    public void testTriangleImpossible() {
        Assert.assertTrue(Double.isNaN(App.calculateTriangle(1, 2, 10)));
    }

    // ---------- ТЕСТЫ ДЛЯ АРИФМЕТИКИ ----------
    @Test
    public void testAddition() {
        Assert.assertEquals(App.calculate(3, 4, '+'), 7);
    }

    @Test
    public void testSubtraction() {
        Assert.assertEquals(App.calculate(3, 4, '-'), -1);
    }

    @Test
    public void testMultiplication() {
        Assert.assertEquals(App.calculate(3, 4, '*'), 12);
    }

    @Test
    public void testDivision() {
        Assert.assertEquals(App.calculate(10, 5, '/'), 2);
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testDivisionByZero() {
        App.calculate(10, 0, '/');
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testUnknownOperation() {
        App.calculate(5, 5, '%');
    }

    // ---------- ТЕСТЫ ДЛЯ СРАВНЕНИЯ ----------
    @Test
    public void testCompareGreater() {
        Assert.assertEquals(App.compareInts(5, 3), "a больше b");
    }

    @Test
    public void testCompareLess() {
        Assert.assertEquals(App.compareInts(3, 5), "a меньше b");
    }

    @Test
    public void testCompareEqual() {
        Assert.assertEquals(App.compareInts(4, 4), "a равно b");
    }
}
