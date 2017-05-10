package form;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.URL;
import org.jboss.logging.annotations.Message;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * Created by admin on 02.05.2017.
 */
public class ItemCreatingForm {

    @NotEmpty(message = "Название товара")
    private String itemName;
    @NotEmpty(message = "Описание товара")
    @Size(max = 500)
    private String description;
    @NotEmpty(message = "Город склада")
    private String city;
    @NotEmpty(message = "Адрес склада")
    private String address;
    @NotNull(message = "Количество товара на складе")
    private Integer amount;
    @URL(message = "URL для обложки товара")
    private String url;

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
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getAmount() {
        return amount;
    }
    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
