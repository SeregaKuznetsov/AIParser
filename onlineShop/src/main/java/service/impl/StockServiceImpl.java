package service.impl;

import model.ItemsInStock;
import model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ItemInStockRepository;
import repository.StockRepository;
import service.StockService;

import java.util.List;

/**
 * Created by admin on 03.05.2017.
 */
@Service("stockService")
public class StockServiceImpl implements StockService {
    @Autowired
    StockRepository stockRepository;
    @Autowired
    ItemInStockRepository itemInStockRepository;

//    @Override
//    public void saveStock(ItemCreatingForm form) {
//        Stock stock = ItemCreatingFormToStockTransformer.transform(form);
//        stockRepository.save(stock);
//    }

    @Override
    public void save(Stock stock) {
        stockRepository.save(stock);
    }

    @Override
    public List<Stock> getAllItems() {
        List<Stock> list = stockRepository.findAll();
        return list;
    }

    @Override
    public void saveItemInStock(ItemsInStock itemsInStock) {
        itemInStockRepository.save(itemsInStock);
    }
}
