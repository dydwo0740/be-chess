package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.Board;
import softeer2nd.chess.exception.PieceOutOfRange;
import softeer2nd.chess.exception.SameTeamHere;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class Queen extends Piece {
    public Queen(Color color) {
        super(everyDirection(), color, QUEEN);
    }
    public static Piece createWhiteQueen(){
        return new Queen(WHITE);
    }
    public static Piece createBlackQueen(){
        return new Queen(BLACK);
    }


    @Override
    public void verifyMovePosition(Position position, Board board) {
    }

    public void checkMove(int depth, Direction direction, int x, int y, Board board){
        if (0 > x || x >= 8 || 0 > y || y >= 8) {
            throw new PieceOutOfRange(direction.toString()+" 방향으로는 " + "기물이 보드 밖으로 벗어나려고 합니다.");
        }
        if (board.getGameChess().isMyTeamHere(x, y, this.color)) {
            throw new SameTeamHere(direction.toString() + " 방향으로는 동일 팀 기물이 존재합니다.");
        }
    }
}
