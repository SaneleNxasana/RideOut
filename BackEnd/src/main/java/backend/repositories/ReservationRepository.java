package backend.repositories;

import backend.domain.Reservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
@Repository
public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
