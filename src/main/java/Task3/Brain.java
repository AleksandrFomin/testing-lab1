package Task3;

public class Brain implements Droppable {
    private BrainEngine state = BrainEngine.NORMAL;
    public void drop() {
        state = BrainEngine.DROPPING;
        System.out.println("Brain has dropped");
    }

    public BrainEngine getState() {
        return state;
    }
}
