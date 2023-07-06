package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Chess;

import java.util.Objects;

import static softeer2nd.chess.pieces.Chess.Color.*;
import static softeer2nd.chess.pieces.Chess.Type.*;

public class Pawn implements Chess {

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
}
