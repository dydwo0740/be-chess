package softeer2nd.chess.pieces.piecetype;

import java.util.Objects;

import static softeer2nd.chess.pieces.piecetype.Piece.Color.*;

public class Piece {

    protected Color color;
    protected Type type;
    protected char representation;

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

        public char getRepresentation() {
            return representation;
        }

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

    public void changeAttribute(Piece piece){
        this.color = piece.getColor();
        this.type = piece.getType();
        this.representation = piece.getRepresentation();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Piece piece = (Piece) o;
        return color == piece.color && type == piece.type;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, type);
    }

}
