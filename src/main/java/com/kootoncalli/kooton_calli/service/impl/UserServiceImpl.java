package com.kootoncalli.kooton_calli.service.impl;

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
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findById'");
    }

    @Override
    public Iterable<UserDto> finaAll() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'finaAll'");
    }

    @Override
    public UserDto update(Integer id, UserDto user) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void deleteByID(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteByID'");
    }

    @Override
    public Iterable<UserDto> findByName(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findByName'");
    }

}
