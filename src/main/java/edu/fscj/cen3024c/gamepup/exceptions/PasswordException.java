package edu.fscj.cen3024c.gamepup.exceptions;

import org.apache.coyote.BadRequestException;

public class PasswordException extends BadRequestException {
    public PasswordException() {
        super();
    }

    public PasswordException(String message) {
        super(message);
    }

    public PasswordException(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordException(Throwable cause) {
        super(cause);
    }
}
