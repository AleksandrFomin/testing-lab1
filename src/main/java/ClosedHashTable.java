import java.util.LinkedList;

public class ClosedHashTable implements HashView {
    private int table_size;
    private int count;
    private LinkedList<Integer>[] table;
    private int hash;
    private AlgoState algoState;

    public ClosedHashTable(int table_size) {
        this.table_size = table_size;
        table = new LinkedList[table_size];
    }

    public AlgoState getAlgoState() {
        return algoState;
    }

    @Override
    public void insert(int value) {
        algoState = new AlgoState();
        if (value < 0) {
            algoState.setState("IllegalArgument");
            algoState.setTable(table);
            return;
        }
        hash = value % table_size;
        algoState.addToState("Hash" + hash + "PrevSize");
        if (table[hash] == null) {
            algoState.addToState("0");
            table[hash] = new LinkedList();
        }
        algoState.addToState(table[hash].toString());
        table[hash].addFirst(value);
        algoState.addToState("NewSize" + table[hash].toString());
    }

    @Override
    public void print() {
        for (int i = 0; i < table_size; i++) {
            if (table[i] != null) {
                System.out.print("[" + i + "]" + " ");
                for (Integer value : table[i]) {
                    System.out.print(value + " ");
                }
            }
        }
    }

    @Override
    public void remove(int value) {
        if (find(value) == null) {
            return;
        }
        hash = value % table_size;
        table[hash].removeFirstOccurrence(value);
    }

    @Override
    public Integer find(int value) {
        hash = value % table_size;
        if (table[hash] == null) {
            return null;
        }
        for (Integer number : table[hash]) {
            if (value == number) {
                return number;
            }
        }
        return null;
    }
}
