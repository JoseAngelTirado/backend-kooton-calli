package com.kootoncalli.kooton_calli.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kootoncalli.kooton_calli.dto.UserDto;
import com.kootoncalli.kooton_calli.model.Role;
import com.kootoncalli.kooton_calli.model.User;
import com.kootoncalli.kooton_calli.repository.RoleRepository;
import com.kootoncalli.kooton_calli.repository.UserRepository;
import com.kootoncalli.kooton_calli.service.UserService;


@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public UserDto save(UserDto userDto) {
        userDto.setId(null); //Asegura que le usuario sea nuevo al poner null en el id
        User userToSave = userDtoToUser(userDto); //traduce DTO a Entidad llamando a userDtoToUser
        User createdUser = userRepository.save(userToSave); //guardamos en la BD con repository
        return userToUserDto(createdUser);
    }

    //Traductor de UserDTO a User
    private User userDtoToUser(UserDto userDto){
        User user = new User(); //inicializamos el user
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        // Agregar lógica para asignar el Role
        if (userDto.getIdRole() != null) {
            Role role = roleRepository.findById(userDto.getIdRole())
                .orElseThrow(() -> new IllegalStateException("Role not found with id: " + userDto.getIdRole()));
            user.setRole(role);
            
        }
        
        return user;
    }

    //Traductor de User a UserDTO
    private UserDto userToUserDto(User user){
        UserDto userDto = new UserDto(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            user.getName(),
            user.getLastName(),
            user.getPhone(),
            user.getRole() != null ? user.getRole().getId() : null //Incluir idRol
        );
        return userDto;
    }



    @Override
    public UserDto findById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new IllegalStateException("User does not exist with id " + id);
        }
        User existingUser = userOptional.get();
        return userToUserDto(existingUser);
    }

    @Override
    public Iterable<UserDto> findAll() {
        List<UserDto> usersDto = new ArrayList<>();
        Iterable<User> users = userRepository.findAll();
        for(User user: users){
            UserDto userDto = new UserDto(user.getId(), user.getEmail(), user.getPassword(),user.getName(), user.getLastName(), user.getPhone(), user.getRole() != null ? user.getRole().getId() : null);
            usersDto.add(userDto);
        }
        return usersDto;
        
    }

    @Override
    public UserDto update(Integer id, UserDto userDto) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()){
            throw new IllegalStateException("User does not exist with id " + id);
        } 
        User existingUser = userOptional.get();
        User newUser = userDtoToUser(userDto);

        existingUser.setEmail(newUser.getEmail());
        existingUser.setPassword(newUser.getPassword());
        existingUser.setName(newUser.getName());
        existingUser.setLastName(newUser.getLastName());
        existingUser.setPhone(newUser.getPhone());
        existingUser.setRole(newUser.getRole());
       
        return userToUserDto(userRepository.save(existingUser));
    }

    @Override
    public void deleteByID(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isEmpty()) {
            throw new IllegalStateException("User does not exist with id " + id);
        }
        User existingUser = userOptional.get();
        userRepository.delete(existingUser);
    }

   
//     @Override
// public Iterable<UserDto> findAllByName(String name) {
//     Iterable<User> users = userRepository.findAllByName(name);
//     List<UserDto> usersDto = new ArrayList<>();
//     for (User user : users) {
//         usersDto.add(userToUserDto(user));
//     }
//     if (usersDto.isEmpty()) {
//         throw new IllegalStateException("No users found with name: " + name);
//     }
//     return usersDto;
// }

}
