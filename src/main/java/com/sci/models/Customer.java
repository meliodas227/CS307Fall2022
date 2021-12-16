package com.sci.models;

public class Customer{

    private int customerId;
    private String lastName;
    private String phone;
    private String email;
    
    
    public int getCustomerId() {
        return customerId;
    }
    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString() {
        return "Customer [customerId=" + customerId + ", email=" + email + ", lastName=" + lastName + ", phone=" + phone
                + "]";
    }
}