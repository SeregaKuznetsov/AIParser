package model;


import org.hibernate.validator.constraints.URL;

import javax.persistence.*;

/**
 * Created by admin on 24.04.2017.
 */
@Entity
@Table(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Column(unique = true)
    private String itemName;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column
    private Integer amount;
    @Column(name = "image")
    @URL
    private String url;

    public Item() {
    }

    public Item(String itemName, String description, Integer amount, String url) {
        this.itemName = itemName;
        this.description = description;
        this.amount = amount;
        this.url = url;
    }

    public Item(String itemName, String description, Integer amount) {
        this.itemName = itemName;
        this.description = description;
        this.amount = amount;
    }


    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

}
