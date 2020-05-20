/*
//package comp1110.ass2;



//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;


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


        public static boolean canPlaceCentralStations(String placementSequence){
            ArrayList<String> coordinateList = new ArrayList<>();
            for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
                String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
                String coordinate = currentTile.substring(4);
                if ("32".equals(coordinate) && (!coordinateList.contains("22") && !coordinateList.contains("31"))){
                    return false;
                }else if ("42".equals(coordinate) && (!coordinateList.contains("41") && !coordinateList.contains("52"))){
                    return false;
                }else if ("23".equals(coordinate) && (!coordinateList.contains("22") && !coordinateList.contains("13"))){
                    return false;
                }else if ("24".equals(coordinate) && (!coordinateList.contains("25") && !coordinateList.contains("14"))){
                    return false;
                }else if ("35".equals(coordinate) && (!coordinateList.contains("25") && !coordinateList.contains("36"))){
                    return false;
                }else if ("45".equals(coordinate) && (!coordinateList.contains("55") && !coordinateList.contains("46"))){
                    return false;
                }else if ("53".equals(coordinate) && (!coordinateList.contains("52") && !coordinateList.contains("63"))){
                    return false;
                }else if ("54".equals(coordinate) && (!coordinateList.contains("55") && !coordinateList.contains("64"))){
                    return false;
                }else {
                    coordinateList.add(coordinate);
                }

            }
            return true;

        }

        public static boolean canPlaceEdge(String placementSequence){
            for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
                String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
                String title = currentTile.substring(0,4);
                String coordinate = currentTile.substring(4);
                if (coordinate.endsWith("0") && LEFT_LIST.contains(title) &&
                        checkTitleHasSpace(placementSequence,currentTile)){
                    return false;
                }

                if (coordinate.endsWith("7") && RIGHT_LIST.contains(title) &&
                        checkTitleHasSpace(placementSequence,currentTile)){
                    return false;
                }
                if (coordinate.startsWith("7") && BOTTOM_LIST.contains(title) &&
                        checkTitleHasSpace(placementSequence,currentTile)){
                    return false;
                }
                if (coordinate.startsWith("0") && TOP_LIST.contains(title) &&
                        checkTitleHasSpace(placementSequence,currentTile)){
                    return false;
                }

            }
            return true;

        }

        public static boolean canPlaceCorner(String placementSequence){
            for (int i = 0; i < placementSequence.length(); i += Metro.TITLE_SIZE) {
                String currentTile = (placementSequence.substring(i, i + Metro.TITLE_SIZE));
                String title = currentTile.substring(0,4);
                String coordinate = currentTile.substring(4);

                if (("00").equals(coordinate) && LEFT_TOP_LIST.contains(title) &&
                        checkTitleHasSpace(placementSequence,currentTile)){
                    return false;
                }

                if (("70").equals(coordinate) && LEFT_BOTTOM_LIST.contains(title) &&
                        checkTitleHasSpace(placementSequence,currentTile)){
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

        private static boolean checkTitleHasSpace(String placementSequence,String currentTile){
            if (placementSequence.length() != 360 || !placementSequence.endsWith(currentTile)){
                return true;
            }else{
                return false;
            }

        }

    }

 */


