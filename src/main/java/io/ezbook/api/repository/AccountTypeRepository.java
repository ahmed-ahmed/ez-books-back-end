package io.ezbook.api.repository;

import java.util.Collection;
import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.ezbook.api.model.AccountType;

@Repository
public interface AccountTypeRepository extends CrudRepository<AccountType, Long> {
    List<AccountType> findAll();
    
    List<AccountType> findByNameIn(Collection<String> names);
}
