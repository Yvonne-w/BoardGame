package comp1110.ass2;
// This class represents shape of a tile on the game board.
// author of this class: Yiwei (u7020050)

import javafx.scene.shape.Polygon;

import static comp1110.ass2.gui.Game.SQUARE_SIZE;

public class Tile extends Polygon {
    public double x;
    public double y;
    public String tileType;
    static int[] tileCode = new int[8];
    static int[] tileTypeCode = new int[8];

    public Tile(double x, double y) {
        super();
        this.x = x;
        this.y = y;

        this.getPoints().addAll((double) -SQUARE_SIZE / 2, (double) -SQUARE_SIZE / 2,
                (double) -SQUARE_SIZE / 2, (double) SQUARE_SIZE / 2,
                (double) SQUARE_SIZE / 2, (double) SQUARE_SIZE / 2,
                (double) SQUARE_SIZE / 2, (double) -SQUARE_SIZE / 2);

        this.setLayoutX(x);
        this.setLayoutY(y);
    }

    public double getDistance(double x2, double y2) {
        return Math.sqrt(Math.pow(x2 - x, 2) + Math.pow(y2 - y, 2));
    }

    //Tile inner union method


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

    /*
    return a tile array based on tiletype
     */


    public static int[] encodeTileType(String tilePlacement) {
        String tileString = tilePlacement.substring(0, 4);

        switch (tileString.charAt(0)) {
            case 'a':
                tileTypeCode[0] = 1;
                tileTypeCode[5] = 1; //+5
                break;
            case 'b':
                tileTypeCode[0] = 2;
                tileTypeCode[3] = 2; //+3
                break;
            case 'c':
                tileTypeCode[0] = 3;
                tileTypeCode[7] = 3; //-1
                break;
            case 'd':
                tileTypeCode[0] = 4;
                tileTypeCode[1] = 4; //+1
                break;
        }

        switch (tileString.charAt(1)) {
            case 'a':
                tileTypeCode[2] = 1;
                tileTypeCode[7] = 1;
                break;
            case 'b':
                tileTypeCode[2] = 2;
                tileTypeCode[5] = 2;
                break;
            case 'c':
                tileTypeCode[2] = 3;
                tileTypeCode[1] = 3;
                break;
            case 'd':
                tileTypeCode[2] = 4;
                tileTypeCode[3] = 4;
                break;
        }

        switch (tileString.charAt(2)) {
            case 'a':
                tileTypeCode[4] = 1;
                tileTypeCode[1] = 1;
                break;
            case 'b':
                tileTypeCode[4] = 2;
                tileTypeCode[7] = 2;
                break;
            case 'c':
                tileTypeCode[4] = 3;
                tileTypeCode[3] = 3;
                break;
            case 'd':
                tileTypeCode[4] = 4;
                tileTypeCode[5] = 4;
                break;
        }

        switch (tileString.charAt(3)) {
            case 'a':
                tileTypeCode[6] = 1;
                tileTypeCode[3] = 1;
                break;
            case 'b':
                tileTypeCode[6] = 2;
                tileTypeCode[1] = 2;
                break;
            case 'c':
                tileTypeCode[6] = 3;
                tileTypeCode[5] = 3;
                break;
            case 'd':
                tileTypeCode[6] = 4;
                tileTypeCode[7] = 4;
                break;
        }


        /*
        for (int i = 0; i < 8; i++) {
            System.out.print(tileTypeCode[i]);
        }
         */
        return tileTypeCode;

    }
}