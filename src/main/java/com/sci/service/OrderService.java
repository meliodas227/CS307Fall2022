package com.sci.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.sci.models.Order;
import com.sci.utils.Constant;

public class OrderService implements AutoCloseable {
    private final PreparedStatement selectOrders;
    private final PreparedStatement selectOrderById;
    private final PreparedStatement deleteOrder;
    private final PreparedStatement updateOrder;
    private final PreparedStatement insertOrder;

    public OrderService(Connection connection) throws SQLException {
        selectOrders = connection.prepareStatement(Constant.SELECT_ORDER);
        selectOrderById = connection.prepareStatement(Constant.SELECT_ORDER_BY_ID);
        updateOrder = connection.prepareStatement(Constant.UPDATE_ORDER);
        deleteOrder = connection.prepareStatement(Constant.DELETE_ORDER);
        insertOrder = connection.prepareStatement(Constant.INSERT_ORDER);
    }

    @Override
    public void close() throws Exception {
        selectOrders.close();
        selectOrderById.close();
        deleteOrder.close();
        updateOrder.close();
        insertOrder.close();
    }
    public List<Order> getAll(){
        List<Order> res = new ArrayList<>();
        try {
            ResultSet resultSet= selectOrders.executeQuery();
            while (resultSet.next()) {
                Order order = new Order();
                order.setCustomerId(resultSet.getInt("customer_id"));
                order.setOrderId(resultSet.getInt("order_id"));
                order.setPrice(resultSet.getInt("price"));
                res.add(order);
            }
        } catch (Exception e) {
            System.err.println("DB error: "+e.getMessage());
        }
        return res;
    }
    public Order getById(int orderId) throws SQLException{
        Order order = null;
        selectOrderById.clearParameters();
        selectOrderById.setInt(1, orderId);
        try {
            ResultSet resultSet = selectOrderById.executeQuery();
            order = new Order();
            order.setCustomerId(resultSet.getInt("customer_id"));
            order.setOrderId(orderId);
            order.setPrice(resultSet.getInt("price"));
        } catch (Exception e) {
            System.err.println("DB error: "+e.getMessage());
        }
        return order;
    }
    public void deleteOrder(int orderId) throws SQLException{
        deleteOrder.clearParameters();
        deleteOrder.setInt(1, orderId);
        deleteOrder.executeQuery();
    }
    public void updateOrder(Order order) throws SQLException{
        updateOrder.clearParameters();
        updateOrder.setInt(1, order.getCustomerId());
        updateOrder.setInt(2, order.getPrice());
        updateOrder.setInt(3, order.getOrderId());
        updateOrder.executeQuery();
    }
    public void insertOrder(Order order) throws SQLException{
        insertOrder.clearParameters();
        insertOrder.setInt(1, order.getOrderId());
        insertOrder.setInt(2, order.getCustomerId());
        insertOrder.setInt(3, order.getPrice());
        insertOrder.executeQuery();
    }
}
