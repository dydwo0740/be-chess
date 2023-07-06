package softeer2nd.chess.pieces.piecetype;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Type.*;

public class Empty extends Piece {
    private Empty(Color color) {
        super(color, NO_PIECE);
    }

    public static Piece createBlank(){
        return new Empty(NOCOLOR);
    }

}
