import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HashTableTests {

    private AlgoState expected;
    private int size = 5;
    private HashView hashView;
    private ArrayList<LinkedList<Integer>> table;
    private Integer value;
    private Integer found;

    @BeforeEach
    void setUp() {
        table = new ArrayList<>(Collections.nCopies(size, null));
        expected = new AlgoState();
        hashView = new ClosedHashTable(size);
    }

    @Test
    @DisplayName("Insert -1")
    void test1() {
        value = -1;
        expected.setTable(table);
        expected.setAnswer("ab");

        hashView.insert(-1);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert 1 into empty table")
    void test2() {
        value = 1;
        table.set(value, new LinkedList<>());
        table.get(value).addFirst(value);
        expected.setTable(table);
        expected.setAnswer("acd");

        hashView.insert(1);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Insert 6 into table containing 1")
    void test3() {
        value = 6;
        table.set(value % size, new LinkedList<>());
        table.get(1).addFirst(1);
        table.get(value % size).addFirst(value);
        expected.setTable(table);
        expected.setAnswer("ace");

        hashView.insert(1);
        hashView.insert(6);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Remove 2 from empty table")
    void test4() {
        value = 2;
        expected.setTable(table);
        expected.setAnswer("ab");

        hashView.remove(value);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Remove 1 (table contains two 1)")
    void test5() {
        value = 1;
        table.set(1, new LinkedList<>());
        table.get(1).addFirst(1);
        expected.setTable(table);
        expected.setAnswer("acde");

        hashView.insert(1);
        hashView.insert(1);
        hashView.remove(value);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Remove 1 (table contains one 1)")
    void test6() {
        value = 1;
        expected.setTable(table);
        expected.setAnswer("acdf");

        hashView.insert(1);
        hashView.remove(value);
        assertEquals(expected, hashView.getAlgoState());
    }

    @Test
    @DisplayName("Find 2 in empty table")
    void test7() {
        value = 2;
        expected.setTable(table);
        expected.setAnswer("ab");

        found = hashView.find(value);
        assertEquals(expected, hashView.getAlgoState());
        assertNull(found);
    }

    @Test
    @DisplayName("Find existing 2")
    void test8() {
        value = 2;
        table.set(value, new LinkedList<>());
        table.get(value).addFirst(value);
        table.get(value).addFirst(7);
        expected.setTable(table);
        expected.setAnswer("acdedf");

        hashView.insert(2);
        hashView.insert(7);
        found = hashView.find(value);
        assertEquals(expected, hashView.getAlgoState());
        assertEquals(value, found);
    }

    @Test
    @DisplayName("Find 2 (table only contains 7)")
    void test9() {
        value = 2;
        table.set(value, new LinkedList<>());
        table.get(value).addFirst(7);
        expected.setTable(table);
        expected.setAnswer("acdeg");

        hashView.insert(7);
        found = hashView.find(value);
        assertEquals(expected, hashView.getAlgoState());
        assertNull(found);
    }
}
