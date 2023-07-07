package softeer2nd.chess.exception;

public class NotProperType extends RuntimeException{
    public NotProperType() {
    }

    public NotProperType(String message) {
        super(message);
    }

    public NotProperType(String message, Throwable cause) {
        super(message, cause);
    }

    public NotProperType(Throwable cause) {
        super(cause);
    }

    public NotProperType(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
