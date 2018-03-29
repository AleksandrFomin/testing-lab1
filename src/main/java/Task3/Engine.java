package Task3;

public class Engine implements Droppable{
    private BrainEngine state = BrainEngine.NORMAL;
    public void drop() {
        state = BrainEngine.DROPPING;
        System.out.println("Engine has dropped");
    }

    public BrainEngine getState() {
        return state;
    }
}
