package com.kootoncalli.kooton_calli.repository;

import com.kootoncalli.kooton_calli.model.Role;
import org.springframework.data.repository.CrudRepository;
import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByRoleName(String roleName);
    boolean existsByRoleName(String roleName);
}