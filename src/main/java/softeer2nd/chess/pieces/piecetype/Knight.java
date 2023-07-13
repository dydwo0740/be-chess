package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;

import static softeer2nd.chess.Board.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.BLACK;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.WHITE;
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
    private boolean flag;
    @Override
    public boolean verifyMovePosition(Position position, Position end, GameChess gameChess) {
        int beforeX = position.getX();
        int beforeY = position.getY();
        int endX = end.getX();
        int endY = end.getY();
        flag = false;
        for (Direction direction : directions) {
            Position add = directionToPosition(direction);
            int afterX = beforeX + add.getX();
            int afterY = beforeY + add.getY();
            if (!isInBoardRange(afterX, afterY) || gameChess.isMyTeamHere(afterX, afterY, this.color)) {
                continue;
            }
            if (afterX == endX && afterY == endY) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
