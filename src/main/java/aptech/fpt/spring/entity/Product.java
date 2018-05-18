package aptech.fpt.spring.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank(message = "Tên không thể để trống.")
    @Size(min = 7, message = "Tên phải dài hơn 7 ký tự.")
    private String name;
    private int categoryId;
    private String description;
    private String imgUrl;
    @Min(1)
    private int price;
    private long createdTime;
    private long editedTime;
    private int status;

    public Product() {
    }

    public Product(@NotNull @Size(min = 8) String name, @NotNull String imgUrl, @Min(1) int price, int categoryId, String description) {
        this.name = name;
        this.categoryId = categoryId;
        this.description = description;
        this.imgUrl = imgUrl;
        this.price = price;
        this.createdTime = System.currentTimeMillis();
        this.editedTime = System.currentTimeMillis();
        this.status = 1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public long getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(long createdTime) {
        this.createdTime = createdTime;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getEditedTime() {
        return editedTime;
    }

    public void setEditedTime(long editedTime) {
        this.editedTime = editedTime;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
