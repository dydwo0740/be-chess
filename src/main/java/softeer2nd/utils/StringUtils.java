package softeer2nd.utils;

public class StringUtils {
    public static final String NEWLINE = System.lineSeparator();

    public static final String WHITE = "White";
    public static final String BLACK = "Black";

    public static final String EMPTY = "Empty";

    public static final char WHITE_PAWN = 'p';

    public static final char BLACK_PAWN = 'P';

    public static final char EMPTY_REPRESENTATION = '.';

    public static final String PAWN_NAME = "Pawn";

    public static final String KNIGHT_NAME = "Knight";
    public static final char WHITE_KNIGHT = 'n';
    public static final char BLACK_KNIGHT = 'N';

    private StringUtils() {
    }

    public static String appendNewLine(String str) {
        return str + NEWLINE;
    }
}
