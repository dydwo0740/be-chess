package softeer2nd.chess.exception;

public class NoPieceException extends RuntimeException{
    public NoPieceException() {
    }

    public NoPieceException(String message) {
        super(message);
    }

    public NoPieceException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoPieceException(Throwable cause) {
        super(cause);
    }

    public NoPieceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
