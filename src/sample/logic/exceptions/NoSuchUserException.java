package sample.logic.exceptions;

public class NoSuchUserException extends Exception {

    public NoSuchUserException() {
        super("No Such User");
    }
}
