package util.Pilhas;

public class PilhaCheiaException extends RuntimeException{

    public PilhaCheiaException() {
    }

    public PilhaCheiaException(String message) {
        super(message);
    }

    public PilhaCheiaException(String message, Throwable cause) {
        super(message, cause);
    }

    public PilhaCheiaException(Throwable cause) {
        super(cause);
    }

    public PilhaCheiaException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
   
}
