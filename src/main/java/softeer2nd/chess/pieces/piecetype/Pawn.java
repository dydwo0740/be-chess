package softeer2nd.chess.pieces.piecetype;


import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;

import java.util.List;

import static softeer2nd.chess.Board.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class Pawn extends Piece {

    Pawn(Color color, List<Direction> directions) {
        super(directions, color, PAWN);
    }
    private boolean flag;
    @Override
    public boolean verifyMovePosition(Position position, Position end, GameChess gameChess) {
        int beforeX = position.getX();
        int beforeY = position.getY();
        int endX = end.getX();
        int endY = end.getY();
        flag = false;
        for(int i=0;i<3;i++){
            Position add = directionToPosition(directions.get(i));
            int afterX = beforeX + add.getX();
            int afterY = beforeY + add.getY();
            if (!isInBoardRange(afterX, afterY) || gameChess.isMyTeamHere(afterX, afterY, this.color)) {
                continue;
            }
            if(i == 0){
                if(endX == afterX && endY == afterY && gameChess.isBlankPiece(afterX, afterY)) {
                    flag = true;
                }
            }else{
                if(endX == afterX && endY == afterY){
                    flag = true;
                }
            }
        }
        return flag;

    }
}
