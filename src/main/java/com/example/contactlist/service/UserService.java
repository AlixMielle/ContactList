package com.example.contactlist.service;

import com.example.contactlist.controller.dto.CreateUser;
import com.example.contactlist.exception.ContactNotFoundException;
import com.example.contactlist.repository.UserRepository;
import com.example.contactlist.repository.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class UserService {

    private UserRepository userRepository;
    private StorageService storageService;

    public UserService(UserRepository userRepository, StorageService storageService) {
        this.userRepository = userRepository;
        this.storageService = storageService;
    }

    public void register(CreateUser createUser) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User newUser = new User();
        newUser.setFirstname(createUser.getFirstname());
        newUser.setLastname(createUser.getLastname());
        newUser.setEmail(createUser.getEmail());
        newUser.setPassword(passwordEncoder.encode(createUser.getPassword()));
        newUser.setPictureUrl(createUser.getPictureUrl());

        MultipartFile picture = createUser.getPictureFile();
        if (picture == null || picture.isEmpty()){
            newUser.setPictureUrl(createUser.getPictureUrl());
        } else {
            storageService.store(picture);
            newUser.setPictureUrl("http://localhost:8080/images/" + picture.getOriginalFilename());
        }

        this.userRepository.save(newUser);
    }


    public User findUserById(long id) {
        return this.userRepository
                .findById(id)
                .orElseThrow(()->new ContactNotFoundException(id));
    }

    public void editUser(long id, CreateUser editUser) {
        User user = this.userRepository
                .findById(id)
                .orElseThrow(()->new ContactNotFoundException(id));

        user.setFirstname(editUser.getFirstname());
        user.setLastname(editUser.getLastname());
        user.setPassword(editUser.getPassword());
        user.setEmail(editUser.getEmail());
        this.userRepository.save(user);
    }
}
