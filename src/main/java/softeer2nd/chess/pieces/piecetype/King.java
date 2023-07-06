package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class King implements Piece {
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
        return color.equals(WHITE) ? true : false;
    }

    @Override
    public boolean isBlack() {
        return !isWhite();
    }
    @Override
    public void changeAttribute(Piece p) {
        this.color = p.getColor();
        this.type = p.getType();
        this.representation = p.getRepresentation();
    }
}
