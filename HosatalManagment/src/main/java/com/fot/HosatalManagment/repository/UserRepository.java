package com.fot.HosatalManagment.repository;


import com.fot.HosatalManagment.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {
    // You can define custom query methods here if needed.

    User findByUsername(String username); // Example method to find a user by username
}
