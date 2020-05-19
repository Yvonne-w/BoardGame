package comp1110.ass2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class EncodeTileType_new {
    boolean testEncodeTileType = false;
    @Test
    public void testLength() {
        int[] testAAAAArray = Tile.encodeTileType("aaaa");
        int[] expectedArray = new int[8];
        assertEquals(testAAAAArray.length, expectedArray.length);
    }

    @Test
    public void testSingleChar() {
        int[] testAAAAArray = Tile.encodeTileType("aaaa");
        int[] expectedArray = {1, 1, 1, 1, 1, 1, 1, 1};
        for (int j = 0; j < 8; j++) {
            assertEquals(expectedArray[j], testAAAAArray[j]);
        }
    }

    @Test
    public void testDouble() {
        int[] testBCBCArray = Tile.encodeTileType("bcbc");
        int[] expectedArray = {2, 3, 3, 2, 2, 3, 3, 2};
        for (int j = 0; j < 8; j++) {
            assertEquals(expectedArray[j], testBCBCArray[j]);
        }
    }

    @Test
    public void testTripe() {
        int[] testACCD = Tile.encodeTileType("accd");
        int[] expectedArray = {1, 3, 3, 3, 3, 1, 4, 4};
        for (int j = 0; j < 8; j++) {
            assertEquals(expectedArray[j], testACCD[j]);
        }
    }
}
