package com.codecool.orderservice.service;


import com.codecool.orderservice.dto.OrderrDTO;
import com.codecool.orderservice.entity.OrderStatus;
import com.codecool.orderservice.entity.Orderr;
import com.codecool.orderservice.modell.User;
import com.codecool.orderservice.modell.UserRole;
import com.codecool.orderservice.repository.OrderrRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
public class OrderService {


    @Autowired
    private OrderrRepository orderrRepository;
    @Autowired
    private UserServiceCaller userServiceCaller;


    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);

//    public void persistIncomingOrder(Long userId, OrderrDTO orderrDTO) {
//        LOGGER.trace("Starting to create incoming order from userId: " + userId + "incomingOrderDTO: " + orderrDTO.toString());
//        HashMap<Long, Integer> pizzas = new HashMap<>();
//        for (PizzaQuantityDTO orderedPizzaWithQuantity : orderrDTO.getIncomingOrderedPizzas()) {
//            //ide kell majd vmi method
//            pizzas.put(pizzaRepository.getPizzaById(orderedPizzaWithQuantity.getId()), orderedPizzaQuantity.getQuantity());
//        }
//        User customer = userRepository.getUserById(userId);
//        Orderr orderr = Orderr.builder()
//                .customer((Customer) customer)
//                .orderStatus(OrderStatus.ORDERED)
//                .orderedPizzas(pizzas)
//                .build();
//
//        LOGGER.info("Incoming order created. incoming order: " + orderr.toString());
//        orderrRepository.save(orderr);
//        LOGGER.info("Incoming order persisted to db. incoming order: " + orderr.toString());
//    }

    private List<OrderrDTO> generateIncomingOrderDTOsFromOrders(List<Orderr> orders) {
        List<OrderrDTO> orderDTOs = new ArrayList<>();
        for (Orderr order : orders) {
            orderDTOs.add(order.generateIncomingOrderDTO());
        }
        return orderDTOs;
    }

    public List<OrderrDTO> listActiveOrdersForUser(User user) {
        LOGGER.info("listActiveOrdersForUser started");
        //TODO: Maybe do the the whole thing in one sql.
        //TODO: error handling!

        UserRole userRoleEnum = user.getRoles().iterator().next();;
        String userRole = userRoleEnum.getRole();
        System.out.println(userRole);
        LOGGER.info(" User role queired for userid: " + user.getId() + " found role: " + userRole);
        List<Orderr> activeOrders = new ArrayList<>();
        switch (userRole) {
            case "ROLE_CUSTOMER": {
                LOGGER.info("Starting to list orders for customer. user id: " + user.getId());
                activeOrders = orderrRepository.getOrderrsByOrderStatusNotLikeAndCustomerIdIs(OrderStatus.DELIVERED,user.getId());
                LOGGER.info(String.format("active orders are: %s",activeOrders.toString()));
                break;
            }
            case "ROLE_MANAGER": {
                LOGGER.info("Starting to list orders for manager. user id: " + user.getId());
                activeOrders = orderrRepository.getOrderrsByOrderStatusNotLike(OrderStatus.DELIVERED);
                break;
            }
            case "ROLE_COOK": {
                LOGGER.info("Starting to list orders for cook. user id: " + user.getId());
                activeOrders = orderrRepository.getCookActiveAssignedOrders(user.getId());
                break;
            }
            case "ROLE_DELIVERYGUY": {
                LOGGER.info("Starting to list orders for deliveryGuy. user id: " + user.getId());
                activeOrders = orderrRepository.getDeliveryGuyActiveAssignedOrders(user.getId());
                break;
            }
        }
        List<OrderrDTO> activeOrdersDTOs = generateIncomingOrderDTOsFromOrders(activeOrders);
        System.out.println("listActiveOrdersForUser processed");;
        return activeOrdersDTOs;
    }
}




