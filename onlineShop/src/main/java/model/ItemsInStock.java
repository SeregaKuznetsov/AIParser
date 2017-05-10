package model;

import javax.persistence.*;

/**
 * Created by admin on 26.04.2017.
 */
@Entity
@Table(name = "itemsInStock")
public class ItemsInStock {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToOne(optional = false)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @OneToOne(optional = false)
    @JoinColumn(name = "stock_id", nullable = false)
    private Stock stock;

    public ItemsInStock() {
    }

    public ItemsInStock(Item item, Stock stock) {
        this.item = item;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public void setStock(Stock stock) {
        this.stock = stock;
    }
    public Item getItem() {
        return item;
    }
    public Stock getStock() {
        return stock;
    }
}
