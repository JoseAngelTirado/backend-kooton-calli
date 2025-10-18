package com.kootoncalli.kooton_calli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.kootoncalli.kooton_calli.dto.RoleDto;
import com.kootoncalli.kooton_calli.service.RoleService;

@RestController
@RequestMapping("/api/v1/roles")
@CrossOrigin(origins = "*")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    ResponseEntity<Iterable<RoleDto>> getAllRoles() {
        return ResponseEntity.ok(roleService.findAll());
    }

    @PostMapping
    ResponseEntity<RoleDto> createRole(@RequestBody RoleDto roleDto) {
        RoleDto createdRole = roleService.save(roleDto);
        return ResponseEntity.status(201).body(createdRole);
    }

    @GetMapping("/{id}")
    ResponseEntity<RoleDto> getRoleById(@PathVariable("id") Integer id) {
        RoleDto roleDto = roleService.findById(id);
        return ResponseEntity.ok(roleDto);
    }

    @PutMapping("/{id}")
    ResponseEntity<RoleDto> updateRole(
            @PathVariable("id") Integer id,
            @RequestBody RoleDto roleDto
    ) {
        RoleDto updatedRole = roleService.update(id, roleDto);
        return ResponseEntity.ok(updatedRole);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<Void> deleteRole(@PathVariable("id") Integer id) {
        roleService.deleteByID(id);
        return ResponseEntity.noContent().build();
    }
}
