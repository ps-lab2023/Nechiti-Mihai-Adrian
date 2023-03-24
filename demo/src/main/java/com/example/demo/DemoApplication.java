package com.example.demo;

import com.example.demo.Enums.Role;
import com.example.demo.model.*;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.ProductRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Bean
	CommandLineRunner init(CategoryRepository categoryRepository, ProductRepository productRepository, UserRepository userRepository,
						   CategoryService categoryService, ProductService productService, UserService userService){
		return args -> {
			User user1 = new User();
			Category category1 = new Category();
			Product product1 = new Product();
			Product product2 = new Product();
			Cart cart1 = new Cart();

			user1.setCart(cart1);
			user1.setRole(Role.USER);
			user1.setName("Mihai");
			user1.setEmail("mishu420@gmail.com");
			user1.setPassword("02496");
			cart1.setUserId(user1);

			category1.setName("Prize");
			category1.setProductId(new ArrayList<Product>());
			category1.getProductId().add(product1);
			category1.getProductId().add(product2);

			product1.setCategory(category1);
			product2.setCategory(category1);

			product1.setName("priza americaneasca");
			product2.setName("priza britanica");

			product1.setPrice(40.99f);
			product2.setPrice(32.90f);

			System.out.println(category1.getProductId().size());
			categoryRepository.save(category1);
			productRepository.save(product1);
			productRepository.save(product2);
			userRepository.save(user1);


		};




	}


}
