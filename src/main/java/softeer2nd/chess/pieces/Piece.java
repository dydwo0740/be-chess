package softeer2nd.chess.pieces;



import java.util.Objects;

import static softeer2nd.chess.pieces.Piece.Color.*;
import static softeer2nd.chess.pieces.Piece.Type.*;
import static softeer2nd.utils.StringUtils.*;

public class Piece {

    public enum Color{
        BLACK, WHITE, NOCOLOR;
    }

    public enum Type{

        PAWN('p'), KNIGHT('n'),
        ROOK('r'), BISHOP('b'),
        KING('k'), QUEEN('q'), NO_PIECE('.');
        private char representation;

        public char getWhiteRepresentation() {
            return representation;
        }

        public char getBlackRepresentation(){
            return Character.toUpperCase(representation);
        }

        private Type(char representation) {
            this.representation = representation;
        }


    }
    private Color color;

    private char representation;

    private Type type;

    private double point;


    private Piece(Color color) {
        this.color = color;
    }

    private Piece(Color color, Type type, double point) {
        this.color = color;
        this.type = type;
        this.point = point;
        if(color == WHITE){
            this.representation = type.getWhiteRepresentation();
        }else if(color == BLACK){
            this.representation = type.getBlackRepresentation();
        }else{
            this.representation = type.representation;
        }
    }

    public Color getColor() {
        return color;
    }


    public char getRepresentation() {
        return representation;
    }

    public Type getType() {
        return type;
    }

    public double getPoint() {
        return point;
    }

    private static Piece createWhite(Type type) {
        switch (type){
            case PAWN:
                return new Piece(WHITE, PAWN, 1);
            case KNIGHT:
                return new Piece(WHITE, KNIGHT, 2.5);
            case ROOK:
                return new Piece(WHITE, ROOK, 5);
            case KING:
                return new Piece(WHITE, KING, 0);
            case QUEEN:
                return new Piece(WHITE, QUEEN, 9);
            case BISHOP:
                return new Piece(WHITE, BISHOP, 3);
            default:
                return new Piece(NOCOLOR, NO_PIECE, 0);
        }
    }
    private static Piece createBlack(Type type) {
        switch (type){
            case PAWN:
                return new Piece(BLACK, PAWN, 1);
            case KNIGHT:
                return new Piece(BLACK, KNIGHT, 2.5);
            case ROOK:
                return new Piece(BLACK, ROOK, 5);
            case KING:
                return new Piece(BLACK, KING, 0);
            case QUEEN:
                return new Piece(BLACK, QUEEN, 9);
            case BISHOP:
                return new Piece(BLACK, BISHOP, 3);
            default:
                return new Piece(NOCOLOR, NO_PIECE, 0);
        }
    }


    public static Piece createWhitePawn(){
        //굳이 매개변수로 색깔을 넘겨줄 필요가 없다.
        // whitePawn이라고 명시되어있기 때문입니다.
        return createWhite(PAWN);
    }

    public static Piece createBlackPawn(){
        return createBlack(PAWN);
    }

    public static Piece createBlank(){
        return createWhite(NO_PIECE);
    }

    public static Piece createWhiteKnight(){
        return createWhite(KNIGHT);
    }

    public static Piece createBlackKnight(){
        return createBlack(KNIGHT);
    }

    public static Piece createWhiteRook(){
        return createWhite(ROOK);
    }
    public static Piece createBlackRook(){
        return createBlack(ROOK);
    }
    public static Piece createWhiteBishop(){
        return createWhite(BISHOP);
    }
    public static Piece createBlackBishop(){
        return createBlack(BISHOP);
    }
    public static Piece createWhiteQueen(){
        return createWhite(QUEEN);
    }
    public static Piece createBlackQueen(){
        return createBlack(QUEEN);
    }
    public static Piece createWhiteKing(){
        return createWhite(KING);
    }
    public static Piece createBlackKing(){
        return createBlack(KING);
    }

    public boolean isBlack() {
        if (color.equals(BLACK)) {
            return true;
        }
        return false;
    }

    public boolean isWhite() {
        if (color.equals(WHITE)) {
            return true;
        }
        return false;
    }

    public void change(Piece to) {
        type = to.type;
        color = to.color;
        representation = to.representation;
        point = to.point;
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
        return Objects.hash(color, representation, type);
    }
}
