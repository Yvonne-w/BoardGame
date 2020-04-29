# New Code for Deliverable D2D

## < u7020050 > < Yiwei Wu >

For Deliverable D2D, I contributed the following new statements of original code:

- The entire Game Class in GUI.
-1. public class Game extends Application {
 2.     //unfinished Task 8
 3.     private static final int GAME_WIDTH = 1024;
 4.     private static final int GAME_HEIGHT = 768;
 5.     private static final int SQUARE_SIZE = 64;
 6.     private static final int BOARD_MARGIN = 50;
 7.     private static final int VBOX_WIDTH = 234;
 8.     private static final int VBOX_HEIGHT = 512;
 9.     private static final double PLAYER_WIDTH = VBOX_WIDTH / 2;
 10.    private static final double PLAYER_HEIGHT = VBOX_HEIGHT / 3;
 11.    private static final String URI_BASE = "assets/";
 12. 
 13.     private final Group root = new Group();
 14.     private final GridPane board = new GridPane();
 15.     private Text mark1 = new Text();
 16.     private Text mark2 = new Text();
 17.     private Text mark3 = new Text();
 18.     private Text mark4 = new Text();
 19.     private Text mark5 = new Text();
 20.     private Text mark6 = new Text();
 21. 
 22. 
 23.     private void makeBoard() {
 24.         //board
 25.         board.setLayoutX(BOARD_MARGIN);
 26.         board.setLayoutY(BOARD_MARGIN);
 27.         board.getChildren().clear();
 28. 
 29.         for (int i = 1; i <= 8; i++) {
 30.             ImageView station = new ImageView();
 31.             String stationLoc = URI_BASE + "station" + i + ".jpg";
 32.             station.setFitWidth(SQUARE_SIZE);
 33.             station.setFitHeight(SQUARE_SIZE);
 34.             station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
 35.             board.add(station, 9 - i, 0);
 36.         }
 37. 
 38.         for (int i = 9; i <= 16; i++) {
 39.             ImageView station = new ImageView();
 40.             String stationLoc = URI_BASE + "station" + i + ".jpg";
 41.             station.setFitWidth(SQUARE_SIZE);
 42.             station.setFitHeight(SQUARE_SIZE);
 43.             station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
 44.             board.add(station, 0, i - 8);
 45.         }
 46. 
 47.         for (int i = 17; i <= 24; i++) {
 48.             ImageView station = new ImageView();
 49.             String stationLoc = URI_BASE + "station" + i + ".jpg";
 50.             station.setFitWidth(SQUARE_SIZE);
 51.             station.setFitHeight(SQUARE_SIZE);
 52.             station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
 53.             board.add(station, i - 16, 9);
 54.         }
 55. 
 56.         for (int i = 25; i <= 32; i++) {
 57.             ImageView station = new ImageView();
 58.             String stationLoc = URI_BASE + "station" + i + ".jpg";
 59.             station.setFitWidth(SQUARE_SIZE);
 60.             station.setFitHeight(SQUARE_SIZE);
 61.             station.setImage(new Image(this.getClass().getResource(stationLoc).toString()));
 62.             board.add(station, 9, 33 - i);
 63.         }
 64. 
 65.         //corner
 66.         ImageView corner = new ImageView();
 67.         corner.setFitWidth(SQUARE_SIZE);
 68.         corner.setFitHeight(SQUARE_SIZE);
 69.         corner.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
 70.         board.add(corner, 0, 0);
 71. 
 72.         ImageView corner1 = new ImageView();
 73.         corner1.setFitWidth(SQUARE_SIZE);
 74.         corner1.setFitHeight(SQUARE_SIZE);
 75.         corner1.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
 76.         board.add(corner1, 0, 9);
 77. 
 78.         ImageView corner2 = new ImageView();
 79.         corner2.setFitWidth(SQUARE_SIZE);
 80.         corner2.setFitHeight(SQUARE_SIZE);
 81.         corner2.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
 82.         board.add(corner2, 9, 0);
 83. 
 84.         ImageView corner3 = new ImageView();
 85.         corner3.setFitWidth(SQUARE_SIZE);
 86.         corner3.setFitHeight(SQUARE_SIZE);
 87.         corner3.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
 88.         board.add(corner3, 9, 9);
 89. 
 90.         root.getChildren().add(board);
 91.     }
 92. 
 93.     private void setBoardBackground() {
 94.         StackPane boardBackgroundStack = new StackPane();
 95.         boardBackgroundStack.setLayoutX(BOARD_MARGIN + SQUARE_SIZE);
 96.         boardBackgroundStack.setLayoutY(BOARD_MARGIN + SQUARE_SIZE);
 97. 
 98.         ImageView boardBackground = new ImageView();
 99.         boardBackground.setFitWidth(SQUARE_SIZE * 8);
 100.         boardBackground.setFitHeight(SQUARE_SIZE * 8);
 101.         boardBackground.setImage(new Image(this.getClass().getResource("assets/board_withoutEdges.png").toString()));
 102. 
 103.         boardBackgroundStack.getChildren().add(boardBackground);
 104.         root.getChildren().add(boardBackgroundStack);
 105.     }
 106. 
 107.     private void setVBoxLeft() {
 108.         VBox vLeft = new VBox();
 109.         vLeft.setLayoutX(BOARD_MARGIN + SQUARE_SIZE * 10 + BOARD_MARGIN);
 110.         vLeft.setLayoutY(BOARD_MARGIN);
 111. 
 112.         ImageView player1 = new ImageView();
 113.         player1.setFitWidth(PLAYER_WIDTH);
 114.         player1.setFitHeight(PLAYER_HEIGHT);
 115.         player1.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
 116.         vLeft.getChildren().add(player1);
 117. 
 118.         mark1.setTextAlignment(TextAlignment.LEFT);
 119.         mark1.setText("Mark for Player 1");
 120.         vLeft.getChildren().add(mark1);
 121. 
 122.         ImageView player3 = new ImageView();
 123.         player3.setFitWidth(PLAYER_WIDTH);
 124.         player3.setFitHeight(PLAYER_HEIGHT);
 125.         player3.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
 126.         vLeft.getChildren().add(player3);
 127. 
 128.         mark3.setTextAlignment(TextAlignment.LEFT);
 129.         mark3.setText("Mark for Player 3");
 130.         vLeft.getChildren().add(mark3);
 131. 
 132.         ImageView player5 = new ImageView();
 133.         player5.setFitWidth(PLAYER_WIDTH);
 134.         player5.setFitHeight(PLAYER_HEIGHT);
 135.         player5.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
 136.         vLeft.getChildren().add(player5);
 137. 
 138.         mark5.setTextAlignment(TextAlignment.LEFT);
 139.         mark5.setText("Mark for Player 5");
 140.         vLeft.getChildren().add(mark5);
 141. 
 142.         root.getChildren().add(vLeft);
 143.     }
 144. 
 145.     private void setVBoxRight() {
 146.         VBox vRight = new VBox();
 147.         vRight.setLayoutX(BOARD_MARGIN + SQUARE_SIZE * 10 + BOARD_MARGIN + PLAYER_WIDTH);
 148.         vRight.setLayoutY(BOARD_MARGIN);
 149. 
 150.         ImageView player2 = new ImageView();
 151.         player2.setFitWidth(PLAYER_WIDTH);
 152.         player2.setFitHeight(PLAYER_HEIGHT);
 153.         player2.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
 154.         vRight.getChildren().add(player2);
 155. 
 156.         mark2.setTextAlignment(TextAlignment.RIGHT);
 157.         mark2.setText("Mark for Player 2");
 158.         vRight.getChildren().add(mark2);
 159. 
 160.         ImageView player4 = new ImageView();
 161.         player4.setFitWidth(PLAYER_WIDTH);
 162.         player4.setFitHeight(PLAYER_HEIGHT);
 163.         player4.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
 164.         vRight.getChildren().add(player4);
 165. 
 166.         mark4.setTextAlignment(TextAlignment.RIGHT);
 167.         mark4.setText("Mark for Player 4");
 168.         vRight.getChildren().add(mark4);
 169. 
 170.         ImageView player6 = new ImageView();
 171.         player6.setFitWidth(PLAYER_WIDTH);
 172.         player6.setFitHeight(PLAYER_HEIGHT);
 173.         player6.setImage(new Image(this.getClass().getResource("assets/tile_back_cover.jpg").toString()));
 174.         vRight.getChildren().add(player6);
 175. 
 176.         mark6.setTextAlignment(TextAlignment.RIGHT);
 177.         mark6.setText("Mark for Player 6");
 178.         vRight.getChildren().add(mark6);
 179. 
 180.         root.getChildren().add(vRight);
 181.     }
 182. 
 183.     private void sethBOX() {
 184.         HBox hHandDock = new HBox();
 185.         hHandDock.setLayoutX(GAME_WIDTH - BOARD_MARGIN - VBOX_WIDTH);
 186.         hHandDock.setLayoutY(GAME_HEIGHT - BOARD_MARGIN - SQUARE_SIZE);
 187. 
 188.         Text tHand = new Text();
 189.         tHand.setText("Hand");
 190.         hHandDock.getChildren().add(tHand);
 191. 
 192.         ImageView playerHand = new ImageView();
 193.         playerHand.setFitWidth(SQUARE_SIZE);
 194.         playerHand.setFitHeight(SQUARE_SIZE);
 195.         playerHand.setImage(new Image(this.getClass().getResource("assets/aaaa.jpg").toString()));
 196.         hHandDock.getChildren().add(playerHand);
 197. 
 198.         Text tDock = new Text();
 199.         tDock.setText("    Dock");
 200.         hHandDock.getChildren().add(tDock);
 201. 
 202.         ImageView dockTile = new ImageView();
 203.         dockTile.setFitWidth(SQUARE_SIZE);
 204.         dockTile.setFitHeight(SQUARE_SIZE);
 205.         dockTile.setImage(new Image(this.getClass().getResource("assets/bcbc.jpg").toString()));
 206.         hHandDock.getChildren().add(dockTile);
 207. 
 208.         root.getChildren().add(hHandDock);
 209. 
 210.     }
 211. 
 212.     @Override
 213.     public void start(Stage primaryStage) throws Exception {
 214.         primaryStage.setTitle("Metro Game");
 215.         Scene scene = new Scene(root, GAME_WIDTH, GAME_HEIGHT);
 216.         makeBoard();
 217.         setBoardBackground();
 218.         setVBoxLeft();
 219.         setVBoxRight();
 220.         sethBOX();
 221.         primaryStage.setScene(scene);
 222.         primaryStage.show();
 223.     }
 224. 
 225.     public static void main(String[] args) {
 226.         launch(args);
 227.     }
 228. }
 229. 


(List at least 10, and include line numbers.)
