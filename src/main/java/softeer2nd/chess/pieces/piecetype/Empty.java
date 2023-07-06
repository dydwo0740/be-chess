package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Chess;

import java.util.Objects;

import static softeer2nd.chess.pieces.Chess.Color.WHITE;
import static softeer2nd.chess.pieces.Chess.Type.*;

public class Empty implements Chess {
    private Color color;

    private Type type = NO_PIECE;

    private char representation;

    public Empty(Color color) {
        this.color = color;
        this.representation = type.getRepresentation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Empty empty = (Empty) o;
        return representation == empty.representation && color == empty.color && type == empty.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, representation);
    }
}
