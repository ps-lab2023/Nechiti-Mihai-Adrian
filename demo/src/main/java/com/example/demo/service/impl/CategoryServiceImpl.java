package com.example.demo.service.impl;


import com.example.demo.model.Category;
import com.example.demo.model.User;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    User user;
    @Autowired
    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public void create(Category category) {
        categoryRepository.save(category);
    }

    @Override
    public void update(Category category) {
        Category upCategory = categoryRepository.findById(category.getId()).get();
        upCategory.setName(category.getName());
        categoryRepository.save(upCategory);

    }

    @Override
    public void delete(Category category) {
        categoryRepository.delete(category);
    }
}
