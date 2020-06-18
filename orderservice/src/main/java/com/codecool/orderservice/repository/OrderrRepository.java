//package com.codecool.orderservice.repository;
//
//import com.codecool.orderservice.entity.OrderStatus;
//import com.codecool.orderservice.entity.Orderr;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//
//import java.util.List;
//
//public interface OrderrRepository extends JpaRepository<Orderr, Long> {
//    List<Orderr> getOrderrsByOrderStatusNotLikeAndCustomer_IdIs(OrderStatus orderStatus, Long id);
//
//    List<Orderr> getOrderrsByOrderStatusNotLike(OrderStatus orderStatus);
//
//    @Query(value = "SELECT * FROM ORDERR\n" +
//            "WHERE COOK_ID  = ?1 AND ORDER_STATUS = 'IN_PROGRESS'", nativeQuery = true)
//    List<Orderr> getCookActiveAssignedOrders(Long id);
//
//    @Query(value = "SELECT * FROM ORDERR\n" +
//            "WHERE DELIVERY_GUY_ID  = ?1 AND ORDER_STATUS = 'IN_DELIVERY'", nativeQuery = true)
//    List<Orderr> getDeliveryGuyActiveAssignedOrders(Long id);
//}
