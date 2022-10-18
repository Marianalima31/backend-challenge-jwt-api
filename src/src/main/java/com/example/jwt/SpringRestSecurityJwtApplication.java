package com.example.jwt;

import com.example.jwt.model.RoleModel;
import com.example.jwt.model.UserModel;
import com.example.jwt.repository.RoleRepository;
import com.example.jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class SpringRestSecurityJwtApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestSecurityJwtApplication.class, args);
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner runner(RoleRepository roleRepository, UserService userService) {
        return args -> {
            roleRepository.save(new RoleModel("Admin"));
            roleRepository.save(new RoleModel("Member"));
            roleRepository.save(new RoleModel("External"));

            userService.save(new UserModel("Mariana Lima", "123456"));
            userService.save(new UserModel("Maria4 oi",  "123456"));
            userService.save(new UserModel("Ana", "123456"));

            userService.addRoleToUser("Mariana Lima", "Admin");
            userService.addRoleToUser("Maria4 oi", "Member");
            userService.addRoleToUser("Ana", "External");
        };
    }

}
