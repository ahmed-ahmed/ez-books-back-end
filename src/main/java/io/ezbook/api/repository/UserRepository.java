package io.ezbook.api.repository;

import org.springframework.data.repository.CrudRepository;

import io.ezbook.api.entity.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
