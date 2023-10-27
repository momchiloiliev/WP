package mk.ukim.finki.wp.lab1_nova.model.exceptions;

public class PasswordsDoNotMatchException extends RuntimeException {
    public PasswordsDoNotMatchException() {
        super("Passwords do not match exceotion");
    }
}
