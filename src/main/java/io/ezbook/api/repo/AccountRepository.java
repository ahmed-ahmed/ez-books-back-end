package io.ezbook.api.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.ezbook.api.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findAll();
}
