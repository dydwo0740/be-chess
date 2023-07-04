package softeer2nd.chess.pieces;


public class Piece {
    private String color;

    private String name;

    private char representation;



    public static final String WHITE = "White";
    public static final String BLACK = "Black";

    public static final String EMPTY = "Empty";

    public static final char WHITE_REPRESENTATION = 'p';

    public static final char BLACK_REPRESENTATION = 'P';

    public static final char EMPTY_REPRESENTATION = '.';



    private Piece() {
    }

    private Piece(String color) {
        this.color = color;
    }

    private Piece(String color, char representation) {
        this.color = color;
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
        Piece piece = new Piece(Piece.WHITE, Piece.WHITE_REPRESENTATION);
        return piece;
    }

    public static Piece createBlackPawn(){
        Piece piece = new Piece(Piece.BLACK, Piece.BLACK_REPRESENTATION);
        return piece;
    }

    public static Piece createEmptyPawn(){
        Piece piece = new Piece(Piece.EMPTY, Piece.EMPTY_REPRESENTATION);
        return piece;
    }
}
