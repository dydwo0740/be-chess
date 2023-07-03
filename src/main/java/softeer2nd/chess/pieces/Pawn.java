package softeer2nd.chess.pieces;


public class Pawn {
    private String color;

    public static final String WHITE = "White";
    public static final String BLACK = "Black";


    public Pawn() {
        this.color = WHITE;
    }

    public Pawn(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
