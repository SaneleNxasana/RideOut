package backend.repositories;

import backend.domain.System;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
@Repository
public interface SystemRepository extends CrudRepository<System, Long> {
}
