package softeer2nd.utils;

public class StringUtils {
    public static final String NEWLINE = System.lineSeparator();

    private StringUtils() {
    }

    public String appendNewLine(String str) {
        return str + NEWLINE;
    }
}
