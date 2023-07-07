package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.Board;
import softeer2nd.chess.exception.PieceOutOfRange;
import softeer2nd.chess.exception.SameTeamHere;
import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.Position;
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


    @Override
    public void verifyMovePosition(Position position, Board board) {
        int x = position.getX();
        int y = position.getY();
        for (Direction direction : directions) {
            Position add = changeDirectionToPosition(direction);
            int nx = x + add.getX();
            int ny = y + add.getY();
            if (0 > nx || nx >= 8 || 0 > ny || ny >= 8) {
                throw new PieceOutOfRange(direction.toString()+" 방향으로는 " + "기물이 보드 밖으로 벗어나려고 합니다.");
            }
            if (board.getGameChess().isMyTeamHere(nx, ny, this.color)) {
                throw new SameTeamHere(direction.toString() + " 방향으로는 동일 팀 기물이 존재합니다.");
            }
            System.out.println(direction.toString()+" 방향으로는 이동이 가능합니다.");
        }

    }
}
