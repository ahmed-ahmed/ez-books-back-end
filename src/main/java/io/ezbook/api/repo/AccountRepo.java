package io.ezbook.api.repo;

import io.ezbook.api.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
    List<Account> findAll();
}
