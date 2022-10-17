package com.example.contactlist.service;

import com.example.contactlist.controller.dto.CreateUser;
import com.example.contactlist.repository.UserRepository;
import com.example.contactlist.repository.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(CreateUser createUser) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User newUser = new User();
        newUser.setEmail(createUser.getEmail());
        newUser.setPassword(passwordEncoder.encode(createUser.getPassword()));

        this.userRepository.save(newUser);
    }
}
