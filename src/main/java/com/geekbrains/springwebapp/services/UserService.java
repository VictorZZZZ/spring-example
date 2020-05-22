package com.geekbrains.springwebapp.services;

import com.geekbrains.springwebapp.entities.User;
import com.geekbrains.springwebapp.repositories.UserRepository;
//import jdk.nashorn.internal.objects.annotations.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public void setUserRepository(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findById(username).get();
    }
}
