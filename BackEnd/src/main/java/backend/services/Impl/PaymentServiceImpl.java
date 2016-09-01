package backend.services.Impl;

import backend.domain.Payment;
import backend.repositories.PaymentRepository;
import backend.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by NXA-C.unltd on 2016/08/25.
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    PaymentRepository repository;

    @Override
    public Payment create(Payment entity) {
        return repository.save(entity);
    }

    @Override
    public Payment readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Payment> readAll() {
        Set<Payment> result = new HashSet<Payment>();
        while (repository.findAll().iterator().hasNext()){
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }

    @Override
    public Payment update(Payment entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Payment entity) {
        repository.delete(entity);
    }
}
