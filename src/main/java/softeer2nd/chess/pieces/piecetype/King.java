package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class King extends Piece {
    public King(Color color) {
        this.color = color;
        this.type = KING;
        if (color.equals(WHITE)) {
            this.representation = KING.getWhiteRepresentation();
        } else {
            this.representation = KING.getBlackRepresentation();
        }
    }
}
