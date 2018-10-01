package my.mapkn3.Orders.service;

import my.mapkn3.Orders.model.Order;
import my.mapkn3.Orders.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    OrderDetail getOrderDetail(Long id);

    Long addNewOrderDetail(OrderDetail orderDetail);

    List<OrderDetail> getAllOrderDetails();

    OrderDetail updateOrderDetail(OrderDetail orderDetail);

    void deleteOrderDetail(OrderDetail orderDetail);

    List<OrderDetail> getOrderDetailsForOrder(Order order);
}
