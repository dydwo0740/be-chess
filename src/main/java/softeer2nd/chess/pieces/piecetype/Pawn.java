package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.Board;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;

import java.util.List;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class Pawn extends Piece {

    Pawn(Color color, List<Direction> directions) {
        super(directions, color, PAWN);
    }
    private boolean flag;
    @Override
    public boolean verifyMovePosition(Position position, Position end,  Board board) {
        int x = position.getX();
        int y = position.getY();
        int endX = end.getX();
        int endY = end.getY();
        flag = false;
        for(int i=0;i<3;i++){
            Position add = changeDirectionToPosition(directions.get(i));
            int nx = x + add.getX();
            int ny = y + add.getY();
            if (0 > nx || nx >= 8 || 0 > ny || ny >= 8 || board.getGameChess().isMyTeamHere(nx, ny, this.color)) {
                continue;
            }
            if(i == 0){
                if(endX == nx && endY == ny && board.getGameChess().isBlankPiece(nx, ny)) {
                    flag = true;
                }
            }else{
                if(endX == nx && endY == ny){
                    flag = true;
                }
            }
        }
        return flag;

    }
}
