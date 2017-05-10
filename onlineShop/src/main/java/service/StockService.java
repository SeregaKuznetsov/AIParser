package service;

import model.ItemsInStock;
import model.Stock;

import java.util.List;

/**
 * Created by admin on 03.05.2017.
 */
public interface StockService {
    //void saveStock(ItemCreatingForm form);
    void save(Stock stock);
    List<Stock> getAllItems();
    void saveItemInStock(ItemsInStock itemsInStock);
//    Stock editStock(Stock stock);
}
