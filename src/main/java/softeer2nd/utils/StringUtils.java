package softeer2nd.utils;

public class StringUtils {
    public static final String NEWLINE = System.lineSeparator();

    public static final String WHITE = "White";
    public static final String BLACK = "Black";

    public static final String EMPTY = "Empty";

    public static final char WHITE_PAWN = 'p';

    public static final char BLACK_PAWN = 'P';

    public static final char EMPTY_REPRESENTATION = '.';

    public static final String PAWN_NAME = "pawn";

    public static final String KNIGHT_NAME = "knight";
    public static final char WHITE_KNIGHT = 'n';
    public static final char BLACK_KNIGHT = 'N';
    public static final String ROOK_NAME = "rook";
    public static final char WHITE_ROOK = 'r';
    public static final char BLACK_ROOK = 'R';
    public static final String BISHOP_NAME = "bishop";
    public static final char WHITE_BISHOP = 'b';
    public static final char BLACK_BISHOP = 'B';
    public static final String QUEEN_NAME = "queen";
    public static final char WHITE_QUEEN = 'q';
    public static final char BLACK_QUEEN = 'Q';
    public static final String KING_NAME = "king";
    public static final char WHITE_KING = 'k';
    public static final char BLACK_KING = 'K';



    private StringUtils() {
    }

    public static String appendNewLine(String str) {
        return str + NEWLINE;
    }
}
