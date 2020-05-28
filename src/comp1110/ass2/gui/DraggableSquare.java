package comp1110.ass2.gui;

import comp1110.ass2.AIDifficulty;
import comp1110.ass2.Tile;

/**
 * This class represents the tile GUI used in the game
 * @author Yiwei
 */
public class DraggableSquare extends Tile {
    public Game game;

    public DraggableSquare(double x, double y, Game game) {
        super(x, y);
        this.game = game;
        this.game = game;

        this.setOnMousePressed(event -> {
            game.mousex = event.getSceneX();
            game.mousey = event.getSceneY();
        });

        this.setOnMouseDragged(event -> {
            double movex = event.getSceneX() - game.mousex;
            double movey = event.getSceneY() - game.mousey;
            this.setLayoutX(game.mousex + movex);
            this.setLayoutY(game.mousey + movey);
            game.mousex = this.getLayoutX();
            game.mousey = this.getLayoutY();
            game.highlightNearestSquare(game.mousex, game.mousey);
        });

        this.setOnMouseReleased(event -> {
            this.setLayoutX(game.hightlighted.x);
            this.setLayoutY(game.hightlighted.y);
            game.tileOnBoard.add(this);


            int indexTurn = 0;
            for (int i = 0; i < game.totalPlayerNum; i++) {
                game.markList.get(i).setText(game.totalName.get(i) + "\nMark: " + game.updateMarks(game.totalPlayerNum, i));
            }

            game.updateTurns();

            while (game.checkAiTurn() && game.aiDifficulty == AIDifficulty.EASY) {
                game.placeAiTile();
                game.updateTurns();
            }

            while (AIDifficulty.DIFFICULT == AIDifficulty.DIFFICULT && game.checkAiTurn()) {
                game.placeAdvancedAiTile();
                game.updateTurns();
            }

            if (game.round == 60) {
                game.enlightPath();
            }

        });
    }
}
