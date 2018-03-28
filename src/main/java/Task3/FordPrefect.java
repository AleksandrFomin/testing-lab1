package Task3;

public class FordPrefect {
    private State state;
    private Remark remark;
    private double value = 1.05;

    public FordPrefect(Remark remark){
        this.remark = remark;
        if(remark.getMessage()!=null){
            System.out.println("Ford's feelings = "+value);
            state=new State(value);
        }
    }

    public State getState() {
        return state;
    }
}
