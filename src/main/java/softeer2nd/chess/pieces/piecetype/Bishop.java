package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.BISHOP;

public class Bishop extends Piece {
    public Bishop(Color color) {
        this.color = color;
        this.type = BISHOP;
        if (color.equals(WHITE)) {
            this.representation = BISHOP.getWhiteRepresentation();
        } else {
            this.representation = BISHOP.getBlackRepresentation();
        }
    }
}
