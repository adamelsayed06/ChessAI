package com.chess.engine.board;

import com.chess.engine.pieces.Piece;

public class EmptyTile extends Tile {
    public EmptyTile(final int coordinate){
        super (coordinate);
    }


    @Override
    public boolean isTileOccupied() {
        return false;
    }

    public Piece getPiece(){
        return null;
    }

}
