package errorAndExceptions.exceptions;

public class UniversityHasNoDepartmentsException extends RuntimeException{
    public UniversityHasNoDepartmentsException(String message) {
        super(message);
    }
}
