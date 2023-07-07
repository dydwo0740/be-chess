package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.Board;
import softeer2nd.chess.exception.NotProperType;
import softeer2nd.chess.pieces.Position;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static softeer2nd.chess.pieces.piecetype.Bishop.*;
import static softeer2nd.chess.pieces.piecetype.King.*;
import static softeer2nd.chess.pieces.piecetype.Knight.*;
import static softeer2nd.chess.pieces.piecetype.Pawn.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.Queen.*;
import static softeer2nd.chess.pieces.piecetype.Rook.*;

public abstract class Piece{
    protected List<Direction> directions = new ArrayList<>();
    protected Color color;
    protected Type type;
    protected char representation;
    public enum Color{
        BLACK, WHITE, NOCOLOR;
    }
    protected Piece(List<Direction> directions, Color color, Type type) {
        this.directions.addAll(directions);
        this.color = color;
        this.type = type;
        if (color.equals(WHITE)) {
            this.representation = type.getWhiteRepresentation();
        } else if(color.equals(BLACK)){
            this.representation = type.getBlackRepresentation();
        }else{
            this.representation = type.getRepresentation();
        }
    }
    public Color getColor() {
        return color;
    }
    public Type getType() {
        return type;
    }
    public char getRepresentation() {
        return representation;
    }
    public List<Direction> getDirections() {
        return directions;
    }
    public boolean isWhite(){
        return color.equals(WHITE);
    }
    public boolean isBlack(){
        return color.equals(BLACK);
    }
    public abstract boolean verifyMovePosition(Position start,Position end, Board board);
    public Position changeDirectionToPosition(Direction direction) {
        return new Position(-direction.getYDegree(), direction.getXDegree());
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return representation == piece.representation && color == piece.color && type == piece.type;
    }
    @Override
    public int hashCode() {
        return Objects.hash(color, type, representation);
    }
}
