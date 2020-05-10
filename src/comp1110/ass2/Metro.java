package comp1110.ass2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Metro {
    /**
     * Task 2
     * Determine whether a piece placement is well-formed. For a piece
     * placement to be well-formed, it must:
     * - contain exactly six characters;
     * - have as its first, second, third and fourth characters letters between
     * 'a' and 'd' inclusive (tracks); and
     * - have as its fifth and sixth characters digits between 0 and 7 inclusive
     * (column and row respectively).
     *
     * @param piecePlacement A String representing the piece to be placed
     * @return True if this string is well-formed
     */
    public static boolean isPiecePlacementWellFormed(String piecePlacement) {
        if (piecePlacement.length() == 6) {
            if (piecePlacement.charAt(0) <= 'd' && piecePlacement.charAt(0) >= 'a'
                    && piecePlacement.charAt(1) <= 'd' && piecePlacement.charAt(1) >= 'a'
                    && piecePlacement.charAt(2) <= 'd' && piecePlacement.charAt(2) >= 'a'
                    && piecePlacement.charAt(3) <= 'd' && piecePlacement.charAt(3) >= 'a') {
                if (Character.getNumericValue(piecePlacement.charAt(4)) <= 7 && Character.getNumericValue(piecePlacement.charAt(4)) >= 0
                        && Character.getNumericValue(piecePlacement.charAt(5)) <= 7 && Character.getNumericValue(piecePlacement.charAt(5)) >= 0) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Task 3
     * Determine whether a placement sequence string is well-formed.
     * For a placement sequence to be well-formed, it must satisfy the
     * following criteria:
     * - It must be composed of well-formed tile placements.
     * - For any piece x, there can exist no more instances of x on the board
     * than instances of x in the deck.
     *
     * @param placement A String representing the placement of all tiles on the
     *                  board
     * @return true if this placement sequence is well-formed
     */
    public static boolean isPlacementSequenceWellFormed(String placement) {
        if (placement.length() == 0)
            return true;
        if (placement.length() < 360 && (placement.length() % 6) == 0) {

            foo:
            for (int i = 0; i < placement.length(); i += 6) {
                String pieceplacement = (placement.substring(i, i + 6));
                if (isPiecePlacementWellFormed(pieceplacement) == true) {
                    if (i == placement.length() - 6) {
                        return true;
                    }

                    continue foo;
                }
            }
            return false;
        }
        return false;
    }

    /**
     * Task 5
     * Draw a random tile from the deck.
     *
     * @param placementSequence a String representing the sequence of tiles
     *                          that have already been played
     * @param totalHands        a String representing all tiles (if any) in
     *                          all players' hands
     * @return a random tile from the deck
     */
    public static String drawFromDeck(String placementSequence, String totalHands) {
        // Task 5: draw a random tile from the deck
        //// author of this method: Yiwei (u7020050)
        ArrayList<String> tileList = new ArrayList<String>(
                Arrays.asList("aacb", "aacb", "aacb", "aacb",
                        "cbaa", "cbaa", "cbaa", "cbaa",
                        "acba", "acba", "acba", "acba",
                        "baac", "baac", "baac", "baac",
                        "aaaa", "aaaa", "aaaa", "aaaa",
                        "cbcb", "cbcb", "cbcb",
                        "bcbc", "bcbc", "bcbc",
                        "cccc", "cccc",
                        "bbbb", "bbbb",
                        "dacc", "dacc",
                        "cdac", "cdac",
                        "ccda", "ccda",
                        "accd", "accd",
                        "dbba", "dbba",
                        "adbb", "adbb",
                        "badb", "badb",
                        "bbad", "bbad",
                        "ddbc", "ddbc",
                        "cddb", "cddb",
                        "bcdd", "bcdd",
                        "dbcd", "dbcd",
                        "adad", "adad",
                        "dada", "dada",
                        "dddd", "dddd"));
        for (int i = 0; i < placementSequence.length(); i += 6) {
            String currentTile = placementSequence.substring(i, i + 4);
            tileList.remove(currentTile);
        }

        for (int j = 0; j < totalHands.length(); j += 4) {
            String currentHand = totalHands.substring(j, j + 4);
            tileList.remove(currentHand);
        }

        String randomTile = tileList.get(new Random().nextInt(tileList.size()));

        return randomTile;
    }

    /**
     * Task 6
     * Determine if a given placement sequence follows the rules of the game.
     * These rules are:
     * - No tile can overlap another tile, or any of the central stations.
     * - A tile cannot be placed next to one of the central squares unless it
     * continues or completes an existing track.
     * - If a tile is on an edge of the board, it cannot contain a track that
     * results in a station looping back to itself, UNLESS that tile could not
     * have been placed elsewhere.
     * - If a tile is on a corner of the board, it cannot contain a track that
     * links the two stations adjacent to that corner, UNLESS that tile could
     * not have been placed elsewhere.
     *
     * @param placementSequence A sequence of placements on the board.
     * @return Whether this placement string is valid.
     */
    public static boolean isPlacementSequenceValid(String placementSequence) {
        if (placementSequence.length() == 0)
            return true;
        if


        return false;
    }

    /**
     * Task 7
     * Determine the current score for the game.
     *
     * @param placementSequence a String representing the sequence of piece placements made so far in the game
     * @param numberOfPlayers   The number of players in the game
     * @return an array containing the scores for all players
     */
    public static int[] getScore(String placementSequence, int numberOfPlayers) {

        return new RoadMap(placementSequence, numberOfPlayers).getScore();
    }

    /**
     * Task 9
     * Given a placement sequence string, generate a valid next move.
     *
     * @param placementSequence a String representing the sequence of piece placements made so far in the game
     * @param piece             a four-character String representing the tile to be placed
     * @param numberOfPlayers   The number of players in the game
     * @return A valid placement of the given tile
     */
    public static String generateMove(String placementSequence, String piece, int numberOfPlayers) {
        // FIXME Task 9: generate a valid move
        return "";
    }
}
