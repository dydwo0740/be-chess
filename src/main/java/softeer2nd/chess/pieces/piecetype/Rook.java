package softeer2nd.chess.pieces.piecetype;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.linearDirection;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.ROOK;

public class Rook extends Piece {
    private Rook(Color color) {
        super(linearDirection(), color, ROOK);
    }

    public static Piece createWhiteRook() {
        return new Rook(WHITE);
    }

    public static Piece createBlackRook() {
        return new Rook(BLACK);
    }


    @Override
    public boolean isRecursion() {
        return false;
    }
}
