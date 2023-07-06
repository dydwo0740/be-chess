package softeer2nd.chess.pieces.piecetype;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Type.*;

public class Queen extends Piece {
    public Queen(Color color) {
        super(color, QUEEN);
    }
    public static Piece createWhiteQueen(){
        return new Queen(WHITE);
    }
    public static Piece createBlackQueen(){
        return new Queen(BLACK);
    }
}
