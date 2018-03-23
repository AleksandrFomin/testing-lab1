import java.util.Arrays;
import java.util.LinkedList;

public class AlgoState {
    private LinkedList<Integer>[] table;
    private String state = "";

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void addToState(String toAdd) {
        this.state += toAdd;
    }

    public LinkedList<Integer>[] getTable() {
        return table;
    }

    public void setTable(LinkedList<Integer>[] table) {
        this.table = table;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        return Arrays.equals(this.table, ((AlgoState)o).table) &&
                this.state.equals(((AlgoState)o).state);
    }
}
