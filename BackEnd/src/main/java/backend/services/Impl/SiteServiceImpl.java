package backend.services.Impl;

import backend.domain.Site;
import backend.repositories.SiteRepository;
import backend.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by NXA-C.unltd on 2016/08/31.
 */
@Service
public class SiteServiceImpl implements SiteService {
    @Autowired
    SiteRepository repository;

    @Override
    public Site create(Site entity) {
        return repository.save(entity);
    }

    @Override
    public Site readById(Long id) {
        return repository.findOne(id);
    }

    @Override
    public Set<Site> readAll() {
        Set<Site> result = new HashSet<Site>();
        while (repository.findAll().iterator().hasNext()) {
            result.add(repository.findAll().iterator().next());
        }
        return result;
    }

    @Override
    public Site update(Site entity) {
        return repository.save(entity);
    }

    @Override
    public void delete(Site entity) {
        repository.delete(entity);
    }
}
