package lsibanda.exceptions;

public class MisspelledBalloonException extends Exception {
    public MisspelledBalloonException() {}

    public MisspelledBalloonException(String message) {
        super(message);
    }
}