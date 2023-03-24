package com.example.demo.service.impl;

import com.example.demo.model.Product;
import com.example.demo.model.User;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

    @Override
    public void delete(User user) {
        userRepository.delete(user);
    }

    @Override
    public void update(User user) {
        User upUser = userRepository.findById(user.getId()).get();
        upUser.setRole(user.getRole());
        upUser.setEmail(user.getEmail());
        upUser.setPassword(user.getPassword());
        upUser.setName(user.getName());
        upUser.setPassword(user.getPassword());
        userRepository.save(upUser);
    }
}
