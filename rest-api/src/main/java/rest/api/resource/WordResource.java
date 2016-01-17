package rest.api.resource;

import entity.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import repository.WordRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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

        if (new Long(77).equals(id)) {
            id = null;
        }

        return wordRepository.findById(id);
    }

    @GET
    @Path("/{id}/new")
    public Word createNew(@PathParam("id") Long id,
                              @QueryParam("source") String source,
                              @QueryParam("translation") String translation) {
        Word word = Word.builder()
                .id(id)
                .source(source)
                .translation(translation)
                .build();

        wordRepository.create(word);

        return word;
    }

}
