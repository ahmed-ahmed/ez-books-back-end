package io.ezbooks.api.repo;


import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

public interface AccountRepo<Account, ID extends Serializable> extends Repository<Account, ID> {
    List<Account> findAll();
}
