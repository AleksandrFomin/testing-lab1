package Task3;

public class You {
    private Droppable engine = new Engine();
    private Droppable brain = new Brain();
    private State state;
    private double value = 1.02;
    private YourState curState = YourState.START;

    public You() {
    }

    public void raceAlongTheRoad() {
        if (curState == YourState.START) {
            curState = YourState.RACING;
            System.out.println("Racing along the road");
        }
    }

    public void sailPastCarsLazily() {
        if (curState == YourState.RACING) {
            curState = YourState.SAILING_PAST_CARS;
            System.out.println("Sailing past cars lazily");
        }
    }

    public void feelingPleased() {
        if (curState == YourState.SAILING_PAST_CARS) {
            curState = YourState.FEELING_PLEASED;
            System.out.println("Feeling pleased");
        }
    }

    public void accidentallyChangeGear(int from, int to, int instead) {
        if (curState == YourState.FEELING_PLEASED) {
            curState = YourState.CHANGING_GEAR;
            if (to != instead && (from - to) > 1) {
                System.out.println("Accidentally gear change");
                engine.drop();
                brain.drop();
                System.out.println("Your feelings = " + value);
                state = new State(value);
                state = new State(1.02);
            }
        }
    }

    public Droppable getBrain() {
        return brain;
    }

    public Droppable getEngine() {
        return engine;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void setCurState(YourState state) {
        curState = state;
    }

    public YourState getCurState() {
        return curState;
    }
}
