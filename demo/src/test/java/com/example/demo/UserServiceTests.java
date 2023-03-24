package com.example.demo;

import com.example.demo.Enums.Role;
import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class UserServiceTests {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;
    private User user;

    @BeforeEach
    void init() {
        initMocks(this);
        user = new User();
        userService = new UserServiceImpl(userRepository);
        when(userRepository.save(user)).thenReturn(user);


    }
    @Test
    void createUpdate(){
        User user = new User();

        user.setName("Marcel Iliescu");
        user.setPassword("79titi'slover420");
        user.setEmail("marcelI@gmail.com");
        user.setRole(Role.USER);
        user.setId(424L);

        userService.create(user);

    }
    @Test
    void updateTest(){
        User userP = new User();
        User userA = new User();


        userP.setName("Marius Iliescu");
        userP.setPassword("4949s3");
        userP.setEmail("marcelI@gmail.com");
        userP.setRole(Role.USER);
        userP.setId(420L);

        userA.setName("Albert Iliescu");
        userP.setPassword("4949s3");
        userP.setEmail("marcelI@gmail.com");
        userP.setRole(Role.USER);
        userA.setId(420L);


        given(userRepository.findById(userP.getId())).willReturn(Optional.of(userP));
        userService.update(userA);
        verify(userRepository).save(userA);
        verify(userRepository).findById(userP.getId());
    }



    @Test
    void deleteVerify(){
        User user = new User();

        user.setName("Marcel Iliescu");
        user.setPassword("69titi'slover420");
        user.setEmail("marcelI@gmail.com");
        user.setRole(Role.USER);
        user.setId(303L);

        when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));

        userService.delete(user);

        verify(userRepository).delete(user);
    }
}
