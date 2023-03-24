package com.example.demo.service;

import com.example.demo.model.Product;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

@Component
public interface ProductService {

    void create(Product product);
    void delete(Product product);

    void update(Product product);


}
