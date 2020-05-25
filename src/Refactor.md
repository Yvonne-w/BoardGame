#Refactored Archieve
All these are working code and have passed tests.

#Birdy Shang
Metro.java

    public static boolean isPlacementSequenceValid(String placementSequence) { /*
        if (placementSequence.length() == 0)
            return true;

        if (placementSequence.length() % TITLE_SIZE == 0) {
            if (!ValidCheck.isPlacementOverlap(placementSequence) || !ValidCheck.canPlaceCentralStations(placementSequence)|| !ValidCheck.isConnectRestBoard(placementSequence)
                    || !ValidCheck.canPlaceEdge(placementSequence) || !ValidCheck.canPlaceCorner(placementSequence)){
                return false;
            }
            return true;
        }else {
            return false;
        }

     }
     
ValidCheck.java

    package comp1110.ass2;
    
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.LinkedList;
    import java.util.List;

    public class ValidCheck {

    private static final ArrayList<String> CENTRAL_LIST = new ArrayList<String>(
            Arrays.asList("34","43","33","44"));

    private static final ArrayList<String> LEFT_LIST = new ArrayList<String>(
            Arrays.asList("accd","adad","bbad","bcdd","dbcd","dddd"));

    private static final ArrayList<String> RIGHT_LIST = new ArrayList<String>(
            Arrays.asList("adbb","adad","cdac","cddb","ddbc","dddd"));

    private static final ArrayList<String> BOTTOM_LIST = new ArrayList<String>(
            Arrays.asList("badb","bcdd","ccda","cddb","dada","dddd"));

    private static final ArrayList<String> TOP_LIST = new ArrayList<String>(
            Arrays.asList("dacc","dada","dbba","ddbc","dbcd","dddd"));

    private static final ArrayList<String> LEFT_TOP_LIST = new ArrayList<String>(
            Arrays.asList("cbaa","cbcb","cccc","ccda","cdac","cddb"));

    private static final ArrayList<String> LEFT_BOTTOM_LIST = new ArrayList<String>(
            Arrays.asList("baac","bcbc","cccc","cdac","dacc","ddbc"));

    private static final ArrayList<String> RIGHT_TOP_LIST = new ArrayList<String>(
            Arrays.asList("acba","accd","bcdd","cccc","ccda","bcbc"));

    private static final ArrayList<String> RIGHT_BOTTOM_LIST = new ArrayList<String>(
            Arrays.asList("aacb","accd","cbcb","cccc","dacc","dbcd"));

    private static final ArrayList<String> CENTRAL_COORDINATE_LIST = new ArrayList<String>(
            Arrays.asList("32","42","23","24","35","45","53","54"));


    public static boolean isPlacementOverlap(String placementSequence){
        List<String> coordinateList = new ArrayList();
        for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
            String coordinate = currentTile.substring(4);
            if (CENTRAL_LIST.contains(coordinate) || coordinateList.contains(coordinate)){
                return false;
            }else {
                coordinateList.add(coordinate);
            }

        }
        return true;
    }


    public static boolean isConnectRestBoard(String placementSequence){
        LinkedList<String> coordinateList = new LinkedList<>();
        for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
            String coordinate = currentTile.substring(4);
            coordinateList.add(coordinate);
        }
        String coordinateFirst =  coordinateList.get(0);
        if (!coordinateFirst.contains("0") && !coordinateFirst.contains("7")){
            return false;
        }

        ArrayList<String> alreadyList = new ArrayList<>();
        for (String coordinate : coordinateList){
            if (coordinate.contains("0")|| coordinate.contains("7")){
                alreadyList.add(coordinate);
                continue;
            }
            Integer coordinateIn = Integer.valueOf(coordinate);
            String coordinateTop = String.valueOf(coordinateIn-10).length() == 2 ? String.valueOf(coordinateIn-10) : "0"+String.valueOf(coordinateIn-10);
            String coordinateLeft = String.valueOf(coordinateIn-1).length() == 2 ? String.valueOf(coordinateIn-1) : "0"+String.valueOf(coordinateIn-1);
            String coordinateRight = String.valueOf(coordinateIn+1).length() == 2 ? String.valueOf(coordinateIn+1) : "0"+String.valueOf(coordinateIn+1).length();
            String coordinateBottom = String.valueOf(coordinateIn+10);
            if((!coordinate.contains("0")&& !coordinate.contains("7")&&(!alreadyList.contains(coordinateTop) && !alreadyList.contains(coordinateLeft)
                    && !alreadyList.contains(coordinateRight) && !alreadyList.contains(coordinateBottom)))){
                return false;
            }
            alreadyList.add(coordinate);
        }
        return true;
    }


    public static boolean canPlaceCentralStations(String placementSequence){
        ArrayList<String> coordinateList = new ArrayList<>();
        for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
            String coordinate = currentTile.substring(4);
            if ("32".equals(coordinate) && (!coordinateList.contains("22") && !coordinateList.contains("31") && !coordinateList.contains("42"))){
                return false;
            }else if ("42".equals(coordinate) && (!coordinateList.contains("41") && !coordinateList.contains("52") && !coordinateList.contains("32"))){
                return false;
            }else if ("23".equals(coordinate) && (!coordinateList.contains("22") && !coordinateList.contains("13") && !coordinateList.contains("24"))){
                return false;
            }else if ("24".equals(coordinate) && (!coordinateList.contains("25") && !coordinateList.contains("14") && !coordinateList.contains("23"))){
                return false;
            }else if ("35".equals(coordinate) && (!coordinateList.contains("25") && !coordinateList.contains("36") && !coordinateList.contains("45"))){
                return false;
            }else if ("45".equals(coordinate) && (!coordinateList.contains("55") && !coordinateList.contains("46") && !coordinateList.contains("35"))){
                return false;
            }else if ("53".equals(coordinate) && (!coordinateList.contains("52") && !coordinateList.contains("63") && !coordinateList.contains("54"))){
                return false;
            }else if ("54".equals(coordinate) && (!coordinateList.contains("55") && !coordinateList.contains("64") && !coordinateList.contains("53"))){
                return false;
            }else {
                coordinateList.add(coordinate);
            }

        }
        return true;

    }

    public static boolean canPlaceEdge(String placementSequence){
        if (placementSequence.startsWith("dddd")){
            return true;
        }
        for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
            String title = currentTile.substring(0,4);
            String coordinate = currentTile.substring(4);
            if (coordinate.endsWith("0") && LEFT_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile) && AfterTitleValid(title,placementSequence.substring(i))){
                return false;
            }

            if (coordinate.endsWith("7") && RIGHT_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile) && AfterTitleValid(title,placementSequence.substring(i))){
                return false;
            }
            if (coordinate.startsWith("7") && BOTTOM_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile) && AfterTitleValid(title,placementSequence.substring(i))){
                return false;
            }
            if (coordinate.startsWith("0") && TOP_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile) && AfterTitleValid(title,placementSequence.substring(i))){
                return false;
            }

        }
        return true;

    }

    public static boolean canPlaceCorner(String placementSequence){
        if (placementSequence.startsWith("dddd")){
            return true;
        }
        for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
            String title = currentTile.substring(0,4);
            String coordinate = currentTile.substring(4);

            if (("00").equals(coordinate) && LEFT_TOP_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile) && AfterTitleCornerValid(title,placementSequence.substring(i))){
                return false;
            }

            if (("70").equals(coordinate) && LEFT_BOTTOM_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile) ){
                return false;
            }
            if (("07").equals(coordinate) && RIGHT_TOP_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile)){
                return false;
            }
            if (("77").equals(coordinate) && RIGHT_BOTTOM_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile)){
                return false;
            }
        }
        return true;
    }


    private static boolean AfterTitleValid(String titleEx,String subTitle){
        int sum = 0;
        for (int i = 0; i < subTitle.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (subTitle.substring(i, i + Metro.TITLE_SIZE));
            String coordinate = currentTile.substring(4);
            if (coordinate.endsWith("0") && LEFT_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }else if (coordinate.endsWith("7") && RIGHT_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }else if (coordinate.startsWith("7") && BOTTOM_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }else if (coordinate.startsWith("0") && TOP_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }
        }
        return sum != subTitle.length();
    }


    private static boolean AfterTitleCornerValid(String titleEx,String subTitle){
        int sum = 0;
        for (int i = 0; i < subTitle.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (subTitle.substring(i, i + Metro.TITLE_SIZE));
            String coordinate = currentTile.substring(4);
            if (("00").equals(coordinate) && LEFT_TOP_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }else if (("70").equals(coordinate) && LEFT_BOTTOM_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }else if(("07").equals(coordinate) && RIGHT_TOP_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }else if(("77").equals(coordinate) && RIGHT_BOTTOM_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }

        }
        return sum != subTitle.length();

    }




    private static boolean checkTitleHasSpace(String placementSequence,String currentTile){
        if (placementSequence.length() != 360 || !placementSequence.endsWith(currentTile)){
            return true;
        }else{
            return false;
        }

     }
    }

#Yiwei Wu 
Game.java

    private static final int VBOX_HEIGHT = 512;
    public int numPlayers1;
    public String playerInput1;
    private ArrayList<ImageView> playerStillList;
    public ArrayList<String> humanPlayerList = new ArrayList<>();
    private Text mark1 = new Text();
    private Text mark2 = new Text();
    private Text mark3 = new Text();
    private Text mark4 = new Text();
    private Text mark5 = new Text();
    private Text mark6 = new Text();
    private TextField textField;
    private static final double PLAYER_HEIGHT = (double) VBOX_HEIGHT / 3;


    from start{
     makeControls();
     makeTileControl();
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

        /*
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
         */

        root.getChildren().add(vRight);
    }
    
 PathList.java
 
     public static ArrayList<ArrayList<Integer>> getplayerstationByNum(int numberOfPlayers) {
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
         System.out.println(numberOfPlayers);
         System.out.println(playerstation);
         return playerstation;
     }
  
    

