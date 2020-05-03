package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class D2Eu7020050 {
    boolean testEncodeTile = false;

    @Test
    public void testLength() {
        int[] testAAAAArray = Tile.encodeTile("aaaa");
        int[] expectedArray = new int[8];
        assertEquals(testAAAAArray.length, expectedArray.length);
    }

    @Test
    public void testSingleChar() {
        int[] testAAAAArray = Tile.encodeTile("aaaa");
        int[] expectedArray = {1, 3, 2, 4, 3, 1, 4, 2};
        for (int j = 0; j < 8; j++) {
            assertEquals(expectedArray[j], testAAAAArray[j]);
        }
    }

    @Test
    public void testDouble() {
        int[] testBCBCArray = Tile.encodeTile("bcbc");
        int[] expectedArray = {1, 2, 2, 1, 3, 4, 4, 3};
        for (int j = 0; j < 8; j++) {
            assertEquals(expectedArray[j], testBCBCArray[j]);
        }
    }

    @Test
    public void testTripe() {
        int[] testACCD = Tile.encodeTile("accd");
        int[] expectedArray = {1, 2, 2, 3, 3, 1, 4, 4};
        for (int j = 0; j < 8; j++) {
            assertEquals(expectedArray[j], testACCD[j]);
        }
    }
}
