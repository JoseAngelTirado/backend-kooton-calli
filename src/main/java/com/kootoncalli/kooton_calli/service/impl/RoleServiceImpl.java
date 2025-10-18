package com.kootoncalli.kooton_calli.service.impl;

import java.lang.StackWalker.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.kootoncalli.kooton_calli.dto.RoleDto;
import com.kootoncalli.kooton_calli.model.Role;
import com.kootoncalli.kooton_calli.repository.RoleRepository;
import com.kootoncalli.kooton_calli.service.RoleService;

public class RoleServiceImpl implements RoleService{
    
    private final RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public RoleDto save(RoleDto roleDto){
        roleDto.setIdRole(null);
        Role roleToSave = roleDtoToRole(roleDto);
        Role createdRole = roleRepository.save(roleToSave);
        return roleToRoleDto(createdRole);
    }

    private Role roleDtoToRole(RoleDto roleDto){
        Role role = new Role();
        role.setId(roleDto.getIdRole());
        role.setRoleName(roleDto.getRoleName());
        return role;
    }

    private RoleDto roleToRoleDto(Role role){
        RoleDto roleDto = new RoleDto(
            role.getId(),
            role.getRoleName()
        );
        return roleDto;
    }

    @Override
    public RoleDto findById(Integer idRole) {
        Optional<Role> roleOptional = roleRepository.findById(idRole);
        if(roleOptional.isEmpty()){
            throw new IllegalStateException("User does not exist id " + idRole);
        }
        Role existingRole = roleOptional.get();
        return roleToRoleDto(existingRole);
    }

    @Override
    public Iterable<RoleDto> findAll() {
        List<RoleDto> rolesDto = new ArrayList<>();
        Iterable<Role> roles = roleRepository.findAll();
        for(Role role: roles){
            RoleDto roleDto = new RoleDto(role.getId(), role.getRoleName());
            rolesDto.add(roleDto);
        }
        return rolesDto;
    }

    @Override
    public RoleDto update(Integer idRole, RoleDto roleDto) {
        Optional<Role> roleOptional = roleRepository.findById(idRole);
        if(roleOptional.isEmpty()){
            throw new IllegalStateException("Role does not exist with role " + idRole);
        }
        Role existingRole = roleOptional.get();
        Role newRole = roleDtoToRole(roleDto);

        existingRole.setRoleName(newRole.getRoleName());

        return roleToRoleDto(roleRepository.save(existingRole));
    }

    @Override
    public void deleteByID(Integer idRole) {
        Optional<Role> roleOptional = roleRepository.findById(idRole);
        if(roleOptional.isEmpty()){
            throw new IllegalStateException("User doesen't exist with id " + idRole);
        }
        Role existingRole = roleOptional.get();
        roleRepository.delete(existingRole);
    }


}
