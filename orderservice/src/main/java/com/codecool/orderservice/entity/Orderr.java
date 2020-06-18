package com.codecool.orderservice.entity;

import com.codecool.orderservice.dto.OrderrDTO;
import com.codecool.orderservice.dto.PizzaQuantityDTO;
import com.codecool.orderservice.service.OrderService;
import com.codecool.orderservice.service.UserServiceCaller;
import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Orderr {
    private static final Logger LOGGER = LoggerFactory.getLogger(Orderr.class);

    @Transient
    @Autowired
    private UserServiceCaller userServiceCaller;

    @GeneratedValue
    @Id
    private Long id;

    @Enumerated(EnumType.STRING)
    private OrderStatus orderStatus;

    @ElementCollection
    @CollectionTable(name = "incomingOrder_pizza_mapping",
            joinColumns = {@JoinColumn(name = "incomingOrder_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "pizzaId")
    @Column(name = "quantity")
    @Singular
    Map<Long, Integer> orderedPizzas;


    private Long cookId;


    private Long deliveryGuyId;


    private Long customerId;


    public OrderrDTO generateIncomingOrderDTO() {
        List<PizzaQuantityDTO> pizzaDTOs = new ArrayList<>();
        for (Long pizzaId : orderedPizzas.keySet()) {
            PizzaQuantityDTO pizzaDTO = generateDTOfromPizza(pizzaId);
            pizzaDTOs.add(pizzaDTO);
        }

        OrderrDTO orderrDTO = OrderrDTO.builder()
                .id(this.getId())
                .orderStatus(this.getOrderStatus())
                .customer(userServiceCaller.getUserByUserId(this.customerId))
                .incomingOrderedPizzas(pizzaDTOs)
                .build();
        LOGGER.debug("incomingorderDTO: " + orderrDTO.toString());
        return orderrDTO;
    }

    private PizzaQuantityDTO generateDTOfromPizza(Long pizzaId) {
        PizzaQuantityDTO pizzaDTO = PizzaQuantityDTO.builder()
                .id(pizzaId)
                .quantity(orderedPizzas.get(pizzaId))
                .build();


        return pizzaDTO;
    }
}
