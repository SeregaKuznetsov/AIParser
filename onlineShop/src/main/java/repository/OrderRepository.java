package repository;

import model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Sergey on 08.05.2017.
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order findOneById(Integer id);
    List<Order> findAllByUserId(Integer id);
}
