package com.kootoncalli.kooton_calli.repository;

import org.springframework.data.repository.CrudRepository;

import com.kootoncalli.kooton_calli.model.User;

public interface UserRepository extends CrudRepository<User, Integer>{
    Iterable<User> findAllByNameContaining(String name);
}
