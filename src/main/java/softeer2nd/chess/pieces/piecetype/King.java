package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.Board;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class King extends Piece {
    King(Color color) {
        super(everyDirection(), color, KING);
    }


    private boolean flag;

    @Override
    public boolean verifyMovePosition(Position position, Position end,  Board board) {
        int x = position.getX();
        int y = position.getY();
        int endX = end.getX();
        int endY = end.getY();
        flag = false;
        for (Direction direction : directions) {
            Position add = changeDirectionToPosition(direction);
            int nx = x + add.getX();
            int ny = y + add.getY();
            if (0 > nx || nx >= 8 || 0 > ny || ny >= 8 || board.getGameChess().isMyTeamHere(nx, ny, this.color)) {
                continue;
            }
            if (nx == endX && ny == endY) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}
