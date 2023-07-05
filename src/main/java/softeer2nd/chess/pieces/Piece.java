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



    public static Piece createWhitePawn(){
        //굳이 매개변수로 색깔을 넘겨줄 필요가 없다.
        // whitePawn이라고 명시되어있기 때문입니다.
        Piece piece = new Piece(WHITE, PAWN);
        return piece;
    }

    public static Piece createBlackPawn(){
        Piece piece = new Piece(BLACK, PAWN);
        return piece;
    }

    public static Piece createEmptyPiece(){
        Piece piece = new Piece(NOCOLOR, NO_PIECE);
        return piece;
    }

    public static Piece createWhiteKnight(){
        return new Piece(WHITE, KNIGHT);
    }

    public static Piece createBlackKnight(){
        return new Piece(BLACK, KNIGHT);
    }

    public static Piece createWhiteRook(){
        return new Piece(WHITE, ROOK);
    }
    public static Piece createBlackRook(){
        return new Piece(BLACK, ROOK);
    }
    public static Piece createWhiteBishop(){
        return new Piece(WHITE, BISHOP);
    }
    public static Piece createBlackBishop(){
        return new Piece(BLACK, BISHOP);
    }
    public static Piece createWhiteQueen(){
        return new Piece(WHITE, QUEEN);
    }
    public static Piece createBlackQueen(){
        return new Piece(BLACK, QUEEN);
    }
    public static Piece createWhiteKing(){
        return new Piece(WHITE, KING);
    }
    public static Piece createBlackKing(){
        return new Piece(BLACK, KING);
    }

    public boolean isBlack() {
        return this.color.equals(BLACK) ? true : false;
    }

    public boolean isWhite() {
        return isBlack() ? false : true;
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
