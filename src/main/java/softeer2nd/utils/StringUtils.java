package softeer2nd.utils;

public class StringUtils {
    public static final String NEWLINE = System.lineSeparator();



    public static final String EMPTY = "Empty";


    public static final String PAWN_NAME = "pawn";

    public static final String KNIGHT_NAME = "knight";

    public static final String ROOK_NAME = "rook";

    public static final String BISHOP_NAME = "bishop";

    public static final String QUEEN_NAME = "queen";

    public static final String KING_NAME = "king";



    private StringUtils() {
    }

    public static String appendNewLine(String str) {
        return str + NEWLINE;
    }
}
