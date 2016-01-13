package repository;

import entity.Word;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author bbuallbest
 */
@Component
public class WordRepository {

    @Autowired
    private SessionFactory sessionFactory;

    public Word findById(Long id) {
        if (id == null) {
            throw new IllegalArgumentException("Can't find Word by id, because id is null!");
        }
        return (Word) sessionFactory.openSession().get(Word.class, id);
    }

    public void createNew(Long id) {
        Word word = new Word();
        word.setId(id);
        word.setSource("successfully");
        word.setTranslation("успешно");

        Session session = sessionFactory.openSession();
        session.persist(word);
        session.flush();
    }
}
