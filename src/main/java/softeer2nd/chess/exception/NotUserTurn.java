package softeer2nd.chess.exception;

public class NotUserTurn extends RuntimeException {
    public NotUserTurn() {
    }

    public NotUserTurn(String message) {
        super(message);
    }

    public NotUserTurn(String message, Throwable cause) {
        super(message, cause);
    }

    public NotUserTurn(Throwable cause) {
        super(cause);
    }

    public NotUserTurn(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
