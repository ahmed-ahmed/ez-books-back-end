package io.ezbook.api.repo;

import org.springframework.data.repository.CrudRepository;

import io.ezbook.api.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}