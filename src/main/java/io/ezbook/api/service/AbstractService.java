package io.ezbook.api.service;

import io.ezbook.api.entity.JournalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.util.Optional;

public abstract class AbstractService<T> {
    public Optional<JournalEntity> findByJournalId(Object id) {
        return getRepo().findById(id);
    }
    public Optional<T> findById(Object id) {
        return getRepo().findById(id);

    }

    public abstract CrudRepository getRepo ();


}
