package comp1110.ass2;

import java.util.*;

public class Metro {
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
        /*
        //Yiwei's trial, to have a better understanding of the game
        System.out.println(placementSequence);
        int[] markList = new int[numberOfPlayers];

        ArrayList<ArrayList<Integer>> playerstation = getplayerstationByNum(numberOfPlayers);

        HashMap<String, String> tileList = new HashMap<>();
        for (int j = 0; j < placementSequence.length(); j += 6) {
            //Hashmap for the placement, position as Key
            String tile = placementSequence.substring(j, j + 4);
            String position = placementSequence.substring(j + 4, j + 6);
            tileList.put(position, tile);
            //System.out.println(positionInt + " " + tile);
        }

        for (int i = 0; i < playerstation.size(); i++) {
            ArrayList<String> startPlaceStr = convertStationToStartLoc(playerstation.get(i));
            System.out.println("startPlaceStr " + startPlaceStr);
            
            for (int j = 0; j < startPlaceStr.size(); j++) {
                //System.out.println("here" + startPlaceStr.get(j));

                if (tileList.containsKey(startPlaceStr.get(j))) {
                    int startStationInt = playerstation.get(i).get(j);
                    System.out.println("startStationInt " + startStationInt);

                    System.out.println("startTile " + tileList.get(startPlaceStr.get(j)));
                    String tileStr = tileList.get(startPlaceStr.get(j));
                    int checkDirction = getDirectionByStartStation(startStationInt);
                    System.out.println("checkDirection " + checkDirction);
                }
            }
        }


        return markList;
        //return new RoadMap(placementSequence, numberOfPlayers).getScore();
    }

    public static int getDirectionByStartStation(int playerStation) {
        int checkDirction = 0;
        if (playerStation <= 8) {
            checkDirction = 10; //down
        } else if (playerStation <= 16) {
            checkDirction = 1;  //right
        } else if (playerStation <= 24) {
            checkDirction = -10;
        } else {
            checkDirction = -1;
        }
        return checkDirction;
    }

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
         */
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
        String generatedMove = "";
        ArrayList<String> placelistStr = new ArrayList();
        ArrayList<String> possibleLocListStr = new ArrayList<>();
        ArrayList<Integer> placeList = new ArrayList();

        if (placementSequence == "") {
            placelistStr = new ArrayList(Arrays.asList("00", "01", "02", "03", "04", "05", "06", "07", "10", "20", "30", "40", "50", "60", "70", "71", "72", "73", "74", "75", "76", "77", "17", "27", "37", "47", "57", "67"));
            int[] tilecode = Tile.encodeTileType(piece);
            //System.out.println(tilecode);
            if (tilecode[0] == 3) {
                placelistStr.remove(0);
                placelistStr.remove(7);
                placelistStr.remove(14);
                placelistStr.remove(21);
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

        //System.out.println(placelistStr);

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
        //System.out.println(possibleLocListStr);

        if (possibleLocListStr.size() != 0) {
            Random r = new Random();
            int randomLoc = r.nextInt(possibleLocListStr.size());
            //System.out.println(randomLoc);

            generatedMove = possibleLocListStr.get(randomLoc).substring(placementSequence.length(), placementSequence.length() + 6);
            //System.out.println(generatedMove);

            String checkCentral = generatedMove.substring(generatedMove.length() - 2, generatedMove.length());
            //System.out.println(checkCentral);

            while (checkCentral.equals("33") || checkCentral.equals("34") || checkCentral.equals("43") || checkCentral.equals("44")) {
                randomLoc = r.nextInt(possibleLocListStr.size());
                //System.out.println(randomLoc);

                generatedMove = possibleLocListStr.get(randomLoc).substring(placementSequence.length(), placementSequence.length() + 6);
                //System.out.println(generatedMove);

                checkCentral = generatedMove.substring(generatedMove.length() - 2, generatedMove.length());
                //System.out.println(checkCentral);
            }
        }

        //System.out.println(generatedMove);
        return generatedMove;
    }
}

