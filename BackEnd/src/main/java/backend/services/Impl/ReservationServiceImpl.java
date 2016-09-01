package backend.services.Impl;

import backend.domain.Reservation;
import backend.repositories.ReservationRepository;
import backend.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    ReservationRepository repository;

    @Override
    public Reservation create(Reservation entity) {
        return repository.save(entity);
    }

    @Override
    public Reservation readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Reservation> readAll() {
        Set<Reservation> result = new HashSet<Reservation>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }

    @Override
    public Reservation update(Reservation entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Reservation entity) {
        repository.delete(entity);
    }
}
