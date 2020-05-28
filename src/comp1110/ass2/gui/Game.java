package comp1110.ass2.gui;

import comp1110.ass2.*;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.text.Text;

import java.awt.*;
import java.nio.file.Paths;
import java.util.*;

import static comp1110.ass2.Metro.isPlacementSequenceValid;

public class Game extends Application {
    private static final int GAME_WIDTH = 1024;
    private static final int GAME_HEIGHT = 768;
    public static final int SQUARE_SIZE = 64;
    private static final int BOARD_MARGIN = 50;
    private static final int VBOX_WIDTH = 234;
    private static final double PLAYER_WIDTH = (double) VBOX_WIDTH / 2;
    private static final String URI_BASE = "assets/";

    public Scene mainscene;
    private Group root = new Group();
    private final GridPane board = new GridPane();
    private final Group controls = new Group();
    public VBox vLeft;
    public VBox vRight;
    public Text mark = new Text();
    private final Color central = Color.TRANSPARENT;

    private double mousex;
    private double mousey;
    Tile hightlighted = null;
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
    public ImageView playerHand;
    public int numPlayers1Start;
    public int numPlayers2Start;
    public int totalPlayerNum;
    public String playerInput1Start;
    public String playerInput2Start;
    public String playerInput3Start;
    public ArrayList<String> humanPlayerListStart = new ArrayList<>();
    public ArrayList<String> aiplayerlistStart = new ArrayList<>();
    public ArrayList<String> totalName = new ArrayList<>();
    public boolean[] turns;
    public int round = 0;
    public AIDifficulty aiDifficulty = AIDifficulty.EASY;
    public int variants;

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        //To launch the still setting part of the game
        mainscene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);

        Image mainSceneBackground = new Image(this.getClass().getResource("assets/MainSceneBackground.png").toString());
        mainscene.setFill(new ImagePattern(mainSceneBackground));

        primaryStage.setTitle("Metro Game");
        root.getChildren().add(controls);

        makeBoard();
        setBoardBackground();
        setVBoxLeft();
        setVBoxRight();
        sethBOX();
        makeLightGreySquareBoard();
        music();


        //Startscene
        sceneStart = new Scene(rootStart, GAME_WIDTH, GAME_HEIGHT);
        makeStartControls();


        chooseDifficulty();
        addVariants();


        rootStart.getChildren().add(controlsStart);
        Image startSceneBackground = new Image(this.getClass().getResource("assets/StartSceneBackground.png").toString());
        sceneStart.setFill(new ImagePattern(startSceneBackground));
        sceneStart.getStylesheets().addAll(this.getClass().getResource("styleGame.css").toExternalForm());
        button3.setOnMouseClicked(event -> {
            primaryStage.setScene(mainscene);
        });


        primaryStage.setScene(sceneStart);
        mainscene.getStylesheets().addAll(this.getClass().getResource("styleGame.css").toExternalForm());
        primaryStage.show();
    }

    private void putextraTile() {
        HBox hb2 = new HBox();
        hb2.setLayoutX(GAME_WIDTH - BOARD_MARGIN - 0.85 * VBOX_WIDTH);
        hb2.setLayoutY(GAME_HEIGHT - 4.5 * BOARD_MARGIN);

        ImageView playerHandNew = new ImageView();
        playerHandNew.setFitWidth(SQUARE_SIZE);
        playerHandNew.setFitHeight(SQUARE_SIZE);
        playerHandNew.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
        hb2.getChildren().add(playerHandNew);
        root.getChildren().add(hb2);

        playerHandNew.setOnMouseClicked(event -> {
            DraggableSquare tileHand2 = new DraggableSquare(GAME_WIDTH - BOARD_MARGIN - 0.72 * VBOX_WIDTH, GAME_HEIGHT - 3.85 * BOARD_MARGIN, this);
            tileHand2.toFront();

            String tiletype3;
            if (allTilesGenerated == "") {
                tiletype3 = Metro.drawFromDeck("", "");
                tileHand2.tileType = tiletype3;
                allTilesGenerated = allTilesGenerated + tiletype3;
            } else {
                tiletype3 = Metro.drawFromDeck("", allTilesGenerated);
                tileHand2.tileType = tiletype3;
                allTilesGenerated = allTilesGenerated + tiletype3;
            }

            highlightPossibleLocation(getPlacementSequence(), tiletype3);
            Image img1 = new Image(this.getClass().getResource("assets/" + tiletype3 + ".jpg").toString());
            tileHand2.setFill(new ImagePattern(img1));
            root.getChildren().add(tileHand2);

            // getAdvancedTilePlacement(AdvancedAI.getPathMarkList(PathList.getPathList(getPlacementSequence()), AdvancedAI.getPathStatusList(PathList.getPathList(getPlacementSequence()))), getAIPathStationList(),tiletype1);


        });

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


                //create player image based on input
                numPlayers1Start = 1;

                //start
                int l = 0;
                while (l < playerInput1Start.length()) {
                    if (playerInput1Start.charAt(l) == ',') {
                        numPlayers1Start++;
                    }
                    l++;
                }


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


                setHumanPlayersStart();
            }
        });

        vbStart.getChildren().addAll(label1, textField1Start, button1);
        vbStart.setSpacing(10);
        vbStart.setLayoutX(GAME_WIDTH / 5);
        vbStart.setLayoutY(GAME_HEIGHT / 2.5);

        Label label2 = new Label("AI Player Name:");
        label2.setTextFill(Color.BLACK);
        textField2Start = new TextField("Enter Players' Sequence, e.g. CindyAI, DavidAI");
        textField2Start.setPrefWidth(300);
        Button button2 = new Button("Set AI Players");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                playerInput2Start = textField2Start.getText();


                //create player image based on input
                numPlayers2Start = 1;

                //start
                int l = 0;
                while (l < playerInput2Start.length()) {
                    if (playerInput2Start.charAt(l) == ',') {
                        numPlayers2Start++;
                    }
                    l++;
                }


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


                setAiPlayersStart();
            }
        });
        vbStart.getChildren().addAll(label2, textField2Start, button2);
        vbStart.setSpacing(10);

        controlsStart.getChildren().add(vbStart);
    }

    private void setHumanPlayersStart() {
        //create Image for players
        for (int i = 0; i < numPlayers1Start; i++) {
            Image imgPlayer = new Image(this.getClass().getResource("assets/p" + (i + 1) + ".jpg").toString());
            Circle c = new Circle(PLAYER_WIDTH / 2.5);
            c.setFill(new ImagePattern(imgPlayer));
            vLeft.getChildren().add(c);

            Text mark = new Text();
            mark.setTextAlignment(TextAlignment.LEFT);
            mark.setText(humanPlayerListStart.get(i) + "\nMark: 0" + "\n");
            //mark.setText(humanPlayerListStart.get(i) + "\nMark: " + Metro.getScore(getPlacementSequence(), humanPlayerListStart.size())[i] + "\n");
            mark.setFill(Color.BLACK);
            vLeft.getChildren().add(mark);
            markList.add(mark);
        }
    }

    private void setAiPlayersStart() {


        for (int i = 0; i < numPlayers2Start; i++) {
            Image imgPlayer2 = new Image(this.getClass().getResource("assets/p" + (i + 4) + ".jpg").toString());
            Circle c2 = new Circle(PLAYER_WIDTH / 2.5);
            c2.setFill(new ImagePattern(imgPlayer2));
            vRight.getChildren().add(c2);

            Text mark = new Text();
            mark.setTextAlignment(TextAlignment.LEFT);
            mark.setText(aiplayerlistStart.get(i) + "\nMark: " + Metro.getScore(getPlacementSequence(), numPlayers1Start + numPlayers2Start)[i + numPlayers1Start] + "\n");
            mark.setFill(Color.BLACK);
            vRight.getChildren().add(mark);
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


                totalName.addAll(humanPlayerListStart);
                totalName.addAll(aiplayerlistStart);
                totalPlayerNum = numPlayers1Start + numPlayers2Start;
                turns = new boolean[totalPlayerNum];

                turns[0] = true;
                textField1Start.clear();
                //TODO
                if (Integer.parseInt(playerInput3Start) < 3) {
                    variants = Integer.parseInt(playerInput3Start); //

                    if (variants == 2) {
                        putextraTile();
                    }
                }


                getAIPathStationList();
                //

            }
        });

        vbStart.getChildren().addAll(label3, textField3Start, button3);
    }

    private void chooseDifficulty() {
        Label label4 = new Label("Choose Difficulty: ");
        label4.setTextFill(Color.BLACK);
        Button button4 = new Button("Easy");
        Button button5 = new Button("Difficult");
        button5.setOnMouseClicked(e -> {
            aiDifficulty = AIDifficulty.DIFFICULT;

        });

        //Button button6 = new Button("Random");
        HBox hbStart = new HBox(label4, button4, button5);
        hbStart.setSpacing(10);
        vbStart.getChildren().addAll(hbStart);
    }


    public static ArrayList<String> getPossibleLocation(String placementSequence, String tileType) {
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
            if (Metro.isPlacementSequenceValid(s)) {
                String location = s.substring(s.length() - 2, s.length());
                possibleLocationList.add(location);
            }
        }
        return possibleLocationList;


    }

    public void highlightPossibleLocation(String placementSequence, String tileType) {
        for (int i = 0; i < squareBoard.size(); i++) {
            squareBoard.get(i).setFill(Color.LIGHTGRAY);
        }

        ArrayList<Integer> centralList = new ArrayList<>(Arrays.asList(27, 28, 35, 36));
        for (int n : centralList) {
            squareBoard.get(n).setFill(central);
        }

        ArrayList<Integer> indexList = new ArrayList<>();
        for (String element : getPossibleLocation(placementSequence, tileType)) {
            int row = Integer.parseInt(String.valueOf(element.charAt(0)));
            int column = Integer.parseInt(String.valueOf(element.charAt(1)));
            int index = row * 8 + column;
            indexList.add(index);
        }

        for (int i = 0; i < squareBoard.size(); i++) {
            if (indexList.contains(i)) {
                squareBoard.get(i).setFill(Color.BLUE);
            }
        }
    }

    public class DraggableSquare extends Tile {
        public Game game;

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

                //highlightPossibleLocation(getPlacementSequence(), this.tileType);

            });

            this.setOnMouseReleased(event -> {
                this.setLayoutX(hightlighted.x);
                this.setLayoutY(hightlighted.y);
                tileOnBoard.add(this);


                int indexTurn = 0;
                for (int i = 0; i < totalPlayerNum; i++) {
                    markList.get(i).setText(totalName.get(i) + "\nMark: " + updateMarks(totalPlayerNum, i));
                }

                updateTurns();

                while (checkAiTurn() && aiDifficulty == AIDifficulty.EASY) {
                    placeAiTile();
                    updateTurns();
                }

                while (AIDifficulty.DIFFICULT == AIDifficulty.DIFFICULT && checkAiTurn()) {
                    placeAdvancedAiTile();
                    updateTurns();
                }

                if (round == 60) {
                    enlightPath();
                }

            });
        }
    }

    private void enlightPath() {
        ArrayList<Tile> squareBoardNew = new ArrayList<>();
        for (int i = 0; i < 64; i++) {
            int row = i / 8;
            int j = i % 8;
            Tile square = new Tile(BOARD_MARGIN + 1.5 * SQUARE_SIZE + SQUARE_SIZE * j, BOARD_MARGIN + 1.5 * SQUARE_SIZE + SQUARE_SIZE * row);
            square.setFill(Color.LIGHTGRAY);
            square.setOpacity(0.3);
            if ((i == 27 || i == 28) || (i == 35 || i == 36)) {
                Image img1 = new Image(this.getClass().getResource("assets/centre_station.jpg").toString());
                square.setFill(new ImagePattern(img1));

            }

            squareBoardNew.add(square);
            root.getChildren().add(square);
        }

        ArrayList<LinkedList<Integer>> pathList = PathList.getPathList(getPlacementSequence());

        for (int j = 0; j < pathList.size(); j++) {
            LinkedList path1 = pathList.get(j);

            int startLoc = convertStartStationToLoc((Integer) path1.getFirst());
            path1.add(1, startLoc);

            for (int i = 1; i < path1.size(); i++) {
                int row = (Integer) path1.get(i) / 10;
                int column = (Integer) path1.get(i) % 10;
                Random r = new Random();
                int randomcolor1 = r.nextInt(256);
                int randomcolor2 = r.nextInt(256);
                int randomcolor3 = r.nextInt(256);
                squareBoardNew.get(row * 8 + column).setFill(Color.rgb(randomcolor1, randomcolor2, randomcolor3));
            }
        }

        ArrayList<Integer> centralList = new ArrayList<>(Arrays.asList(27, 28, 35, 36));
        for (int n : centralList) {
            squareBoard.get(n).setFill(central);
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
        ArrayList<Integer> centralList = new ArrayList<>(Arrays.asList(27, 28, 35, 36));
        for (int n : centralList) {
            squareBoard.get(n).setFill(central);
        }
    }


    private void setVBoxLeft() {
        //To set the left box for human players
        vLeft = new VBox();
        vLeft.setLayoutX(BOARD_MARGIN + SQUARE_SIZE * 10 + BOARD_MARGIN);
        vLeft.setLayoutY(BOARD_MARGIN);
        root.getChildren().add(vLeft);
    }

    public void setVBoxRight() {
        //To set the left box for AI players
        vRight = new VBox();
        vRight.setLayoutX(BOARD_MARGIN + SQUARE_SIZE * 10 + BOARD_MARGIN + PLAYER_WIDTH + 5);
        vRight.setLayoutY(BOARD_MARGIN);

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


        playerHand = new ImageView();
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
            Image img1 = new Image(this.getClass().getResource("assets/" + tiletype1 + ".jpg").toString());
            tileHand.setFill(new ImagePattern(img1));
            root.getChildren().add(tileHand);

            // getAdvancedTilePlacement(AdvancedAI.getPathMarkList(PathList.getPathList(getPlacementSequence()), AdvancedAI.getPathStatusList(PathList.getPathList(getPlacementSequence()))), getAIPathStationList(),tiletype1);


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
            String tiletype2;
            if (allTilesGenerated == "") {
                tiletype2 = Metro.drawFromDeck("", "");
                tileDock.tileType = tiletype2;
                allTilesGenerated = allTilesGenerated + tiletype2;

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


    public void makeLightGreySquareBoard() {
        for (int i = 0; i < 64; i++) {
            int row = i / 8;
            int j = i % 8;
            Tile square = new Tile(BOARD_MARGIN + 1.5 * SQUARE_SIZE + SQUARE_SIZE * j, BOARD_MARGIN + 1.5 * SQUARE_SIZE + SQUARE_SIZE * row);
            square.setFill(Color.LIGHTGRAY);
            square.setOpacity(0.3);
            if ((i == 27 || i == 28) || (i == 35 || i == 36)) {
                square.setFill(central);
            }
            squareBoard.add(square);
            root.getChildren().add(square);
        }

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

        //add edges
        for (int i = 1; i <= 32; i++) {
            ImageView station = new ImageView();
            String stationLoc = URI_BASE + "station" + i + ".jpg";
            station.setFitWidth(64);
            station.setFitHeight(64);
            station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
            if (i <= 8) {
                board.add(station, 9 - i, 0);
            } else if (i <= 16) {
                board.add(station, 0, i - 8);
            } else if (i <= 24) {
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

    public String getPlacementSequence() {
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

    public int updateMarks(int numOfPlayers, int index) {
        int[] markArray = Metro.getScore(getPlacementSequence(), numOfPlayers);
        int score = 0;

        if (index < markArray.length) {
            score = markArray[index];
        }

        return score;
    }

    public void updateTurns() {
        int currentTurn = 0;
        for (int i = 0; i < totalPlayerNum; i++) {
            if (turns[i] == true) {
                currentTurn = i;
            }
        }


        round++;


        int nextIndex = round % totalPlayerNum;


        turns[currentTurn] = false;
        turns[nextIndex] = true;

    }

    boolean checkAiTurn() {
        if (round % totalPlayerNum >= numPlayers1Start) {

            return true;
        }
        return false;
    }

    void placeAiTile() {
        DraggableSquare tileAI = new DraggableSquare(GAME_WIDTH - BOARD_MARGIN - VBOX_WIDTH + SQUARE_SIZE, GAME_HEIGHT - 2 * BOARD_MARGIN, this);

        String tiletype1 = "";
        if (allTilesGenerated.equals("")) {
            tiletype1 = Metro.drawFromDeck("", "");
            tileAI.tileType = tiletype1;
            allTilesGenerated = allTilesGenerated + tiletype1;
        } else {
            tiletype1 = Metro.drawFromDeck("", allTilesGenerated);
            tileAI.tileType = tiletype1;
            allTilesGenerated = allTilesGenerated + tiletype1;
        }

        String placeS = getPlacementSequence();

        String s = Metro.generateMove(placeS, tiletype1, totalPlayerNum);


        int row = Integer.parseInt(String.valueOf(s.charAt(4)));
        int column = Integer.parseInt(String.valueOf(s.charAt(5)));
        double setX = (row + 1) * 64 + 82;
        double setY = (column + 1) * 64 + 82;


        tileAI.setLayoutX(setY);
        tileAI.setLayoutY(setX);
        tileOnBoard.add(tileAI);

        Image img1 = new Image(this.getClass().getResource("assets/" + tiletype1 + ".jpg").toString());
        tileAI.setFill(new ImagePattern(img1));

        root.getChildren().add(tileAI);

    }

    public ArrayList<Integer> getAIPathStationList() {
        ArrayList<Integer> stationList = new ArrayList<>();
        ArrayList<ArrayList<Integer>> playerstation = getplayerstationByNum(totalPlayerNum);
        for (int i = numPlayers1Start; i < totalPlayerNum; i++) {
            stationList.addAll(playerstation.get(i));
        }

        return stationList;
    }

    public ArrayList<ArrayList<Integer>> getplayerstationByNum(int numberOfPlayers) {
        ArrayList<ArrayList<Integer>> playerstation = new ArrayList<>();

        switch (numberOfPlayers) {
            case 2:
                playerstation.add(new ArrayList<>(Arrays.asList(1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31)));
                playerstation.add(new ArrayList<>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32)));
                break;
            case 3:
                playerstation.add(new ArrayList<>(Arrays.asList(1, 4, 6, 11, 15, 20, 23, 25, 28, 31)));
                playerstation.add(new ArrayList<>(Arrays.asList(2, 7, 9, 12, 14, 19, 22, 27, 29, 32)));
                playerstation.add(new ArrayList<>(Arrays.asList(3, 5, 8, 10, 13, 18, 21, 24, 26, 30)));
                break;
            case 4:
                playerstation.add(new ArrayList<>(Arrays.asList(4, 7, 11, 16, 20, 23, 27, 32)));
                playerstation.add(new ArrayList<>(Arrays.asList(3, 8, 12, 15, 19, 24, 28, 31)));
                playerstation.add(new ArrayList<>(Arrays.asList(1, 6, 10, 13, 18, 21, 25, 30)));
                playerstation.add(new ArrayList<>(Arrays.asList(2, 5, 9, 14, 17, 22, 26, 29)));
                break;
            case 5:
                playerstation.add(new ArrayList<>(Arrays.asList(1, 5, 10, 14, 22, 28)));
                playerstation.add(new ArrayList<>(Arrays.asList(6, 12, 18, 23, 27, 32)));
                playerstation.add(new ArrayList<>(Arrays.asList(3, 7, 15, 19, 25, 29)));
                playerstation.add(new ArrayList<>(Arrays.asList(2, 9, 13, 21, 26, 30)));
                playerstation.add(new ArrayList<>(Arrays.asList(4, 8, 11, 20, 24, 31)));
                break;
            case 6:
                playerstation.add(new ArrayList<>(Arrays.asList(1, 5, 10, 19, 27)));
                playerstation.add(new ArrayList<>(Arrays.asList(2, 11, 18, 25, 29)));
                playerstation.add(new ArrayList<>(Arrays.asList(4, 8, 14, 21, 26)));
                playerstation.add(new ArrayList<>(Arrays.asList(6, 15, 20, 24, 31)));
                playerstation.add(new ArrayList<>(Arrays.asList(3, 9, 13, 23, 30)));
                playerstation.add(new ArrayList<>(Arrays.asList(7, 12, 22, 28, 32)));
                break;
        }

        return playerstation;
    }

    String getAdvancedTilePlacement(String tiletypeAi) {
        String advanced = "";

        String placementSequence = getPlacementSequence();
        HashMap<Integer, String> tileList = new HashMap<>();
        for (int j = 0; j < placementSequence.length(); j += 6) {
            String tile = placementSequence.substring(j, j + 4);
            String position = placementSequence.substring(j + 4, j + 6);
            int positionInt = Integer.parseInt(position);
            tileList.put(positionInt, tile);

        }

        ArrayList<Integer> possibleListInt = new ArrayList<>();
        ArrayList<String> possibleListStr = Metro.getPossibleListNew(placementSequence, tiletypeAi);
        for (String s : possibleListStr) {
            int n = Integer.parseInt(s.substring(s.length() - 2));
            possibleListInt.add(n);
        }


        HashMap<Double, String> possibleMarkList = new HashMap<>();
        ArrayList<Integer> aiStationList = getAIPathStationList();

        for (int i = 0; i < possibleListStr.size(); i++) {
            String placeSequenceNew = "";
            String place1 = possibleListStr.get(i);
            placeSequenceNew = placementSequence + place1;


            ArrayList<LinkedList<Integer>> pathListNew = PathList.getPathList(placeSequenceNew);
            ArrayList<PathState> pathStatusListNew = AdvancedAI.getPathStatusList(pathListNew);
            ArrayList<Double> markListNew = AdvancedAI.getPathMarkList(pathListNew, pathStatusListNew);

            ArrayList<Integer> aiStationListNew = getAIPathStationList();

            HashMap<Double, LinkedList<Integer>> markStationMapNew = new HashMap<>();
            for (int j : aiStationList) {
                if (markStationMapNew.containsKey(markListNew.get(j - 1))) {
                    markStationMapNew.get(markListNew.get(j - 1)).add(j);
                } else {
                    markStationMapNew.put(markListNew.get(j - 1), new LinkedList<>());
                    markStationMapNew.get(markListNew.get(j - 1)).addFirst(j);
                }
            }


            double sumNew = 0;
            for (double markAi : markStationMapNew.keySet()) {
                sumNew += markAi;

            }

            possibleMarkList.put(sumNew, place1);
        }


        double greatest = 0;
        for (double h : possibleMarkList.keySet()) {
            if (h > greatest) {
                greatest = h;
            }
        }

        advanced = possibleMarkList.get(greatest);

        return advanced;
    }

    int convertStartStationToLoc(int startStation) {
        int startLoc = 0;
        if (startStation <= 8) {
            startLoc = 8 - startStation;
        } else if (startStation <= 16) {
            startLoc = startStation - 9;
        } else if (startStation <= 24) {
            startLoc = startStation + 53;
        } else {
            startLoc = 102 - (startStation - 25) * 9 - startStation;
        }
        return startLoc;
    }

    int getNextPosition(String startType, int startPlace, LinkedList<Integer> path) {
        String placementSequence = getPlacementSequence();

        HashMap<Integer, String> tileList = new HashMap<>();
        for (int j = 0; j < placementSequence.length(); j += 6) {
            //Hashmap for the placement, position as Key
            String tile = placementSequence.substring(j, j + 4);
            String position = placementSequence.substring(j + 4, j + 6);
            int positionInt = Integer.parseInt(position);
            tileList.put(positionInt, tile);

        }

        int next = 0;
        int startDirection = PathList.getPreviousDirctionForEdge(startType, startPlace);


        String tiletype1 = tileList.get(startPlace);
        int tilePlace1 = startPlace;
        int direction = startDirection;
        int newDirection = 0;

        while (next != path.get(path.size() - 1)) {
            newDirection = PathList.getDirectionForTile(tiletype1, tilePlace1, direction);
            next = tilePlace1 + newDirection;
            tiletype1 = tileList.get(next);
            tilePlace1 = next;
            direction = newDirection;
        }


        return next;
    }

    LinkedList<Integer> getStationWithMaxMark(HashMap<Double, LinkedList<Integer>> markStationMap) {
        double max = 0.0;
        LinkedList<Integer> maxStationList = new LinkedList<>();

        for (double mark : markStationMap.keySet()) {
            if (mark > max) {
                max = mark;
                maxStationList = markStationMap.get(max);
            }
        }


        return maxStationList;
    }

    double getHightestMark(HashMap<Double, LinkedList<Integer>> markStationMap) {
        double max = 0.0;
        LinkedList<Integer> maxStationList = new LinkedList<>();

        for (double mark : markStationMap.keySet()) {
            if (mark > max) {
                max = mark;
                maxStationList = markStationMap.get(max);
            }
        }


        return max;
    }

    void placeAdvancedAiTile() {
        DraggableSquare tileAI = new DraggableSquare(GAME_WIDTH - BOARD_MARGIN - VBOX_WIDTH + SQUARE_SIZE, GAME_HEIGHT - 2 * BOARD_MARGIN, this);

        String tiletype1 = "";
        if (allTilesGenerated.equals("")) {
            tiletype1 = Metro.drawFromDeck("", "");
            tileAI.tileType = tiletype1;
            allTilesGenerated = allTilesGenerated + tiletype1;
        } else {
            tiletype1 = Metro.drawFromDeck("", allTilesGenerated);
            tileAI.tileType = tiletype1;
            allTilesGenerated = allTilesGenerated + tiletype1;
        }

        String placeS = getPlacementSequence();

        String s = getAdvancedTilePlacement(tiletype1);


        int row = Integer.parseInt(String.valueOf(s.charAt(4)));
        int column = Integer.parseInt(String.valueOf(s.charAt(5)));
        double setX = (row + 1) * 64 + 82;
        double setY = (column + 1) * 64 + 82;


        tileAI.setLayoutX(setY);
        tileAI.setLayoutY(setX);
        tileOnBoard.add(tileAI);

        Image img1 = new Image(this.getClass().getResource("assets/" + tiletype1 + ".jpg").toString());
        tileAI.setFill(new ImagePattern(img1));

        root.getChildren().add(tileAI);

    }


    MediaPlayer mediaPlayer;

    public void music() {
        Media h = new Media(this.getClass().getResource("assets/background.mp3").toString());
        mediaPlayer = new MediaPlayer(h);
        mediaPlayer.setVolume(0.01f);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();
    }


}
