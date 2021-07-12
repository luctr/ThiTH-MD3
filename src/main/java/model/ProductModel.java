package model;

import java.util.List;

public class ProductModel {
    private int id;
    private String product_name;
    private int price;
    private int quantity;
    private String color;
    private String description;
    private String category_name;

    public ProductModel() {
    }

    public ProductModel(int id, String product_name, int price, int quantity, String color, String description, String category_name) {
        this.id = id;
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.category_name = category_name;
    }

    public ProductModel(String product_name, int price, int quantity, String color, String description, String category_name) {
        this.product_name = product_name;
        this.price = price;
        this.quantity = quantity;
        this.color = color;
        this.description = description;
        this.category_name = category_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }
}
