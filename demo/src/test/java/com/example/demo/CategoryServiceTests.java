package com.example.demo;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.service.impl.CategoryServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class CategoryServiceTests {

    @Mock
    private CategoryRepository categoryRepository;
    @InjectMocks
    private CategoryServiceImpl categoryService;
    private Category category;

    @BeforeEach
    void init() {
        initMocks(this);
        category = new Category();
        categoryService = new CategoryServiceImpl(categoryRepository);
        when(categoryRepository.save(category)).thenReturn(category);


    }
    @Test
    void createTest(){
        Category category = new Category();

        category.setName("Laptop-uri");
        category.setId(424L);

        categoryService.create(category);
    
    }
    @Test
    void updateTest(){
        Category categoryP = new Category();
        categoryP.setName("Laptop-uri");
        categoryP.setId(420L);
        Category categoryA = new Category();
        categoryA.setName("Cpmputer");
        categoryA.setId(420L);

        given(categoryRepository.findById(categoryP.getId())).willReturn(Optional.of(categoryP));
        categoryService.update(categoryA);
        verify(categoryRepository).save(categoryA);
        verify(categoryRepository).findById(categoryP.getId());
    }


    @Test
    void deleteTest(){
        Category category1 = new Category();

        category1.setName("Laptop-uri");
        category1.setId(303L);

        when(categoryRepository.findById(category1.getId())).thenReturn(Optional.of(category1));

        categoryService.delete(category1);

        verify(categoryRepository).delete(category1);
    }
}