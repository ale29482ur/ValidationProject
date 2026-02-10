package com.example.ValidationProject.controller;

import com.example.ValidationProject.model.User;
import com.example.ValidationProject.service.ValidatorService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class ValidatorController {

    private final ValidatorService validatorService;


    public ValidatorController(ValidatorService validatorService) {
        this.validatorService = validatorService;
    }

    @GetMapping
    public List<User> getAll() {
        return validatorService.getAll();
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return validatorService.save(user);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        validatorService.delete(id);
    }


}
