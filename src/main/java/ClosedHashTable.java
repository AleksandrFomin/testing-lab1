public class ClosedHashTable implements HashView {
    private int table_size;
    private int count;
    private Integer[] table;
    private int hash;

    public ClosedHashTable(int table_size) {
        this.table_size = table_size;
        table = new Integer[table_size];
    }

    @Override
    public void insert(int value) throws NoSpaceAvailableException {
        if (count == table_size) {
            throw new NoSpaceAvailableException("No space available for insert operation");
        }
        hash = (value < table_size) ? value : value % table_size;
        while (table[hash] != null) {
            hash++;
            hash %= table_size;
        }
        table[hash] = value;
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
    public void remove(int value) throws NoSuchValueException {
        if (find(value) == null) {
            throw new NoSuchValueException("There is no " + value + " in the table");
        }
        hash = (value < table_size) ? value : value % table_size;
        while (table[hash] != null) {
            if (table[hash].equals(value)) {
                table[hash] = null;
            }
            hash++;
            hash %= table_size;
        }
    }

    @Override
    public Integer find(int value) {
        boolean loop = value >= table_size;
        hash = (value < table_size) ? value : value % table_size;
        while (table[hash] != null) {
            if (table[hash].equals(value)) {
                return table[hash];
            }
            hash++;
            hash %= table_size;
            if (hash == value || (loop && hash == value % table_size)) {
                return null;
            }
        }
        return null;
    }
}
