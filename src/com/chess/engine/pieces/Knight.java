package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.BoardUtility;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Knight extends Piece{

    private final static int[] POSSIBLE_COORDS = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }

    @Override
    public Collection<Move> calcLegalMoves(Board board) {


        final ArrayList<Move> legalMoves = new ArrayList<>();

        for(final int currentPossible : POSSIBLE_COORDS){

            final int destinationCoordinate = this.piecePosition + currentPossible;

            if(BoardUtility.isValidTileCoord(destinationCoordinate)){

                if(isFirstColumn(this.piecePosition, currentPossible)
                        || isSecondColumn(this.piecePosition, currentPossible)
                            || isSeventhColumn(this.piecePosition, currentPossible)
                                || isEighthColumn(this.piecePosition, currentPossible)){

                    continue;
                }

                final Tile candidateTile = board.getTile(destinationCoordinate);

                if(!(candidateTile.isTileOccupied())){
                    legalMoves.add(new Move());
                } else{
                    final Piece pieceAtDestination = candidateTile.getPiece();
                    final Alliance pieceAlliance = pieceAtDestination.getPieceAlliance();

                    if(this.pieceAlliance != pieceAlliance){
                        legalMoves.add(new Move());
                    }
                }
            }
        }
            return Collections.unmodifiableList(legalMoves);
    }

    private static boolean isFirstColumn(final int currPos, final int canOffset){
        return BoardUtility.FIRST_COLUMN[currPos] && (canOffset == -17 || canOffset == -10 || canOffset == 6  || canOffset == 15);
    }

    private static boolean isSecondColumn(final int currPos, final int canOffset){
        return BoardUtility.SECOND_COLUMN[currPos] && (canOffset == -10 || canOffset == 6 );
    }

    private static boolean isSeventhColumn(final int currPos, final int canOffset){
        return BoardUtility.SEVENTH_COLUMN[currPos] && (canOffset == -6 || canOffset == 10);
    }

    private static boolean isEighthColumn(final int currPos, final int canOffset){
        return BoardUtility.EIGHTH_COLUMN[currPos] && (canOffset == -15 || canOffset == -6 || canOffset == 10 || canOffset == 17);
    }


}
