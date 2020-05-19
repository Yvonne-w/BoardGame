package comp1110.ass2.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.stage.Stage;

import java.util.ArrayList;

public class StartScene extends Application {
    private static final int GAME_WIDTH = 1024;
    private static final int GAME_HEIGHT = 768;

    public Stage startStage;
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
    public void start(Stage startStage) {
        startStage.setTitle("Welcome to Metro");

        Scene sceneStart = new Scene(rootStart, GAME_WIDTH, GAME_HEIGHT);
        sceneStart.setFill(Color.rgb(109, 95, 87));
        makeStartControls();
        addVariants();
        rootStart.getChildren().add(controlsStart);
        Image startSceneBackground = new Image(this.getClass().getResource("assets/StartSceneBackground.jpg").toString());
        sceneStart.setFill(new ImagePattern(startSceneBackground));

        startStage.setScene(sceneStart);
        sceneStart.getStylesheets().addAll(this.getClass().getResource("styleGame.css").toExternalForm());
        startStage.show();
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


}
