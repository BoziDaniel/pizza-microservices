package com.codecool.orderservice.service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
@Slf4j
public class JwtTokenService {

    public String getTokenFromRequest(HttpServletRequest req) {
//        String bearerToken = req.getHeader("Authorization");
//        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
//            return bearerToken.substring(7, bearerToken.length());
//        }
//        return null;
        String authorizationHeader = req.getHeader("Authorization");
        String token = authorizationHeader.replace("Bearer ", "");
        return token;
    }

    public String getUsernameFromToken(String token) {
        String secretKey = "securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecurevalami";

        Claims body = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        log.info(body.toString());
        return (String) body.get("sub");
    }
//    Claims body = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
//    String username = body.getSubject();
    public String getUsernameFromRequestThroughToken(HttpServletRequest req) {
        String token = getTokenFromRequest(req);
        return getUsernameFromToken(token);
    }
}



