package com.chess.engine.board;

public class BoardUtility {

    public static final boolean[] FIRST_COLUMN = null;
    public static final boolean[] SECOND_COLUMN = null;
    public static final boolean[] SEVENTH_COLUMN = null;
    public static final boolean[] EIGHTH_COLUMN = null;

    private BoardUtility(){
        throw new RuntimeException("Do not instantiate please");
    }
    public static boolean isValidTileCoord(int coordinate) {
        return coordinate >= 0 && coordinate < 64;
    }

}
