// package com.kootoncalli.kooton_calli.util;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Profile;
// import org.springframework.core.annotation.Order;
// import org.springframework.stereotype.Component;

// import com.kootoncalli.kooton_calli.model.Role;
// import com.kootoncalli.kooton_calli.model.User;
// import com.kootoncalli.kooton_calli.repository.RoleRepository; 
// import com.kootoncalli.kooton_calli.repository.UserRepository;

// @Component
// @Order(2)
// @Profile("dev")
// public class UserDataLoader implements CommandLineRunner{

//     private final UserRepository userRepository;
//     private final RoleRepository roleRepository;

//     public UserDataLoader(UserRepository userRepository, RoleRepository roleRepository) { 
//         this.userRepository = userRepository;
//         this.roleRepository = roleRepository;     }


//     @Override
//     public void run(String... args) throws Exception {

//         Role adminRole = roleRepository.findByRoleName("Admin")
//             .orElseThrow(() -> new IllegalStateException("Role 'Admin' not found"));
        
//         User peter = new User();
//         peter.setEmail("peter@example.com");
//         peter.setPassword("123");
//         peter.setName("Peter");
//         peter.setLastName("Languila");
//         peter.setPhone("1234567890"); 


//         peter.setRole(adminRole);

//         userRepository.save(peter);
//         }
//     }

