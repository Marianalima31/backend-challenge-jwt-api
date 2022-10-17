package com.example.jwt;

import com.example.jwt.model.RoleModel;
import com.example.jwt.model.UserModel;
import com.example.jwt.repository.RoleRepository;
import com.example.jwt.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
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
            roleRepository.save(new RoleModel("ROLE_ADMIN"));
            roleRepository.save(new RoleModel("ROLE_MEMBER"));
            roleRepository.save(new RoleModel("ROLE_EXTERNAL"));

            userService.save(new UserModel("Mariana", "mariana@gmail.com", "123456"));
            userService.save(new UserModel("Fuskinha", "fuskinha@gmail.com", "123456"));
            userService.save(new UserModel("Ana", "ana@gmail.com", "123456"));

            userService.addRoleToUser("maria@gmail.com", "ROLE_ADMIN");
            userService.addRoleToUser("fuskinha@gmail.com", "ROLE_MEMBER");
            userService.addRoleToUser("ana@gmail.com", "ROLE_EXTERNAL");
        };
    }

}
