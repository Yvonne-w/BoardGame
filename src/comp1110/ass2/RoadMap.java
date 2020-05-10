package comp1110.ass2;

import java.util.HashSet;

public class RoadMap {
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


