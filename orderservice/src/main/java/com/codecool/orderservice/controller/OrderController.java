package com.codecool.orderservice.controller;

import com.codecool.orderservice.dto.OrderrDTO;
import com.codecool.orderservice.modell.User;
import com.codecool.orderservice.service.OrderService;
import com.codecool.orderservice.service.UserServiceCaller;
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

//        Long idFromToken = jwtTokenService.getIdFromRequestThroughToken(request);
//
//        List<OrderrDTO> activieOrderDTOs = orderService.listActiveOrdersForUser(idFromToken);
//        log.info(" Get request: /orders/active/ processed. Id was: " + idFromToken +" \n Return value will be: " + activieOrderDTOs.toString());
//        return activieOrderDTOs;
//    }

    @Autowired
    private UserServiceCaller userServiceCaller;
    @Autowired
    private OrderService orderService;

    @GetMapping("/active")
    public void getActiverOrrdersForUser(HttpServletRequest request) {
        log.info("get request: /orders/active/ arrived");
        Enumeration<String> headers = request.getHeaderNames();
        String username = request.getHeader("username");
        User user = userServiceCaller.getUserByUserName(username);
        List<OrderrDTO> activieOrderDTOs = orderService.listActiveOrdersForUser(user);
        System.out.println(activieOrderDTOs);
    }
}
