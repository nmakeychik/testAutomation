package by.bsu.testcases.exception.copy;

public class TriangleException extends RuntimeException {

    private static final long serialVersionUID = 4004529439014888550L;

    public TriangleException() {
        super();
    }

    public TriangleException(String message, Throwable cause) {
        super(message, cause);
    }

    public TriangleException(String message) {
        super(message);
    }

    public TriangleException(Throwable cause) {
        super(cause);
    }
}
