package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.Board;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class Blank extends Piece {
    private Blank(Color color) {
        super(blankDirection(), color, NO_PIECE);
    }

    public static Piece createBlank(){
        return new Blank(NOCOLOR);
    }

    @Override
    public void verifyMovePosition(Position position, Board board) {

    }

}
