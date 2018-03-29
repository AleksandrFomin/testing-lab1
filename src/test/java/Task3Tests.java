import Task3.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class Task3Tests {

    private You you = new You();
    private YourState expected;
    private BrainEngine brainState;
    private BrainEngine engineState;
    private FordPrefect fordPrefect = new FordPrefect();
    private Remark remark = new Remark("remark");

    @Test
    @DisplayName("START=>RACING")
    void test1() {
        brainState = BrainEngine.NORMAL;
        engineState = BrainEngine.NORMAL;
        you.setCurState(YourState.START);
        expected = YourState.RACING;
        you.raceAlongTheRoad();

        assertEquals(expected, you.getCurState());
        assertEquals(brainState, ((Brain)you.getBrain()).getState());
        assertEquals(engineState, ((Engine)you.getEngine()).getState());
    }

    @Test
    @DisplayName("RACING=>SAILING")
    void test2() {
        brainState = BrainEngine.NORMAL;
        engineState = BrainEngine.NORMAL;
        you.setCurState(YourState.RACING);
        expected = YourState.SAILING_PAST_CARS;
        you.sailPastCarsLazily();

        assertEquals(expected, you.getCurState());
        assertEquals(brainState, ((Brain)you.getBrain()).getState());
        assertEquals(engineState, ((Engine)you.getEngine()).getState());
    }

    @Test
    @DisplayName("SAILING=>FEELING")
    void test3() {
        brainState = BrainEngine.NORMAL;
        engineState = BrainEngine.NORMAL;
        you.setCurState(YourState.SAILING_PAST_CARS);
        expected = YourState.FEELING_PLEASED;
        you.feelingPleased();

        assertEquals(expected, you.getCurState());
        assertEquals(brainState, ((Brain)you.getBrain()).getState());
        assertEquals(engineState, ((Engine)you.getEngine()).getState());
    }

    @Test
    @DisplayName("FEELING=>CHANGING")
    void test4() {
        brainState = BrainEngine.DROPPING;
        engineState = BrainEngine.DROPPING;
        you.setCurState(YourState.FEELING_PLEASED);
        expected = YourState.CHANGING_GEAR;
        you.accidentallyChangeGear(4, 1, 3);

        assertEquals(expected, you.getCurState());
        assertEquals(brainState, ((Brain)you.getBrain()).getState());
        assertEquals(engineState, ((Engine)you.getEngine()).getState());
    }

    @Test
    @DisplayName("FORD'S FEELINGS")
    void test5() {
        expected = YourState.FEELING;
        fordPrefect.feel(remark);

        assertEquals(expected, fordPrefect.getFordState());
    }

    @Test
    @DisplayName("COMPARE FEELINGS")
    void test6() {
        you.setState(new State(1.02));
        fordPrefect.setState(new State(1.09));

        assertEquals(you.getState(), fordPrefect.getState());
    }

    @Test
    @DisplayName("COMPARE FEELINGS 2")
    void test7() {
        you.setState(new State(1.02));
        fordPrefect.setState(new State(1.12));

        assertNotEquals(you.getState(), fordPrefect.getState());
    }

    @Test
    @DisplayName("START=>FEELING")
    void test8() {
        brainState = BrainEngine.NORMAL;
        engineState = BrainEngine.NORMAL;
        you.setCurState(YourState.START);
        expected = YourState.START;
        you.feelingPleased();

        assertEquals(expected, you.getCurState());
        assertEquals(brainState, ((Brain)you.getBrain()).getState());
        assertEquals(engineState, ((Engine)you.getEngine()).getState());
    }
}
