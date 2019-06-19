package eurekaproduct.exception;

import lombok.Getter;

public class UnknownException extends RuntimeException {

    private static final long serialVersionUID = 4267539611475873037L;

    @Getter
    private final String message;

    public UnknownException(String message) {
        this.message = message;
    }
}
