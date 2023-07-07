package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.Board;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class Knight extends Piece {
    private Knight(Color color) {
        super(knightDirection(), color, KNIGHT);
    }
    public static Piece createWhiteKnight(){
        return new Knight(WHITE);
    }

    public static Piece createBlackKnight(){
        return new Knight(BLACK);
    }

    @Override
    public void verifyMovePosition(Position position, Board board) {

    }
}
