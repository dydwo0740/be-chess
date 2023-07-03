package softeer2nd.chess.pieces;

import static softeer2nd.chess.Color.*;

public class Pawn {
    private String color;


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
