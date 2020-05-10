package comp1110.ass2;

// author of this class: Luna

public class Config {
    final static int[][][] playersStations = new int[][][]{
            // define the start point
            new int[][]{new int[]{1, 3, 5, 7, 9, 11, 13, 15, 17, 19, 21, 23, 25, 27, 29, 31}, new int[]{2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32}},
            new int[][]{new int[]{1, 4, 6, 11, 15, 20, 23, 25, 28, 31}, new int[]{2, 7, 9, 12, 14, 19, 22, 27, 29, 32}, new int[]{3, 5, 8, 10, 13, 18, 21, 24, 26, 30}},
            new int[][]{new int[]{4, 7, 11, 16, 20, 23, 27, 32}, new int[]{3, 8, 12, 15, 19, 24, 28, 31}, new int[]{1, 6, 10, 13, 18, 21, 25, 30}, new int[]{2, 5, 9, 14, 17, 22, 26, 29}},
            new int[][]{new int[]{1, 5, 10, 14, 22, 28}, new int[]{6, 12, 18, 23, 27, 32}, new int[]{3, 7, 15, 19, 25, 29}, new int[]{2, 9, 13, 21, 26, 30}, new int[]{4, 8, 11, 20, 24, 31}},
            new int[][]{new int[]{1, 5, 10, 19, 27}, new int[]{2, 11, 18, 25, 29}, new int[]{4, 8, 14, 21, 26}, new int[]{6, 15, 20, 24, 31}, new int[]{3, 9, 13, 23, 30}, new int[]{7, 12, 22, 28, 32}}};

    final static int height = 8;
    final static int width = 8;

    static int[][] getPlayerStations(int num) {
        for (int[][] playerStation : playersStations) {
            if (playerStation.length == num) {
                return playerStation;
            }
        }
        return null;
    }

}

