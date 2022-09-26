package examples.unit08.util.exceptions;

/**
 *
 * @Author German Carreño
 */
public class InsufficientMoneyException extends RuntimeException {
    public InsufficientMoneyException(String message) {
        super(message);
    }
}
