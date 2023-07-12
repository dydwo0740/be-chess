package softeer2nd.chess.pieces.piecetype;


import softeer2nd.chess.game.GameChess;
import softeer2nd.chess.pieces.Position;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class Blank extends Piece {
    Blank(Color color) {
        super(blankDirection(), color, NO_PIECE);
    }

    @Override
    public boolean verifyMovePosition(Position start, Position end, GameChess gameChess) {
        return true;
    }

}
