package com.codecool.userservice.repository;

import com.codecool.userservice.entity.User;
import com.codecool.userservice.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long Id);

//    UserRole getRolesById(Long userId);

    User getUserByUsername(String userName);

}
