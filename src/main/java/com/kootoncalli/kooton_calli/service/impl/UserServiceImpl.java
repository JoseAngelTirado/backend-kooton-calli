package com.kootoncalli.kooton_calli.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kootoncalli.kooton_calli.dto.UserDto;
import com.kootoncalli.kooton_calli.model.User;
import com.kootoncalli.kooton_calli.repository.UserRepository;
import com.kootoncalli.kooton_calli.service.UserService;


@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto save(UserDto userDto) {
        userDto.setId(null);
        User userToSave = userDtoToUser(userDto);
        User createdUser = userRepository.save(userToSave);
        return userToUserDto(createdUser);
    }

    private User userDtoToUser(UserDto userDto){
        User user = new User();
        user.setId(userDto.getId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        user.setName(userDto.getName());
        user.setLastName(userDto.getLastName());
        user.setPhone(userDto.getPhone());
        return user;
    }

    private UserDto userToUserDto(User user){
        UserDto userDto = new UserDto(
            user.getId(),
            user.getEmail(),
            user.getPassword(),
            user.getName(),
            user.getLastName(),
            user.getPhone()
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
            UserDto userDto = new UserDto(user.getId(), user.getEmail(), user.getPassword(),user.getName(), user.getLastName(), user.getPhone());
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
