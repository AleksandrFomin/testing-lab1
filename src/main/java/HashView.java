public interface HashView {
    void insert(int value) throws NoSpaceAvailableException;

    void remove(int value) throws NoSuchValueException;

    Integer find(int value);

    void print();
}
