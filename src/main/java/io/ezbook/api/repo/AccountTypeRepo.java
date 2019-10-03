package io.ezbook.api.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.ezbook.api.model.AccountType;

@Repository
public interface AccountTypeRepo extends CrudRepository<AccountType, Long> {
    List<AccountType> findAll();
}
