import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ArccosTests {
    private double value;
    private double accuracy = 10e-6;
    private double actual;
    private double expected;
    TaylorSeries ts = new TaylorSeries();

    @Test
    @DisplayName("arccos(-3)")
    void testMethod1() {
        // Prepare
        value = -3;
        // Execute
        // Assertions
        assertThrows(IllegalArgumentException.class, () -> ts.getArccosSeries(value, accuracy));
    }

    @Test
    @DisplayName("arccos(-1)")
    void testMethod2() {
        // Prepare
        value = -1;
        expected = Math.acos(value);
        // Execute
        actual = ts.getArccosSeries(value, accuracy);
        // Assertions
        assertEquals(expected, actual, accuracy);
    }

    @Test
    @DisplayName("arccos(-0.4)")
    void testMethod3() {
        // Prepare
        value = -0.4;
        expected = Math.acos(value);
        // Execute
        actual = ts.getArccosSeries(value, accuracy);
        // Assertions
        assertEquals(expected, actual, accuracy);
    }

    @Test
    @DisplayName("arccos(0)")
    void testMethod4() {
        // Prepare
        value = 0;
        expected = Math.acos(value);
        // Execute
        actual = ts.getArccosSeries(value, accuracy);
        // Assertions
        assertEquals(expected, actual, accuracy);
    }

    @Test
    @DisplayName("arccos(0.6)")
    void testMethod5() {
        // Prepare
        value = 0.6;
        expected = Math.acos(value);
        // Execute
        actual = ts.getArccosSeries(value, accuracy);
        // Assertions
        assertEquals(expected, actual, accuracy);
    }

    @Test
    @DisplayName("arccos(1)")
    void testMethod6() {
        // Prepare
        value = 1;
        expected = Math.acos(value);
        // Execute
        actual = ts.getArccosSeries(value, accuracy);
        // Assertions
        assertEquals(expected, actual, accuracy);
    }

    @Test
    @DisplayName("arccos(1.8)")
    void testMethod7() {
        // Prepare
        value = 1.8;
        // Execute
        // Assertions
        assertThrows(IllegalArgumentException.class, () -> ts.getArccosSeries(value, accuracy));
    }
}
