package com.sci.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sci.models.Product;
import com.sci.utils.Constant;

public class ProductService implements AutoCloseable{
    private final PreparedStatement selectProducts;
    private final PreparedStatement selectProductById;
    private final PreparedStatement deleteProduct;
    private final PreparedStatement updateProduct;
    private final PreparedStatement insertProduct;
    public ProductService(Connection connection) throws SQLException{
        selectProducts = connection.prepareStatement(Constant.SELECT_PRODUCTS);
        selectProductById = connection.prepareStatement(Constant.SELECT_PRODUCT_BY_ID);
        updateProduct = connection.prepareStatement(Constant.UPDATE_PRODUCT);
        deleteProduct = connection.prepareStatement(Constant.DELETE_PRODUCT);
        insertProduct = connection.prepareStatement(Constant.INSERT_PRODUCT);
    }
    @Override
    public void close() throws Exception {
       selectProducts.close();
       selectProductById.close();
       deleteProduct.close();
       updateProduct.close();
       insertProduct.close();
    }
    public List<Product> getAll(){
        List<Product> res = new ArrayList<>();
        try {
            ResultSet resultSet = selectProducts.executeQuery();
            while (resultSet.next()) {
                Product product = new Product();
                product.setName(resultSet.getString("name"));
                product.setProductId(resultSet.getInt("product_id"));
                res.add(product);
            }
        } catch (Exception e) {
            System.err.println("DB error: "+e.getMessage());
        }
        return res;
    }
    public Product getById(int productId) throws SQLException {
        selectProductById.clearParameters();
        selectProductById.setInt(1, productId);
        ResultSet resultSet = selectProductById.executeQuery();
        Product product = new Product();
        product.setName(resultSet.getString("name"));
        product.setPrice(resultSet.getInt("price"));
        product.setProductId(productId);
        return product;
    }
    public void deleteProduct(int productId) throws SQLException{
        deleteProduct.clearParameters();
        deleteProduct.setInt(1,productId);
        deleteProduct.executeQuery();
    }
    public void updateProduct(Product product) throws SQLException{
        updateProduct.clearParameters();
        updateProduct.setInt(1, product.getPrice());
        updateProduct.setString(2, product.getName());
        updateProduct.setInt(3, product.getProductId());
        updateProduct.executeQuery();
    }
    public void insertProduct(Product product) throws SQLException{
        insertProduct.clearParameters();
        insertProduct.setInt(3, product.getPrice());
        insertProduct.setString(2, product.getName());
        insertProduct.setInt(1, product.getProductId());
        insertProduct.executeQuery();
    }
}
