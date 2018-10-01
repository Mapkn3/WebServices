package my.mapkn3.Orders.service;

import my.mapkn3.Orders.dao.PrettyEntityDao;
import my.mapkn3.Orders.model.Order;
import my.mapkn3.Orders.model.OrderDetail;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderDetailServiceImpl implements OrderDetailService {
    private static final Logger logger = Logger.getLogger(OrderDetailServiceImpl.class);

    @Autowired
    private PrettyEntityDao orderDetailDao;

    @Transactional(readOnly = true)
    @Override
    public OrderDetail getOrderDetail(Long id) {
        logger.debug("Getting order detail with id = " + id);
        return orderDetailDao.findById(OrderDetail.class, id);
    }

    @Override
    public Long addNewOrderDetail(OrderDetail orderDetail) {
        Long id = (Long) orderDetailDao.save(orderDetail);
        logger.debug("Id of new order detail: " + id);
        return id;
    }

    @Transactional(readOnly = true)
    @Override
    public List<OrderDetail> getAllOrderDetails() {
        List<OrderDetail> orderDetails = orderDetailDao.getAll(OrderDetail.class);
        logger.debug("Get " + orderDetails.size() + " order details:\n");
        orderDetails.forEach(logger::debug);
        return orderDetails;
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        OrderDetail oldOrderDetail = orderDetailDao.findById(OrderDetail.class, orderDetail.getId());
        OrderDetail newOrderDetail = orderDetailDao.update(orderDetail);
        logger.debug("Old order detail: " + oldOrderDetail);
        logger.debug("New order detail: " + newOrderDetail);
        return newOrderDetail;
    }

    @Override
    public void deleteOrderDetail(OrderDetail orderDetail) {
        logger.debug("Delete order detail: " + orderDetail);
        orderDetailDao.delete(orderDetail);
    }

    @Transactional(readOnly = true)
    @Override
    public List<OrderDetail> getOrderDetailsForOrder(Order order) {
        return getAllOrderDetails().stream()
                .filter(orderDetail -> orderDetail.getOrder().equals(order))
                .collect(Collectors.toList());
    }
}
