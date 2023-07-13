package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;

import static softeer2nd.chess.Board.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.WHITE;
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
    public boolean verifyMovePosition(Position position, Position end, GameChess gameChess) {
        flag = false;
        for (Direction direction : directions) {
            checkMove(0, direction, position.getX(), position.getY(),end.getX(), end.getY(), gameChess);
        }
        return flag;
    }

    public void checkMove(int depth, Direction direction, int curX, int curY, int endX, int endY, GameChess gameChess){
        if (!isInBoardRange(curX, curY) || (gameChess.isMyTeamHere(curX, curY, this.color) && depth > 0)) {
            return;
        }
        if(curX == endX && curY == endY){
            flag = true;
            return;
        }
        checkMove(depth + 1, direction, curX + directionToPosition(direction).getX(), curY + directionToPosition(direction).getY(),endX, endY, gameChess);

    }
}
