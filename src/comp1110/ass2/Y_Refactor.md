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
 
     
 Metro.java
 
        // Old Version 
        /**
         * Task 9
         * Given a placement sequence string, generate a valid next move.
         *
         * @param placementSequence a String representing the sequence of piece placements made so far in the game
         * @param piece             a four-character String representing the tile to be placed
         * @param numberOfPlayers   The number of players in the game
         * @return A valid placement of the given tile
         */
        
        public static String generateMove(String placementSequence, String piece, int numberOfPlayers) {
            //System.out.println(placementSequence);
            String generatedMove = "";
            ArrayList<String> placelistStr = new ArrayList();
            ArrayList<String> possibleLocListStr = new ArrayList<>();
            ArrayList<Integer> placeList = new ArrayList();
    
            if (placementSequence == "") {
                placelistStr = new ArrayList(Arrays.asList("00", "01", "02", "03", "04", "05", "06", "07", "10", "20", "30", "40", "50", "60", "70", "71", "72", "73", "74", "75", "76", "77", "17", "27", "37", "47", "57", "67"));
                int[] tilecode = Tile.encodeTileType(piece);
                //System.out.println(Tile.encodeTileType("cccc")[0]);
                if (tilecode[0] == 3 || tilecode[1] == 3) {
                    placelistStr.remove("00");
                    placelistStr.remove("07");
                    placelistStr.remove("70");
                    placelistStr.remove("77");
                    //System.out.println("placelistStr = " + placelistStr);
                }
    
            } else {
                for (int i = 0; i < 80; i += 10) {
                    for (int j = 0; j < 8; j++) {
                        int placeInt = i + j;
                        placeList.add(placeInt);
                    }
                }
            }
    
            //System.out.println(placeList);
    
            ArrayList<Integer> existList = new ArrayList<>();
            for (int m = 4; m < placementSequence.length(); m += 6) {
                int existPlaceInt = Integer.parseInt(placementSequence.substring(m, m + 2));
                existList.add(existPlaceInt);
            }
    
            //System.out.println(existList);
    
            for (int existPlaceInt : existList) {
                int removeIdx = placeList.indexOf(existPlaceInt);
                placeList.remove(removeIdx);
            }
    
            //System.out.println(placeList);
    
    
            for (int placeInt : placeList) {
                if (placeInt < 8) {
                    String s = "0" + String.valueOf(placeInt);
                    placelistStr.add(s);
                } else {
                    placelistStr.add(String.valueOf(placeInt));
                }
            }
    
            for (String placeStr : placelistStr) {
                //System.out.println(placeStr);
                String tryPlacement = "";
                tryPlacement = placementSequence + piece + placeStr;
                //System.out.println(tryPlacement);
                boolean b = isPlacementSequenceValid(tryPlacement);
                //System.out.println(b);
                if (b) {
                    possibleLocListStr.add(tryPlacement);
                }
    
            }
    
            if (possibleLocListStr.size() != 0) {
                Random r = new Random();
                int randomLoc = r.nextInt(possibleLocListStr.size());
    
                generatedMove = possibleLocListStr.get(randomLoc).substring(placementSequence.length(), placementSequence.length() + 6);
    
                String checkCentral = generatedMove.substring(generatedMove.length() - 2, generatedMove.length());
    
                while (checkCentral.equals("33") || checkCentral.equals("34") || checkCentral.equals("43") || checkCentral.equals("44")) {
                    randomLoc = r.nextInt(possibleLocListStr.size());
    
                    generatedMove = possibleLocListStr.get(randomLoc).substring(placementSequence.length(), placementSequence.length() + 6);
    
                    checkCentral = generatedMove.substring(generatedMove.length() - 2, generatedMove.length());
                }
            }
            return generatedMove;
        }
    
        public static ArrayList<String> convertStationToStartLoc(ArrayList<Integer> stationlist) {
            ArrayList<String> startStationList = new ArrayList<>();
            for (Integer station : stationlist) {
                if (station <= 8) {
                    int startLocInt = 8 - station;
                    startStationList.add("0" + String.valueOf(startLocInt));
                } else if (station <= 16) {
                    int startLocInt = station - 9;
                    startStationList.add(String.valueOf(startLocInt) + "0");
                } else if (station <= 24) {
                    int startLocInt = station + 53;
                    startStationList.add(String.valueOf(startLocInt));
                } else {
                    int startLocInt = 102 - (station - 25) * 9 - station;
                    if (startLocInt < 10) {
                        startStationList.add("0" + String.valueOf(startLocInt));
                    } else {
                        startStationList.add(String.valueOf(startLocInt));
                    }
                }
            }
    
            return startStationList;
        }
        
Unfinished Improvement Trial

    public static ArrayList<String> getPossibleLocation(String placementSequence, String tileType) {
        
        if (placementSequence == "") {
            ArrayList<String> possibleList = new ArrayList<>(Arrays.asList(
                    "00", "01", "02", "03", "04", "05", "06", "07",
                    "10", "17",
                    "20", "27",
                    "30", "37",
                    "40", "47",
                    "50", "57",
                    "60", "67",
                    "70", "71", "72", "73", "74", "75", "76", "77"));
            if (piece == "dddd") {
                return possibleList;
            }

            int[] tilecode = Tile.encodeTileType(piece);
            if (tilecode[0] == 4) {
                possibleList.removeAll(Arrays.asList("00", "01", "02", "03", "04", "05", "06", "07"));
            }
            if (tilecode[2] == 4) {
                possibleList.removeAll(Arrays.asList("17", "27", "37", "47", "57", "67", "77", "07"));
            }
            if (tilecode[4] == 4) {
                possibleList.removeAll(Arrays.asList("70", "71", "72", "73", "74", "75", "76", "77"));
            }
            if (tilecode[6] == 4) {
                possibleList.removeAll(Arrays.asList("10", "20", "30", "40", "50", "60", "70", "00"));
            }
            return possibleList;
        }

        ArrayList<String> placementList = new ArrayList<>(Arrays.asList(
                "00", "01", "02", "03", "04", "05", "06", "07",
                "10", "11", "12", "13", "14", "15", "16", "17",
                "20", "21", "22", "23", "24", "25", "26", "27",
                "30", "31", "32", "35", "36", "37",
                "40", "41", "42", "45", "46", "47",
                "50", "51", "52", "53", "54", "55", "56", "57",
                "60", "61", "62", "63", "64", "65", "66", "67",
                "70", "71", "72", "73", "74", "75", "76", "77"));

        for (int j = 0; j < placementSequence.length(); j += 6) {
            String exist = placementSequence.substring(j + 4, j + 6);
            placementList.remove(exist);
        }

        if (placementSequence.length() < 354) {
            int[] tilecode = Tile.encodeTileType(piece);
            if (tilecode[0] == 3) {
                placementList.remove("00");
            }
            if (tilecode[2] == 3) {
                placementList.remove("07");
            }
            if (tilecode[3] == 3) {
                placementList.remove("77");
            }
            if (tilecode[6] == 3) {
                placementList.remove("70");
            }
        }


        ArrayList<String> possibleList = new ArrayList<>();
        for (int i = 0; i < placementList.size(); i++) {
            String newPlacementSequence = placementSequence + piece + placementList.get(i);
            if (isPlacementSequenceValid(newPlacementSequence)) {
                String newPlacement = piece + placementList.get(i);
                possibleList.add(newPlacement);
            }
        }


        return possibleList;
        }
        
Advanced AI

    String getAdvancedTilePlacement(ArrayList<Double> markList, ArrayList<Integer> aiSTationList, String tiletypeAi) {
        String placementSequence = getPlacementSequence();

        HashMap<Integer, String> tileList = new HashMap<>();
        for (int j = 0; j < placementSequence.length(); j += 6) {
            //Hashmap for the placement, position as Key
            String tile = placementSequence.substring(j, j + 4);
            String position = placementSequence.substring(j + 4, j + 6);
            int positionInt = Integer.parseInt(position);
            tileList.put(positionInt, tile);
            //System.out.println(positionInt + " " + tile);
        }

        ArrayList<Integer> possibleListInt = new ArrayList<>();
        ArrayList<String> possibleListStr = Metro.getPossibleListNew(placementSequence, tiletypeAi);
        for (String s : possibleListStr) {
            int n = Integer.parseInt(s.substring(s.length()-2));
            possibleListInt.add(n);
        }


        String advanced = "";
        ArrayList<Double> aiMarkList = new ArrayList<>();
        HashMap<Double, LinkedList<Integer>> markStationMap = new HashMap<>();

        for (int i : aiSTationList) {
            aiMarkList.add(markList.get(i - 1));
            //stationMarkMap.put(i, markList.get(i - 1));
            if (markStationMap.containsKey(markList.get(i - 1))) {
                markStationMap.get(markList.get(i - 1)).add(i);
            } else {
                markStationMap.put(markList.get(i - 1), new LinkedList<>());
                markStationMap.get(markList.get(i - 1)).addFirst(i);
            }
        }
        //System.out.println(aiMarkList);
        System.out.println("HashMap " + markStationMap);

        LinkedList<Integer> maxList = getStationWithMaxMark(markStationMap);
        System.out.println("maxList" + maxList);

        int advancedInt = -1;
        for (int j = 0; j < maxList.size(); j++) {
            advancedInt = 0;
            int startStation = maxList.get(j);
            LinkedList<Integer> path = PathList.getPathList(getPlacementSequence()).get(startStation - 1);
            int endPoint = path.get(path.size() - 1);
            System.out.println("endPoint " + endPoint);
            if (path.size() == 1) {
                advancedInt = convertStartStationToLoc(endPoint);
            } else {
                int startPlace = convertStartStationToLoc(startStation);
                String startType = tileList.get(startPlace);
                LinkedList<Integer> path1 = PathList.getPathList(getPlacementSequence()).get(startStation - 1);
                advancedInt = getNextPosition(startType, startPlace, path1);
                if (!possibleListInt.contains(advancedInt)) {
                    markStationMap.remove(maxList);
                    maxList = getStationWithMaxMark(markStationMap);
                }
            }
            System.out.println("advancedInt " + advancedInt);
        }

        if (advancedInt < 10) {
            advanced = "0" + String.valueOf(advancedInt);
        } else {
            advanced = String.valueOf(advancedInt);
        }
        System.out.println("advanced" + advanced);

        return advanced;
    }
    
Advanced AI Trial 2

    String getAdvancedTilePlacement(String tiletypeAi) {
        String advanced = "";

        String placementSequence = getPlacementSequence();
        HashMap<Integer, String> tileList = new HashMap<>();
        for (int j = 0; j < placementSequence.length(); j += 6) {
            //Hashmap for the placement, position as Key
            String tile = placementSequence.substring(j, j + 4);
            String position = placementSequence.substring(j + 4, j + 6);
            int positionInt = Integer.parseInt(position);
            tileList.put(positionInt, tile);
            //System.out.println(positionInt + " " + tile);
        }

        ArrayList<Integer> possibleListInt = new ArrayList<>();
        ArrayList<String> possibleListStr = Metro.getPossibleListNew(placementSequence, tiletypeAi);
        for (String s : possibleListStr) {
            int n = Integer.parseInt(s.substring(s.length() - 2));
            possibleListInt.add(n);
        }
        System.out.println("possibleListInt " + possibleListInt);


        ArrayList<LinkedList<Integer>> pathList = PathList.getPathList(placementSequence);
        ArrayList<PathState> pathStatusList = AdvancedAI.getPathStatusList(pathList);
        ArrayList<Double> markListNew = AdvancedAI.getPathMarkList(pathList, pathStatusList);

        ArrayList<Integer> aiStationList = getAIPathStationList();

        HashMap<Double, LinkedList<Integer>> markStationMap = new HashMap<>();
        for (int i : aiStationList) {
            if (markStationMap.containsKey(markListNew.get(i - 1))) {
                markStationMap.get(markListNew.get(i - 1)).add(i);
            } else {
                markStationMap.put(markListNew.get(i - 1), new LinkedList<>());
                markStationMap.get(markListNew.get(i - 1)).addFirst(i);
            }
        }
        //System.out.println(aiMarkList);
        System.out.println("HashMap " + markStationMap);

        LinkedList<Integer> maxStationList = getStationWithMaxMark(markStationMap);
        System.out.println("maxStationList " + maxStationList);


        while (advanced == "") {
            for (int j = 0; j < maxStationList.size(); j++) {
                int station = maxStationList.get(j);
                int place = convertStartStationToLoc(station);
                if (possibleListInt.contains(place)) {
                    advanced = String.valueOf(place);
                    System.out.println("advanced" + advanced);
                    return advanced;
                }
            }

            double max = getHightestMark(markStationMap);
            markStationMap.remove(max);
            maxStationList = getStationWithMaxMark(markStationMap);

            for (int m = 0; m < maxStationList.size(); m++) {

                int station = maxStationList.get(m);
                int place = convertStartStationToLoc(station);
                String startType = tileList.get(place);
                LinkedList<Integer> path1 = pathList.get(station - 1);

                int advancedInt = getNextPosition(startType, place, path1);

                if (possibleListInt.contains(advancedInt)) {
                    advanced = String.valueOf(advancedInt);
                    System.out.println("advanced" + advanced);
                    return advanced;
                }
            }

            max = getHightestMark(markStationMap);
            markStationMap.remove(max);
            maxStationList = getStationWithMaxMark(markStationMap);

        }


        return advanced;
    }
    
AI help method 1
    
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

AI help method 2

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
    
AI help method 3

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
    
Task 9 help method

    public static boolean isTileConnected(HashMap<String, String> tileList, String position, int direction) {
        int positionInt = Integer.parseInt(position);
        int checkLoc = positionInt + direction;
        return tileList.containsKey(String.valueOf(checkLoc));
    }
    
PathList help method

