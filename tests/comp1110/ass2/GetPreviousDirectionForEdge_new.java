package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GetPreviousDirectionForEdge_new {
    @Test
    public void testRightDirection() {
        int actual = Metro.getPreviousDirctionForEdge("accd",67);
        int expected = -10;
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        int actual = Metro.getPreviousDirctionForEdge("cbcb",05);
        int expected = -1;
        assertEquals(expected, actual);
    }
}
