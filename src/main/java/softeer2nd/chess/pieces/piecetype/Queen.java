package softeer2nd.chess.pieces.piecetype;


import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;
import static softeer2nd.chess.Board.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class Queen extends Piece {
    Queen(Color color) {
        super(everyDirection(), color, QUEEN);
    }
    private boolean flag;
    @Override
    public boolean verifyMovePosition(Position position, Position end,GameChess gameChess) {
        flag = false;
        for (Direction direction : directions) {
            checkMove(0, direction, position.getX(), position.getY(),end.getX(), end.getY(), gameChess);
        }
        return flag;
    }

    public void checkMove(int depth, Direction direction, int curX, int curY, int endX, int endY, GameChess gameChess){
        if (isInBoardRange(curX, curY) || (gameChess.isMyTeamHere(curX, curY, this.color) && (depth > 0))) {
            return;
        }
        if(curX == endX && curY == endY){
            flag = true;
            return;
        }
        checkMove(depth + 1, direction, curX + changeDirectionToPosition(direction).getX(), curY + changeDirectionToPosition(direction).getY(),endX, endY, gameChess);

    }
}
