package rest.api.resource;

import entity.Word;
import org.hibernate.persister.entity.Loadable;
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
//    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {

        if (new Long(55).equals(id)) {
            throw new RuntimeException("Word is eq to 55");
        }

        Word entity = wordRepository.findById(id);
        String result;
        if (entity != null) {
            result = "{\"id\":" + entity.getId() +
                    ",\"source\":" + entity.getSource() +
                    ",\"translation\":" + entity.getTranslation() + "}";
        } else {
            result = "{\"entity\":\"not found\"}";
        }
        return Response
                .status(Response.Status.OK)
                .entity(result)
                .build();
    }

    @GET
    @Path("/{id}/new")
//    @Produces(MediaType.APPLICATION_JSON)
    public Response createNew(@PathParam("id") Long id) {
        wordRepository.createNew(id);

        return Response
                .status(Response.Status.OK)
                .entity("{\"isCreated\":\"true\"}")
                .build();
    }

}
