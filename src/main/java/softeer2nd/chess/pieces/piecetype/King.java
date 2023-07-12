package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.Board;
import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;

import static softeer2nd.chess.Board.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class King extends Piece {
    King(Color color) {
        super(everyDirection(), color, KING);
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
            Position add = changeDirectionToPosition(direction);
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
