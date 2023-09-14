package com.tesseract.ordergenie.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import java.util.ArrayList;
import java.util.List;


public class ProductService {
	static Connection con=null;
	static double productPrice;
    static double shippingcost;
    static double gst;
	static String productCategory;
	static String productName;
	static int productId;
	public static Connection getDbCon()
	{
		
		String dbUrl="jdbc:mysql://localhost:3306/codefury";
		String username="root",password="20Jan@2000";
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

	public static void calculateGST(int id)
	{
		try {
	
		Statement st=con.createStatement();
		ResultSet rs=st.executeQuery("Select productPrice from products where productId="+id);
		gst=0;
		while(rs.next()) {
			 productPrice=rs.getInt(1);
		}
		
		 gst=gst+0.1*productPrice;
		 System.out.println("The gst is: "+gst);
		
	}catch(SQLException e) {
		e.printStackTrace();
	}

	
}

	
	public static double ShipCost(int id) {
	    double shippingCost = 0; // Use double for shipping cost to allow for decimal values
	    String productCategory = null;
	    
	    try {
	        // Create a PreparedStatement to safely pass parameters to the query
	        PreparedStatement pstmt = con.prepareStatement("SELECT productId, productPrice, productCategory FROM products WHERE productId = ?");
	        pstmt.setInt(1, id);

	        ResultSet rs = pstmt.executeQuery();

	        while (rs.next()) {
	            // Retrieve values from the result set
	            int productId = rs.getInt("productId");
	            int productPrice = rs.getInt("productPrice");
	            productCategory = rs.getString("productCategory");

	            if ("Level1".equals(productCategory)) {
	                shippingCost = 0.05 * productPrice;
	            } else if ("Level2".equals(productCategory)) {
	                shippingCost = 0.03 * productPrice;
	            } else if ("Level3".equals(productCategory)) {
	                shippingCost = 0.02 * productPrice;
	            }
	            
	            System.out.println("The Shipping Cost for Product ID " + productId + " is: " + shippingCost);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();}
	    
	    return shippingCost;
 } 


		
	


		
	public static void GetAllProduct() {
	    try {
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT productName FROM products");
            System.out.println("The list of all product names are : \n");
	        while (rs.next()) {
	            String productName = rs.getString(1);
	            System.out.println(productName);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } }


		

	public static void GetProductDetail(int id) {
	    try {
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT * FROM products WHERE productId = " + id);

	        while (rs.next()) {
	            int productId = rs.getInt(1);
	            String productName = rs.getString(2);
	            int productPrice = rs.getInt(3);
	            String productCategory = rs.getString(4);

	            System.out.println("Product ID: " + productId);
	            System.out.println("Product Name: " + productName);
	            System.out.println("Product Price: " + productPrice);
	            System.out.println("Product Category: " + productCategory);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } }

	public static void GetProductNamesByLevel(String level) {
	    List<String> productNamesByLevel = new ArrayList<>();
	    
	    try {
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT productName, productCategory FROM products");

	        while (rs.next()) {
	            String productName = rs.getString("productName");
	            String productCategory = rs.getString("productCategory");
	            
	            if (level.equals(productCategory)) {
	                productNamesByLevel.add(productName);
	            }
	        }
	        
	        System.out.println("Product Names under Level " + level + ":");
	        for (String productName : productNamesByLevel) {
	            System.out.println(productName);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } }


		
//	private static void GetproductQuantity(int id) // passing using an object
//	{
//		String qry="Insert into emp values(?,?,?,?)";
//		try {
//		       PreparedStatement pst=con.prepareStatement(qry);
//		       pst.setInt(1,p.getProductId());
//		       
//		       pst.setString(4, p.getCategory());
//		       pst.setInt(5,p.getQuantity());
//		       
//		       System.out.println("PreparedStatement ready to execute..");
//		       int count=pst.executeUpdate();
//		       System.out.println(count+"records updated");
//		       }catch(SQLException ex)
//		{
//		    	   ex.printStackTrace();
//		}
//	}
	
	public static void GetProductQuantity(int id) {
	    try {
	        PreparedStatement pst = con.prepareStatement("SELECT productQuantity FROM products WHERE productId = ?");
	        pst.setInt(1, id);

	        ResultSet rs = pst.executeQuery();

	        while (rs.next()) {
	            int productQuantity = rs.getInt(1);
	            System.out.println("Product ID: " + id + ", Quantity: " + productQuantity);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            con.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	}

	
	
	
	
}

