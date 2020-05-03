package comp1110.ass2;

import org.junit.Rule;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class D2Eu6648214{
    @Rule
    public void test(String piecePlacement, Boolean expected){
        boolean result =(Metro.isPiecePlacementWellFormed(piecePlacement));
        assertTrue(expected + "was expected, but returned: " + result, result == expected);
    }

    @Test
    public void testGoodShape() {
        String testPlacement = new String();

        for (int i = 0; i <= 3; i++) {
            assertTrue(testPlacement.charAt(i) <= 'd' && testPlacement.charAt(i) >= 'a');
        }
    }

    @Test
    public void testGoodLocation(){
        String testPlacement = new String();

        for (int i = 4; i<= 5; i ++){
            assertTrue(Character.getNumericValue(testPlacement.charAt(i))<= 7
                              && Character.getNumericValue(testPlacement.charAt(i)) >= 0);
        }
    }

    @Test
    public void testBadPlacement(){
        testTiles();
    }

    private void testTiles() {
        test("azyu65", false);
        test("aaaa81", false);
        test("abhg78", false);
        test("abab00",true);

    }
}