package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.piecetype.enumutils.Direction;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class King extends Piece {
    private King(Color color) {
        super(everyDirection(), color, KING);
    }

    public static Piece createWhiteKing(){
        return new King(WHITE);
    }
    public static Piece createBlackKing(){
        return new King(BLACK);
    }


}
