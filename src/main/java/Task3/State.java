package Task3;

public class State {
    private double feeling;

    public State(double value){
        feeling=value;
    }
    @Override
    public boolean equals(Object o){
        if(o==null){
            return false;
        }
        return Math.abs(this.feeling-((State)o).feeling)<0.1;
    }

}
