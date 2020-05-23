package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class GetDirectionFromNonEdge_new {
    boolean testGetDirection = false;

    @Test
    public void testRightDirection() {
        int actual = Metro.getDirectionForTile("cbaa", 21, 1);
        int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        int actual = Metro.getDirectionForTile("bbad", 31, 10);
        int expected = 1;
        assertEquals(expected, actual);
    }
}
