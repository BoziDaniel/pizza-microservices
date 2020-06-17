package com.codecool.userservice.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class AuthServiceCaller {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${apigateway.url}")
    private String baseUrl;

//    public String encode(String password) {
//        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/encode?password=" + password, String.class);
//        String encodedPassword = response.getBody();
//        log.info(encodedPassword);
//        return encodedPassword;
//
//    }


}
