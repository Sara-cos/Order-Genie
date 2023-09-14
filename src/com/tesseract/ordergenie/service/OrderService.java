package com.tesseract.ordergenie.service;

import com.tesseract.ordergenie.dao.StorageImpl;
import com.tesseract.ordergenie.model.*;
import com.tesseract.ordergenie.dao.*;
import com.tesseract.ordergenie.service.*;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderService {
    StorageImpl si = new StorageImpl();
    ArrayList<Customer> arr;
    ArrayList<Product> prodList = new ArrayList<>();

    public OrderService() {
        si.addList();
        arr = si.getList();
    }


    int i = 0;

    static Connection con = null;

    public static Connection getConnection() {

        String dbUrl = "jdbc:mysql://localhost:3306/order-genie";
        String username = "root", password = "123456";
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(dbUrl, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }

    Customer c = new Customer();

    public void addProduct(int custid, int prodId) {
        Product p = new Product();
        try {
            Connection con = null;
            con = getConnection();
            String queryString = "SELECT * FROM products where productId=" + prodId;
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(queryString);
            ResultSet results = ps.executeQuery(queryString);
            while (results.next()) {
                p.setProductId(results.getInt("productId"));
                p.setProductName(results.getString("productName"));
                p.setProductPrice(results.getInt("productPrice"));
                p.setCategory(results.getString("productCategory"));
                p.setQuantity(results.getInt("productQuantity"));
            }
            System.out.println(p.getCategory());
        } catch (SQLException sql) {
            System.out.println(sql);
        }
        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getCustomerId() == custid) {
                prodList.add(p);
                arr.get(i).setProductList(prodList);
            }
        }
    }

    public ArrayList<Product> getProduct(int id) {


        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i).getCustomerId() == id)
                return arr.get(i).getProductList();

        }
        return null;
    }


    //public void getOrderByCustomerId();

    Order o = new Order();

    public double totalShippingCost() {
        ProductJdbc pj = new ProductJdbc();
        double totalSC = 0.0;
        if (o.getOrderValue() > 100000) {
            o.setShippingCost(0);
        } else {
            for (int i = 0; i < prodList.size(); i++) {
                totalSC += pj.ShipCost(prodList.get(i));
            }

        }
        return totalSC;
    }

    public String getOrderStatus(int customerId) {
        String status="";
        try {
            Connection con = null;
            con = getConnection();
            String queryString = "SELECT * FROM order1 where customerId=" + customerId;
            Statement st = con.createStatement();
            PreparedStatement ps = con.prepareStatement(queryString);
            ResultSet results = ps.executeQuery(queryString);
            while (results.next()) {
                status = results.getString("orderStatus");
            }
        } catch (SQLException sql) {
            System.out.println(sql);
        }
        return status;
    }

    public double orderValue() {
        double sum=0;
        List<Product> listNew = c.getProductList();
        for(Product i : listNew) {
            sum+=i.getProductPrice();
        }
        return sum;

    }

    public List<Order> getOrderByCustomerId(int customerId) {
        List<Order> orderList = new ArrayList<>();
        try {
            Connection con = getConnection();


            String queryString = "SELECT * FROM order1 WHERE customerId=?";
            PreparedStatement ps = con.prepareStatement(queryString);
            ps.setInt(1, customerId);
            ResultSet results = ps.executeQuery();

            while (results.next()) {
                Order order = new Order();
                order.setOrderId(results.getInt("orderId"));
                order.setCustomerId(results.getInt("customerId"));
                order.setProductList(getProduct(customerId));
                order.setOrderStatus(getOrderStatus(customerId));
                order.getOrderValue();

                orderList.add(order);
            }

            con.close();
        } catch (SQLException sql) {
            System.out.println(sql);
        }
        return orderList;
    }

    public void newQuote() {
        Customer customer = new Customer();
        Order order = new Order();

        System.out.println("Quote Generated :");
        System.out.println("Order Date: " + order.getOrderDate());
        System.out.println("Customer Name: " + customer.getCustomerName());
        System.out.println("Customer GST No: " + customer.getCustomerGstNumber());
        System.out.println("Customer Shipping Address: " + customer.getCustomerAddress());
        System.out.println("Customer City: " + customer.getCustomerCity());
        System.out.println("Customer Phone Number: " + customer.getPhone());
        System.out.println("Customer Email: " + customer.getEmail());
        System.out.println("Customer Pin Code: " + customer.getPincode());
        System.out.println("Shipping Cost: $" + order.getShippingCost());
        System.out.println("Total Order Value: $" + order.getOrderValue());
    }
}
