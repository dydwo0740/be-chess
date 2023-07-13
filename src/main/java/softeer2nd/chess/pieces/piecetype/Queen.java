package softeer2nd.chess.pieces.piecetype;


import static softeer2nd.chess.pieces.piecetype.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.everyDirection;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.QUEEN;

public class Queen extends Piece {
    private Queen(Color color) {
        super(everyDirection(), color, QUEEN);
    }

    public static Piece createWhiteQueen() {
        return new Queen(WHITE);
    }

    public static Piece createBlackQueen() {
        return new Queen(BLACK);
    }


    @Override
    public boolean isRecursion() {
        return false;
    }
}
