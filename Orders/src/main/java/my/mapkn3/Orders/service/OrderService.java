package my.mapkn3.Orders.service;

import my.mapkn3.Orders.model.Order;

import java.util.List;

public interface OrderService {
    Order getOrder(Long id);

    Long addNewOrder(Order order);

    List<Order> getAllOrders();

    Order updateOrder(Order order);

    void deleteOrder(Order order);
}
