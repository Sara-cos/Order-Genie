package com.tesseract.ordergenie.dao;

import com.tesseract.ordergenie.model.*;


import java.sql.*;
import java.util.ArrayList;

public class StorageImpl {
    ArrayList<Customer> customerList = new ArrayList<>();

    static Connection con = null;

    public static Connection getConnection() {

        String dbUrl = "jdbc:mysql://localhost:3306/order-genie";
        String username = "root", password = "Parag@1967";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(dbUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    public void addList() {
        Customer customer = new Customer();
        try {

            Connection con = null;
            con = getConnection();
            String queryString = "SELECT * FROM customer";
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(queryString);
            ResultSet results = ps.executeQuery(queryString);
            while (results.next()) {
                customer = new Customer();
                customer.setCustomerId(results.getInt("customerId"));
                customer.setCustomerName(results.getString("customerName"));
                customer.setCustomerGstNumber(results.getString("customerGstNumber"));
                customer.setCustomerAddress(results.getString("customerAddress"));
                customer.setCustomerCity(results.getString("customerCity"));
                customer.setPhone(results.getLong("phone"));
                this.customerList.add(customer);
            }
        } catch (SQLException sql) {
            System.out.println(sql);
        }

    }

    public ArrayList<Customer> getList(){
        return customerList;
    }

    public ArrayList<Product> setList(ArrayList<Product> p){
        return p;

    }
}
