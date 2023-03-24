package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import org.springframework.stereotype.Component;

@Component
public interface CategoryService {
    void create(Category category);

    void update(Category category);
    void delete(Category category);



}
