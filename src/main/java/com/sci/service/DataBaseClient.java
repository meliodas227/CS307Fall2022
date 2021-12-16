package com.sci.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import com.sci.models.*;
import com.sci.utils.Constant;

public class DataBaseClient implements AutoCloseable{
    private final Connection connection;
    private final CustomerService customerService;
    private final OrderItemsService orderItemsService;
    private final OrderService orderService;
    private final ProductService productService;
    public DataBaseClient() throws SQLException{
        connection=DriverManager.getConnection(Constant.DB_URL, Constant.USERNAME, Constant.PASSWORD);
        customerService = new CustomerService(connection);
        orderItemsService = new OrderItemsService(connection);
        orderService = new OrderService(connection);
        productService = new ProductService(connection);
    }
    @Override
    public void close() throws SQLException {
    connection.close();
    }
    public List<Customer> getAllCustomers(){
        return customerService.getAll();
    }
    public Customer getCustomerById(int customerId) throws SQLException{
        return customerService.getById(customerId);
    }
    public void deleteCustomer(int customerId) throws SQLException{
        customerService.deleteCustomer(customerId);
    }
    public void updateCustomer(Customer customer) throws SQLException{
        customerService.updateCustomer(customer);
    }
    public void insertCustomer(Customer customer) throws SQLException{
        customerService.insertCustomer(customer);
    }

    public List<Order> getAllOrders(){
        return orderService.getAll();
    }
    public Order getOrderById(int orderId) throws SQLException{
        return orderService.getById(orderId);
    }
    public void deleteOrder(int orderId) throws SQLException{
        orderService.deleteOrder(orderId);
    }
    public void updateOrder(Order order) throws SQLException{
        orderService.updateOrder(order);
    }
    public void insertOrder(Order order) throws SQLException{
        orderService.insertOrder(order);
    }

    public List<OrderItems> getAllItems(){
        return orderItemsService.getAll();
    }
    public OrderItems getOrderItemById(int orderItemId)throws SQLException {
        return orderItemsService.getById(orderItemId);
    }
    public void deleteOrderItem(int orderItemId) throws SQLException{
        orderItemsService.deleteOrderItems(orderItemId);
    }
    public void updateOrderItem(OrderItems orderItems) throws SQLException{
        orderItemsService.updateOrderItem(orderItems);
    }
    public void insertOrderItem(OrderItems orderItems) throws SQLException{
        orderItemsService.insertOrderItem(orderItems);
    }

    public List<Product> getAllProducts(){
        return productService.getAll();
    }
    public Product getById(int productId)throws SQLException{
        return productService.getById(productId);
    }
    public void updateProduct(Product product) throws SQLException{
        productService.updateProduct(product);
    }
    public void deleteProduct(int productId) throws SQLException{
        productService.deleteProduct(productId);
    }
    public void insertProduct(Product product) throws SQLException{
        productService.insertProduct(product);
    }
}
