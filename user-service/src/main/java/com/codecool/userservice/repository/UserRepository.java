package com.codecool.userservice.repository;

import com.codecool.userservice.entity.User;
import com.codecool.userservice.modell.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.codecool.userservice.modell.UserCredentials;


public interface UserRepository extends JpaRepository<User, Long> {
    User getUserById(Long Id);

    @Query(value = "SELECT ROLE FROM USER WHERE ID=?1", nativeQuery = true)
    UserRole getUserRoleByUserId(Long userId);

    UserCredentials getUserByUsername(String userName);

}
