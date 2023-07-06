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

        PAWN('p', 1.0),
        ROOK('r', 5.0),
        KNIGHT('n', 2.5),
        BISHOP('b', 3.0),
        QUEEN('q', 9.0),
        KING('k', 0.0),
        NO_PIECE('.', 0.0);

        private char representation;
        private double defaultPoint;

        private Type(char representation, double defaultPoint) {
            this.representation = representation;
            this.defaultPoint = defaultPoint;
        }

        public double getDefaultPoint() {
            return defaultPoint;
        }

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



    private Piece(Color color) {
        this.color = color;
    }

    private Piece(Color color, Type type) {
        this.color = color;
        this.type = type;
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



    private static Piece createWhite(Type type) {
        switch (type){
            case PAWN:
                return new Piece(WHITE, PAWN);
            case KNIGHT:
                return new Piece(WHITE, KNIGHT);
            case ROOK:
                return new Piece(WHITE, ROOK);
            case KING:
                return new Piece(WHITE, KING);
            case QUEEN:
                return new Piece(WHITE, QUEEN);
            case BISHOP:
                return new Piece(WHITE, BISHOP);
            default:
                return new Piece(NOCOLOR, NO_PIECE);
        }
    }
    private static Piece createBlack(Type type) {
        switch (type){
            case PAWN:
                return new Piece(BLACK, PAWN);
            case KNIGHT:
                return new Piece(BLACK, KNIGHT);
            case ROOK:
                return new Piece(BLACK, ROOK);
            case KING:
                return new Piece(BLACK, KING);
            case QUEEN:
                return new Piece(BLACK, QUEEN);
            case BISHOP:
                return new Piece(BLACK, BISHOP);
            default:
                return new Piece(NOCOLOR, NO_PIECE);
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
