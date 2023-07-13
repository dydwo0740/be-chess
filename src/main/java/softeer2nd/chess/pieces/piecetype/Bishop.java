package softeer2nd.chess.pieces.piecetype;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;


public class Bishop extends Piece {
    private Bishop(Color color) {
        super(diagonalDirection(), color, BISHOP);
    }

    public static Piece createBlackBishop() {
        return new Bishop(BLACK);
    }

    public static Piece createWhiteBishop() {
        return new Bishop(WHITE);
    }


    @Override
    public boolean isRecursion() {
        return true;
    }
}
