package io.ezbook.api.repository;

import java.util.List;

import io.ezbook.api.entity.JournalEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalRepository extends CrudRepository<JournalEntity, Long> {

	List<JournalEntity> findAll();
}
