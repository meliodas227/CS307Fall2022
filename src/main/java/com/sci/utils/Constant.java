package com.sci.utils;

public interface Constant {
    String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
    String USERNAME = "system";
    String PASSWORD = "system";
  
    String SELECT_CUSTOMER = "select * from customer";
    String SELECT_CUSTOMER_BY_ID = "select * from customer where customer_id=?";
    String UPDATE_CUSTOMER = "update customer set last_name=?, phone=?, email=? where customer_id=?";
    String DELETE_CUSTOMER = "delete from customer where customer_id = ?";
    String INSERT_CUSTOMER = "insert into customer values( ?,?,?,?)";

    String SELECT_ORDER = "select * from theorder";
    String SELECT_ORDER_BY_ID = "select * from theorder";
    String UPDATE_ORDER = "update theorder set customer_id=? , price = ? where order_id =?";
    String DELETE_ORDER = "delete from theorder where order_id=?";
    String INSERT_ORDER = "insert into theorder values (?,?,?)";
    
    String SELECT_ORDER_ITEMS = "select * from order_items";
    String SELECT_ORDER_ITEMS_BY_ID = "select * from order_items where order_items_id = ?";
    String UPDATE_ORDER_ITEMS = "update order_items set order_id=? , product_id=? , quantity=? where order_Items_id=? ";
    String DELETE_ORER_ITEMS = "delete from order_items where order_items_id = ?";
    String INSERT_ORDER_ITEM = "insert INto order_items values (?,?,?,?)";

    String SELECT_PRODUCTS = "select * from product";
    String SELECT_PRODUCT_BY_ID = "select * from product where product_id=?";
    String UPDATE_PRODUCT = "update product set price = ?,name=? where product_id = ?";
    String DELETE_PRODUCT = "delete from product where product_id =?";
    String INSERT_PRODUCT = "insert into product values (?,?,?)";
}
