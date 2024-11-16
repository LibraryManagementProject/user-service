package com.example.library.user_service.service;

import com.example.library.user_service.model.User;
import com.example.library.user_service.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private static final String BOOK_SERVICE_URL = "http://localhost:8082/books/user/";


    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(int userId) {
        return userRepository.findById(userId);
    }

    public List<String> getBooksHeldByUser(int userId) {
        String url = BOOK_SERVICE_URL + userId;
        return restTemplate.getForObject(url, List.class);
    }
}
