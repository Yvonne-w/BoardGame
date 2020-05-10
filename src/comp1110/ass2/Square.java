package comp1110.ass2;
// This class represents shape of a tile on the game board.
// author of this class: Yiwei (u7020050)

import javafx.scene.shape.Polygon;

import static comp1110.ass2.gui.Game.SQUARE_SIZE;

public class Square extends Polygon {
    public double x;
    public double y;
    public double side;

    public Square(double x, double y) {
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
}