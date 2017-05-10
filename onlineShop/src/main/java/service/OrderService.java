package service;

import model.ItemsInOrder;
import model.Order;

import java.util.List;

/**
 * Created by Sergey on 08.05.2017.
 */
public interface OrderService {
    void save(Order order);
    List<Order> getAllOrders();
    Order findOneById(Integer id);
    List<Order> findAllByUserId(Integer id);
    void saveItemInOrder(ItemsInOrder itemsInOrder);
}
