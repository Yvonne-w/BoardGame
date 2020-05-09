package comp1110.ass2.gui;

import comp1110.ass2.Tile;
import comp1110.ass2.TileType;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import static comp1110.ass2.gui.Game.SQUARE_SIZE;

public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        primaryStage.setTitle("Test");
        Scene scene = new Scene(root, 1024, 768);
        //scene.setFill(Color.rgb(109, 95, 87));

        /*
        Tile tile = new Tile(TileType.aaaa, 32);
        tile.setLayoutX(50);
        tile.setLayoutY(60);
        root.getChildren().add(tile);
        tile.toFront();
         */

        ImageView playerHand = new ImageView();
        playerHand.setFitWidth(SQUARE_SIZE);
        playerHand.setFitHeight(SQUARE_SIZE);
        playerHand.setImage(new Image(this.getClass().getResource("assets/aaaa.jpg").toString()));
        root.getChildren().add(playerHand);

        primaryStage.setScene(scene);
        scene.getStylesheets().addAll(this.getClass().getResource("styleGame.css").toExternalForm());
        primaryStage.show();

    }
}
