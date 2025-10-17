package com.kootoncalli.kooton_calli.service;

import com.kootoncalli.kooton_calli.dto.UserDto;


public interface UserService {

    //Metodos Crud

    UserDto save(UserDto user);
    UserDto findById(Integer id);

    Iterable<UserDto> findAll();

    UserDto update(Integer id, UserDto user);
    void deleteByID(Integer id);

    //Metodo de User Repository para traer nombres
    Iterable<UserDto> findByName(String name);

}
