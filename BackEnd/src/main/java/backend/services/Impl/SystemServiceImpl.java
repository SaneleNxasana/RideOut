package backend.services.Impl;

import backend.domain.System;
import backend.repositories.SystemRepository;
import backend.services.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
@Service
public class SystemServiceImpl implements SystemService {
    @Autowired
    SystemRepository repository;

    @Override
    public System create(System entity) {
        return repository.save(entity);
    }

    @Override
    public System readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<System> readAll() {
        Set<System> result = new HashSet<System>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }

    @Override
    public System update(System entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(System entity) {
        repository.delete(entity);
    }
}
