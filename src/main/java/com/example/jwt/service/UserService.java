package com.example.jwt.service;

import com.example.jwt.model.RoleModel;
import com.example.jwt.model.UserModel;
import com.example.jwt.repository.RoleRepository;
import com.example.jwt.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel user = this.userRepository.findByUsername(username).orElseThrow();

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (RoleModel role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new User(user.getUsername(), user.getPassword(), authorities);
    }

    public UserModel save(UserModel userModel) {
        userModel.setPassword(this.passwordEncoder.encode(userModel.getPassword()));
        return this.userRepository.save(userModel);
    }

    public void addRoleToUser(String username, String name) {
        UserModel user = this.userRepository.findByUsername(username).orElseThrow();
        RoleModel role = this.roleRepository.findByName(name).orElseThrow();

        user.getRoles().add(role);

        this.userRepository.save(user);
    }

}
