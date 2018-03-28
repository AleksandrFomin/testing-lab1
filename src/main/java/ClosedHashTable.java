import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class ClosedHashTable implements HashView {
    private int table_size;
    private ArrayList<LinkedList<Integer>> table;
    private int hash;
    private AlgoState algoState;
    private StringBuilder result = new StringBuilder();

    public ClosedHashTable(int table_size) {
        this.table_size = table_size;
        table = new ArrayList<>(Collections.nCopies(table_size, null));
    }

    public AlgoState getAlgoState() {
        return algoState;
    }

    @Override
    public void insert(int value) {                 // 1
        result = new StringBuilder();
        result.append('a');
        algoState = new AlgoState();
        if (value < 0) {                            // 2
            result.append('b');
            algoState.setTable(table);
            algoState.setAnswer(result.toString());
            return;                                 // 3
        }
        hash = value % table_size;
        result.append('c');
        if (table.get(hash) == null) {              // 4
            result.append('d');
            table.set(hash, new LinkedList<>());
        } else {
            result.append('e');
        }
        table.get(hash).addFirst(value);
        algoState.setTable(table);                  // 5
        algoState.setAnswer(result.toString());
    }

    @Override
    public void print() {
        for (int i = 0; i < table_size; i++) {
            if (table.get(i) != null) {
                System.out.print("[" + i + "]" + " ");
                for (Integer value : table.get(i)) {
                    System.out.print(value + " ");
                }
            }
        }
    }

    @Override
    public void remove(int value) {     // 1
        if (find(value) == null) {      // 2
            algoState = new AlgoState();
            result = new StringBuilder();
            result.append('a');
            result.append('b');
            algoState.setTable(table);
            algoState.setAnswer(result.toString());
            return;                     // 3
        } else {
            algoState = new AlgoState();
            result = new StringBuilder();
            result.append('a');
            result.append('c');         // 4
        }
        result.append('d');
        hash = value % table_size;
        table.get(hash).removeFirstOccurrence(value);
        if (table.get(hash).size() == 0) {  // 5
            result.append('f');
            table.set(hash, null);
        } else {
            result.append('e');
        }

        algoState.setTable(table);      // 6
        algoState.setAnswer(result.toString());
    }

    @Override
    public Integer find(int value) {    // 1
        algoState = new AlgoState();
        result = new StringBuilder();
        algoState.setTable(table);
        hash = value % table_size;
        result.append('a');
        if (table.get(hash) == null) {  // 2
            result.append('b');
            algoState.setAnswer(result.toString());
            return null;                // 3
        }
        result.append('c');
        for (Integer number : table.get(hash)) {    // 4
            result.append('d');
            if (value == number) {  // 5
                result.append('f');
                algoState.setAnswer(result.toString());
                return number;  // 6
            }
            result.append('e');
        }
        result.append('g');
        algoState.setAnswer(result.toString());
        return null;    // 7
    }
}

