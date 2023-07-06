package softeer2nd.chess.pieces;

public interface Piece {
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

    Type getType();

    Color getColor();

    char getRepresentation();

    boolean isWhite();

    boolean isBlack();

    void changeAttribute(Piece p);



}
