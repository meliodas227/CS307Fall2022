package com.sci.models;

public class Product {
    private int productId;
    private int price;
    private String name;
   
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    @Override
    public String toString() {
        return "Product [name=" + name + ", price=" + price + ", productId=" + productId + "]";
    }
}
