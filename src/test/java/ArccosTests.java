import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArccosTests {
    private double value;
    private double accuracy;
    private double actual;
    private double expected;
    private TaylorSeries ts;

    @BeforeEach
    public void setUp() {
        ts = new TaylorSeries();
        accuracy = 10e-6;
    }

    @Test
    @DisplayName("arccos(-3)")
    void testMethod1() {
        value = -3;
        assertThrows(IllegalArgumentException.class, () -> ts.getArccosSeries(value, accuracy));
    }

    @Test
    @DisplayName("arccos(-1)")
    void testMethod2() {
        value = -1;
        expected = Math.acos(value);
        actual = ts.getArccosSeries(value, accuracy);
        assertEquals(expected, actual, accuracy);
    }

    @Test
    @DisplayName("arccos(-0.9)")
    void testMethod8() {
        value = -0.9;
        expected = Math.acos(value);
        actual = ts.getArccosSeries(value, accuracy);
        assertEquals(expected, actual, accuracy);
    }

    @Test
    @DisplayName("arccos(-0.4)")
    void testMethod3() {
        value = -0.4;
        expected = Math.acos(value);
        actual = ts.getArccosSeries(value, accuracy);
        assertEquals(expected, actual, accuracy);
    }

    @Test
    @DisplayName("arccos(0)")
    void testMethod4() {
        value = 0;
        expected = Math.acos(value);
        actual = ts.getArccosSeries(value, accuracy);
        assertEquals(expected, actual, accuracy);
    }

    @Test
    @DisplayName("arccos(0.4)")
    void testMethod5() {
        value = 0.6;
        expected = Math.acos(value);
        actual = ts.getArccosSeries(value, accuracy);
        assertEquals(expected, actual, accuracy);
    }

    @Test
    @DisplayName("arccos(0.9)")
    void testMethod9() {
        value = 0.9;
        expected = Math.acos(value);
        actual = ts.getArccosSeries(value, accuracy);
        assertEquals(expected, actual, accuracy);
    }

    @Test
    @DisplayName("arccos(1)")
    void testMethod6() {
        value = 1;
        expected = Math.acos(value);
        actual = ts.getArccosSeries(value, accuracy);
        assertEquals(expected, actual, accuracy);
    }

    @Test
    @DisplayName("arccos(1.8)")
    void testMethod7() {
        value = 1.8;
        assertThrows(IllegalArgumentException.class, () -> ts.getArccosSeries(value, accuracy));
    }
}
