package Task3;

public class You {
    private Droppable engine = new Engine();
    private Droppable brain=new Brain();
    private State state;
    private double value = 1.02;

    public You(){
        raceAlongTheRoad();
    }

    private void raceAlongTheRoad(){
        System.out.println("Racing along the road");
        sailPastCarsLazily();
    }
    private void sailPastCarsLazily(){
        System.out.println("Sailing past cars lazily");
        feelingPleased();
    }
    private void feelingPleased(){
        System.out.println("Feeling pleased");
        accidentallyChangeGear(4,1,3);
    }
    private void accidentallyChangeGear(int from, int to, int instead){
        if(to!=instead && (from-to)>1){
            System.out.println("Accidentally gear change");
            engine.drop();
            brain.drop();
            System.out.println("Your feelings = "+value);
            state=new State(value);
            state=new State(1.02);
        }
    }

    public State getState() {
        return state;
    }
}
