//package com.codecool.orderservice.service;
//
//
//import com.codecool.orderservice.dto.OrderrDTO;
//import com.codecool.orderservice.dto.PizzaQuantityDTO;
//import com.codecool.orderservice.repository.OrderrRepository;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//
//@Service
//public class OrderService {
//
//
//    @Autowired
//    private OrderrRepository orderrRepository;
//
//
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(OrderService.class);
//
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
//
//    private List<OrderrDTO> generateIncomingOrderDTOsFromOrders(List<Orderr> orders) {
//        List<OrderrDTO> orderDTOs = new ArrayList<>();
//        for (Orderr order : orders) {
//            orderDTOs.add(order.generateIncomingOrderDTO());
//        }
//        return orderDTOs;
//    }
//
//    public List<OrderrDTO> listActiveOrdersForUser(Long userId) {
//        LOGGER.info("listActiveOrdersForUser started");
//        //TODO: Maybe do the the whole thing in one sql.
//        //TODO: error handling!
//        String userRole = userRepository.getUserRoleByUserId(userId);
//        LOGGER.info(" User role queired for userid: " + userId + " found role: " + userRole);
//        List<Orderr> activeOrders = new ArrayList<>();
//        switch (userRole) {
//            case "Customer": {
//                LOGGER.info("Starting to list orders for customer. user id: " + userId);
//                activeOrders = orderrRepository.getOrderrsByOrderStatusNotLikeAndCustomer_IdIs(OrderStatus.DELIVERED, userId);
//                LOGGER.info(String.format("active orders are: %s",activeOrders.toString()));
//                break;
//            }
//            case "Manager": {
//                LOGGER.info("Starting to list orders for manager. user id: " + userId);
//                activeOrders = orderrRepository.getOrderrsByOrderStatusNotLike(OrderStatus.DELIVERED);
//                break;
//            }
//            case "Cook": {
//                LOGGER.info("Starting to list orders for cook. user id: " + userId);
//                activeOrders = orderrRepository.getCookActiveAssignedOrders(userId);
//                break;
//            }
//            case "DeliveryGuy": {
//                LOGGER.info("Starting to list orders for deliveryGuy. user id: " + userId);
//                activeOrders = orderrRepository.getDeliveryGuyActiveAssignedOrders(userId);
//                break;
//            }
//        }
//        List<OrderrDTO> activeOrdersDTOs = generateIncomingOrderDTOsFromOrders(activeOrders);
//        return activeOrdersDTOs;
//    }
//}
//
//
//
//
