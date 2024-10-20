package pos.spring.possystemmongo.exception;

public class DataPersistException extends RuntimeException {


    public DataPersistException() {
        super("Data persistence error occurred");
    }


    public DataPersistException(String message) {
        super(message);
    }


    public DataPersistException(String message, Throwable cause) {
        super(message, cause);
    }


    public DataPersistException(Throwable cause) {
        super(cause);
    }
}
