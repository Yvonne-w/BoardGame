/*package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ValidCheck {

    private static final ArrayList<String> CENTRAL_LIST = new ArrayList<String>(
            Arrays.asList("34","43","33","44"));

    private static final ArrayList<String> LEFT_LIST = new ArrayList<String>(
            Arrays.asList("accd","adad","bbad","bcdd","dbcd","dddd"));

    private static final ArrayList<String> RIGHT_LIST = new ArrayList<String>(
            Arrays.asList("adbb","adad","cdac","cddb","ddbc","dddd"));

    private static final ArrayList<String> BOTTOM_LIST = new ArrayList<String>(
            Arrays.asList("badb","bcdd","ccda","cddb","dada","dddd"));

    private static final ArrayList<String> TOP_LIST = new ArrayList<String>(
            Arrays.asList("dacc","dada","dbba","ddbc","dbcd","dddd"));

    private static final ArrayList<String> LEFT_TOP_LIST = new ArrayList<String>(
            Arrays.asList("cbaa","cbcb","cccc","ccda","cdac","cddb"));

    private static final ArrayList<String> LEFT_BOTTOM_LIST = new ArrayList<String>(
            Arrays.asList("baac","bcbc","cccc","cdac","dacc","ddbc"));

    private static final ArrayList<String> RIGHT_TOP_LIST = new ArrayList<String>(
            Arrays.asList("acba","accd","bcdd","cccc","ccda","bcbc"));

    private static final ArrayList<String> RIGHT_BOTTOM_LIST = new ArrayList<String>(
            Arrays.asList("aacb","accd","cbcb","cccc","dacc","dbcd"));

    private static final ArrayList<String> CENTRAL_COORDINATE_LIST = new ArrayList<String>(
            Arrays.asList("32","42","23","24","35","45","53","54"));


    public static boolean isPlacementOverlap(String placementSequence){
        List<String> coordinateList = new ArrayList();
        for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
            String coordinate = currentTile.substring(4);
            if (CENTRAL_LIST.contains(coordinate) || coordinateList.contains(coordinate)){
                return false;
            }else {
                coordinateList.add(coordinate);
            }

        }
        return true;
    }


    public static boolean isConnectRestBoard(String placementSequence){
        LinkedList<String> coordinateList = new LinkedList<>();
        for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
            String coordinate = currentTile.substring(4);
            coordinateList.add(coordinate);
        }
        String coordinateFirst =  coordinateList.get(0);
        if (!coordinateFirst.contains("0") && !coordinateFirst.contains("7")){
            return false;
        }

        ArrayList<String> alreadyList = new ArrayList<>();
        for (String coordinate : coordinateList){
            if (coordinate.contains("0")|| coordinate.contains("7")){
                alreadyList.add(coordinate);
                continue;
            }
            Integer coordinateIn = Integer.valueOf(coordinate);
            String coordinateTop = String.valueOf(coordinateIn-10).length() == 2 ? String.valueOf(coordinateIn-10) : "0"+String.valueOf(coordinateIn-10);
            String coordinateLeft = String.valueOf(coordinateIn-1).length() == 2 ? String.valueOf(coordinateIn-1) : "0"+String.valueOf(coordinateIn-1);
            String coordinateRight = String.valueOf(coordinateIn+1).length() == 2 ? String.valueOf(coordinateIn+1) : "0"+String.valueOf(coordinateIn+1).length();
            String coordinateBottom = String.valueOf(coordinateIn+10);
            if((!coordinate.contains("0")&& !coordinate.contains("7")&&(!alreadyList.contains(coordinateTop) && !alreadyList.contains(coordinateLeft)
                    && !alreadyList.contains(coordinateRight) && !alreadyList.contains(coordinateBottom)))){
                return false;
            }
            alreadyList.add(coordinate);
        }
        return true;
    }


    public static boolean canPlaceCentralStations(String placementSequence){
        ArrayList<String> coordinateList = new ArrayList<>();
        for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
            String coordinate = currentTile.substring(4);
            if ("32".equals(coordinate) && (!coordinateList.contains("22") && !coordinateList.contains("31") && !coordinateList.contains("42"))){
                return false;
            }else if ("42".equals(coordinate) && (!coordinateList.contains("41") && !coordinateList.contains("52") && !coordinateList.contains("32"))){
                return false;
            }else if ("23".equals(coordinate) && (!coordinateList.contains("22") && !coordinateList.contains("13") && !coordinateList.contains("24"))){
                return false;
            }else if ("24".equals(coordinate) && (!coordinateList.contains("25") && !coordinateList.contains("14") && !coordinateList.contains("23"))){
                return false;
            }else if ("35".equals(coordinate) && (!coordinateList.contains("25") && !coordinateList.contains("36") && !coordinateList.contains("45"))){
                return false;
            }else if ("45".equals(coordinate) && (!coordinateList.contains("55") && !coordinateList.contains("46") && !coordinateList.contains("35"))){
                return false;
            }else if ("53".equals(coordinate) && (!coordinateList.contains("52") && !coordinateList.contains("63") && !coordinateList.contains("54"))){
                return false;
            }else if ("54".equals(coordinate) && (!coordinateList.contains("55") && !coordinateList.contains("64") && !coordinateList.contains("53"))){
                return false;
            }else {
                coordinateList.add(coordinate);
            }

        }
        return true;

    }

    public static boolean canPlaceEdge(String placementSequence){
        if (placementSequence.startsWith("dddd")){
            return true;
        }
        for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
            String title = currentTile.substring(0,4);
            String coordinate = currentTile.substring(4);
            if (coordinate.endsWith("0") && LEFT_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile) && AfterTitleValid(title,placementSequence.substring(i))){
                return false;
            }

            if (coordinate.endsWith("7") && RIGHT_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile) && AfterTitleValid(title,placementSequence.substring(i))){
                return false;
            }
            if (coordinate.startsWith("7") && BOTTOM_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile) && AfterTitleValid(title,placementSequence.substring(i))){
                return false;
            }
            if (coordinate.startsWith("0") && TOP_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile) && AfterTitleValid(title,placementSequence.substring(i))){
                return false;
            }

        }
        return true;

    }

    public static boolean canPlaceCorner(String placementSequence){
        if (placementSequence.startsWith("dddd")){
            return true;
        }
        for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
            String title = currentTile.substring(0,4);
            String coordinate = currentTile.substring(4);

            if (("00").equals(coordinate) && LEFT_TOP_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile) && AfterTitleCornerValid(title,placementSequence.substring(i))){
                return false;
            }

            if (("70").equals(coordinate) && LEFT_BOTTOM_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile) ){
                return false;
            }
            if (("07").equals(coordinate) && RIGHT_TOP_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile)){
                return false;
            }
            if (("77").equals(coordinate) && RIGHT_BOTTOM_LIST.contains(title) &&
                    checkTitleHasSpace(placementSequence,currentTile)){
                return false;
            }
        }
        return true;
    }


    private static boolean AfterTitleValid(String titleEx,String subTitle){
        int sum = 0;
        for (int i = 0; i < subTitle.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (subTitle.substring(i, i + Metro.TITLE_SIZE));
            String coordinate = currentTile.substring(4);
            if (coordinate.endsWith("0") && LEFT_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }else if (coordinate.endsWith("7") && RIGHT_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }else if (coordinate.startsWith("7") && BOTTOM_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }else if (coordinate.startsWith("0") && TOP_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }
        }
        return sum != subTitle.length();
    }


    private static boolean AfterTitleCornerValid(String titleEx,String subTitle){
        int sum = 0;
        for (int i = 0; i < subTitle.length(); i += Metro.TITLE_SIZE) {
            String currentTile = (subTitle.substring(i, i + Metro.TITLE_SIZE));
            String coordinate = currentTile.substring(4);
            if (("00").equals(coordinate) && LEFT_TOP_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }else if (("70").equals(coordinate) && LEFT_BOTTOM_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }else if(("07").equals(coordinate) && RIGHT_TOP_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }else if(("77").equals(coordinate) && RIGHT_BOTTOM_LIST.contains(titleEx)){
                sum = sum+Metro.TITLE_SIZE;
            }

        }
        return sum != subTitle.length();

    }




    private static boolean checkTitleHasSpace(String placementSequence,String currentTile){
        if (placementSequence.length() != 360 || !placementSequence.endsWith(currentTile)){
            return true;
        }else{
            return false;
        }

    }

}*/
