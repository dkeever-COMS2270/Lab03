package lab3;
import balloon.Balloon;
import org.junit.Test;

import static org.junit.Assert.*;

public class BalloonTests {

    Balloon b = new Balloon(10);
    private static final double EPSILON = 10e-07;

    @Test
    public void newlyConstructed() {
        assertEquals(0, b.getRadius());
        assertFalse(b.isPopped());
    }

    @Test
    public void blow5() {
        b.blow(5);
        assertEquals(5, b.getRadius(), EPSILON);
        assertFalse(b.isPopped());
    }

    @Test
    public void blowLimit() {
        //Limit is 10
        String popMsg = "Balloon should pop after a its maximum of 10";
        String radMsg = "Balloon should have a radius of 0 when popped";
        b.blow(11);
        assertTrue(popMsg, b.isPopped());
        assertEquals(radMsg,0, b.getRadius(), EPSILON);
    }

    @Test
    public void popBlow() {
        String popMsg = "Balloon should be popped as b.pop() was called.";
        String radMsg = "You should not be able to blow a balloon when it is popped.";
        b.pop();
        b.blow(6);
        assertTrue(popMsg, b.isPopped());
        assertEquals(radMsg, 0, b.getRadius(), EPSILON);
    }

    @Test
    public void blowPop() {
        String popMsg = "b.pop() was called and the balloon should be popped.";
        String radMsg = "Radius should be 0 because when it is popped.";
        b.blow(7);
        b.pop();
        assertTrue(popMsg, b.isPopped());
        assertEquals(radMsg, 0, b.getRadius(), EPSILON);
    }

    @Test
    public void deflate() {
        String popMsg = "b.deflate() was called and the balloon should be deflated, not popped.";
        String radMsg = "b.deflate() was called and the balloon should have a radius of 0 when deflated.";
        b.blow(8);
        b.deflate();
        assertEquals(radMsg, 0, b.getRadius(), EPSILON);
        assertFalse(popMsg, b.isPopped());
    }

    @Test
    public void negativeBlow() {
        String radMsg = "b.blow() was called with a positive and a negative number meaning the balloon should maintain a radius of positive.";
        String popMsg = "The balloon has not exceeded its maximum radius meaning the balloon should not be popped.";
        b.blow(5);
        b.blow(-3);
        assertEquals(radMsg, 5, b.getRadius(), EPSILON);
        assertFalse(popMsg, b.isPopped());
    }
}

/* --------------------
FINDINGS:
balloon1 package findings:
1. When the b.blow() surpasses the max radius, the balloon is not popped as it should be. Ex: 11 > 10
2. You should not be able to blow a balloon when it is popped.  Ex: 6 != 0

balloon2 package findings:
1. You should not be able to blow a balloon when it is popped.  Ex: 6 != 0

balloon3 package findings:
1. NO ERRORS FOUND.

balloon4 package findings:
1. When b.deflate() is called, the balloon should be deflated, not popped.
-------------------- */