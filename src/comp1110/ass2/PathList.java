package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class PathList {

    public static void main(String[] args) {
        System.out.println(getScore("bcbc01dada30cbcb05cdac60bbad31accd67baac02bcdd41cccc57bbbb17dacc72ccda20cbaa21dbba76dddd22aacb06aaaa32acba42", 2));
    }


    public static int[] getScore(String placementSequence, int numberOfPlayers) {

        //Yiwei's trial, to have a better understanding of the game
        System.out.println(placementSequence);
        int[] markList = new int[numberOfPlayers];

        ArrayList<ArrayList<Integer>> playerstation = getplayerstationByNum(numberOfPlayers);

        HashMap<String, String> tileListPT = new HashMap<>();
        for (int j = 0; j < placementSequence.length(); j += 6) {
            //Hashmap for the placement, position as Key
            String tile = placementSequence.substring(j, j + 4);
            String position = placementSequence.substring(j + 4, j + 6);
            tileListPT.put(position, tile);
            //System.out.println(positionInt + " " + tile);
        }


        ArrayList<LinkedList<Integer>> pathlist = new ArrayList<>(32);
        for (int n = 1; n <= 32; n++) {
            LinkedList<Integer> path = new LinkedList<>();
            path.addFirst(n);
            pathlist.add(n - 1, path);
        }
        //System.out.println("pathlist " + pathlist);


        for (int i = 0; i < playerstation.size(); i++) {
            ArrayList<String> startPlaceStrList = convertStationToStartLoc(playerstation.get(i));
            System.out.println("startPlaceStrList " + startPlaceStrList);

            for (int j = 0; j < startPlaceStrList.size(); j++) {
                //System.out.println("here" + startPlaceStrList.get(j));

                if (tileListPT.containsKey(startPlaceStrList.get(j))) {
                    String startPlaceStr = startPlaceStrList.get(j);
                    System.out.println("startPlaceStr " + startPlaceStr);
                    int startStationInt = playerstation.get(i).get(j);
                    //System.out.println("startStationInt " + startStationInt);

                    //System.out.println("startTile " + tileListPT.get(startPlaceStrList.get(j)));
                    String tileStr = tileListPT.get(startPlaceStrList.get(j));
                    System.out.println("tileStr " + tileStr);

                    //int checkDirction = getDirectionByStartStation(startStationInt);
                    //System.out.println("checkDirection " + checkDirction);


                    int previousDirection = getPreviousDirctionForEdge(tileStr, Integer.parseInt(startPlaceStr));
                    //System.out.println("previousDirection " + previousDirection);
                    int checkDirction2 = previousDirection;
                    //System.out.println("test tileStr " + tileStr);
                    //System.out.println(Integer.parseInt(startPlaceStr));
                    //System.out.println("checkDirection2 " + checkDirction2);
                    int checkDirction = checkDirction2;


                    String position = startPlaceStr;
                    int directionCheck = checkDirction;

                    ArrayList<String> terminate = new ArrayList(Arrays.asList("00", "01", "02", "03", "04", "05", "06", "07", "10", "17", "70", "71", "72", "73", "74", "75", "76", "77", "20", "27", "30", "37", "40", "47", "50", "57", "60", "67"));

                    while (isTileConnected(tileListPT, position, directionCheck)) {
                        int newposition = Integer.parseInt(position) + directionCheck;
                        //System.out.println("new position " + newposition);
                        pathlist.get(startStationInt - 1).add(newposition);

                        String tiletypeNew = tileListPT.get(String.valueOf(newposition));
                        //System.out.println("tiletypeNew " + tiletypeNew);

                        int newDirection = getDirectionForTile(tiletypeNew, newposition, directionCheck);
                        //System.out.println("newDirection " + newDirection);

                        position = String.valueOf(newposition);
                        directionCheck = newDirection;

                        if (terminate.contains(position)) {
                            break;
                        }

                    }
                }
            }

            System.out.println("new PathList " + pathlist);
        }

        return markList;

        //return new RoadMap(placementSequence, numberOfPlayers).getScore();
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

    /**
     * @param tileType1
     * @param tilePlace1
     * @param previoudDirection -10 Up, +10 Down, +1 Right, -1 Left
     * @return
     */

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

        //return new RoadMap(placementSequence, numberOfPlayers).getScore();
    }
}
