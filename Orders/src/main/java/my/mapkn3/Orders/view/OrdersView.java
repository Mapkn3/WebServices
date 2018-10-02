package my.mapkn3.Orders.view;

import my.mapkn3.Orders.model.Order;
import my.mapkn3.Orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class OrdersView implements Serializable {
    private List<Order> orders;
    private Order selectedOrder;
    @Autowired
    private OrderService orderService;

    @PostConstruct
    void init() {
        orders = orderService.getAllOrders();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Order getSelectedOrder() {
        return selectedOrder;
    }

    public void setSelectedOrder(Order selectedOrder) {
        this.selectedOrder = selectedOrder;
    }
}
