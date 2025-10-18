package com.kootoncalli.kooton_calli.service;

import org.springframework.stereotype.Service;

import com.kootoncalli.kooton_calli.dto.RoleDto;


public interface RoleService {


    //Metodos CRUD para Role
    RoleDto save(RoleDto roleDto);
    RoleDto findById(Integer idRole);

    Iterable<RoleDto> findAll();

    RoleDto update(Integer idRole, RoleDto role);
    void deleteByID(Integer idRole);

    public RoleDto getRoleById(Long id);


}
