package comp1110.ass2.gui;

import comp1110.ass2.Metro;
import comp1110.ass2.PathList;
import comp1110.ass2.PathState;
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

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Game extends Application {
    private static final int GAME_WIDTH = 1024;
    private static final int GAME_HEIGHT = 768;
    public static final int SQUARE_SIZE = 64;
    private static final int BOARD_MARGIN = 50;
    private static final int VBOX_WIDTH = 234;
    private static final double PLAYER_WIDTH = (double) VBOX_WIDTH / 2;
    private static final String URI_BASE = "assets/";

    public Scene mainscene;
    private final Group root = new Group();
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

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        //To launch the still setting part of the game
        mainscene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);

        Image mainSceneBackground = new Image(this.getClass().getResource("assets/vintagePaper.jpg").toString());
        mainscene.setFill(new ImagePattern(mainSceneBackground));

        primaryStage.setTitle("Metro Game");
        root.getChildren().add(controls);

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
                //System.out.println(playerInput1Start);

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

                setHumanPlayersStart();
            }
        });

        vbStart.getChildren().addAll(label1, textField1Start, button1);
        vbStart.setSpacing(10);
        vbStart.setLayoutX(GAME_WIDTH / 3);
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
                //System.out.println(playerInput2Start);

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
        //create Image for players
        System.out.println(aiplayerlistStart);

        for (int i = 0; i < numPlayers2Start; i++) {
            Image imgPlayer2 = new Image(this.getClass().getResource("assets/p" + (i + 6) + ".jpg").toString());
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
                System.out.println(playerInput3Start);

                totalName.addAll(humanPlayerListStart);
                totalName.addAll(aiplayerlistStart);
                totalPlayerNum = numPlayers1Start + numPlayers2Start;
                turns = new boolean[totalPlayerNum];
                System.out.println("turns " + turns.length);
                turns[0] = true;
                //TODO

                textField1Start.clear();

            }
        });

        vbStart.getChildren().addAll(label3, textField3Start, button3);
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

                while (checkAiTurn()) {
                    placeAiTile();
                    updateTurns();
                }

                getPathMarkList(PathList.getPathList(getPlacementSequence()), getPathStatusList(PathList.getPathList(getPlacementSequence())));
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
        //System.out.println("currentTurn " + currentTurn);

        round++;
        //System.out.println("round " + round);

        int nextIndex = round % totalPlayerNum;
        //System.out.println("nextIndex " + nextIndex);

        turns[currentTurn] = false;
        turns[nextIndex] = true;


        for (int d = 0; d < turns.length; d++) {
            //System.out.print(turns[d] + "");
        }
        //System.out.println();
    }

    boolean checkAiTurn() {
        if (round % totalPlayerNum >= numPlayers1Start) {
            System.out.println("AI turn");
            return true;
        }
        return false;
    }

    void placeAiTile() {
        DraggableSquare tileAI = new DraggableSquare(GAME_WIDTH - BOARD_MARGIN - VBOX_WIDTH + SQUARE_SIZE, GAME_HEIGHT - 2 * BOARD_MARGIN, this);

        String tiletype1 = "";
        if (allTilesGenerated == "") {
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
        //System.out.println(s);

        int row = Integer.parseInt(String.valueOf(s.charAt(4)));
        int column = Integer.parseInt(String.valueOf(s.charAt(5)));
        double setX = (row + 1) * 64 + 82;
        double setY = (column + 1) * 64 + 82;
        //System.out.println("row " + row + " column " + column + " setX " + setX + " setY " + setY);

        tileAI.setLayoutX(setY);
        tileAI.setLayoutY(setX);
        tileOnBoard.add(tileAI);

        Image img1 = new Image(this.getClass().getResource("assets/" + tiletype1 + ".jpg").toString());
        tileAI.setFill(new ImagePattern(img1));

        root.getChildren().add(tileAI);

    }

    public ArrayList<PathState> getPathStatusList(ArrayList<LinkedList<Integer>> pathlist) {
        ArrayList<PathState> pathStatusList = new ArrayList<PathState>();
        System.out.println(pathlist);
        //ArrayList<Integer> alreadyEnd = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,10,17,20,27,30,37,40,47,50,57,60,67,70,71,72,73,74,75,76,77));

        for (int i = 0; i < pathlist.size(); i++) {
            int pathLength = pathlist.get(i).size();
            int endPoint = pathlist.get(i).get(pathLength - 1);
            System.out.print(endPoint + " ");
            pathStatusList.add(PathState.getState(pathLength, endPoint));
        }

        System.out.println(pathStatusList);

        return pathStatusList;
    }

    public ArrayList<Double> getPathMarkList(ArrayList<LinkedList<Integer>> pathlist, ArrayList<PathState> pathStatusList) {
        ArrayList<Double> pathMarkList = new ArrayList<>();

        for (int i = 0; i < pathStatusList.size(); i++) {
            if (pathStatusList.get(i) == PathState.INACTIVE) {
                pathMarkList.add(0.0);
            } else {
                int pathLength = pathlist.get(i).size();
                int endPoint = pathlist.get(i).get(pathLength - 1);
                double distance = getDistanceToCentralFromInt(endPoint);
                double mark = pathLength + 2 * (3.5 * Math.sqrt(2) - distance);
                //length + coefficient * ( 4 * Math.sqrt(2) - distance(endpoint - (0, 0)))
                pathMarkList.add(mark);
            }
        }

        System.out.println(pathMarkList);
        return pathMarkList;
    }

    public static double getDistanceToCentralFromInt(int endPoint) {

        int row = endPoint / 10;
        int column = endPoint % 10;
        //System.out.println(row + " " + column);

        double distance = Math.sqrt(Math.pow((row - 3.5), 2) + Math.pow((column - 3.5), 2));
        //System.out.println(distance);
        return distance;
    }






}
