package rest.api.resource;

import entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.WordRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author bbuallbest
 */
@Path("/word")
@Produces(MediaType.APPLICATION_JSON)
@Component
public class WordResource {

    @Autowired
    private WordRepository wordRepository;

    @GET
    @Path("/{id}")
    public Word getById(@PathParam("id") Long id) {

        if (new Long(55).equals(id)) {
            throw new RuntimeException("Word is eq to 55");
        }

        return wordRepository.findById(id);
    }

    @GET
    @Path("/{id}/new")
    public Response createNew(@PathParam("id") Long id) {
        wordRepository.createNew(id);

        return Response
                .status(Response.Status.OK)
                .entity("{\"isCreated\":\"true\"}")
                .build();
    }

}
