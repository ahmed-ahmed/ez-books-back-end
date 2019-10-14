package io.ezbook.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import io.ezbook.api.entity.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
    List<Account> findAll();
}
