package am.hay.cc.exception;

public class PersistFailureException extends RuntimeException {

    public PersistFailureException() {
    }

    public PersistFailureException(String message) {
        super(message);
    }

    public PersistFailureException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersistFailureException(Throwable cause) {
        super(cause);
    }

    protected PersistFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
