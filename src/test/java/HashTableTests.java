import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HashTableTests {

    private AlgoState expected = new AlgoState();
    private HashView hashView;
    private int size;
    private Integer[] table;
    private String state;
    private Integer value;

    @BeforeEach
    public void setUp() {
        size = 5;
        hashView = new ClosedHashTable(size);
    }

    @Test
    @DisplayName("Insert 2 into empty table")
    void testMethod1() {
        table = new Integer[]{null, null, 2, null, null};
        expected.setTable(table);
        state = "NoLoop2FinalHash2";
        expected.setState(state);
        hashView.insert(2);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert 2 into table already containing 2")
    void testMethod2() {
        hashView.insert(2);
        table = new Integer[]{null, null, 2, 2, null};
        expected.setTable(table);
        state = "NoLoop2>FinalHash3";
        expected.setState(state);
        hashView.insert(2);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert 2 into table already containing two 2")
    void test() {
        hashView.insert(2);
        hashView.insert(2);
        table = new Integer[]{null, null, 2, 2, 2};
        expected.setTable(table);
        state = "NoLoop2>>FinalHash4";
        expected.setState(state);
        hashView.insert(2);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert 2 into table already containing 2 (loop)")
    void testLoop() {
        hashView.insert(2);
        hashView.insert(2);
        hashView.insert(2);
        table = new Integer[]{2, null, 2, 2, 2};
        expected.setTable(table);
        state = "NoLoop2>>>FinalHash0";
        expected.setState(state);
        hashView.insert(2);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert 0 into empty table")
    void testMethod3() {
        size = 5;
        hashView = new ClosedHashTable(size);
        table = new Integer[]{0, null, null, null, null};
        expected.setTable(table);
        state = "NoLoop0FinalHash0";
        expected.setState(state);
        hashView.insert(0);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert 0 into non-empty table")
    void testMethod4() {
        hashView.insert(3);
        table = new Integer[]{0, null, null, 3, null};
        expected.setTable(table);
        state = "NoLoop0FinalHash0";
        expected.setState(state);
        hashView.insert(0);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert 4 into empty table (size = 5)")
    void testMethod5() {
        table = new Integer[]{null, null, null, null, 4};
        expected.setTable(table);
        state = "NoLoop4FinalHash4";
        expected.setState(state);
        hashView.insert(4);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert 2 which hash already used")
    void testMethod6() {
        hashView.insert(1);
        hashView.insert(1);
        table = new Integer[]{null, 1, 1, 2, null};
        expected.setTable(table);
        state = "NoLoop2>FinalHash3";
        expected.setState(state);
        hashView.insert(2);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert 6")
    void testMethod7() {
        table = new Integer[]{null, 6, null, null, null};
        expected.setTable(table);
        state = "Loop1FinalHash1";
        expected.setState(state);
        hashView.insert(6);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert 15")
    void testMethod8() {
        table = new Integer[]{15, null, null, null, null};
        expected.setTable(table);
        state = "Loop0FinalHash0";
        expected.setState(state);
        hashView.insert(15);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert -3")
    void testMethod9() {
        hashView.insert(1);
        table = new Integer[]{null, 1, null, null, null};
        expected.setTable(table);
        state = "IllegalArgument";
        expected.setState(state);
        hashView.insert(-3);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert into full table")
    void testMethod10() {
        hashView.insert(0);
        hashView.insert(1);
        hashView.insert(2);
        hashView.insert(3);
        hashView.insert(4);
        table = new Integer[]{0, 1, 2, 3, 4};
        expected.setTable(table);
        state = "NoSpace";
        expected.setState(state);
        hashView.insert(3);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Find 2")
    void testMethod11() {
        hashView.insert(2);
        table = new Integer[]{null, null, 2, null, null};
        expected.setTable(table);
        state = "NoLoop2FinalHash2";
        expected.setState(state);
        value = hashView.find(2);
        assertEquals(expected, hashView.getAlgoState());
        assertEquals(Integer.valueOf(2), value);
    }

    @Test
    @DisplayName("Find not existing 2")
    void testMethod12() {
        table = new Integer[]{null, null, null, null, null};
        expected.setTable(table);
        state = "NoLoop2";
        expected.setState(state);
        value = hashView.find(2);
        assertEquals(expected, hashView.getAlgoState());
        assertNull(value);
    }

    @Test
    @DisplayName("Find 2 with hash != 2")
    void testMethod13() {
        hashView.insert(1);
        hashView.insert(1);
        hashView.insert(2);
        table = new Integer[]{null, 1, 1, 2, null};
        expected.setTable(table);
        state = "NoLoop2>FinalHash3";
        expected.setState(state);
        value = hashView.find(2);
        assertEquals(expected, hashView.getAlgoState());
        assertEquals(Integer.valueOf(2),value);
    }

    @Test
    @DisplayName("Find 6")
    void testMethod14() {
        hashView.insert(6);
        table = new Integer[]{null, 6, null, null, null};
        expected.setTable(table);
        state = "Loop1FinalHash1";
        expected.setState(state);
        value = hashView.find(6);
        assertEquals(expected, hashView.getAlgoState());
        assertEquals(Integer.valueOf(6), value);
    }

    @Test
    @DisplayName("Remove 2")
    void testMethod15() {
        hashView.insert(2);
        table = new Integer[]{null, null, null, null, null};
        expected.setTable(table);
        state = "NoLoop2FinalHash2";
        expected.setState(state);
        hashView.remove(2);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Remove 2 with hash != 2")
    void testMethod16() {
        hashView.insert(1);
        hashView.insert(1);
        hashView.insert(2);
        table = new Integer[]{null, 1, 1, null, null};
        expected.setTable(table);
        state = "NoLoop2>FinalHash3";
        expected.setState(state);
        hashView.remove(2);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Remove 2 not empty")
    void testMethod17() {
        hashView.insert(4);
        hashView.insert(2);
        table = new Integer[]{null, null, null, null, 4};
        expected.setTable(table);
        state = "NoLoop2FinalHash2";
        expected.setState(state);
        hashView.remove(2);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Remove 6")
    void testMethod18() {
        hashView.insert(1);
        hashView.insert(6);
        table = new Integer[]{null, 1, null, null, null};
        expected.setTable(table);
        state = "Loop1>FinalHash2";
        expected.setState(state);
        hashView.remove(6);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Remove not existing 2")
    void testMethod19() {
        hashView.insert(1);
        table = new Integer[]{null, 1, null, null, null};
        expected.setTable(table);
        state = "NoSuchValue";
        expected.setState(state);
        hashView.remove(2);
        assertEquals(expected, hashView.getAlgoState());
    }
}
