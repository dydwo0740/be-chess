package softeer2nd.chess.exception;

public class NeverReach extends RuntimeException {
    public NeverReach() {
    }

    public NeverReach(String message) {
        super(message);
    }

    public NeverReach(String message, Throwable cause) {
        super(message, cause);
    }

    public NeverReach(Throwable cause) {
        super(cause);
    }

    public NeverReach(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
