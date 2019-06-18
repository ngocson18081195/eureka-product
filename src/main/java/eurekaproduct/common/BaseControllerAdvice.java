package eurekaproduct.common;

import eurekaproduct.exception.NotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

public class BaseControllerAdvice {

    @ExceptionHandler({ NotFoundException.class })
    public final Response handleException(Exception ex, WebRequest request) {
        // fixme --- Temporary implementation
        return Response.Builder.buildError(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

