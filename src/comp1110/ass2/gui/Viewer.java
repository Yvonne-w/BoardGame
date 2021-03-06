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
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * A very simple viewer for piece placements in the Metro game.
 * <p>
 * NOTE: This class is separate from your main game class.  This
 * class does not play a game, it just illustrates various piece
 * placements.
 */
public class Viewer extends Application {
    /* board layout */
    private static final int SQUARE_SIZE = 64;
    private static final int VIEWER_WIDTH = 1024;
    private static final int VIEWER_HEIGHT = 768;

    private static final String URI_BASE = "assets/";

    private final Group root = new Group();
    private final Group controls = new Group();
    private TextField textField;

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Draw a placement in the window, removing any previously drawn one
     *
     * @param placement A valid placement string
     * @author: Yiwei
     */
    void makePlacement(String placement) {
        GridPane board = new GridPane();

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

        for (int idx = 0; idx < placement.length(); idx += 6) {
            String tileType = placement.substring(idx, idx + 4);
            int row = Integer.parseInt(placement.substring(idx + 4, idx + 5));
            int column = Integer.parseInt(placement.substring(idx + 5, idx + 6));

            String tileLoc = URI_BASE + tileType + ".jpg";

            ImageView tile = new ImageView();
            tile.setFitWidth(SQUARE_SIZE);
            tile.setFitHeight(SQUARE_SIZE);
            tile.setImage(new Image(this.getClass().getResource(tileLoc).toString()));

            board.add(tile, column + 1, row + 1);
        }

        root.getChildren().add(board);
    }

    /**
     * Create a basic text field for input and a refresh button.
     */
    private void makeControls() {
        Label label1 = new Label("Placement:");
        textField = new TextField("Board appears after correct placement input"); //Yiwei added String Apr 19th
        textField.setPrefWidth(300);

        Button button = new Button("Refresh");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                makePlacement(textField.getText());
                textField.clear();
            }
        });
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, textField, button);
        hb.setSpacing(10);
        hb.setLayoutX(130);
        hb.setLayoutY(VIEWER_HEIGHT - 50);
        controls.getChildren().add(hb);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("FocusGame Viewer");
        Scene scene = new Scene(root, VIEWER_WIDTH, VIEWER_HEIGHT);
        root.getChildren().add(controls);
        makeControls();
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
