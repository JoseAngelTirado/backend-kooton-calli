package com.kootoncalli.kooton_calli.repository;

import org.springframework.data.repository.CrudRepository;
import com.kootoncalli.kooton_calli.model.Role;
import java.util.Optional; // <-- Importa Optional

public interface RoleRepository extends CrudRepository<Role,Integer>{
    
    Iterable<Role> findAllByNameContaining(String roleName); // Este ya lo tenías

    /**
     * Añade este método para verificar si un rol existe por su nombre.
     * Spring Data JPA entenderá "existsBy" + "RoleName"
     */
    boolean existsByRoleName(String roleName);

    /**
     * Añade este método para buscar un rol por su nombre.
     * Spring Data JPA entenderá "findBy" + "RoleName"
     */
    Optional<Role> findByRoleName(String roleName);
}