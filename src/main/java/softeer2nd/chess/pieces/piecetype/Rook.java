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

    private boolean flag;
    @Override
    public boolean verifyMovePosition(Position position, Position end, Board board) {
        flag = false;
        for (Direction direction : directions) {
            checkMove(0, direction, position.getX(), position.getY(),end.getX(), end.getY(), board);
        }
        return flag;
    }

    public void checkMove(int depth, Direction direction, int x, int y, int endX, int endY, Board board){
        if (0 > x || x >= 8 || 0 > y || y >= 8 || (board.getGameChess().isMyTeamHere(x, y, this.color) && depth > 0)) {
            return;
        }
        if(x == endX && y == endY){
            flag = true;
            return;
        }
        checkMove(depth + 1, direction, x + changeDirectionToPosition(direction).getX(), y + changeDirectionToPosition(direction).getY(),endX, endY, board);

    }
}
