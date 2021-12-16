package com.sci.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sci.models.OrderItems;
import com.sci.utils.Constant;

public class OrderItemsService implements AutoCloseable {
    private final PreparedStatement selectItems;
    private final PreparedStatement selectItemsById;
    private final PreparedStatement deleteItem;
    private final PreparedStatement updateItem;
    private final PreparedStatement insertItem;
    public OrderItemsService(Connection connection) throws SQLException{
        selectItems = connection.prepareStatement(Constant.SELECT_ORDER_ITEMS);
        selectItemsById = connection.prepareStatement(Constant.SELECT_ORDER_ITEMS_BY_ID);
        deleteItem = connection.prepareStatement(Constant.DELETE_ORER_ITEMS);
        updateItem = connection.prepareStatement(Constant.UPDATE_ORDER_ITEMS);
        insertItem = connection.prepareStatement(Constant.INSERT_ORDER_ITEM);
    }
    @Override
    public void close() throws Exception {
        selectItems.close();
       selectItemsById.close();
       deleteItem.close();
       updateItem.close();
       insertItem.close();
    }
    public List<OrderItems> getAll(){
        List<OrderItems> res = new ArrayList<>();
        try {
            ResultSet resultSet = selectItems.executeQuery();
            while (resultSet.next()) {
                OrderItems orderItems= new OrderItems();
                orderItems.setOrderId(resultSet.getInt("order_id"));
                orderItems.setOrerItemsId(resultSet.getInt("order_items_id"));
                orderItems.setProductId(resultSet.getInt("product_id"));
                orderItems.setQuantity(resultSet.getInt("quantity"));
                res.add(orderItems);
            }
        } catch (Exception e) {
            System.err.println("DB error: "+e.getMessage());
        }
        return res;
    }
    public OrderItems getById(int orderItemsId)throws SQLException{
        OrderItems orderItems = null;
        selectItemsById.clearParameters();
        selectItemsById.setInt(1, orderItemsId);
        try {
            ResultSet resultSet = selectItemsById.executeQuery();
            orderItems = new OrderItems();
            orderItems.setOrderId(resultSet.getInt("order_id"));
            orderItems.setOrerItemsId(resultSet.getInt("order_items_id"));
            orderItems.setProductId(resultSet.getInt("product_id"));
            orderItems.setQuantity(resultSet.getInt("quantity"));
        } catch (Exception e) {
            System.err.println("DB error: "+e.getMessage());
        }
        return orderItems;
    }
    public void deleteOrderItems(int orderItemsId)throws SQLException{
        deleteItem.clearParameters();
        deleteItem.setInt(1, orderItemsId);
        deleteItem.executeQuery();
    }
    public void updateOrderItem(OrderItems orderItems) throws SQLException{
        updateItem.clearParameters();
        updateItem.setInt(1, orderItems.getOrderId());
        updateItem.setInt(2, orderItems.getProductId());
        updateItem.setInt(3, orderItems.getQuantity());
        updateItem.setInt(4, orderItems.getOrerItemsId());
        updateItem.executeQuery();
    }
    public void insertOrderItem(OrderItems orderItems) throws SQLException{
        insertItem.clearParameters();
        insertItem.setInt(1, orderItems.getOrerItemsId());
        insertItem.setInt(2, orderItems.getOrderId());
        insertItem.setInt(3, orderItems.getProductId());
        insertItem.setInt(4, orderItems.getQuantity());
        insertItem.executeQuery();
    }

}
