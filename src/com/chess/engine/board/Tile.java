package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;


public abstract class Tile {

    protected final int tileCoord;
    private static final Map<Integer, EmptyTile> emptyTiles = allPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> allPossibleEmptyTiles(){
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for(int i = 0; i < 64; i++){
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return Collections.unmodifiableMap(emptyTileMap);
    }

    public Tile(int tileCoord){
        this.tileCoord = tileCoord;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();


}
