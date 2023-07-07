package softeer2nd.chess.pieces.piecetype;

import softeer2nd.chess.exception.NotProperType;
import softeer2nd.chess.pieces.piecetype.enumutils.Direction;
import softeer2nd.chess.pieces.piecetype.enumutils.Type;

import java.util.Objects;

import static softeer2nd.chess.pieces.piecetype.Bishop.*;
import static softeer2nd.chess.pieces.piecetype.King.*;
import static softeer2nd.chess.pieces.piecetype.Knight.*;
import static softeer2nd.chess.pieces.piecetype.Pawn.*;
import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;
import static softeer2nd.chess.pieces.piecetype.Queen.*;
import static softeer2nd.chess.pieces.piecetype.Rook.*;

public class Piece{
    protected Direction direction;
    protected Color color;
    protected Type type;
    protected char representation;

    public enum Color{
        BLACK, WHITE, NOCOLOR;
    }

    public Piece(Color color, Type type) {
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
    public static Piece createWhite(Type type) {
        switch (type){
            case PAWN:
                return createWhitePawn();
            case KNIGHT:
                return createWhiteKnight();
            case ROOK:
                return createWhiteRook();
            case KING:
                return createWhiteKing();
            case QUEEN:
                return createWhiteQueen();
            case BISHOP:
                return createWhiteBishop();
            default:
                throw new NotProperType("올바르지 않은 타입의 기물입니다.");
        }
    }
    public static Piece createBlack(Type type) {
        switch (type){
            case PAWN:
                return createBlackPawn();
            case KNIGHT:
                return createBlackKnight();
            case ROOK:
                return createBlackRook();
            case KING:
                return createBlackKing();
            case QUEEN:
                return createBlackQueen();
            case BISHOP:
                return createBlackBishop();
            default:
                throw new NotProperType("올바르지 않은 타입의 기물입니다.");
        }
    }

    public static Piece createBlank(){
        return Blank.createBlank();
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

    public boolean isWhite(){
        if(color.equals(WHITE)){
            return true;
        }
        return false;
    }

    public boolean isBlack(){
        if(color.equals(BLACK)){
            return true;
        }
        return false;
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
