package comp1110.ass2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;

public class Score {

    public static class Config {
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

    public enum TrainState {
        RUNNING, ENDCENTRALSTATION, FAIL, ENDNORMALSTATION
    }

    public static class TrainPosition {
        private final int x;
        private final int y;
        private final int start;
        private TrainState state;

        /*
         * x: x coordinate column
         * y: y coordinate row
         * start: beginning exit point
         */
        TrainPosition(int y, int x, int start, TrainState state) {
            this.x = x;
            this.y = y;
            this.start = start;
            this.state = state;
        }

        public static TrainPosition computeStartTrainPosition(int num) {
            if (num >= 1 && num <= 8) {
                return new TrainPosition(0, 8 - num, 0, TrainState.RUNNING);
            } else if (num >= 9 && num <= 16) {
                return new TrainPosition(num - 9, 0, 6, TrainState.RUNNING);
            } else if (num >= 17 && num <= 24) {
                return new TrainPosition(7, num - 17, 4, TrainState.RUNNING);
            } else if (num >= 25 && num <= 32) {
                return new TrainPosition(32 - num, 7, 2, TrainState.RUNNING);
            }
            return null;
        }

        public TrainState getState() {
            return state;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        public int getStart() {
            return start;
        }

        @Override
        public String toString() {
            return "SearchParam{" +
                    "x=" + x +
                    ", y=" + y +
                    ", start=" + start +
                    ", state=" + state +
                    '}';
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            TrainPosition that = (TrainPosition) o;
            return x == that.x &&
                    y == that.y &&
                    start == that.start;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y, start);
        }
    }

    public static class TileRoad {
        ArrayList<Path> pathList;
        private int x;
        private int y;
        private String placement;

        TileRoad(String placement) {
            this.placement = placement;
            assert placement.length() == 6;
            pathList = new ArrayList<>();
            for (int i = 0; i < 4; i++) {
                int start = 2 * i;
                int end = getEnd(start, placement.charAt(i));
                pathList.add(new Path(start, end));
            }
            y = Integer.parseInt(String.valueOf(placement.charAt(4)));
            x = Integer.parseInt(String.valueOf(placement.charAt(5)));
        }

        /**
         * x: start from exit
         * return: the other exit connect to x, -1 if no match
         */
        int getConnected(int x) {
            for (Path p : pathList) {
                int connected = p.getConnected(x);
                if (connected != -1) {
                    return connected;
                }
            }
            return -1;
        }


        /**
         * start: even number exit
         * c: road type
         * return: other side of odd exit
         */
        private int getEnd(int start, char c) {
            // assume starting from 0
            int ans = 0;
            if (c == 'a') {
                //straight track
                ans = 5;
            } else if (c == 'b') {
                // turns 90 clock wise
                ans = 3;
            } else if (c == 'c') {
                // turns 90 counter clock wise
                ans = 7;
            } else if (c == 'd') {
                // turns 180, loop back
                ans = 1;
            } else {
                System.err.println("wrong char for road type " + c);
                assert false;
            }
            return (ans + start) % 8;
        }

        public int getX() {
            return x;
        }

        public int getY() {
            return y;
        }

        @Override
        public String toString() {
            StringBuilder pathListstr = new StringBuilder();
            for (Path p : pathList) {
                pathListstr.append(p.toString()).append("\n");
            }
            return "TileRoad{" +
                    "pathList=" + pathListstr +
                    ", x=" + x +
                    ", y=" + y +
                    ", placement='" + placement + '\'' +
                    '}';
        }

        static class Path {
            private final int start;
            private final int end;

            Path(int start, int end) {
                this.start = start;
                this.end = end;
            }

            /**
             * exit1: one exit
             * return: get other exit if one exit is the input, -1 if no match
             */
            int getConnected(int exit1) {
                if (exit1 == start) {
                    return end;
                } else if (exit1 == end) {
                    return start;
                } else {
                    return -1;
                }
            }

            @Override
            public String toString() {
                return "Path{" +
                        "start=" + start +
                        ", end=" + end +
                        '}';
            }
        }
    }

    public static class RoadMap {
        private final int numberOfPlayers;
        TileRoad[][] roads = new TileRoad[Config.height][Config.width];

        public RoadMap(String placementSequence, int numberOfPlayers) {
            this.numberOfPlayers = numberOfPlayers;
            for (int i = 0; i < placementSequence.length() / 6; i++) {
                String placement = placementSequence.substring(i * 6, (i + 1) * 6);
                addTile(new TileRoad(placement));
            }
        }

        private void addTile(TileRoad tileRoad) {
            roads[tileRoad.getY()][tileRoad.getX()] = tileRoad;
        }

        public int[] getScore() {
            int[][] playerStations = Config.getPlayerStations(numberOfPlayers);
            assert playerStations != null;
            int[] ans = new int[playerStations.length];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = 0;
                HashSet<TrainPosition> visitd = new HashSet<>();
                for (int j = 0; j < playerStations[i].length; j++) {
                    TrainPosition trainPosition = TrainPosition.computeStartTrainPosition(playerStations[i][j]);
                    assert trainPosition != null;
                    if (!visitd.contains(trainPosition)) {
                        visitd.add(trainPosition);
                        ans[i] += getStationScore(trainPosition, visitd);
                    }
                }
            }
            return ans;
        }

        /**
         * trainPosition: starting parame to search
         * return: a score from (x, y) of start exit
         */
        public int getStationScore(TrainPosition trainPosition, HashSet<TrainPosition> visited) {
            int score = 0;
            while (trainPosition.getState() == TrainState.RUNNING) {
                trainPosition = getNextPosition(trainPosition);
                // score each cross over a tile
                score++;
            }
            switch (trainPosition.getState()) {
                case FAIL:
                    return 0;
                case ENDNORMALSTATION:
                    // might end in it's own station
                    return score;
                case ENDCENTRALSTATION:
                    //double the score
                    return 2 * score;
                default:
                    throw new IllegalStateException("Unexpected value: " + trainPosition.getState());
            }
        }


        private TrainPosition getNextPosition(TrainPosition s) {
            int y = s.getY();
            int x = s.getX();
            int start = s.getStart();
            TileRoad pre = roads[y][x];
            TrainState search = TrainState.RUNNING;

            // if nothing here
            if (pre == null) {
                return new TrainPosition(y, x, 0, TrainState.FAIL);
            }

            // get exit
            int end = pre.getConnected(start);
            int next_begin = end % 2 == 0 ? (end - 3) % 8 : (end + 3) % 8;
            if (end == 1 || end == 0) {
                //up
                y--;
            } else if (end == 3 || end == 2) {
                // right
                x++;
            } else if (end == 5 || end == 4) {
                // down
                y++;
            } else if (end == 7 || end == 6) {
                // left
                x--;
            } else if (end == -1) {
                // no connected
                search = TrainState.FAIL;
            } else {
                // something wrong
                assert false;
            }
            // end of the road
            if (roadAtNormalStation(x, y)) {
                search = TrainState.ENDNORMALSTATION;
                x = s.getX();
                y = s.getY();
                next_begin = end;
            } else if (roadAtCentralStation(x, y)) {
                search = TrainState.ENDCENTRALSTATION;
            }
            return new TrainPosition(y, x, next_begin, search);
        }

        private boolean roadAtCentralStation(int x, int y) {
            return (x == 4 && y == 4) || (x == 3 && y == 3) || (x == 4 && y == 3) || (x == 3 && y == 4);
        }

        private boolean roadAtNormalStation(int x, int y) {
            return x >= Config.width || x < 0 || y >= Config.height || y < 0;
        }
    }
}
