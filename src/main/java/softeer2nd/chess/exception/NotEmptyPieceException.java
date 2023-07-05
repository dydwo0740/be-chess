package softeer2nd.chess.exception;

public class NotEmptyPieceException extends RuntimeException{
    public NotEmptyPieceException() {
    }

    public NotEmptyPieceException(String message) {
        super(message);
    }

    public NotEmptyPieceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotEmptyPieceException(Throwable cause) {
        super(cause);
    }

    public NotEmptyPieceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
