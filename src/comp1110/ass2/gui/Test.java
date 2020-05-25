package comp1110.ass2.gui;

import comp1110.ass2.Metro;
import comp1110.ass2.Tile;
import comp1110.ass2.TileType;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

import static comp1110.ass2.Metro.isPlacementSequenceValid;
import static comp1110.ass2.gui.Game.SQUARE_SIZE;

public class Test {
    public static void main(String[] args) {
        Game.getDistanceToCentralFromInt(00);
        Game.getDistanceToCentralFromInt(11);
        Game.getDistanceToCentralFromInt(22);
        Game.getDistanceToCentralFromInt(30);
        Game.getDistanceToCentralFromInt(31);
        Game.getDistanceToCentralFromInt(32);
        Game.getDistanceToCentralFromInt(77);
        //System.out.println(Metro.generateMove("", "bcbc", 2));
        //System.out.println(Metro.generateMove("", "cccc", 2));
        //System.out.println(Metro.getScore("", 2));
        //Game.highlightPossibleLocation("", "cbcb");
        //Game.getPossibleLocation("","cbcb");
        //System.out.println(Metro.getScore("bcbc01dada30cbcb05cdac60bbad31accd67baac02bcdd41cccc57bbbb17dacc72ccda20cbaa21dbba76dddd22aacb06aaaa32acba42", 2));
        //System.out.println(isPlacementSequenceValid(""));
        //generateMove("", "cccc", 2);
        //System.out.println(Metro.possibleLocListStr);
        //System.out.println(TileList.class.toString());
    }

    public static String generateMove(String placementSequence, String piece, int numberOfPlayers) {
        //Task 9: generate a valid move
        //System.out.println(placementSequence);
        String generatedMove = "";
        ArrayList<String> placelistStr = new ArrayList();
        ArrayList<String> possibleLocListStr = new ArrayList<>();
        ArrayList<Integer> placeList = new ArrayList();

        if (placementSequence == "") {
            placelistStr = new ArrayList(Arrays.asList("00", "01", "02", "03", "04", "05", "06", "07", "10", "20", "30", "40", "50", "60", "70", "71", "72", "73", "74", "75", "76", "77", "17", "27", "37", "47", "57", "67"));
            int[] tilecode = Tile.encodeTileType(piece);
            //System.out.println(tilecode);
            if (tilecode[0] == 3) {
                placelistStr.remove(0);
                placelistStr.remove(7);
                placelistStr.remove(14);
                placelistStr.remove(21);
                System.out.println("placelistStr = " + placelistStr);
            }

        } else {
            for (int i = 0; i < 80; i += 10) {
                for (int j = 0; j < 8; j++) {
                    int placeInt = i + j;
                    placeList.add(placeInt);
                }
            }
        }

        //System.out.println(placeList);

        ArrayList<Integer> existList = new ArrayList<>();
        for (int m = 4; m < placementSequence.length(); m += 6) {
            int existPlaceInt = Integer.parseInt(placementSequence.substring(m, m + 2));
            existList.add(existPlaceInt);
        }

        //System.out.println(existList);

        for (int existPlaceInt : existList) {
            int removeIdx = placeList.indexOf(existPlaceInt);
            placeList.remove(removeIdx);
        }

        //System.out.println(placeList);


        for (int placeInt : placeList) {
            if (placeInt < 8) {
                String s = "0" + String.valueOf(placeInt);
                placelistStr.add(s);
            } else {
                placelistStr.add(String.valueOf(placeInt));
            }
        }

        //System.out.println(placelistStr);

        for (String placeStr : placelistStr) {
            //System.out.println(placeStr);
            String tryPlacement = "";
            tryPlacement = placementSequence + piece + placeStr;
            //System.out.println(tryPlacement);
            boolean b = isPlacementSequenceValid(tryPlacement);
            //System.out.println(b);
            if (b) {
                possibleLocListStr.add(tryPlacement);
            }

        }
        //System.out.println(possibleLocListStr);

        if (possibleLocListStr.size() != 0) {
            Random r = new Random();
            int randomLoc = r.nextInt(possibleLocListStr.size());
            //System.out.println(randomLoc);

            generatedMove = possibleLocListStr.get(randomLoc).substring(placementSequence.length(), placementSequence.length() + 6);
            //System.out.println(generatedMove);

            String checkCentral = generatedMove.substring(generatedMove.length() - 2, generatedMove.length());
            //System.out.println(checkCentral);

            while (checkCentral.equals("33") || checkCentral.equals("34") || checkCentral.equals("43") || checkCentral.equals("44")) {
                randomLoc = r.nextInt(possibleLocListStr.size());
                //System.out.println(randomLoc);

                generatedMove = possibleLocListStr.get(randomLoc).substring(placementSequence.length(), placementSequence.length() + 6);
                //System.out.println(generatedMove);

                checkCentral = generatedMove.substring(generatedMove.length() - 2, generatedMove.length());
                //System.out.println(checkCentral);
            }
        }

        //System.out.println(generatedMove);
        return generatedMove;
    }
}
