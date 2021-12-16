package com.sci.models;

public class Order {
    int orderId,customerId,price;

    @Override
    public String toString() {
        return "Order [customerId=" + customerId + ", orderId=" + orderId + ", price=" + price + "]";
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    
}
