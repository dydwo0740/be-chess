package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.piecetype.enumutils.Direction;

import java.util.List;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class Pawn extends Piece {

    private Pawn(Color color, List<Direction> directions) {
        super(directions, color, PAWN);
    }

    public static Piece createWhitePawn() {
        return new Pawn(WHITE, whitePawnDirection());
    }

    public static Piece createBlackPawn() {
        return new Pawn(BLACK, blackPawnDirection());
    }
}
