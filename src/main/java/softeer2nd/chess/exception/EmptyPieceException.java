package softeer2nd.chess.exception;

public class EmptyPieceException extends RuntimeException{
    public EmptyPieceException() {
    }

    public EmptyPieceException(String message) {
        super(message);
    }

    public EmptyPieceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyPieceException(Throwable cause) {
        super(cause);
    }

    public EmptyPieceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
