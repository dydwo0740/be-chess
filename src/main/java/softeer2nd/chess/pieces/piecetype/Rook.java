package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Rook implements Piece {
    private Color color;

    private Type type = ROOK;

    private char representation;

    public Rook(Color color) {
        this.color = color;
        if (color.equals(WHITE)) {
            this.representation = ROOK.getWhiteRepresentation();
        } else {
            this.representation = ROOK.getBlackRepresentation();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rook rook = (Rook) o;
        return representation == rook.representation && color == rook.color && type == rook.type;
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
