package comp1110.ass2;
@author of this class: Yiwei (u7020050)

    public class Skeleton {
    
/*
#Main class:
Plan to use Game.fxml (or a Main class link to Game.fxml).
I have finished the layout part of the Game.fxml, so please check the Game.fxml in the GUI folder.
For the event-handler part, we are trying to mock the Metro Game on iOS platform as much as we can.

7 sub classes in total:

Class 1. Board {
    initial stage (UI setting, don't know how to describe in details yet)

    public static String[] Location(){
        return a String[60] that represents the tiles on the Board;
    }

}

#Class 2. Players {
    public enum playersDefault(){
        color;
        the default setting for 6 players;
    }

    public static int[] activePlayers(){
        return an int[6];
    }

    public static String[] tileBelongToPlayers(){
        return the tile that each player currently has;
    }

    public static boolean whichTileToPlace(){
        return True if the player decides to place the tile he has;
        return False if the player decided to place the tile from dock;
    }

}

#Class 3. Turns{
    public static boolean[] whoseTurn(){
        return boolean[] of whose turn it is;
        e.g. {True, False, False, False, False, False}
    }

}

#Class 4. Tiles{
    construct Tiles;

    public static String getTileType(){
        return tileType;
        e.g. 'aacd'
    }

    Public static String getTilePosition(){
        return tilePlacement;
        e.g. '32'
    }

    public static String changeTilePlacement(){
        return new tileString after one player changed the tilePlacement;
        e.g. 'aacd32';
    }

}

#Class 5. Scores {
    set the initial scores to be 0;

    public static boolean isRouteConnected (tile1, tile2) {
        return isRouteConnected;
    }

    public static boolean isEdgeConnected (tileString) {
        based on placement
        return isEdgeConnected;
    }

    public static boolean isCenterConnected (tileString) {
        based on tile placement
        return isCenterConnected;
    }

    public static boolean isRouteEnded (tileString) {
        based on edge or center
        return isRouteEnded
    }

    public static int whichPlayerScored (){
        based on edge
        return whichPlayerScored;

    }

    public static boolean isGameEnded() {
        No empty places
        return isGameEnded;
    }

    public static int whoIsTheWinner () {
        highest score;
        return whoIsTheWinner;
    }
}

#Class 6. TileDock {
     construct a String[]
}

#Class 7. PossibleLocation {
    public static boolean isEmptyLocation(){
        return isEmptyLocation;
    }

       public static boolean[] emptyLocationList(){
        return emptyLocationList;
    }

    public static boolean isLocationPossible(){

    }

    public static boolean[] possibleLocationList () {

    }



}
 */

}


