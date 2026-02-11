package com.example.ValidationProject.repository;

import com.example.ValidationProject.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
