package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.Board;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;


public class Bishop extends Piece {
    private Bishop(Color color) {
        super(diagonalDirection(), color, BISHOP);
    }

    public static Piece createWhiteBishop(){
        return new Bishop(WHITE);
    }
    public static Piece createBlackBishop(){
        return new Bishop(BLACK);
    }

    private boolean flag;
    @Override
    public boolean verifyMovePosition(Position start, Position end, Board board) {
        flag = false;
        int x = start.getX();
        int y = start.getY();

        for (Direction direction : directions) {

        }

        return flag;
    }
}
