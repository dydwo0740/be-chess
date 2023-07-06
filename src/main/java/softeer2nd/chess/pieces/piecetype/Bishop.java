package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Chess;

import java.util.Objects;

import static softeer2nd.chess.pieces.Chess.Color.WHITE;
import static softeer2nd.chess.pieces.Chess.Type.BISHOP;
import static softeer2nd.chess.pieces.Chess.Type.PAWN;

public class Bishop implements Chess {
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
}
