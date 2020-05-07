package comp1110.ass2;
// This class represents a tile on the game board.

import comp1110.ass2.gui.Game;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Polygon;
import static comp1110.ass2.gui.Game.SQUARE_SIZE;

public class Tile extends Polygon {
    private final TileType tileType;
    private int position;

    public Tile(TileType tileType, int position) {
        super();
        this.tileType = tileType;
        this.position = position;

        ImageView Tile = new ImageView();
        Tile.setFitWidth(SQUARE_SIZE);
        Tile.setFitHeight(SQUARE_SIZE);
        String tileloc = "gui/assets/aaaa.jpg";
        System.out.println(tileloc); //
        Tile.setImage(new Image(this.getClass().getResource(tileloc).toString()));

    }


    //Tile inner union method
    static int[] tileCode = new int[8];

    public static int[] encodeTile(String tilePlacement) {
        String tileString = tilePlacement.substring(0, 4);
        for (int i = 0; i < tileString.length(); i++) {
            int posInArray = 2 * i;
            int union = i + 1;
            if (tileString.charAt(i) == 'a') {
                tileCode[posInArray] = union;
                switch (posInArray) {
                    case 0:
                        tileCode[5] = union;
                        break;
                    case 2:
                        tileCode[7] = union;
                        break;
                    case 4:
                        tileCode[1] = union;
                        break;
                    case 6:
                        tileCode[3] = union;
                        break;
                }
            } else if (tileString.charAt(i) == 'b') {
                tileCode[posInArray] = union;
                switch (posInArray) {
                    case 0:
                        tileCode[3] = union;
                        break;
                    case 2:
                        tileCode[5] = union;
                        break;
                    case 4:
                        tileCode[7] = union;
                        break;
                    case 6:
                        tileCode[1] = union;
                        break;
                }
            } else if (tileString.charAt(i) == 'c') {
                tileCode[posInArray] = union;
                switch (posInArray) {
                    case 0:
                        tileCode[7] = union;
                        break;
                    case 2:
                        tileCode[1] = union;
                        break;
                    case 4:
                        tileCode[3] = union;
                        break;
                    case 6:
                        tileCode[5] = union;
                        break;
                }
            } else if (tileString.charAt(i) == 'd') {
                tileCode[posInArray] = union;
                switch (posInArray) {
                    case 0:
                        tileCode[1] = union;
                        break;
                    case 2:
                        tileCode[3] = union;
                        break;
                    case 4:
                        tileCode[5] = union;
                        break;
                    case 6:
                        tileCode[7] = union;
                        break;
                }
            }
        }
        return tileCode;

    }
}
