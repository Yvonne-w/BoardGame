package comp1110.ass2;
// author of this class: Luna

import java.util.ArrayList;

public class TileRoad {
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


