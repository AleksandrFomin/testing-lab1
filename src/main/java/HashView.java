public interface HashView {
    void insert(int value);

    void remove(int value);

    Integer find(int value);

    void print();

    public AlgoState getAlgoState();
}
