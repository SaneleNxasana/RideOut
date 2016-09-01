package backend.services;

import java.util.Set;

/**
 * Created by NXA-C.unltd on 2016/08/25.
 */
public interface Service <E, ID> {

    E create(E entity);

    E readById(ID id);

    Set<E> readAll();

    E update(E entity);

    void delete(E entity);
}
