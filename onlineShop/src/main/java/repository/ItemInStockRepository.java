package repository;

import model.ItemsInStock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 04.05.2017.
 */
public interface ItemInStockRepository extends JpaRepository<ItemsInStock,Long> {
}
