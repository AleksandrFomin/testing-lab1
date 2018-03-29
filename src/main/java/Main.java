import Task3.*;

public class Main {
    public static void main(String[] args) {

        You you = new You();
        you.raceAlongTheRoad();
        you.sailPastCarsLazily();
        you.feelingPleased();
        you.accidentallyChangeGear(4, 1, 3);

        FordPrefect fordPrefect = new FordPrefect();
        Remark remark = new Remark("remark");
        fordPrefect.feel(remark);
        if (you.getState().equals(fordPrefect.getState())) {
            System.out.println("Feelings are almost identical");
        } else {
            System.out.println("Feelings are not identical");
        }
    }
}
