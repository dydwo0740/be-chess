package softeer2nd.chess.pieces.piecetype;


import static softeer2nd.chess.pieces.piecetype.Piece.Color.NOCOLOR;
import static softeer2nd.chess.pieces.piecetype.enumutils.Direction.blankDirection;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.NO_PIECE;

public class Blank extends Piece {
    private Blank(Color color) {
        super(blankDirection(), color, NO_PIECE);
    }

    public static Piece createBlank() {
        return new Blank(NOCOLOR);
    }


    @Override
    public boolean isRecursion() {
        return false;
    }
}
