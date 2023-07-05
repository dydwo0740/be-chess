package softeer2nd.chess.pieces;


import softeer2nd.utils.StringUtils;

import static softeer2nd.utils.StringUtils.*;

public class Piece {
    private String color;

    private String name;

    private char representation;


    private Piece(String color) {
        this.color = color;
    }

    private Piece(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    private Piece(String color, String name, char representation) {
        this.color = color;
        this.name = name;
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
    }

    public String getColor() {
        return color;
    }

    public String getName() {
        return name;
    }

    public static Piece createWhitePawn(){
        //굳이 매개변수로 색깔을 넘겨줄 필요가 없다.
        // whitePawn이라고 명시되어있기 때문입니다.
        Piece piece = new Piece(WHITE,PAWN_NAME, WHITE_PAWN);
        return piece;
    }

    public static Piece createBlackPawn(){
        Piece piece = new Piece(BLACK, PAWN_NAME, BLACK_PAWN);
        return piece;
    }

    public static Piece createEmptyPawn(){
        Piece piece = new Piece(EMPTY, EMPTY, EMPTY_REPRESENTATION);
        return piece;
    }

    public static Piece createWhiteKnight(){
        return new Piece(WHITE, KNIGHT_NAME, WHITE_KNIGHT);
    }

    public static Piece createBlackKnight(){
        return new Piece(BLACK, KNIGHT_NAME, BLACK_KNIGHT);
    }

    public static Piece createWhiteRook(){
        return new Piece(WHITE, ROOK_NAME, WHITE_ROOK);
    }
    public static Piece createBlackRook(){
        return new Piece(BLACK, ROOK_NAME, BLACK_ROOK);
    }
    public static Piece createWhiteBishop(){
        return new Piece(WHITE, BISHOP_NAME, WHITE_BISHOP);
    }
    public static Piece createBlackBishop(){
        return new Piece(BLACK, BISHOP_NAME, BLACK_BISHOP);
    }
    public static Piece createWhiteQueen(){
        return new Piece(WHITE, QUEEN_NAME, WHITE_QUEEN);
    }
    public static Piece createBlackQueen(){
        return new Piece(BLACK, QUEEN_NAME, BLACK_QUEEN);
    }
    public static Piece createWhiteKing(){
        return new Piece(WHITE, KING_NAME, WHITE_KING);
    }
    public static Piece createBlackKing(){
        return new Piece(BLACK, KING_NAME, BLACK_KING);
    }

    public boolean isBlack() {

        return this.color.equals(BLACK) ? true : false;
    }

    public boolean isWhite() {
        return this.color.equals(WHITE) ? true : false;
    }
}
