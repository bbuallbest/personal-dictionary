package repository.util;

/**
 * @author bbuallbest
 */
public interface ValidationMessage {

    String CANT_FIND_OBJECT_BY_NULL_ID = "Can't find object by id, because id is null!";
    String CANT_PERSIST_NULLABLE_ENTITY = "Can't persist entity, because it's null!";

}
