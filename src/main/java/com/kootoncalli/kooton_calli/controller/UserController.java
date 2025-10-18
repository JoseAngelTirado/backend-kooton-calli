package com.kootoncalli.kooton_calli.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kootoncalli.kooton_calli.dto.UserDto;
import com.kootoncalli.kooton_calli.service.UserService;




@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")

public class UserController {

       private final UserService userService;

       public UserController(UserService userService) {
            this.userService = userService;
       }

       @GetMapping("/{id}")
       ResponseEntity<Iterable<UserDto>> getAllUsers(){
             return ResponseEntity.ok(userService.findAll());
       }

      @PostMapping
      ResponseEntity<UserDto> createdUser(@RequestBody UserDto userDto){
            UserDto createdUser = userService.save(userDto);
            return ResponseEntity.status(201).body(createdUser);
      }

      @GetMapping("/{id}")
      ResponseEntity<UserDto> findById(@PathVariable("id")Integer id){
            UserDto existingUserDto = userService.findById(id);
            return ResponseEntity.ok(existingUserDto);
      }
      
      
      @PutMapping("/{id}") 
      ResponseEntity<UserDto> updadateById(
            @PathVariable("id")Integer id,
            @RequestBody UserDto userDto
      ){
            UserDto existingUserDto = userService.update(id, userDto);
            return ResponseEntity.ok(existingUserDto);
      }
      @DeleteMapping("/{id}") 
      ResponseEntity<Void> deleteById(@PathVariable("id")Integer id){
            userService.deleteByID(id);
            return ResponseEntity.noContent().build();
      }
}
