package comp1110.ass2;
// author of this class: Luna
import java.util.Objects;

public class TrainPosition {
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

