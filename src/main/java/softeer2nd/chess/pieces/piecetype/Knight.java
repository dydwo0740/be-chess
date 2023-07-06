package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Knight implements Piece {
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

    @Override
    public Type getType() {
        return type;
    }

    @Override
    public Color getColor() {
        return color;
    }
    @Override
    public char getRepresentation() {
        return representation;
    }
}
