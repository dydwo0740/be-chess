package softeer2nd.chess.pieces.piecetype;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.enumutils.Type.*;

public class Knight extends Piece {
    private Knight(Color color) {
        super(color, KNIGHT);
    }
    public static Piece createWhiteKnight(){
        return new Knight(WHITE);
    }

    public static Piece createBlackKnight(){
        return new Knight(BLACK);
    }
}
