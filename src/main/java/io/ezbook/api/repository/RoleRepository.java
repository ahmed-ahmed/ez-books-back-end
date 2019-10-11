package io.ezbook.api.repository;

import org.springframework.data.repository.CrudRepository;

import io.ezbook.api.model.Role;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Role findByRoleName(String roleName);
}