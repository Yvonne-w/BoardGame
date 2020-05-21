package comp1110.ass2.gui;

import comp1110.ass2.Metro;
import comp1110.ass2.Tile;
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
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class Game extends Application {
    /**
     * This class was created as an implementation of Task 8, and then extended to be the main scene of the game.
     *
     * @author Yiwei
     */
    private static final int GAME_WIDTH = 1024;
    private static final int GAME_HEIGHT = 768;
    public static final int SQUARE_SIZE = 64;
    private static final int BOARD_MARGIN = 50;
    private static final int VBOX_WIDTH = 234;
    private static final int VBOX_HEIGHT = 512;
    private static final double PLAYER_WIDTH = (double) VBOX_WIDTH / 2;
    private static final double PLAYER_HEIGHT = (double) VBOX_HEIGHT / 3;
    private static final String URI_BASE = "assets/";

    public Scene mainscene;
    private final Group root = new Group();
    private final GridPane board = new GridPane();
    private final Group controls = new Group();
    public VBox vLeft;
    private ArrayList<ImageView> playerStillList;
    public Text mark = new Text();
    private Text mark1 = new Text();
    private Text mark2 = new Text();
    private Text mark3 = new Text();
    private Text mark4 = new Text();
    private Text mark5 = new Text();
    private Text mark6 = new Text();
    private TextField textField;
    private final Color central = Color.TRANSPARENT;

    private double mousex;
    private double mousey;
    public int numPlayers1;
    public String playerInput1;
    Tile hightlighted = null;
    public ArrayList<String> humanPlayerList = new ArrayList<>();
    public static ArrayList<Tile> squareBoard = new ArrayList<>();
    public ArrayList<Tile> tileOnBoard = new ArrayList<>();
    public ArrayList<Text> markList = new ArrayList<>();
    public String placementSequence;
    public String allTilesGenerated = "";

    //Startscene
    public Scene sceneStart;
    private final Group rootStart = new Group();
    private final Group controlsStart = new Group();
    private TextField textField1Start;
    private TextField textField2Start;
    private TextField textField3Start;
    private VBox vbStart = new VBox();
    public Button button3;

    public int numPlayers1Start;
    public int numPlayers2Start;
    public String playerInput1Start;
    public String playerInput2Start;
    public String playerInput3Start;
    public ArrayList<String> humanPlayerListStart = new ArrayList<>();
    public ArrayList<String> aiplayerlistStart = new ArrayList<>();


    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        /**
         * This start method sets the primaryStage of the game.
         */

        //To launch the still setting part of the game
        mainscene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);

        Image mainSceneBackground = new Image(this.getClass().getResource("assets/vintagePaper.jpg").toString());
        mainscene.setFill(new ImagePattern(mainSceneBackground));

        primaryStage.setTitle("Metro Game");
        root.getChildren().add(controls);
        makeControls();
        makeTileControl();
        makeBoard();
        setBoardBackground();
        setVBoxLeft();
        setVBoxRight();
        sethBOX();
        makeLightGreySquareBoard();


        //Startscene
        sceneStart = new Scene(rootStart, GAME_WIDTH, GAME_HEIGHT);
        makeStartControls();
        addVariants();
        rootStart.getChildren().add(controlsStart);
        Image startSceneBackground = new Image(this.getClass().getResource("assets/StartSceneBackground.jpg").toString());
        sceneStart.setFill(new ImagePattern(startSceneBackground));
        sceneStart.getStylesheets().addAll(this.getClass().getResource("styleGame.css").toExternalForm());
        button3.setOnMouseClicked(event -> {
            primaryStage.setScene(mainscene);
        });

        primaryStage.setScene(sceneStart);
        mainscene.getStylesheets().addAll(this.getClass().getResource("styleGame.css").toExternalForm());
        primaryStage.show();
    }


    private void makeStartControls() {
        //Label, input and button part
        Label label1 = new Label("Human Player Name:");
        label1.setTextFill(Color.BLACK);
        textField1Start = new TextField("Enter Players' Sequence, e.g. Amy, Bob");
        textField1Start.setPrefWidth(300);
        Button button1 = new Button("Set Human Players");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                playerInput1Start = textField1Start.getText();
                System.out.println(playerInput1Start);

                //create player image based on input
                numPlayers1Start = 1;
                for (int i = 0; i < playerInput1Start.length(); i++) {
                    if (playerInput1Start.charAt(i) == ',') {
                        numPlayers1Start++;
                    }
                }
                System.out.println(numPlayers1Start);

                String s = "";
                for (int j = 0; j < playerInput1Start.length(); j++) {
                    if (playerInput1Start.charAt(j) != ',' && playerInput1Start.charAt(j) != ' ') {
                        s = s + playerInput1Start.charAt(j);
                    } else if (playerInput1Start.charAt(j) != ',') {
                        humanPlayerListStart.add(s);
                        s = "";
                    }
                }
                humanPlayerListStart.add(s);

                for (int m = 0; m < humanPlayerListStart.size(); m++) {
                    System.out.println(humanPlayerListStart.get(m));
                }

                textField1Start.clear();
            }
        });

        vbStart.getChildren().addAll(label1, textField1Start, button1);
        vbStart.setSpacing(10);
        vbStart.setLayoutX(GAME_WIDTH / 3);
        vbStart.setLayoutY(GAME_HEIGHT / 2.5);

        Label label2 = new Label("AI Player Name:");
        label2.setTextFill(Color.BLACK);
        textField2Start = new TextField("Enter Players' Sequence, e.g. Amy, Bob");
        textField2Start.setPrefWidth(300);
        Button button2 = new Button("Set AI Players");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                playerInput2Start = textField2Start.getText();
                System.out.println(playerInput2Start);

                //create player image based on input
                numPlayers2Start = 1;
                for (int i = 0; i < playerInput2Start.length(); i++) {
                    if (playerInput2Start.charAt(i) == ',') {
                        numPlayers2Start++;
                    }
                }
                System.out.println(numPlayers2Start);

                String s2 = "";
                for (int j = 0; j < playerInput2Start.length(); j++) {
                    if (playerInput2Start.charAt(j) != ',' && playerInput2Start.charAt(j) != ' ') {
                        s2 = s2 + playerInput2Start.charAt(j);
                    } else if (playerInput2Start.charAt(j) != ',') {
                        aiplayerlistStart.add(s2);
                        s2 = "";
                    }
                }
                aiplayerlistStart.add(s2);

                for (int m = 0; m < aiplayerlistStart.size(); m++) {
                    System.out.println(aiplayerlistStart.get(m));
                }

                textField2Start.clear();
            }
        });
        vbStart.getChildren().addAll(label2, textField2Start, button2);
        vbStart.setSpacing(10);

        controlsStart.getChildren().add(vbStart);
    }

    private void setHumanPlayers() {
        //create Image for players
        vLeft.getChildren().removeAll(playerStillList.get(0), playerStillList.get(1), playerStillList.get(2), mark1, mark3, mark5);

        for (int i = 0; i < numPlayers1; i++) {
            Image imgPlayer = new Image(this.getClass().getResource("assets/p" + (i + 1) + ".jpg").toString());
            Circle c = new Circle(PLAYER_WIDTH / 2);
            c.setFill(new ImagePattern(imgPlayer));
            vLeft.getChildren().add(c);

            Text mark = new Text();
            mark.setTextAlignment(TextAlignment.LEFT);
            mark.setText(humanPlayerList.get(i) + "\nMark: " + Metro.getScore(getPlacementSequence(), numPlayers1)[i] + "\n");
            mark.setFill(Color.BROWN);
            vLeft.getChildren().add(mark);
            markList.add(mark);
        }
    }

    private void addVariants() {
        Label label3 = new Label("Enter Variants: ");
        label3.setTextFill(Color.BLACK);
        textField3Start = new TextField("Enter Tile Vatiants, e.g. 2");
        textField3Start.setPrefWidth(200);
        button3 = new Button("Start");
        button3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                playerInput3Start = textField3Start.getText();
                System.out.println(playerInput3Start);
                //TODO

                textField1Start.clear();

            }
        });

        vbStart.getChildren().addAll(label3, textField3Start, button3);
    }

    // change e

    private void makeTileControl() {
        /**
         * This method will make control for the bottom left tile button part
         * TODO: fix the backend logic
         * @author Yiwei
         */

        Button buttonConfirm = new Button("Confirm");
        buttonConfirm.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

            }
        });

        Button buttonCancel = new Button("Cancel");
        buttonCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {

            }
        });

        HBox hbtile = new HBox();
        hbtile.getChildren().addAll(buttonConfirm, buttonCancel);
        hbtile.setSpacing(BOARD_MARGIN);
        hbtile.setLayoutX(GAME_WIDTH - VBOX_WIDTH - 20);
        hbtile.setLayoutY(GAME_HEIGHT - 50);
        controls.getChildren().add(hbtile);
    }

    private void makeControls() {
        /**
         * This method generates the left bottom part for playerSequence input.
         * TODO: could be moved to StartScene
         */

        //Label, input and button part
        Label label1 = new Label("Player Name:");
        label1.setTextFill(Color.WHITE);
        textField = new TextField("Enter Players' Sequence, e.g. Amy, Bob");
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
                    //System.out.println(humanPlayerList.get(m));
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


    public static ArrayList<String> getPossibleLocation(String placementSequence, String tileType) {
        //TODO: need input to run metro.possibleListStr

        ArrayList<String> placementList = new ArrayList<>(Arrays.asList(
                "00", "01", "02", "03", "04", "05", "06", "07",
                "10", "11", "12", "13", "14", "15", "16", "17",
                "20", "21", "22", "23", "24", "25", "26", "27",
                "30", "31", "32", "33", "34", "35", "36", "37",
                "40", "41", "42", "43", "44", "45", "46", "47",
                "50", "51", "52", "53", "54", "55", "56", "57",
                "60", "61", "62", "63", "64", "65", "66", "67",
                "70", "71", "72", "73", "74", "75", "76", "77"));

        ArrayList<String> possibleLocationList = new ArrayList<>();

        for (int i = 0; i < placementList.size(); i++) {
            String s = placementSequence + tileType + placementList.get(i);
            //System.out.println(s);
            if (Metro.isPlacementSequenceValid(s)) {
                String location = s.substring(s.length() - 2, s.length());
                possibleLocationList.add(location);
                //System.out.println(s);
            }
        }
        //System.out.println(possibleLocationList);
        return possibleLocationList;
    }

    public class DraggableSquare extends Tile {
        /**
         * This class implements the draggable square to represent the tile
         */
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
                this.setLayoutX(hightlighted.x);
                this.setLayoutY(hightlighted.y);
                tileOnBoard.add(this);
                for (int j = 0; j < markList.size(); j++) {
                    //continue here
                    markList.get(j).setText(humanPlayerList.get(j) + "\nMark: " + Metro.getScore(getPlacementSequence(), numPlayers1)[j] + "\n");
                }

            });
        }
    }

    public Tile findNearestSquare(double x, double y) {
        //To find the nearest square on board
        double shortDistance = GAME_WIDTH * 3;
        int index = 0;
        for (int i = 0; i < squareBoard.size(); i++) {
            if (squareBoard.get(i) != null) {
                Tile squ = squareBoard.get(i);
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
        //To highlight the nearest square on Board
        if (hightlighted != null) {
            hightlighted.setFill(Color.LIGHTGRAY);
        }
        hightlighted = findNearestSquare(mousex, mousey);
        if (hightlighted != null) {
            hightlighted.setFill(Color.GREEN);
        }
    }

    public void highlightPossibleLocation(String placementSequence, String tileType) {
        for (int i = 0; i < squareBoard.size(); i++) {
            squareBoard.get(i).setFill(Color.LIGHTGRAY);
        }

        ArrayList<Integer> indexList = new ArrayList<>();
        for (String element : getPossibleLocation(placementSequence, tileType)) {
            int row = Integer.parseInt(String.valueOf(element.charAt(0)));
            int column = Integer.parseInt(String.valueOf(element.charAt(1)));
            System.out.println("row");
            System.out.println("column");
            int index = Integer.parseInt(String.valueOf(element.charAt(0))) * 8 + Integer.parseInt(String.valueOf(element.charAt(1)));
            indexList.add(index);
        }
        System.out.println("indexlist " + indexList);

        for (int i = 0; i < squareBoard.size(); i++) {
            System.out.println("new tile");
            if (indexList.contains(i)) {
                squareBoard.get(i).setFill(Color.BLUE);
                System.out.println("i = " + i);
                System.out.println("x " + squareBoard.get(i).getLayoutX());
            }
        }
    }

    public void makeLightGreySquareBoard() {
        //create a lightgrey square Arraylist on Board for future highlight

        for (int i = 0; i < 64; i++) {
            int row = i / 8;
            int j = i % 8;
            //Tile square = new Tile(BOARD_MARGIN + 1.5 * SQUARE_SIZE + SQUARE_SIZE * row, BOARD_MARGIN + 1.5 * SQUARE_SIZE + SQUARE_SIZE * j);
            Tile square = new Tile(BOARD_MARGIN + 1.5 * SQUARE_SIZE + SQUARE_SIZE * j, BOARD_MARGIN + 1.5 * SQUARE_SIZE + SQUARE_SIZE * row);
            square.setFill(Color.LIGHTGRAY);
            square.setOpacity(0.3);
            if ((i == 27 || i == 28) || (i == 35 || i == 36)) {
                square.setFill(central);
            }
            squareBoard.add(square);
            root.getChildren().add(square);
        }


        /*
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                Tile square = new Tile(BOARD_MARGIN + 1.5 * SQUARE_SIZE + SQUARE_SIZE * i, BOARD_MARGIN + 1.5 * SQUARE_SIZE + SQUARE_SIZE * j);
                square.setFill(Color.LIGHTGRAY);
                square.setOpacity(0.3);
                if ((i == 3 || i == 4) && (j == 3 || j == 4)) {
                    square.setFill(central);
                }
                squareBoard.add(square);
                root.getChildren().add(square);
            }
        }

         */


    }

    private void setVBoxLeft() {
        //To set the left box for human players
        vLeft = new VBox();
        vLeft.setLayoutX(BOARD_MARGIN + SQUARE_SIZE * 10 + BOARD_MARGIN);
        vLeft.setLayoutY(BOARD_MARGIN);

        playerStillList = new ArrayList<>();

        for (int j = 0; j < 3; j++) {
            ImageView player = new ImageView();
            player.setFitWidth(PLAYER_WIDTH);
            player.setFitHeight(PLAYER_HEIGHT);
            player.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
            vLeft.getChildren().add(player);
            playerStillList.add(player);

            if (j == 0) {
                mark1.setTextAlignment(TextAlignment.RIGHT);
                mark1.setText("Mark for Player 1");
                mark1.setFill(Color.BROWN);
                vLeft.getChildren().add(mark1);
            }

            if (j == 1) {
                mark3.setTextAlignment(TextAlignment.RIGHT);
                mark3.setText("Mark for Player 3");
                mark3.setFill(Color.BROWN);
                vLeft.getChildren().add(mark3);
            }

            if (j == 2) {
                mark5.setTextAlignment(TextAlignment.RIGHT);
                mark5.setText("Mark for Player 5");
                mark5.setFill(Color.BROWN);
                vLeft.getChildren().add(mark5);
            }
        }

        root.getChildren().add(vLeft);
    }

    private void setVBoxRight() {
        //To set the left box for AI players
        VBox vRight = new VBox();
        vRight.setLayoutX(BOARD_MARGIN + SQUARE_SIZE * 10 + BOARD_MARGIN + PLAYER_WIDTH + 5);
        vRight.setLayoutY(BOARD_MARGIN);

        for (int j = 0; j < 3; j++) {
            ImageView player = new ImageView();
            player.setFitWidth(PLAYER_WIDTH);
            player.setFitHeight(PLAYER_HEIGHT);
            player.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
            vRight.getChildren().add(player);

            if (j == 0) {
                mark2.setTextAlignment(TextAlignment.RIGHT);
                mark2.setText("Mark for Player 2");
                mark2.setFill(Color.BROWN);
                vRight.getChildren().add(mark2);
            }

            if (j == 1) {
                mark4.setTextAlignment(TextAlignment.RIGHT);
                mark4.setText("Mark for Player 4");
                mark4.setFill(Color.BROWN);
                vRight.getChildren().add(mark4);
            }

            if (j == 2) {
                mark6.setTextAlignment(TextAlignment.RIGHT);
                mark6.setText("Mark for Player 6");
                mark6.setFill(Color.BROWN);
                vRight.getChildren().add(mark6);
            }
        }

        root.getChildren().add(vRight);
    }

    private void sethBOX() {
        //Tile in Hand and Tile in dock part
        HBox hHandDock = new HBox();
        hHandDock.setLayoutX(GAME_WIDTH - BOARD_MARGIN - VBOX_WIDTH);
        hHandDock.setLayoutY(GAME_HEIGHT - BOARD_MARGIN - 1.3 * SQUARE_SIZE);

        Text tHand = new Text();
        tHand.setText("Hand");
        tHand.setFill(Color.BROWN);
        hHandDock.getChildren().add(tHand);

        ImageView playerHand = new ImageView();
        playerHand.setFitWidth(SQUARE_SIZE);
        playerHand.setFitHeight(SQUARE_SIZE);
        playerHand.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        hHandDock.getChildren().add(playerHand);
        playerHand.setOnMouseClicked(event -> {
            DraggableSquare tileHand = new DraggableSquare(GAME_WIDTH - BOARD_MARGIN - VBOX_WIDTH + SQUARE_SIZE, GAME_HEIGHT - 2 * BOARD_MARGIN, this);

            String tiletype1;
            if (allTilesGenerated == "") {
                tiletype1 = Metro.drawFromDeck("", "");
                tileHand.tileType = tiletype1;
                allTilesGenerated = allTilesGenerated + tiletype1;
            } else {
                tiletype1 = Metro.drawFromDeck("", allTilesGenerated);
                tileHand.tileType = tiletype1;
                allTilesGenerated = allTilesGenerated + tiletype1;
            }

            highlightPossibleLocation(getPlacementSequence(), tiletype1);
            //System.out.println(getPlacementSequence());
            Image img1 = new Image(this.getClass().getResource("assets/" + tiletype1 + ".jpg").toString());
            tileHand.setFill(new ImagePattern(img1));
            root.getChildren().add(tileHand);


        });

        Text tDock = new Text();
        tDock.setText("    Deck");
        tDock.setFill(Color.BROWN);
        hHandDock.getChildren().add(tDock);

        ImageView dockTile = new ImageView();
        dockTile.setFitWidth(SQUARE_SIZE);
        dockTile.setFitHeight(SQUARE_SIZE);
        dockTile.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        hHandDock.getChildren().add(dockTile);

        dockTile.setOnMouseClicked(event -> {
            DraggableSquare tileDock = new DraggableSquare(GAME_WIDTH - BOARD_MARGIN - VBOX_WIDTH + 2.75 * SQUARE_SIZE, GAME_HEIGHT - 2 * BOARD_MARGIN, this);

            //System.out.println("original " + allTilesGenerated);
            String tiletype2;
            if (allTilesGenerated == "") {
                tiletype2 = Metro.drawFromDeck("", "");
                tileDock.tileType = tiletype2;
                allTilesGenerated = allTilesGenerated + tiletype2;
                //System.out.println("addedDock " + allTilesGenerated);
            } else {
                tiletype2 = Metro.drawFromDeck("", allTilesGenerated);
                tileDock.tileType = tiletype2;
                allTilesGenerated = allTilesGenerated + tiletype2;
            }
            highlightPossibleLocation(getPlacementSequence(), tiletype2);

            Image img2 = new Image(this.getClass().getResource("assets/" + tiletype2 + ".jpg").toString());
            tileDock.setFill(new ImagePattern(img2));
            root.getChildren().add(tileDock);
        });

        root.getChildren().add(hHandDock);

    }

    private String getPlacementSequence() {
        placementSequence = "";
        for (int n = 0; n < tileOnBoard.size(); n++) {
            double layoutX = tileOnBoard.get(n).getLayoutX();
            double layoutY = tileOnBoard.get(n).getLayoutY();
            int tileRow = (int) ((layoutY - 82) / 64) - 1;
            int tileColumn = (int) ((layoutX - 82) / 64) - 1;
            String placeString = tileOnBoard.get(n).tileType + String.valueOf(tileRow) + String.valueOf(tileColumn);
            placementSequence = placementSequence + placeString;
        }

        return placementSequence;
    }

    private void setBoardBackground() {
        /**
         * This method adds a stackpane and uses a background image for the board.
         */
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

        //add edges
        for (int i = 1; i <= 32; i++) {
            ImageView station = new ImageView();
            String stationLoc = URI_BASE + "station" + i + ".jpg";
            station.setFitWidth(64);
            station.setFitHeight(64);
            station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
            if (i <= 8) {
                board.add(station, 9 - i, 0);
            } else if (i <= 16 && i >= 9) {
                board.add(station, 0, i - 8);
            } else if (i <= 24 && i >= 17) {
                board.add(station, i - 16, 9);
            } else {
                board.add(station, 9, 33 - i);
            }
        }

        for (int i = 0; i < 4; i++) {
            // add corners
            ImageView corner = new ImageView();
            corner.setFitWidth(SQUARE_SIZE);
            corner.setFitHeight(SQUARE_SIZE);
            corner.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
            if (i == 0) {
                board.add(corner, 0, 0);
            } else if (i == 1) {
                board.add(corner, 0, 9);
            } else if (i == 2) {
                board.add(corner, 9, 0);
            } else {
                board.add(corner, 9, 9);
            }
        }

        root.getChildren().add(board);
    }


}
