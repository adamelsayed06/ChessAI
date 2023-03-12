package board;

import java.util.HashMap;
import java.util.Map;

public abstract class Tile {

    protected final int tileCoord;
    private static final Map<Integer, EmptyTile> emptyTiles = allPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> allPossibleEmptyTiles(){
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap<>();

        for(int i = 0; i < 64; i++){
            emptyTileMap.put(i, new EmptyTile(i));
        }
        return emptyTileMap;
    }

    public Tile(int tileCoord){
        this.tileCoord = tileCoord;
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();


}
