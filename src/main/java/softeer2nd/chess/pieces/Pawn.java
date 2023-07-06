package softeer2nd.chess.pieces;

import static softeer2nd.chess.pieces.Chess.Color.*;
import static softeer2nd.chess.pieces.Chess.Type.*;

public class Pawn implements Chess{

    private Color color;

    private Type type = PAWN;

    private char representation;

    public Pawn(Color color) {
        this.color = color;
        if (color.equals(WHITE)) {
            this.representation = PAWN.getWhiteRepresentation();
        }else{
            this.representation = PAWN.getBlackRepresentation();
        }
    }
}
