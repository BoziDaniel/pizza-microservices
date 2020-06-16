package com.codecool.userservice.controller;

import com.codecool.userservice.entity.User;
import com.codecool.userservice.modell.UserRole;
import com.codecool.userservice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/{id}")
    public User getUserByUserId(@PathVariable("id") Long id) {
        log.info(String.format("request arrived at '/user/%s'", id));
        User user = userRepository.getUserById(id);
        log.info(String.format("request processed '/user/%s' , found user: %s", id , user.toString()));
        return user;
    }

    @GetMapping("/{id}/role")
    public UserRole getUserRoleById(@PathVariable("id") Long id) {
        log.info(String.format("request arrived at '/user/%s/role'", id));
        UserRole role=  userRepository.getUserRoleByUserId(id);
        log.info(String.format("request processed '/user/%s/role' , found  role: %s", id , role.toString()));
        return role;
    }
//itt usercredentialt kéne visszaadni!!! majd átír
    @GetMapping
    public User getUserCredentialsByUsername(@RequestParam("username") String username) {
        log.info(String.format("request arrived at /user?username=%s", username  ));
        User user = userRepository.getUserByUsername(username);
        log.info(String.format("request processed /user?username=%s found user: %s", username, user.toString()));
        return user;
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        log.info(String.format("request arrived at /user with request body: %s", user.toString()));
        userRepository.save(user);
        log.info(String.format("request processed at /user with request body: %s", user.toString()));
    }
}
