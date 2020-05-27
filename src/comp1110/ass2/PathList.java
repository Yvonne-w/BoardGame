package comp1110.ass2;

import java.sql.SQLOutput;
import java.util.*;

public class PathList {

    public static ArrayList<LinkedList<Integer>> getPathList(String placementSequence) {
        HashMap<Integer, String> tileListPT = new HashMap<>();
        ArrayList<Integer> startStationInt = new ArrayList<>();
        ArrayList<Integer> startStationlist = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 10, 17, 20, 27, 30, 37, 40, 47, 50, 57, 60, 67, 70, 71, 72, 73, 74, 75, 76, 77));

        for (int j = 0; j < placementSequence.length(); j += 6) {
            String tile = placementSequence.substring(j, j + 4);
            Integer position = Integer.parseInt(placementSequence.substring(j + 4, j + 6));
            tileListPT.put(position, tile);
            if (startStationlist.contains(position)) {
                startStationInt.add(position);
            }
        }
        Collections.sort(startStationInt);

        ArrayList<LinkedList<Integer>> pathlist = new ArrayList<>(32);
        for (int n = 1; n <= 32; n++) {
            LinkedList<Integer> path = new LinkedList<>();
            path.addFirst(n);
            pathlist.add(n - 1, path);
        }

        int startPosition = 0;
        int startDirection = 0;
        int startIndex = 0;
        for (int j = 0; j < startStationInt.size(); j++) {
            String startTileStr = tileListPT.get(startStationInt.get(j));
            startPosition = startStationInt.get(j);
            startDirection = getPreviousDirctionForEdge(startTileStr, startPosition);

            if (startPosition < 8) {
                startIndex = 8 - startPosition;
            } else if (startPosition % 10 == 0) {
                startIndex = startPosition / 10 + 9;
            } else if (startPosition > 70) {
                startIndex = startPosition - 53;
            } else {
                startIndex = 32 - (startPosition - 7) / 10;
            }

            if (tileListPT.containsKey(startPosition + startDirection)) {
                int position1 = startPosition;
                int diection1 = startDirection;

                while (isTileConnected(tileListPT, position1, diection1)) {
                    int newposition = position1 + diection1;

                    String tiletypeNew = tileListPT.get(newposition);
                    if (tiletypeNew != null) {
                        pathlist.get(startIndex - 1).add(newposition);
                        int newDirection = getDirectionForTile(tiletypeNew, newposition, diection1);
                        position1 = newposition;
                        diection1 = newDirection;
                    } else {
                        break;
                    }
                }
            }
        }
        return pathlist;
    }

    public static int getPreviousDirctionForEdge(String tileType, int tilePlace) {
        int previousDirection = 0;
        int index = 0;
        int[] tileCode = Tile.encodeTile(tileType);

        if (tilePlace <= 8) {
            index = 0;
        } else if (tilePlace > 68) {
            index = 4;
        } else if (tilePlace % 10 == 0) {
            index = 6;
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

    public static boolean isTileConnected(HashMap<Integer, String> tileList, int position, int direction) {
        int checkLoc = position + direction;
        if (tileList.containsKey(position)) {
            return true;
        }
        return false;
    }
}


