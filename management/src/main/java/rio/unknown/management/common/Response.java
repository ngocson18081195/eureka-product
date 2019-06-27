package rio.unknown.management.common;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

import lombok.Data;

@Data
public class Response implements Serializable {

    private static final long serialVersionUID = -3597647861555521218L;

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

        public static Response buildInternalServerError(String message) {
            Response response = new Response();
            response.data = null;
            response.message = message;
            response.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
            return response;
        }
    }
}
