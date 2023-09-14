package com.tesseract.ordergenie.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.tesseract.ordergenie.exception.CustomerDoesNotExistException;
import com.tesseract.ordergenie.model.Customer;



public class CustomerService {
	
	 static Connection con=null;
	    public static Connection getConnection()
	    {

	        String dbUrl="jdbc:mysql://localhost:3306/order-genie";
	        String username="root",password="12345";
	        try
	        {
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            con=DriverManager.getConnection(dbUrl,username,password);
	        }catch(ClassNotFoundException e)
	        {
	            e.printStackTrace();
	        }catch(SQLException e)
	        {
	            e.printStackTrace();
	        }
	        return con;
	    }
	
	
	Customer obj = new Customer();

	public boolean validateByCustomerName(String name, String password) throws CustomerDoesNotExistException {
	    
		
		 try{
	         Connection con=null;
	         con=getConnection();
	         String queryString = "SELECT * FROM customer";
	         Statement st= con.createStatement();
	         PreparedStatement ps=con.prepareStatement(queryString);
	         ResultSet results = ps.executeQuery(queryString);
	         while(results.next()) {
	             String un = results.getString("customerName");
	             String pwd = results.getString("password");
	             if (un.equals(name) && pwd.equals(password))
	                 return true;
	         }
	          throw new CustomerDoesNotExistException("Customer with customerName "+name+" does not exist");
	     }
	     catch(SQLException sql) {
	         System.out.println(sql);
	     }
	     return false;
	 }


	
public boolean validateByCustomerId(int id, String password) throws CustomerDoesNotExistException{
	
	
	 try{
         Connection con=null;
         con=getConnection();
         String queryString = "SELECT * FROM customer";
         Statement st= con.createStatement();
         PreparedStatement ps=con.prepareStatement(queryString);
         ResultSet results = ps.executeQuery(queryString);
         while(results.next()) {
             int un = results.getInt("customerId");
             String pwd = results.getString("password");
             System.out.println(un+" "+pwd);
             if (un == id && pwd.equals(password))
                 return true;
         }
          throw new CustomerDoesNotExistException("Customer with customerId "+id+" does not exist");
     }
     catch(SQLException sql) {
         System.out.println(sql);
     }
     return false;
 }

private void closeConnection(Connection connection) {
    if (connection != null) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
	
}