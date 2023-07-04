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
        Piece piece = new Piece(WHITE, WHITE_PAWN);
        return piece;
    }

    public static Piece createBlackPawn(){
        Piece piece = new Piece(BLACK, BLACK_PAWN);
        return piece;
    }

    public static Piece createEmptyPawn(){
        Piece piece = new Piece(EMPTY, EMPTY_REPRESENTATION);
        return piece;
    }

    public static Piece createdWhiteKnight(){
        return new Piece(WHITE, KNIGHT_NAME, WHITE_KNIGHT);
    }

    public static Piece createdBlackKnight(){
        return new Piece(BLACK, KNIGHT_NAME, BLACK_KNIGHT);
    }
}
