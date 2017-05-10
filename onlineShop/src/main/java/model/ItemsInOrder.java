package model;

import javax.persistence.*;

/**
 * Created by admin on 26.04.2017.
 */
@Entity
@Table(name = "itemsInOrder")
public class ItemsInOrder {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "item_id", nullable = false, unique = false)
    private Item item;

    @ManyToOne(optional = false)
    @JoinColumn(name = "order_id", nullable = false, unique = false)
    private Order order;

    public ItemsInOrder() {
    }

    public ItemsInOrder(Item item, Order order) {
        this.item = item;
        this.order = order;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
