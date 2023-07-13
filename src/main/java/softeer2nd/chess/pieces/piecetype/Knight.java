package softeer2nd.chess.pieces.piecetype;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.knightDirection;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.KNIGHT;

public class Knight extends Piece {
    private Knight(Color color) {
        super(knightDirection(), color, KNIGHT);
    }

    public static Piece createWhiteKnight() {
        return new Knight(WHITE);
    }

    public static Piece createBlackKnight() {
        return new Knight(BLACK);
    }


    @Override
    public boolean isRecursion() {
        return false;
    }
}
