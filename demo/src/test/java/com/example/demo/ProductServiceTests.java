package com.example.demo;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.impl.ProductServiceImpl;
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

public class ProductServiceTests {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    private ProductServiceImpl productService;
    private Product product;

    @BeforeEach
    void init() {
        initMocks(this);
        product = new Product();
        productService = new ProductServiceImpl(productRepository);
        when(productRepository.save(product)).thenReturn(product);


    }
    @Test
    void createTest(){
        Product product = new Product();

        product.setName("Samsung Galaxy S8");
        product.setPrice(2099.0f);
        product.setId(424L);

        productService.create(product);

    }

    @Test
    void updateTest(){
        Product productP = new Product();
        Product productA = new Product();

        productP.setName("Iphone 14");
        productP.setPrice(4330.0f);
        productP.setId(303L);

        productA.setName("Iphone 14 Plus");
        productA.setPrice(5000.0f);
        productA.setId(303L);

        given(productRepository.findById(productP.getId())).willReturn(Optional.of(productP));
        productService.update(productA);

        verify(productRepository).save(productA);
        verify(productRepository).findById(productP.getId());
    }


    @Test
    void deleteTest(){

        Product product = new Product();

        product.setName("Iphone 14");
        product.setPrice(4330.0f);
        product.setId(303L);


        when(productRepository.findById(product.getId())).thenReturn(Optional.of(product));

        productService.delete(product);

        verify(productRepository).delete(product);
    }

}