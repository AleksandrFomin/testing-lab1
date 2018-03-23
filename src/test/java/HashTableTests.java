import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class HashTableTests {

    private AlgoState expected = new AlgoState();
    private int size = 5;
    private HashView hashView = new ClosedHashTable(size);
    private LinkedList<Integer>[] table;
    private String state;
    private Integer value;



}
