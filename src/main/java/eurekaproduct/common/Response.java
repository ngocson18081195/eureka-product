package eurekaproduct.common;

public class Response {

    private Object data;

    public static final class Builder {

        public static Response buildSuccess(Object data) {
            Response response = new Response();
            response.data = data;
            return response;
        }
    }
}
