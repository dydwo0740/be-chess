package softeer2nd.chess.pieces.piecetype;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.everyDirection;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.KING;

public class King extends Piece {
    private King(Color color) {
        super(everyDirection(), color, KING);
    }

    public static Piece createWhiteKing() {
        return new King(WHITE);
    }

    public static Piece createBlackKing() {
        return new King(BLACK);
    }


    @Override
    public boolean isRecursion() {
        return false;
    }
}
