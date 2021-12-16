package com.sci.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sci.models.Customer;
import com.sci.utils.Constant;

public class CustomerService implements AutoCloseable{
    private final PreparedStatement selectCustomer;
    private final PreparedStatement selectCustomerById;
    private final PreparedStatement deleteCustomer;
    private final PreparedStatement updateCustomer;
    private final PreparedStatement insertCustomer;
    public CustomerService(Connection connection) throws SQLException{
        selectCustomer=connection.prepareStatement(Constant.SELECT_CUSTOMER);
        selectCustomerById = connection.prepareStatement(Constant.SELECT_CUSTOMER_BY_ID);
        deleteCustomer = connection.prepareStatement(Constant.DELETE_CUSTOMER);
        updateCustomer = connection.prepareStatement(Constant.UPDATE_CUSTOMER);
        insertCustomer = connection.prepareStatement(Constant.INSERT_CUSTOMER);
    }
    @Override
    public void close() throws Exception {
       selectCustomer.close();
       selectCustomerById.close();
       deleteCustomer.close();
       updateCustomer.close();
       insertCustomer.close();
    }   
    public List<Customer> getAll(){
        List<Customer> res = new ArrayList<>();
        try{
            ResultSet resultSet = selectCustomer.executeQuery();
            while (resultSet.next()) {
                Customer customer = new Customer();
                customer.setCustomerId(resultSet.getInt("customer_id"));
                customer.setEmail(resultSet.getString("email"));
                customer.setLastName(resultSet.getString("last_name"));
                customer.setPhone(resultSet.getString("phone"));
                res.add(customer);
            }
        } catch(Exception e){
            System.err.println("DB error: "+e.getMessage());
        }
        return res;
    }
    public Customer getById(int customerId){
        Customer customer = null;
        try {
            selectCustomerById.clearParameters();
            selectCustomerById.setInt(1, customerId);
            ResultSet resultSet = selectCustomerById.executeQuery();
            customer=new Customer();
            customer.setCustomerId(customerId);
            customer.setEmail(resultSet.getString("email"));
            customer.setLastName(resultSet.getString("last_name"));
            customer.setPhone(resultSet.getString("phone"));
        } catch (Exception e) {
            System.err.println("DB error: "+e.getMessage());
        }
        return customer;
    }
    public void deleteCustomer(int customerId) throws SQLException{
        deleteCustomer.clearParameters();
        deleteCustomer.setInt(1, customerId);
        deleteCustomer.executeQuery();
    }
    public void updateCustomer(Customer customer) throws SQLException{
        updateCustomer.clearParameters();
        updateCustomer.setString(1, customer.getLastName());
        updateCustomer.setString(2, customer.getPhone());
        updateCustomer.setString(3, customer.getEmail());
        updateCustomer.setInt(4, customer.getCustomerId());
        updateCustomer.executeQuery();
    }
    public void insertCustomer(Customer customer) throws SQLException{
        insertCustomer.clearParameters();
        insertCustomer.setInt(1, customer.getCustomerId());
        insertCustomer.setString(2, customer.getLastName());
        insertCustomer.setString(3, customer.getPhone());
        insertCustomer.setString(4, customer.getEmail());
        insertCustomer.executeQuery();
    }
}
