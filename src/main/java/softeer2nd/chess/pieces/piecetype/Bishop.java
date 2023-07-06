package softeer2nd.chess.pieces.piecetype;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Type.BISHOP;

public class Bishop extends Piece {
    private Bishop(Color color) {
        super(color, BISHOP);
    }

    public static Piece createWhiteBishop(){
        return new Bishop(WHITE);
    }
    public static Piece createBlackBishop(){
        return new Bishop(BLACK);
    }


}
