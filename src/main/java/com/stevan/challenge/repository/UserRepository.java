package com.stevan.challenge.repository;

import com.stevan.challenge.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByMail(String mail);
}
