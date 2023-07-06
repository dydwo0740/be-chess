package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.BISHOP;

public class Bishop implements Piece {
    private Color color;

    private Type type = BISHOP;

    private char representation;

    public Bishop(Color color) {
        this.color = color;
        if (color.equals(WHITE)) {
            this.representation = BISHOP.getWhiteRepresentation();
        } else {
            this.representation = BISHOP.getBlackRepresentation();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bishop bishop = (Bishop) o;
        return representation == bishop.representation && color == bishop.color && type == bishop.type;
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
