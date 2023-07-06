package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Knight extends Piece {
    public Knight(Color color) {
        this.color = color;
        this.type = KNIGHT;
        if (color.equals(WHITE)) {
            this.representation = KNIGHT.getWhiteRepresentation();
        } else {
            this.representation = KNIGHT.getBlackRepresentation();
        }
    }
}
