package softeer2nd.chess.pieces;


public class Pawn {
    private String color;

    private char representation;



    public static final String WHITE = "White";
    public static final String BLACK = "Black";

    public static final char WHITE_REPRESENTATION = 'p';

    public static final char BLACK_REPRESENTATION = 'P';



    public Pawn() {
        this.color = WHITE;
        this.representation = WHITE_REPRESENTATION;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public Pawn(String color, char representation) {
        this.color = color;
        this.representation = representation;
    }

    public char getRepresentation() {
        return representation;
    }

    public String getColor() {
        return color;
    }

}
