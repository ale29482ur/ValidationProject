package com.example.ValidationProject.service;

import com.example.ValidationProject.model.User;
import com.example.ValidationProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {

        return userRepository.findAll();
    }

    public User getUser(Long id){
        return userRepository.getById(id);
    }

    public User save(User user) {

        if (user.getName() == null || user.getName().isBlank()) {
            throw new IllegalArgumentException("nome e obrigatorio");
        }
        if (user.getName().length() < 3){
            throw new IllegalArgumentException("o nome deve ter 3 ou mais caracteres");
        }

        return userRepository.save(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }


}