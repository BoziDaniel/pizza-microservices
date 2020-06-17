package com.codecool.apigateway.service;

import com.codecool.apigateway.modell.UserCredentials;
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


    public UserCredentials getUserCredentialByUserName(String username) {
        ResponseEntity<UserCredentials> response = restTemplate.getForEntity(baseUrl+"?username=" + username , UserCredentials.class);
        UserCredentials userCredentials = response.getBody();
        log.info(userCredentials.toString());
        return userCredentials;
    }



//    public List<Recommendation> getRecommendationForVideo(Long id) {
//        ResponseEntity<Recommendation[]> response = restTemplate.getForEntity(baseUrl + "/" + id, Recommendation[].class);
//        Recommendation[] recommendations = response.getBody();
//        List<Recommendation> recommendationList = Arrays.asList(recommendations);
//        return recommendationList;


//public void addRecommendation(Long id, Recommendation recommendation) {
//    String url = "http://localhost:8091/recommendations";
//    HttpEntity<Recommendation> request = new HttpEntity<>(recommendation);
//    restTemplate.postForObject(url + "/" + id, request, Recommendation.class);
//}
}
