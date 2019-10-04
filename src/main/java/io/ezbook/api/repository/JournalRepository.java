package io.ezbook.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.ezbook.api.model.Journal;

@Repository
public interface JournalRepository extends CrudRepository<Journal	, Long> {
    
	List<Journal> findAll();
}
