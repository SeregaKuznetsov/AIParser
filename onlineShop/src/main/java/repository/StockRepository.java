package repository;

import model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by admin on 03.05.2017.
 */
public interface StockRepository extends JpaRepository<Stock,Long> {
}
