package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.pieces.Piece;

import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.WHITE;
import static softeer2nd.chess.pieces.Piece.Type.*;

public class Empty extends Piece {
    public Empty(Color color) {
        this.color = color;
        this.type = NO_PIECE;
        representation = NO_PIECE.getRepresentation();
    }
}
