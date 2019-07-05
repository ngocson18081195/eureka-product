package rio.unknown.common;

import rio.unknown.exception.UnknownException;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

public class BaseControllerAdvice {

    @ExceptionHandler({UnknownException.class})
    @ResponseBody
    public final Response handleException(Exception ex) {
        // fixme --- implement temporarily
        if (ex instanceof UnknownException) {
            UnknownException nfe = (UnknownException) ex;
            return Response.Builder.buildInternalServerError(nfe.getMessage());
        }
        return Response.Builder.buildInternalServerError(ex.getMessage());
    }
}

