package com.kootoncalli.kooton_calli.util;

import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Profile;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.kootoncalli.kooton_calli.model.User;
import com.kootoncalli.kooton_calli.repository.UserRepository;

@Component
@Order(1)
//@Profile
public class UserDataLoader implements CommandLineRunner{

    private final UserRepository userRepository;

    public UserDataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        
        User peter = new User();
        peter.setEmail("peter@example.com");
        peter.setPassword("123");
        peter.setName("Peter");
        peter.setLastName("Languila");
        peter.setPhone("1234567890");
        userRepository.save(peter);

        /* Set <Role> roles = new HashSet<>();
        roles.add(new Role()) */

        userRepository.save(peter);

        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

}

