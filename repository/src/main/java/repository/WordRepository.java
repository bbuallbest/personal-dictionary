package repository;

import com.google.common.base.Preconditions;
import entity.Word;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import repository.util.ValidationMessage;

/**
 * @author bbuallbest
 */
// TODO: remove Transaction management from this layer..
@Repository
public class WordRepository {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional(propagation = Propagation.REQUIRED)
    public Word findById(Long id) {
        Preconditions.checkNotNull(id, ValidationMessage.CANT_FIND_OBJECT_BY_NULL_ID);
        return (Word) sessionFactory
                .getCurrentSession()
                    .get(Word.class, id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void create(Word word) {
        Preconditions.checkNotNull(word, ValidationMessage.CANT_PERSIST_NULLABLE_ENTITY);
        sessionFactory
                .getCurrentSession()
                    .persist(word);
    }

}
