package comp1110.ass2;

import java.util.ArrayList;
import java.util.LinkedList;

public class AdvancedAI {
    private final AIDifficulty AIDifficulty;
    public int index;
    public String name;

    AdvancedAI(int index, String name, AIDifficulty aiDifficulty) {
        this.index = index;
        this.name = name;
        this.AIDifficulty = comp1110.ass2.AIDifficulty.DIFFICULT;
    }

    public static ArrayList<PathState> getPathStatusList(ArrayList<LinkedList<Integer>> pathlist) {
        ArrayList<PathState> pathStatusList = new ArrayList<PathState>();


        for (int i = 0; i < pathlist.size(); i++) {
            int pathLength = pathlist.get(i).size();
            int endPoint = pathlist.get(i).get(pathLength - 1);

            pathStatusList.add(PathState.getState(pathLength, endPoint));
        }

        return pathStatusList;
    }

    public static ArrayList<Double> getPathMarkList(ArrayList<LinkedList<Integer>> pathlist, ArrayList<PathState> pathStatusList) {
        ArrayList<Double> pathMarkList = new ArrayList<>();

        for (int i = 0; i < pathStatusList.size(); i++) {
            if (pathStatusList.get(i) == PathState.INACTIVE) {
                pathMarkList.add(0.0);
            } else {
                int pathLength = pathlist.get(i).size();
                int endPoint = pathlist.get(i).get(pathLength - 1);
                double distance = getDistanceToCentralFromInt(endPoint);
                double mark = pathLength + 2 * (3.5 * Math.sqrt(2) - distance);
                //length + coefficient * ( 4 * Math.sqrt(2) - distance(endpoint - (0, 0)))
                pathMarkList.add(mark);
            }
        }


        return pathMarkList;
    }

    public static double getDistanceToCentralFromInt(int endPoint) {

        int row = endPoint / 10;
        int column = endPoint % 10;


        double distance = Math.sqrt(Math.pow((row - 3.5), 2) + Math.pow((column - 3.5), 2));

        return distance;
    }

}
