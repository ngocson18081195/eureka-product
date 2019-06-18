package eurekaproduct.common;

import eurekaproduct.exception.NotFoundException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class BaseControllerAdvice {

    @ExceptionHandler({ NotFoundException.class })
    public final Response handleException(Exception ex, WebRequest request) {
        // fixme --- Temporary implement
        // still not working yet
        return Response.Builder.buildInternalServerError(ex.getMessage());
    }
}

