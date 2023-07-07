package softeer2nd.chess.exception;

public class SamePosition extends RuntimeException {
    public SamePosition() {
    }

    public SamePosition(String message) {
        super(message);
    }

    public SamePosition(String message, Throwable cause) {
        super(message, cause);
    }

    public SamePosition(Throwable cause) {
        super(cause);
    }

    public SamePosition(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
