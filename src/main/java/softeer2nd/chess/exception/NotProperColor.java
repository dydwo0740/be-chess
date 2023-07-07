package softeer2nd.chess.exception;

public class NotProperColor extends RuntimeException{
    public NotProperColor() {
    }

    public NotProperColor(String message) {
        super(message);
    }

    public NotProperColor(String message, Throwable cause) {
        super(message, cause);
    }

    public NotProperColor(Throwable cause) {
        super(cause);
    }

    public NotProperColor(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
