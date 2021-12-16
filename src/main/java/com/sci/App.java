package com.sci;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sci.models.*;
import com.sci.service.DataBaseClient;

public class App{
    public static DataBaseClient db;
    public static Scanner input;
    public static void main(String[] args) throws SQLException {
        input=new Scanner(System.in);
        db=new DataBaseClient();
        int operation;
        while ((operation=input.nextInt())!=0) {
            switch(operation){
                case 1: handleSelectAllCustomers();
                break;
                case 2:handleInsertCustomer();
                break;
            }

        }
    }
    public static void handleUpdateCustomer() throws SQLException{
        System.out.print("enter customer id, last name, email, phone: ");
        int customerId = input.nextInt();
        String lastName = input.next();
        String email = input.next();
        String phone = input.next();
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setEmail(email);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        db.updateCustomer(customer);
    }
    public static void handleSelectAllCustomers() throws SQLException{
        List<Customer> customersList = db.getAllCustomers();
        for(Customer customer : customersList){
            System.out.println(customer);
        }
    }
    public static void handleDeleteCustomer() throws SQLException{
        System.out.print("enter customer id: ");
        int customerId = input.nextInt();
        db.deleteCustomer(customerId);
    }
    public static void handleInsertCustomer() throws SQLException{
        System.out.print("enter customer id, last name, email, phone: ");
        int customerId = input.nextInt();
        String lastName = input.next();
        String email = input.next();
        String phone = input.next();
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setEmail(email);
        customer.setLastName(lastName);
        customer.setPhone(phone);
        db.insertCustomer(customer);
    }
    public static void handleSelectCustomerById() throws SQLException{
        System.out.print("enter customer id: ");
        int customerId = input.nextInt();
        System.out.println(db.getCustomerById(customerId));
    }

    public static void handleSelectOrders() throws SQLException{
        List<Order> orderList = db.getAllOrders();
        for(Order order: orderList){
            System.out.println(order);
        }
    }
    public static void handleSelectOrderById() throws SQLException{
        System.out.print("enter order id: ");
        int orderId = input.nextInt();
        System.out.println(db.getOrderById(orderId));
    }
    public static void handleDeleteOrder() throws SQLException{
        System.out.print("enter order id: ");
        int orderId = input.nextInt();
        db.deleteOrder(orderId);
    }
    public static void handleUpdateOrder() throws SQLException{
        System.out.print("enter order id , customer id , price: ");
        int orderId = input.nextInt(), customerId = input.nextInt(), price = input.nextInt();
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderId(orderId);
        order.setPrice(price);
        db.updateOrder(order);
    }
    public static void handleInsertOrder() throws SQLException{
        System.out.print("enter order id , customer id , price: ");
        int orderId = input.nextInt(), customerId = input.nextInt(), price = input.nextInt();
        Order order = new Order();
        order.setCustomerId(customerId);
        order.setOrderId(orderId);
        order.setPrice(price);
        db.insertOrder(order);
    }
    
    public static void handleSelectOrderItems() throws SQLException{
        List<OrderItems> orderItemsList = db.getAllItems();
        for(OrderItems orderItems : orderItemsList){
            System.out.println(orderItems);
        }
    }
    public static void handleDeleteOrderItem() throws SQLException{
        System.out.print("enter order item id: ");
        int orderItemId = input.nextInt();
        db.deleteOrderItem(orderItemId);
    }
    public static void handlegetOrderItemById() throws SQLException{
        System.out.print("enter order item id: ");
        int orderItemId = input.nextInt();
        System.out.println(db.getOrderItemById(orderItemId));
    }
    public static void handleOrderItemUpdate() throws SQLException{
        System.out.print("enter order item id, order id, product id , quantity: ");
        int itemId = input.nextInt(),orderId=input.nextInt(), productId=input.nextInt(), quantity=input.nextInt();
        OrderItems orderItems = new OrderItems();
        orderItems.setOrderId(orderId);
        orderItems.setOrerItemsId(itemId);
        orderItems.setProductId(productId);
        orderItems.setQuantity(quantity);
        db.updateOrderItem(orderItems);
    }
    public static void handleInsertOrderItem() throws SQLException{
        System.out.print("enter order item id, order id, product id , quantity: ");
        int itemId = input.nextInt(),orderId=input.nextInt(), productId=input.nextInt(), quantity=input.nextInt();
        OrderItems orderItems = new OrderItems();
        orderItems.setOrderId(orderId);
        orderItems.setOrerItemsId(itemId);
        orderItems.setProductId(productId);
        orderItems.setQuantity(quantity);
        db.insertOrderItem(orderItems);
    }

}
