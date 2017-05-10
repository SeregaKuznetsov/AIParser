package repository;

import model.ItemsInOrder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by Sergey on 08.05.2017.
 */
public interface ItemInOrderRepository extends JpaRepository<ItemsInOrder,Long> {
    List<ItemsInOrder> getItemsInOrdersByOrderUserId(Integer id);
}
