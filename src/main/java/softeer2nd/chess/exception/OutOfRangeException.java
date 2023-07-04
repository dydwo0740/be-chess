package softeer2nd.chess.exception;

public class OutOfRangeException extends RuntimeException {
    public OutOfRangeException() {
    }

    public OutOfRangeException(String message) {
        super(message);
    }

    public OutOfRangeException(String message, Throwable cause) {
        super(message, cause);
    }

    public OutOfRangeException(Throwable cause) {
        super(cause);
    }

    public OutOfRangeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
