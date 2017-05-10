package model;

import model.enums.ItemStatus;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by admin on 26.04.2017.
 */
@Entity
@Table(name = "orders") //"order" is a keyword of SQL
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @OneToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    private ItemStatus status;

    public Order() {}

    public Order(int id, User user, ItemStatus itemStatus) {
        this.user = user;
        this.id = id;
        this.status = itemStatus;
    }

    public Order(ItemStatus itemStatus) {
        this.status = itemStatus;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public Order(User user, ItemStatus status) {
        this.user = user;
        this.status = status;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ItemStatus getStatus() {
        return status;
    }
    public void setStatus(ItemStatus status) {
        this.status = status;
    }
}
