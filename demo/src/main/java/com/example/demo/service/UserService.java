package com.example.demo.service;

import com.example.demo.model.Product;
import com.example.demo.model.User;

public interface UserService {
    void create(User user);
    void delete(User user);
    void update(User user);

}
