package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Rook extends Piece {
    public Rook(Color color) {
        this.color = color;
        this.type = ROOK;
        if (color.equals(WHITE)) {
            this.representation = ROOK.getWhiteRepresentation();
        } else {
            this.representation = ROOK.getBlackRepresentation();
        }
    }
}
