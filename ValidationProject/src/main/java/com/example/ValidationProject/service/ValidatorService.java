package com.example.ValidationProject.service;

import com.example.ValidationProject.model.User;
import com.example.ValidationProject.repository.ValidatorRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ValidatorService {

    private final ValidatorRepository validatorRepository;

    public ValidatorService(ValidatorRepository validatorRepository) {
        this.validatorRepository = validatorRepository;
    }

    public List<User> getAll() {
        return validatorRepository.findAll();
    }

    public User save(User user) {
        return validatorRepository.save(user);
    }

    public void delete(Long id) {
        validatorRepository.deleteById(id);
    }


}