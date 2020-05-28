package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;
/**
 * Set the PathStatus
 * @author Yiwei
 */
public enum PathState {
    ACTIVE, INACTIVE;

    public static PathState getState(int pathLength, int endPoint) {
        ArrayList<Integer> alreadyEnd = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 10, 17, 20, 27, 30, 37, 40, 47, 50, 57, 60, 67, 70, 71, 72, 73, 74, 75, 76, 77));
        if (pathLength > 1 && alreadyEnd.contains(endPoint)) {
            return INACTIVE;
        }
        return ACTIVE;
    }

}
