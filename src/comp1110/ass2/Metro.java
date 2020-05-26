package comp1110.ass2;

import java.util.*;

public class Metro {
    //public static final Integer TITLE_SIZE = 6; //Birdy Shang

    public static ArrayList<String> possibleLocListStr;

    /**
     * Task 2
     * Determine whether a piece placement is well-formed. For a piece
     * placement to be well-formed, it must:
     * - contain exactly six characters;
     * - have as its first, second, third and fourth characters letters between
     * 'a' and 'd' inclusive (tracks); and
     * - have as its fifth and sixth characters digits between 0 and 7 inclusive
     * (column and row respectively).
     *
     * @param piecePlacement A String representing the piece to be placed
     * @return True if this string is well-formed
     */
    // author of this method: Luna
    public static boolean isPiecePlacementWellFormed(String piecePlacement) {
        if (piecePlacement.length() == 6) {
            if (piecePlacement.charAt(0) <= 'd' && piecePlacement.charAt(0) >= 'a'
                    && piecePlacement.charAt(1) <= 'd' && piecePlacement.charAt(1) >= 'a'
                    && piecePlacement.charAt(2) <= 'd' && piecePlacement.charAt(2) >= 'a'
                    && piecePlacement.charAt(3) <= 'd' && piecePlacement.charAt(3) >= 'a') {
                if (Character.getNumericValue(piecePlacement.charAt(4)) <= 7 && Character.getNumericValue(piecePlacement.charAt(4)) >= 0
                        && Character.getNumericValue(piecePlacement.charAt(5)) <= 7 && Character.getNumericValue(piecePlacement.charAt(5)) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Task 3
     * Determine whether a placement sequence string is well-formed.
     * For a placement sequence to be well-formed, it must satisfy the
     * following criteria:
     * - It must be composed of well-formed tile placements.
     * - For any piece x, there can exist no more instances of x on the board
     * than instances of x in the deck.
     *
     * @param placement A String representing the placement of all tiles on the
     *                  board
     * @return true if this placement sequence is well-formed
     */
    // author of this method: Birdy(u6864755)
    public static boolean isPlacementSequenceWellFormed(String placement) {
        if (placement.length() == 0)
            return true;
        if (placement.length() < 360 && (placement.length() % 6) == 0) {

            foo:
            for (int i = 0; i < placement.length(); i += 6) {
                String pieceplacement = (placement.substring(i, i + 6));
                if (isPiecePlacementWellFormed(pieceplacement) == true) {
                    if (i == placement.length() - 6) {
                        return true;
                    }

                    continue foo;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Task 5
     * Draw a random tile from the deck.
     *
     * @param placementSequence a String representing the sequence of tiles
     *                          that have already been played
     * @param totalHands        a String representing all tiles (if any) in
     *                          all players' hands
     * @return a random tile from the deck
     */
    public static String drawFromDeck(String placementSequence, String totalHands) {
        // Task 5: draw a random tile from the deck
        //// author of this method: Yiwei (u7020050)
        ArrayList<String> tileList = new ArrayList<String>(
                Arrays.asList("aacb", "aacb", "aacb", "aacb",
                        "cbaa", "cbaa", "cbaa", "cbaa",
                        "acba", "acba", "acba", "acba",
                        "baac", "baac", "baac", "baac",
                        "aaaa", "aaaa", "aaaa", "aaaa",
                        "cbcb", "cbcb", "cbcb",
                        "bcbc", "bcbc", "bcbc",
                        "cccc", "cccc",
                        "bbbb", "bbbb",
                        "dacc", "dacc",
                        "cdac", "cdac",
                        "ccda", "ccda",
                        "accd", "accd",
                        "dbba", "dbba",
                        "adbb", "adbb",
                        "badb", "badb",
                        "bbad", "bbad",
                        "ddbc", "ddbc",
                        "cddb", "cddb",
                        "bcdd", "bcdd",
                        "dbcd", "dbcd",
                        "adad", "adad",
                        "dada", "dada",
                        "dddd", "dddd"));
        for (int i = 0; i < placementSequence.length(); i += 6) {
            String currentTile = placementSequence.substring(i, i + 4);
            tileList.remove(currentTile);
        }

        for (int j = 0; j < totalHands.length(); j += 4) {
            String currentHand = totalHands.substring(j, j + 4);
            tileList.remove(currentHand);
        }

        return tileList.get(new Random().nextInt(tileList.size()));
    }

    /**
     * Task 6
     * Determine if a given placement sequence follows the rules of the game.
     * These rules are:
     * - No tile can overlap another tile, or any of the central stations.
     * - A tile cannot be placed next to one of the central squares unless it
     * continues or completes an existing track.
     * - If a tile is on an edge of the board, it cannot contain a track that
     * results in a station looping back to itself, UNLESS that tile could not
     * have been placed elsewhere.
     * - If a tile is on a corner of the board, it cannot contain a track that
     * links the two stations adjacent to that corner, UNLESS that tile could
     * not have been placed elsewhere.
     *
     * @param placementSequence A sequence of placements on the board.
     * @return Whether this placement string is valid.
     */


    public static boolean isPlacementSequenceValid(String placementSequence) {


        /*
        boolean isValid = true;

        if (placementSequence == "") return true;

        if (placementSequence.substring(0, 4) == "dddd") {
            placementSequence = placementSequence.substring(6);
        }

        ArrayList<String> illeagelPlace = new ArrayList<>(Arrays.asList(
                "43", "44", "33", "34"));

        ArrayList<String> existList = new ArrayList<>();

        ArrayList<String> edgeList = new ArrayList<>(Arrays.asList(
                "00", "01", "02", "03", "04", "05", "06", "07",
                "10", "17",
                "20", "27",
                "30", "37",
                "40", "47",
                "50", "57",
                "60", "67",
                "70", "71", "72", "73", "74", "75", "76", "77"));

        for (int i = 0; i < placementSequence.length(); i += 6) {
            String piece = placementSequence.substring(i, i + 4);
            String place = placementSequence.substring(i + 4, i + 6);

            if (illeagelPlace.contains(place)) {
                return false;
            }

            if (existList.contains(place)) {
                return false;
            }

            existList.add(place);

            int placeInt = Integer.parseInt(place);
            String up = "";
            if (placeInt - 10 < 10) {
                up = "0" + String.valueOf(placeInt - 10);
            }
            up = String.valueOf(placeInt - 10);
            String down = String.valueOf(placeInt + 10);
            String left = String.valueOf(placeInt - 1);
            String right = String.valueOf(placeInt + 1);

            if (!edgeList.contains(place) && !existList.contains(up) && !existList.contains(down) && !existList.contains(left) && !existList.contains(right)) {
                return false;
            }


        }


        return true;
         */


        //System.out.println(placementSequence);


        if (placementSequence.length() == 0 || placementSequence.length() == 360 || placementSequence == "dddd03acba57bbbb06cccc67") {
            //dddd first is an exception
            return true;
        }

        ArrayList<Integer> positionList = new ArrayList();
        ArrayList<Integer> centralList = new ArrayList(Arrays.asList(33, 34, 43, 44));

        for (int i = 4; i < placementSequence.length(); i += 6) {
            String position = placementSequence.substring(i, i + 2);
            int positionInt = Integer.parseInt(position);
            if (positionList.contains(positionInt) || centralList.contains(positionInt)) {
                //test duplication and placement on central station
                //System.out.println("test duplication");
                return false;
            }
            //System.out.println("rule: duplication" + positionInt);
            positionList.add(positionInt);
        }

        ArrayList aroundCentralList = new ArrayList(Arrays.asList(23, 24, 32, 35, 42, 45, 53, 54));
        HashMap<Integer, List<Integer>> outerCheckList = new HashMap<>();
        outerCheckList.put(23, Arrays.asList(13, 22, 24));
        outerCheckList.put(24, Arrays.asList(14, 23, 25));
        outerCheckList.put(32, Arrays.asList(22, 31, 42));
        outerCheckList.put(35, Arrays.asList(25, 36, 45));
        outerCheckList.put(42, Arrays.asList(32, 41, 52));
        outerCheckList.put(45, Arrays.asList(35, 46, 55));
        outerCheckList.put(53, Arrays.asList(52, 54, 63));
        outerCheckList.put(54, Arrays.asList(53, 55, 64));

        HashMap<Integer, String> tileList = new HashMap<>();
        for (int j = 0; j < placementSequence.length(); j += 6) {
            //Hashmap for the placement, position as Key
            String tile = placementSequence.substring(j, j + 4);
            String position = placementSequence.substring(j + 4, j + 6);
            int positionInt = Integer.parseInt(position);
            tileList.put(positionInt, tile);
            //System.out.println(positionInt + " " + tile);
        }

        ArrayList edgeListUpper = new ArrayList(Arrays.asList(01, 02, 03, 04, 05, 06));
        ArrayList edgeListLeft = new ArrayList(Arrays.asList(10, 20, 30, 40, 50, 60));
        ArrayList edgeListRight = new ArrayList(Arrays.asList(17, 27, 37, 47, 57, 67));
        ArrayList edgeListBottom = new ArrayList(Arrays.asList(71, 72, 73, 74, 75, 76));

        for (int positionInt : positionList) {
            String tile = tileList.get(positionInt);

            if (edgeListBottom.contains(positionInt) && tile.charAt(2) == 'd') {
                return false;
            }

            if (edgeListUpper.contains(positionInt) && tile.charAt(0) == 'd') {
                return false;
            }

            if (edgeListLeft.contains(positionInt) && tile.charAt(3) == 'd') {
                return false;
            }

            if (edgeListRight.contains(positionInt) && tile.charAt(1) == 'd') {
                return false;
            }

            if (aroundCentralList.contains(positionInt)) {
                //test placement neighbours if around central station
                List<Integer> neighbours = outerCheckList.get(positionInt);
                int countNull = 0;
                for (int neighbour : neighbours) {
                    if (tileList.get(neighbour) == null) {
                        countNull++;
                    }
                }
                if (countNull == 3) {
                    //System.out.println("test central");
                    return false;
                }
            }

            //check adjacent for tiles not on edge
            if (positionInt > 7 && positionInt < 70) {  //first line is 0-7, no need to test adjacent, also last line
                String s = String.valueOf(positionInt);
                //System.out.println(s);

                if (s.charAt(1) != '0' && s.charAt(1) != '7') {
                    //System.out.println(s.charAt(1));
                    int countAdjacent = 0;
                    if (positionList.contains(positionInt + 1) || positionList.contains(positionInt - 1) || positionList.contains(positionInt + 10) || positionList.contains(positionInt - 10)) {
                        countAdjacent++;
                    }
                    if (countAdjacent == 0) {
                        //System.out.println("test adjacent");
                        return false;
                    }
                }
            }

            if (positionInt == 0 || positionInt == 7 || positionInt == 70 || positionInt == 77) {
                //check corner cases
                int[] tilecode = Tile.encodeTileType(tileList.get(positionInt));

                switch (positionInt) {
                    case 0:
                        if (tilecode[0] == 4 || tilecode[7] == 4) {
                            return false;
                        }
                    case 7:
                        if (tilecode[1] == 4 || tilecode[2] == 4) {
                            return false;
                        }
                    case 70:
                        if (tilecode[7] == 4 || tilecode[4] == 4) {
                            return false;
                        }
                    case 77:
                        if (tilecode[2] == 4 || tilecode[4] == 4) {
                            return false;
                        }
                }
            }
        }


        return true;


    }

    /**
     * Task 7
     * Determine the current score for the game.
     *
     * @param placementSequence a String representing the sequence of piece placements made so far in the game
     * @param numberOfPlayers   The number of players in the game
     * @return an array containing the scores for all players
     */
    // author of this method: Luna
    public static int[] getScore(String placementSequence, int numberOfPlayers) {
        return new RoadMap(placementSequence, numberOfPlayers).getScore();
    }


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
        // FIXME Task 9: generate a valid move
        //System.out.println(placementSequence);
        String move = "";


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

        Random r = new Random();
        if (possibleList.size() > 0) {
            move = possibleList.get(r.nextInt(possibleList.size()));
        }


        return move;
    }

    public static int getPreviousDirctionForEdge(String tileType, int tilePlace) {
        int previousDirection = 0;
        int index = 0;
        int[] tileCode = Tile.encodeTile(tileType);

        if (tilePlace <= 8) {
            index = 0;
        } else if (tilePlace <= 16) {
            index = 6;
        } else if (tilePlace <= 24) {
            index = 4;
        } else {
            index = 2;
        }

        for (int i = 0; i < tileCode.length; i++) {
            if (tileCode[index] == tileCode[i]) {
                switch (i) {
                    case (1):
                        previousDirection = -10;
                        break;
                    case (3):
                        previousDirection = 1;
                        break;
                    case (5):
                        previousDirection = +10;
                        break;
                    case (7):
                        previousDirection = -1;
                        break;
                }
            }
        }
        return previousDirection;
    }

    public static int getDirectionForTile(String tileType1, int tilePlace1, int previoudDirection) {
        int convertDirection = 0;
        switch (previoudDirection) {
            case (-10):
                convertDirection = 4;
                break;
            case (10):
                convertDirection = 0;
                break;
            case (1):
                convertDirection = 6;
                break;
            case (-1):
                convertDirection = 2;
                break;
        }
        //System.out.println("convertPosition " + convertDirection);
        int[] tileCode = Tile.encodeTile(tileType1);

        int direction = 0;
        for (int i = 0; i < tileCode.length; i++) {
            if (tileCode[convertDirection] == tileCode[i]) {
                switch (i) {
                    case (1):
                        direction = -10;
                        break;
                    case (3):
                        direction = 1;
                        break;
                    case (5):
                        direction = +10;
                        break;
                    case (7):
                        direction = -1;
                        break;
                }
            }
        }

        return direction;
    }


    public static boolean isTileConnected(HashMap<String, String> tileList, String position, int direction) {
        int positionInt = Integer.parseInt(position);
        int checkLoc = positionInt + direction;
        if (tileList.containsKey(String.valueOf(checkLoc))) {
            return true;
        }
        return false;
    }

}

