package net.golovach.dao.exception;

public class NotUniqueUserLoginException extends DBException {

    public NotUniqueUserLoginException(String message) {
        super(message);
    }

    public NotUniqueUserLoginException(String message, Throwable cause) {
        super(message, cause);
    }
}
