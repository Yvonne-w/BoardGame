package comp1110.ass2.gui;

// This class represents the main Game and include almost all the GUI parts.
// author of this class: Yiwei (u7020050)

import comp1110.ass2.Square;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.util.ArrayList;

public class Game extends Application {
    //Task 8
    private static final int GAME_WIDTH = 1024;
    private static final int GAME_HEIGHT = 768;
    public static final int SQUARE_SIZE = 64;
    private static final int BOARD_MARGIN = 50;
    private static final int VBOX_WIDTH = 234;
    private static final int VBOX_HEIGHT = 512;
    private static final double PLAYER_WIDTH = (double) VBOX_WIDTH / 2;
    private static final double PLAYER_HEIGHT = (double) VBOX_HEIGHT / 3;
    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final GridPane board = new GridPane();


    private ImageView player1;
    private ImageView player3;
    private ImageView player5;
    private Text mark = new Text();
    private Text mark1 = new Text();
    private Text mark2 = new Text();
    private Text mark3 = new Text();
    private Text mark4 = new Text();
    private Text mark5 = new Text();
    private Text mark6 = new Text();
    private final Group controls = new Group();
    private TextField textField;
    public VBox vLeft;

    public ArrayList<Square> squareBoard = new ArrayList<>();
    Square hightlighted = null;
    public String playerInput1;
    public int numPlayers1;
    public ArrayList<Text> markList = new ArrayList<>();
    public ArrayList<String> humanPlayerList = new ArrayList<>();
    private double mousex;
    private double mousey;
    public DraggableSquare draggableSquareHand;
    public DraggableSquare draggableSquareDock;


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Metro Game");
        root.getChildren().add(controls);
        makeControls();

        Scene scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
        scene.setFill(Color.rgb(109, 95, 87));
        makeBoard();
        setBoardBackground();
        setVBoxLeft();
        setVBoxRight();
        sethBOX();

        //create a lightgrey square Arraylist on Board for future highlight
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Square square = new Square(BOARD_MARGIN + 1.5 * SQUARE_SIZE + SQUARE_SIZE * i, BOARD_MARGIN + 1.5 * SQUARE_SIZE + SQUARE_SIZE * j);
                square.setFill(Color.LIGHTGRAY);
                square.setOpacity(0.3);
                if ((i == 3 || i == 4) && (j == 3 || j == 4)) {
                    square.setFill(Color.TRANSPARENT);
                }
                squareBoard.add(square);
                root.getChildren().add(square);
            }
        }

        draggableSquareHand = new DraggableSquare(GAME_WIDTH - BOARD_MARGIN - VBOX_WIDTH + SQUARE_SIZE, GAME_HEIGHT - BOARD_MARGIN - SQUARE_SIZE / 2, this);
        Image img1 = new Image(this.getClass().getResource("assets/bcbc.jpg").toString());
        draggableSquareHand.setFill(new ImagePattern(img1));
        root.getChildren().add(draggableSquareHand);

        /*
        draggableSquareDock = new DraggableSquare(GAME_WIDTH - BOARD_MARGIN - VBOX_WIDTH + SQUARE_SIZE, GAME_HEIGHT - BOARD_MARGIN - SQUARE_SIZE / 2, this);
        Image img2 = new Image(this.getClass().getResource("assets/aaaa.jpg").toString());
        draggableSquareDock.setFill(new ImagePattern(img2));
        root.getChildren().add(draggableSquareDock);
         */

        primaryStage.setScene(scene);
        scene.getStylesheets().addAll(this.getClass().getResource("styleGame.css").toExternalForm());
        primaryStage.show();
    }

    public class DraggableSquare extends Square {
        private Game game;

        public DraggableSquare(double x, double y, Game game) {
            super(x, y);
            this.game = game;

            this.setOnMousePressed(event -> {
                mousex = event.getSceneX();
                mousey = event.getSceneY();
            });

            this.setOnMouseDragged(event -> {
                double movex = event.getSceneX() - mousex;
                double movey = event.getSceneY() - mousey;
                this.setLayoutX(mousex + movex);
                this.setLayoutY(mousey + movey);
                mousex = this.getLayoutX();
                mousey = this.getLayoutY();
                game.highlightNearestSquare(mousex, mousey);

            });

            this.setOnMouseReleased(event -> {
                draggableSquareHand.setLayoutX(hightlighted.x);
                draggableSquareHand.setLayoutY(hightlighted.y);

            });
        }
    }

    public Square findNearestSquare(double x, double y) {
        double shortDistance = GAME_WIDTH * 3;
        int index = 0;
        for (int i = 0; i < squareBoard.size(); i++) {
            if (squareBoard.get(i) != null) {
                Square squ = squareBoard.get(i);
                double distance = squ.getDistance(x, y);
                if (distance < shortDistance) {
                    shortDistance = distance;
                    index = i;
                }
            }

        }
        return squareBoard.get(index);
    }

    public void highlightNearestSquare(double x, double y) {
        if (hightlighted != null) {
            hightlighted.setFill(Color.LIGHTGRAY);
        }
        hightlighted = findNearestSquare(mousex, mousey);
        if (hightlighted != null) {
            hightlighted.setFill(Color.GREEN);
        }
    }

    private void setHumanPlayers() {
        vLeft.getChildren().removeAll(player1, player3, player5, mark1, mark3, mark5);

        for (int i = 0; i < numPlayers1; i++) {
            Square p = new Square(BOARD_MARGIN + SQUARE_SIZE * 10 + BOARD_MARGIN, BOARD_MARGIN);
            Image imgplayer = new Image(this.getClass().getResource("assets/p" + (i + 1) + ".jpg").toString());
            p.setFill(new ImagePattern(imgplayer));
            vLeft.getChildren().add(p);

            Text mark = new Text();
            mark.setTextAlignment(TextAlignment.LEFT);
            mark.setText(humanPlayerList.get(i) + "\nMark for Player " + i + "\n");
            mark.setFill(Color.WHITE);
            vLeft.getChildren().add(mark);
            markList.add(mark);
        }
    }

    private void makeControls() {
        Label label1 = new Label("Player Name:");
        label1.setTextFill(Color.WHITE);
        textField = new TextField("Enter Human Players'names as a String, use comma to separate, e.g. Amy, Bob");
        textField.setPrefWidth(300);
        Button button = new Button("Start");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                playerInput1 = textField.getText();
                System.out.println(playerInput1);

                //create player image based on input
                numPlayers1 = 1;
                for (int i = 0; i < playerInput1.length(); i++) {
                    if (playerInput1.charAt(i) == ',') {
                        numPlayers1++;
                    }
                }
                System.out.println(numPlayers1);

                String s = "";
                for (int j = 0; j < playerInput1.length(); j++) {
                    if (playerInput1.charAt(j) != ',' && playerInput1.charAt(j) != ' ') {
                        s = s + playerInput1.charAt(j);
                    } else if (playerInput1.charAt(j) != ',') {
                        humanPlayerList.add(s);
                        s = "";
                    }
                }
                humanPlayerList.add(s);

                for (int m = 0; m < humanPlayerList.size(); m++) {
                    System.out.println(humanPlayerList.get(m));
                }

                setHumanPlayers();
                textField.clear();
            }
        });

        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(GAME_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    private void setVBoxLeft() {
        vLeft = new VBox();
        vLeft.setLayoutX(BOARD_MARGIN + SQUARE_SIZE * 10 + BOARD_MARGIN);
        vLeft.setLayoutY(BOARD_MARGIN);


        player1 = new ImageView();
        player1.setFitWidth(PLAYER_WIDTH);
        player1.setFitHeight(PLAYER_HEIGHT);
        player1.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        vLeft.getChildren().add(player1);

        mark1.setTextAlignment(TextAlignment.LEFT);
        mark1.setText("Mark for Player 1");
        mark1.setFill(Color.WHITE);
        vLeft.getChildren().add(mark1);


        player3 = new ImageView();
        player3.setFitWidth(PLAYER_WIDTH);
        player3.setFitHeight(PLAYER_HEIGHT);
        player3.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        vLeft.getChildren().add(player3);


        mark3.setTextAlignment(TextAlignment.LEFT);
        mark3.setText("Mark for Player 3");
        mark3.setFill(Color.WHITE);
        vLeft.getChildren().add(mark3);

        player5 = new ImageView();
        player5.setFitWidth(PLAYER_WIDTH);
        player5.setFitHeight(PLAYER_HEIGHT);
        player5.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        vLeft.getChildren().add(player5);

        mark5.setTextAlignment(TextAlignment.LEFT);
        mark5.setText("Mark for Player 5");
        mark5.setFill(Color.WHITE);
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
        mark2.setFill(Color.WHITE);
        vRight.getChildren().add(mark2);

        ImageView player4 = new ImageView();
        player4.setFitWidth(PLAYER_WIDTH);
        player4.setFitHeight(PLAYER_HEIGHT);
        player4.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        vRight.getChildren().add(player4);

        mark4.setTextAlignment(TextAlignment.RIGHT);
        mark4.setText("Mark for Player 4");
        mark4.setFill(Color.WHITE);
        vRight.getChildren().add(mark4);

        ImageView player6 = new ImageView();
        player6.setFitWidth(PLAYER_WIDTH);
        player6.setFitHeight(PLAYER_HEIGHT);
        player6.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        vRight.getChildren().add(player6);

        mark6.setTextAlignment(TextAlignment.RIGHT);
        mark6.setText("Mark for Player 6");
        mark6.setFill(Color.WHITE);
        vRight.getChildren().add(mark6);

        root.getChildren().add(vRight);
    }

    private void sethBOX() {
        HBox hHandDock = new HBox();
        hHandDock.setLayoutX(GAME_WIDTH - BOARD_MARGIN - VBOX_WIDTH);
        hHandDock.setLayoutY(GAME_HEIGHT - BOARD_MARGIN - SQUARE_SIZE);

        Text tHand = new Text();
        tHand.setText("Hand");
        tHand.setFill(Color.WHITE);
        hHandDock.getChildren().add(tHand);

        ImageView playerHand = new ImageView();
        playerHand.setFitWidth(SQUARE_SIZE);
        playerHand.setFitHeight(SQUARE_SIZE);
        playerHand.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        hHandDock.getChildren().add(playerHand);

        Text tDock = new Text();
        tDock.setText("    Dock");
        tDock.setFill(Color.WHITE);
        hHandDock.getChildren().add(tDock);

        ImageView dockTile = new ImageView();
        dockTile.setFitWidth(SQUARE_SIZE);
        dockTile.setFitHeight(SQUARE_SIZE);
        dockTile.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        hHandDock.getChildren().add(dockTile);

        root.getChildren().add(hHandDock);

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

    void makeBoard() {
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
}
