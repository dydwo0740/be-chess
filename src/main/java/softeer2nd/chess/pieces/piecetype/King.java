package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Chess;

import java.util.Objects;

import static softeer2nd.chess.pieces.Chess.Color.WHITE;
import static softeer2nd.chess.pieces.Chess.Type.*;

public class King implements Chess {
    private Color color;

    private Type type = KING;

    private char representation;

    public King(Color color) {
        this.color = color;
        if (color.equals(WHITE)) {
            this.representation = KING.getWhiteRepresentation();
        } else {
            this.representation = KING.getBlackRepresentation();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        King king = (King) o;
        return representation == king.representation && color == king.color && type == king.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, representation);
    }
}
