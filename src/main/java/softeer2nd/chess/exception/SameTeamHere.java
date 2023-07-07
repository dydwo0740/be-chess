package softeer2nd.chess.exception;

public class SameTeamHere extends RuntimeException {
    public SameTeamHere() {
    }

    public SameTeamHere(String message) {
        super(message);
    }

    public SameTeamHere(String message, Throwable cause) {
        super(message, cause);
    }

    public SameTeamHere(Throwable cause) {
        super(cause);
    }

    public SameTeamHere(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
