package comp1110.ass2;

import comp1110.ass2.gui.Game;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;

public class GetPossibleLocation_new {
    boolean result = false;
    @Test
    public void testEmptyBoard(){
        int[] testAAAAArray = Tile.encodeTileType("cbcb");
        ArrayList<String> expected = new ArrayList<>(Arrays.asList());
        assertEquals(expected, Game.getPossibleLocation("", "cbcb"));
    }

}
