package com.practice.librarymanagement.service;

import com.practice.librarymanagement.entity.User;
import com.practice.librarymanagement.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User save(User user){
        return userRepository.save(user);
    }
}
