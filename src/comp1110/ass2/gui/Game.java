package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class Game extends Application {
    //Task 8
    private static final int GAME_WIDTH = 1024;
    private static final int GAME_HEIGHT = 768;
    private static final int SQUARE_SIZE = 64;
    private static final int BOARD_MARGIN = 50;
    private static final int VBOX_WIDTH = 234;
    private static final int VBOX_HEIGHT = 512;
    private static final double PLAYER_WIDTH = VBOX_WIDTH / 2;
    private static final double PLAYER_HEIGHT = VBOX_HEIGHT / 3;
    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final GridPane board = new GridPane();
    private Text mark1 = new Text();
    private Text mark2 = new Text();
    private Text mark3 = new Text();
    private Text mark4 = new Text();
    private Text mark5 = new Text();
    private Text mark6 = new Text();


    private void makeBoard() {
        //board
        board.setLayoutX(BOARD_MARGIN);
        board.setLayoutY(BOARD_MARGIN);
        board.getChildren().clear();

        for (int i = 1; i <= 8; i++) {
            ImageView station = new ImageView();
            String stationLoc = URI_BASE + "station" + i + ".jpg";
            station.setFitWidth(SQUARE_SIZE);
            station.setFitHeight(SQUARE_SIZE);
            station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
            board.add(station, 9 - i, 0);
        }

        for (int i = 9; i <= 16; i++) {
            ImageView station = new ImageView();
            String stationLoc = URI_BASE + "station" + i + ".jpg";
            station.setFitWidth(SQUARE_SIZE);
            station.setFitHeight(SQUARE_SIZE);
            station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
            board.add(station, 0, i - 8);
        }

        for (int i = 17; i <= 24; i++) {
            ImageView station = new ImageView();
            String stationLoc = URI_BASE + "station" + i + ".jpg";
            station.setFitWidth(SQUARE_SIZE);
            station.setFitHeight(SQUARE_SIZE);
            station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
            board.add(station, i - 16, 9);
        }

        for (int i = 25; i <= 32; i++) {
            ImageView station = new ImageView();
            String stationLoc = URI_BASE + "station" + i + ".jpg";
            station.setFitWidth(SQUARE_SIZE);
            station.setFitHeight(SQUARE_SIZE);
            station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
            board.add(station, 9, 33 - i);
        }

        //corner
        ImageView corner = new ImageView();
        corner.setFitWidth(SQUARE_SIZE);
        corner.setFitHeight(SQUARE_SIZE);
        corner.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        board.add(corner, 0, 0);

        ImageView corner1 = new ImageView();
        corner1.setFitWidth(SQUARE_SIZE);
        corner1.setFitHeight(SQUARE_SIZE);
        corner1.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        board.add(corner1, 0, 9);

        ImageView corner2 = new ImageView();
        corner2.setFitWidth(SQUARE_SIZE);
        corner2.setFitHeight(SQUARE_SIZE);
        corner2.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        board.add(corner2, 9, 0);

        ImageView corner3 = new ImageView();
        corner3.setFitWidth(SQUARE_SIZE);
        corner3.setFitHeight(SQUARE_SIZE);
        corner3.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        board.add(corner3, 9, 9);

        root.getChildren().add(board);
    }

    private void setBoardBackground() {
        StackPane boardBackgroundStack = new StackPane();
        boardBackgroundStack.setLayoutX(BOARD_MARGIN + SQUARE_SIZE);
        boardBackgroundStack.setLayoutY(BOARD_MARGIN + SQUARE_SIZE);

        ImageView boardBackground = new ImageView();
        boardBackground.setFitWidth(SQUARE_SIZE * 8);
        boardBackground.setFitHeight(SQUARE_SIZE * 8);
        boardBackground.setImage(new Image(this.getClass().getResource("assets/board_withoutEdges.png").toString()));

        boardBackgroundStack.getChildren().add(boardBackground);
        root.getChildren().add(boardBackgroundStack);
    }

    private void setVBoxLeft() {
        VBox vLeft = new VBox();
        vLeft.setLayoutX(BOARD_MARGIN + SQUARE_SIZE * 10 + BOARD_MARGIN);
        vLeft.setLayoutY(BOARD_MARGIN);

        ImageView player1 = new ImageView();
        player1.setFitWidth(PLAYER_WIDTH);
        player1.setFitHeight(PLAYER_HEIGHT);
        player1.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        vLeft.getChildren().add(player1);

        mark1.setTextAlignment(TextAlignment.LEFT);
        mark1.setText("Mark for Player 1");
        vLeft.getChildren().add(mark1);

        ImageView player3 = new ImageView();
        player3.setFitWidth(PLAYER_WIDTH);
        player3.setFitHeight(PLAYER_HEIGHT);
        player3.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        vLeft.getChildren().add(player3);

        mark3.setTextAlignment(TextAlignment.LEFT);
        mark3.setText("Mark for Player 3");
        vLeft.getChildren().add(mark3);

        ImageView player5 = new ImageView();
        player5.setFitWidth(PLAYER_WIDTH);
        player5.setFitHeight(PLAYER_HEIGHT);
        player5.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        vLeft.getChildren().add(player5);

        mark5.setTextAlignment(TextAlignment.LEFT);
        mark5.setText("Mark for Player 5");
        vLeft.getChildren().add(mark5);

        root.getChildren().add(vLeft);
    }

    private void setVBoxRight() {
        VBox vRight = new VBox();
        vRight.setLayoutX(BOARD_MARGIN + SQUARE_SIZE * 10 + BOARD_MARGIN + PLAYER_WIDTH);
        vRight.setLayoutY(BOARD_MARGIN);

        ImageView player2 = new ImageView();
        player2.setFitWidth(PLAYER_WIDTH);
        player2.setFitHeight(PLAYER_HEIGHT);
        player2.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        vRight.getChildren().add(player2);

        mark2.setTextAlignment(TextAlignment.RIGHT);
        mark2.setText("Mark for Player 2");
        vRight.getChildren().add(mark2);

        ImageView player4 = new ImageView();
        player4.setFitWidth(PLAYER_WIDTH);
        player4.setFitHeight(PLAYER_HEIGHT);
        player4.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        vRight.getChildren().add(player4);

        mark4.setTextAlignment(TextAlignment.RIGHT);
        mark4.setText("Mark for Player 4");
        vRight.getChildren().add(mark4);

        ImageView player6 = new ImageView();
        player6.setFitWidth(PLAYER_WIDTH);
        player6.setFitHeight(PLAYER_HEIGHT);
        player6.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        vRight.getChildren().add(player6);

        mark6.setTextAlignment(TextAlignment.RIGHT);
        mark6.setText("Mark for Player 6");
        vRight.getChildren().add(mark6);

        root.getChildren().add(vRight);
    }

    private void sethBOX() {
        HBox hHandDock = new HBox();
        hHandDock.setLayoutX(GAME_WIDTH - BOARD_MARGIN - VBOX_WIDTH);
        hHandDock.setLayoutY(GAME_HEIGHT - BOARD_MARGIN - SQUARE_SIZE);

        Text tHand = new Text();
        tHand.setText("Hand");
        hHandDock.getChildren().add(tHand);

        ImageView playerHand = new ImageView();
        playerHand.setFitWidth(SQUARE_SIZE);
        playerHand.setFitHeight(SQUARE_SIZE);
        playerHand.setImage(new Image(this.getClass().getResource("assets/aaaa.jpg").toString()));
        hHandDock.getChildren().add(playerHand);

        Text tDock = new Text();
        tDock.setText("    Dock");
        hHandDock.getChildren().add(tDock);

        ImageView dockTile = new ImageView();
        dockTile.setFitWidth(SQUARE_SIZE);
        dockTile.setFitHeight(SQUARE_SIZE);
        dockTile.setImage(new Image(this.getClass().getResource("assets/bcbc.jpg").toString()));
        hHandDock.getChildren().add(dockTile);

        root.getChildren().add(hHandDock);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Metro Game");
        Scene scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
        makeBoard();
        setBoardBackground();
        setVBoxLeft();
        setVBoxRight();
        sethBOX();
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
