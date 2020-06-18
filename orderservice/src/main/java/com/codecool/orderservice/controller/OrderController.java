package com.codecool.orderservice.controller;

import com.codecool.orderservice.service.JwtTokenService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Enumeration;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/orders")
public class OrderController {
    //@PreAuthorize("hasAnyAuthority('customer:read', 'cook:read', 'manager:read', 'deliveryguy:read')")
//    @PreAuthorize("hasAnyRole('ROLE_COOK', 'ROLE_CUSTOMER', 'ROLE_MANAGER', 'ROLE_DELIVERY_GUY')")
//    @GetMapping("/active")
//    public List<OrderrDTO> getActiveOrdersForUser(HttpServletRequest request) {
//        log.info("get request: /orders/active/ arrived");
//        log.info(request.getHeader("Authorization"));
//        Long idFromToken = jwtTokenService.getIdFromRequestThroughToken(request);
//        log.info(String.format("id from token: %s", idFromToken));
//        List<OrderrDTO> activieOrderDTOs = orderService.listActiveOrdersForUser(idFromToken);
//        log.info(" Get request: /orders/active/ processed. Id was: " + idFromToken +" \n Return value will be: " + activieOrderDTOs.toString());
//        return activieOrderDTOs;
//    }

    //    @Autowired
//    private AuthServiceCaller authServiceCaller;
    private String secretKey = "securesecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecuresecurevalami";
    @Autowired
    private JwtTokenService jwtTokenService;

    @GetMapping("/active")
    public void getActiverOrrdersForUser(HttpServletRequest request) {
        if (request.getHeader("Test") != null) {
            int a = 5;
        }
        log.info("get request: /orders/active/ arrived");
        Enumeration<String> headers = request.getHeaderNames();
        log.info(headers.toString());
        log.info(String.format("AUTH HEADER: %s", request.getHeader("Authorization")));
        String bearerToken = request.getHeader("Authorization");

        String token = bearerToken.substring(7, bearerToken.length());

        Claims body = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
        String username = body.getSubject();

        System.out.println(username);
    }
}
