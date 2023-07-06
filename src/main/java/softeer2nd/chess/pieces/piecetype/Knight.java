package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Chess;

import java.util.Objects;

import static softeer2nd.chess.pieces.Chess.Color.WHITE;
import static softeer2nd.chess.pieces.Chess.Type.*;

public class Knight implements Chess {
    private Color color;

    private Type type = KNIGHT;

    private char representation;

    public Knight(Color color) {
        this.color = color;
        if (color.equals(WHITE)) {
            this.representation = KNIGHT.getWhiteRepresentation();
        } else {
            this.representation = KNIGHT.getBlackRepresentation();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Knight knight = (Knight) o;
        return representation == knight.representation && color == knight.color && type == knight.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type, representation);
    }
}
