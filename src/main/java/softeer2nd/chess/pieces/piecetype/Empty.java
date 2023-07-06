package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Empty implements Piece {
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
    @Override
    public boolean isWhite() {
        return false;
    }

    @Override
    public boolean isBlack() {
        return false;
    }
    @Override
    public void changeAttribute(Piece p) {
        this.color = p.getColor();
        this.type = p.getType();
        this.representation = p.getRepresentation();
    }
}
