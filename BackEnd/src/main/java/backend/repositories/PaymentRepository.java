package backend.repositories;

import backend.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by NXA-C.unltd on 2016/08/25.
 */
@Repository
public interface PaymentRepository extends CrudRepository<Payment, Long> {
}
