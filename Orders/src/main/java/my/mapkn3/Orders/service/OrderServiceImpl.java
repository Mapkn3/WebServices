package my.mapkn3.Orders.service;

import my.mapkn3.Orders.dao.PrettyEntityDao;
import my.mapkn3.Orders.model.Order;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private static final Logger logger = Logger.getLogger(OrderServiceImpl.class);

    @Autowired
    private PrettyEntityDao orderDao;

    @Transactional(readOnly = true)
    @Override
    public Order getOrder(Long id) {
        logger.debug("Getting order with id = " + id);
        return orderDao.findById(Order.class, id);
    }

    @Override
    public Long addNewOrder(Order order) {
        Long id = (Long) orderDao.save(order);
        logger.debug("Id of new order: " + id);
        return id;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = orderDao.getAll(Order.class);
        logger.debug("Get " + orders.size() + " orders:\n");
        orders.forEach(logger::debug);
        return orders;
    }

    @Override
    public Order updateOrder(Order order) {
        Order oldOrder = orderDao.findById(Order.class, order.getId());
        Order newOrder = orderDao.update(order);
        logger.debug("Old order: " + oldOrder);
        logger.debug("New order: " + newOrder);
        return newOrder;
    }

    @Override
    public void deleteOrder(Order order) {
        logger.debug("Delete order: " + order);
        orderDao.delete(order);
    }
}
