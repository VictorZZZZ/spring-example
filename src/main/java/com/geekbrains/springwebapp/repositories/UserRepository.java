package com.geekbrains.springwebapp.repositories;

import com.geekbrains.springwebapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findByUsername(String sboot);
}
