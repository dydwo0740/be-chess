package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.Board;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class Rook extends Piece {
    private Rook(Color color) {
       super(linearDirection(), color, ROOK);
    }

    public static Piece createWhiteRook(){
        return new Rook(WHITE);
    }
    public static Piece createBlackRook(){
        return new Rook(BLACK);
    }

    @Override
    public void verifyMovePosition(Position position, Board board) {

    }
}
