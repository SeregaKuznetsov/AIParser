package repository;

import model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by admin on 02.05.2017.
 */
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findOneById(Integer id);
    List<Item> findAll();
    Item findOneByItemName(String itemName);
}
