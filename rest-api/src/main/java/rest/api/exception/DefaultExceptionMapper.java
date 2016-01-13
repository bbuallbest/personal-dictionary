package rest.api.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 * @author bbuallbest
 */
@Provider
public class DefaultExceptionMapper implements ExceptionMapper<Exception> {

    public Response toResponse(Exception e) {
        return Response
                .status(Response.Status.INTERNAL_SERVER_ERROR)
                .entity("{\"status\":500,\"message\":\"" + e.getMessage() + "\"}")
                .build();
    }

}
