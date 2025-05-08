package Library;

public class ApiException extends RuntimeException {
    // Constructor que recibe un mensaje de error
    public ApiException(String message) {
        super(message);
    }

    // Constructor que recibe un mensaje de error y la causa
    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }
}
