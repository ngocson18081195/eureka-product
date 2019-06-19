package eurekaproduct.exception;

import lombok.Getter;

public class NotFoundException extends RuntimeException {

    private static final long serialVersionUID = 4267539611475873037L;

    @Getter
    private final String message;

    public NotFoundException(String message) {
        this.message = message;
    }
}
