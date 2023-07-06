package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Pawn extends Piece {

    public Pawn(Color color) {
        this.color = color;
        this.type = PAWN;
        if (color.equals(WHITE)) {
            this.representation = PAWN.getWhiteRepresentation();
        } else {
            this.representation = PAWN.getBlackRepresentation();
        }
    }
}
