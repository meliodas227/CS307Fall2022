package com.sci.models;

public class OrderItems {
    int orerItemsId,orderId,productId,quantity;

    public int getOrerItemsId() {
        return orerItemsId;
    }

    public void setOrerItemsId(int orerItemsId) {
        this.orerItemsId = orerItemsId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "OrderItems [orderId=" + orderId + ", orerItemsId=" + orerItemsId + ", productId=" + productId
                + ", quantity=" + quantity + "]";
    }
    
}
