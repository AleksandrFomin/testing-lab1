public class ClosedHashTable implements HashView {
    private int table_size;
    private int count;
    private Integer[] table;
    private int hash;
    private AlgoState algoState;

    public ClosedHashTable(int table_size) {
        this.table_size = table_size;
        table = new Integer[table_size];
    }

    public AlgoState getAlgoState() {
        return algoState;
    }

    @Override
    public void insert(int value) {
        algoState = new AlgoState();                    //init
        if (value < 0) {
            algoState.addToState("IllegalArgument");
            algoState.setTable(table);
            return;
        }
        if (count == table_size) {
            algoState.addToState("NoSpace");
            algoState.setTable(table);
            return;
        }
        hash = (value < table_size) ? value : value % table_size;
        algoState.addToState((value < table_size) ? "NoLoop" : "Loop");   //if loop
        algoState.addToState(String.valueOf(hash));                 //add hash
        while (table[hash] != null) {
            hash++;
            hash %= table_size;
            algoState.addToState(">");                              //add '>'
        }
        table[hash] = value;
        algoState.addToState("FinalHash" + hash);                   //add final hash
        algoState.setTable(table);
        count++;
    }

    @Override
    public void print() {
        for (int i = 0; i < table_size; i++) {
            if (table[i] != null) {
                System.out.println(i + " " + table[i]);
            }
        }
    }

    @Override
    public void remove(int value) {
        if (find(value) == null) {
            algoState = new AlgoState();
            algoState.addToState("NoSuchValue");
            algoState.setTable(table);
            return;
        }
        algoState = new AlgoState();
        hash = (value < table_size) ? value : value % table_size;
        algoState.addToState((value < table_size) ? "NoLoop" : "Loop");   //if loop
        algoState.addToState(String.valueOf(hash));                 //add hash
        while (table[hash] != null) {
            if (table[hash].equals(value)) {
                algoState.addToState("FinalHash" + hash);
                table[hash] = null;
                algoState.setTable(table);
                return;
            }
            hash++;
            hash %= table_size;
            algoState.addToState(">");
        }
    }

    @Override
    public Integer find(int value) {
        algoState = new AlgoState();
        algoState.setTable(table);
        boolean loop = value >= table_size;
        hash = (value < table_size) ? value : value % table_size;
        algoState.addToState((value < table_size) ? "NoLoop" : "Loop");   //if loop
        algoState.addToState(String.valueOf(hash));                 //add hash
        while (table[hash] != null) {
            if (table[hash].equals(value)) {
                algoState.addToState("FinalHash" + hash);
                algoState.setTable(table);
                return table[hash];
            }
            hash++;
            hash %= table_size;
            algoState.addToState(">");
            if (hash == value || (loop && hash == value % table_size)) {
                return null;
            }
        }
        return null;
    }
}
