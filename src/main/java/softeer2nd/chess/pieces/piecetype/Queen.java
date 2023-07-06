package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Queen extends Piece {
    public Queen(Color color) {
        this.color = color;
        this.type = QUEEN;
        if (color.equals(WHITE)) {
            this.representation = QUEEN.getWhiteRepresentation();
        } else {
            this.representation = QUEEN.getBlackRepresentation();
        }
    }
}
