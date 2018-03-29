package Task3;

public class FordPrefect {
    private State state;
    private double value = 1.05;
    private YourState fordState = YourState.START;

    public FordPrefect() {
    }

    public void feel(Remark remark) {
        if (remark.getMessage() != null) {
            System.out.println("Ford's feelings = " + value);
            state = new State(value);
        }
        if(fordState == YourState.START){
            fordState = YourState.FEELING;
        }
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public YourState getFordState(){
        return fordState;
    }
}
