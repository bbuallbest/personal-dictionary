package rest.api.config;

import org.glassfish.jersey.server.ResourceConfig;
import rest.api.filter.CharsetResponseFilter;

import javax.ws.rs.ApplicationPath;

/**
 * @author bbuallbest
 */
@ApplicationPath("/api/rest")
public class RestApi extends ResourceConfig {

    public RestApi() {
        packages("rest.api.resource");
        packages("rest.api.exception");

        register(CharsetResponseFilter.class);
    }

}
