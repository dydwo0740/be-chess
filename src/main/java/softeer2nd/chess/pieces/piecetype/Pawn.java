package softeer2nd.chess.pieces.piecetype;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Type.*;

public class Pawn extends Piece {

    private Pawn(Color color) {
        super(color, PAWN);
    }

    public static Piece createWhitePawn() {
        return new Pawn(WHITE);
    }

    public static Piece createBlackPawn() {
        return new Pawn(BLACK);
    }
}
