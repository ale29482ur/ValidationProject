package com.example.ValidationProject.repository;

import com.example.ValidationProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ValidatorRepository extends JpaRepository<User, Long> {
}
