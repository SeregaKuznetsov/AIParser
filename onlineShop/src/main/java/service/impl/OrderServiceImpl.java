package service.impl;

import model.ItemsInOrder;
import model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ItemInOrderRepository;
import repository.OrderRepository;
import service.OrderService;

import java.util.List;

/**
 * Created by Sergey on 08.05.2017.
 */

@Service("orderService")
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    ItemInOrderRepository itemInOrderRepository;

    @Override
    public void save(Order order) {
        orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        List<Order> list = orderRepository.findAll();
        return list;
    }

    @Override
    public Order findOneById(Integer id) {
        return orderRepository.findOneById(id);
    }

    @Override
    public List<Order> findAllByUserId(Integer id) {
        return orderRepository.findAllByUserId(id);
    }

    @Override
    public void saveItemInOrder(ItemsInOrder itemsInOrder) {
        itemInOrderRepository.save(itemsInOrder);
    }
}
