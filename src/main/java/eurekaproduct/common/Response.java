package eurekaproduct.common;

import org.springframework.http.HttpStatus;

public class Response {

    private Object data;

    private String message;

    private HttpStatus httpStatus;

    public static final class Builder {

        public static Response buildSuccess(Object data) {
            Response response = new Response();
            response.data = data;
            response.message = "Success";
            response.httpStatus = HttpStatus.OK;
            return response;
        }

        public static Response buildError(String message, HttpStatus httpStatus) {
            Response response = new Response();
            response.data = null;
            response.message = message;
            response.httpStatus = httpStatus;
            return response;
        }
    }
}
