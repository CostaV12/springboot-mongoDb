package com.example.springbootmongo.service;

import com.example.springbootmongo.domain.User;
import com.example.springbootmongo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> userList () {
        return userRepository.findAll();
    }
}
