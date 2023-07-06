package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Pawn implements Piece {

    private Color color;

    private Type type = PAWN;

    private char representation;

    public Pawn(Color color) {
        this.color = color;
        if (color.equals(WHITE)) {
            this.representation = PAWN.getWhiteRepresentation();
        }else{
            this.representation = PAWN.getBlackRepresentation();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pawn pawn = (Pawn) o;
        return representation == pawn.representation && color == pawn.color && type == pawn.type;
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
