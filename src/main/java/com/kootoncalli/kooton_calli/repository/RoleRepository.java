package com.kootoncalli.kooton_calli.repository;

import org.springframework.data.repository.CrudRepository;

import com.kootoncalli.kooton_calli.model.Role;

public interface RoleRepository extends CrudRepository<Role,Integer>{
    Iterable<Role> findAllByNameContaining(String roleName);
}
