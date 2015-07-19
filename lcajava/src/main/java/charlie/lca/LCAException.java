package charlie.lca;

/**
 * Created by ezhayog on 7/17/2015.
 */
public class LCAException  extends Exception{

    public LCAException(String message) {
        super(message);
    }

    public LCAException(String message, Throwable cause) {
        super(message, cause);
    }

    public LCAException(Throwable cause) {
        super(cause);
    }

    public LCAException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
