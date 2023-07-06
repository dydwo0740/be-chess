package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Chess;

import java.util.Objects;

import static softeer2nd.chess.pieces.Chess.Color.WHITE;
import static softeer2nd.chess.pieces.Chess.Type.*;

public class Queen implements Chess {
    private Color color;

    private Type type = QUEEN;

    private char representation;

    public Queen(Color color) {
        this.color = color;
        if (color.equals(WHITE)) {
            this.representation = QUEEN.getWhiteRepresentation();
        } else {
            this.representation = QUEEN.getBlackRepresentation();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Queen queen = (Queen) o;
        return representation == queen.representation && color == queen.color && type == queen.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, representation);
    }
}
