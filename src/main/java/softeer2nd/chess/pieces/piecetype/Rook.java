package softeer2nd.chess.pieces.piecetype;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class Rook extends Piece {
    private Rook(Color color) {
       super(color, ROOK);
    }

    public static Piece createWhiteRook(){
        return new Rook(WHITE);
    }
    public static Piece createBlackRook(){
        return new Rook(BLACK);
    }
}
