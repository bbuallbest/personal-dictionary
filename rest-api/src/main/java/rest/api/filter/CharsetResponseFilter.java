package rest.api.filter;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
/**
 * @author bbuallbest
 */
public class CharsetResponseFilter implements ContainerResponseFilter {

    private static final String UTF_8 = "utf-8";
    private static final String CONTENT_TYPE = "Content-Type";

    public void filter(ContainerRequestContext containerRequestContext, ContainerResponseContext containerResponseContext)
            throws IOException {
        MediaType mediaType = containerResponseContext.getMediaType();
        if (mediaType != null) {
            if (!mediaType.getParameters().containsKey(MediaType.CHARSET_PARAMETER)) {
                MediaType typeWithCharset = mediaType.withCharset(UTF_8);
                containerResponseContext.getHeaders().putSingle(CONTENT_TYPE, typeWithCharset);
            }
        }
    }
}
