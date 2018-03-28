import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class AlgoState {
    private ArrayList<LinkedList<Integer>> table;
    private String answer;

    public AlgoState() {
    }

    public ArrayList<LinkedList<Integer>> getTable() {
        return table;
    }

    public void setTable(ArrayList<LinkedList<Integer>> table) {
        this.table = table;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) {
            return false;
        }
        return this.table.equals(((AlgoState) o).table) &&
                this.answer.equals(((AlgoState) o).answer);
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer(){
        return answer;
    }
}
