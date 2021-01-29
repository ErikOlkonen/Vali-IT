package ee.bcs.valiit.tasks;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Lesson1MathUtilTest {

    @Test
    void min() {
        // int result = lessson1MathUtil.min(3,4);
        assertEquals(-1, Lesson1MathUtil.min(-1, 2));
        assertEquals(3, Lesson1MathUtil.min(5, 3));

        // double expected = 5;
        // double result = 5;
        // assertEquals(expected, result, 0.00001);
    }

    @Test
    void max() {
        assertEquals(3, Lesson1MathUtil.max(-1, 3));
        assertEquals(3, Lesson1MathUtil.max(3, -5));
    }

    @Test
    void abs() {
        assertEquals(10, Lesson1MathUtil.abs(-10));
        assertEquals(9, Lesson1MathUtil.abs(9));
        assertEquals(66, Lesson1MathUtil.abs(-66));
        assertEquals(6, Lesson1MathUtil.abs(6));

    }

    @Test
    void isEven() {
        // assertTrue(true, Lesson1MathUtil.isEven(4));
        // assertTrue(true, Lesson1MathUtil.isEven(9));
        // assertTrue(true, Lesson1MathUtil.isEven(256));
        assertTrue(Lesson1MathUtil.isEven(4));
        assertFalse(Lesson1MathUtil.isEven(7));
    }

    @Test
    void testMin() {
        assertEquals(-10, Lesson1MathUtil.min(-10, 2, -5));
        assertEquals(0, Lesson1MathUtil.min(1, 0, 5));
        assertEquals(0, Lesson1MathUtil.min(1, 69, 0));

    }

    @Test
    void testMax() {
        assertEquals(5, Lesson1MathUtil.max(1,2,5) );
        assertEquals(50, Lesson1MathUtil.max(-99, 50, 0));
    }
}