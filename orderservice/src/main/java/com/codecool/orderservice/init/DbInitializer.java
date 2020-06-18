package com.codecool.orderservice.init;

import com.codecool.orderservice.entity.OrderStatus;
import com.codecool.orderservice.entity.Orderr;
import com.codecool.orderservice.repository.OrderrRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class DbInitializer {
    @Autowired
    private OrderrRepository orderrRepository;

    public void intializeDatabase() {
        Orderr orderredOrder = Orderr.builder()
                .orderedPizzas(new HashMap<Long, Integer>() {{
                    put((long) 1, 1);
                    put((long) 2, 1);
                    put((long) 3, 3);
                    put((long) 4, 20);
                }})
                .customerId((long) 1)
                .orderStatus(OrderStatus.ORDERED)
                .build();

        Orderr inprogressOrder = Orderr.builder()
                .orderedPizzas(new HashMap<Long, Integer>() {{
                    put((long) 1, 1);
                    put((long) 2, 1);
                    put((long) 3, 3);
                    put((long) 4, 1);
                }})
                .customerId((long) 1)
                .cookId((long) 2)

                .orderStatus(OrderStatus.IN_PROGRESS)
                .build();

        Orderr readyOrder = Orderr.builder()
                .orderedPizzas(new HashMap<Long, Integer>() {{
                    put((long) 1, 1);
                    put((long) 2, 121);
                    put((long) 3, 3);
                    put((long) 4, 20);
                }})
                .customerId((long) 1)
                .cookId((long) 2)

                .orderStatus(OrderStatus.READY)
                .build();

        Orderr indeliveryOrder = Orderr.builder()
                .orderedPizzas(new HashMap<Long, Integer>() {{
                    put((long) 1, 1);
                    put((long) 2, 1);
                    put((long) 3, 323);
                    put((long) 4, 20);
                }})
                .customerId((long) 1)
                .cookId((long) 2)
                .deliveryGuyId((long) 4)
                .orderStatus(OrderStatus.IN_DELIVERY)
                .build();

        Orderr deliveredOrder = Orderr.builder()
                .orderedPizzas(new HashMap<Long, Integer>() {{
                    put((long) 1, 1);
                    put((long) 2, 321);
                    put((long) 3, 3);
                    put((long) 4, 20);
                }})
                .customerId((long) 1)
                .cookId((long) 2)
                .deliveryGuyId((long) 4)
                .orderStatus(OrderStatus.DELIVERED)
                .build();

        orderrRepository.save(orderredOrder);
        orderrRepository.save(inprogressOrder);
        orderrRepository.save(readyOrder);
        orderrRepository.save(indeliveryOrder);
        orderrRepository.save(deliveredOrder);
    }
}
