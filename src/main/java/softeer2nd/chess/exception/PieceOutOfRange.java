package softeer2nd.chess.exception;

public class PieceOutOfRange extends RuntimeException {
    public PieceOutOfRange() {
    }

    public PieceOutOfRange(String message) {
        super(message);
    }

    public PieceOutOfRange(String message, Throwable cause) {
        super(message, cause);
    }

    public PieceOutOfRange(Throwable cause) {
        super(cause);
    }

    public PieceOutOfRange(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
