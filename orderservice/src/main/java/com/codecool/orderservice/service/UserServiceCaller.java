package com.codecool.orderservice.service;

import com.codecool.orderservice.modell.User;
import com.codecool.orderservice.modell.UserRole;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserServiceCaller {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${userservice.url}")
    private String baseUrl;

    public User getUserByUserName(String username) {
        ResponseEntity<User> response = restTemplate.getForEntity(baseUrl +"/complete-user?username=" + username, User.class);
        User user = response.getBody();
        return user;
    }

//    public UserRole getUserRoleById(Long id) {
//        System.out.println("getUserRoleById() called");
//        ResponseEntity<UserRole> response = restTemplate.getForEntity(baseUrl + "/" + id + "/role", UserRole.class);
//        UserRole role = response.getBody();
//        return role;
//    }

    public User getUserByUserId(Long id) {
        ResponseEntity<User> response = restTemplate.getForEntity(baseUrl + id, User.class);
        User user = response.getBody();
        log.info(user.toString());
        return user;
    }
}
