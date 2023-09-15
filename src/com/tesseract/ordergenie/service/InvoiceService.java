package com.tesseract.ordergenie.service;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.Date;

import com.tesseract.ordergenie.dao.*;
import com.tesseract.ordergenie.model.*;
import com.tesseract.ordergenie.service.*;
public class InvoiceService {
	static Connection con=null;
	Customer c=new Customer();
	Order o=new Order();
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
	
	public void getPaymentStatus(int orderId) {
	    try {
	        Statement st = con.createStatement();
	        ResultSet rs = st.executeQuery("SELECT orderId FROM orders WHERE orderId=" + orderId);

	        while (rs.next()) {
	            int orderValue = getOrderValue(orderId); // Calculate the order value
	            double totalShippingCost = calculateTotalShippingCost(orderId); // Calculate shipping cost
	            double gst = calculateGST(orderId); // Calculate GST

	            double totalAmountPaid = orderValue + totalShippingCost + gst;

	            if (c.getTotalAmountPaid() == totalAmountPaid) {
	                System.out.println("Invoice for Order " + orderId + ":");
	                System.out.println("Order Value: " + orderValue);
	                System.out.println("Shipping Cost: " + totalShippingCost);
	                System.out.println("GST: " + gst);
	                System.out.println("Total Amount Paid: " + totalAmountPaid);
	                System.out.println("Payment Status: Approved");
	            } else {
	                System.out.println("Payment Status: Disapproved");
	            }
	        }
	    }catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void generateInvoices() {
        try {
            // Get the current date and the date of the previous day
            Calendar calendar = Calendar.getInstance();
            calendar.add(Calendar.DATE, -1);
            Date previousDay = calendar.getTime();

            // Query to retrieve approved orders from the previous day
            String query = "SELECT orderId, customerId FROM orders WHERE orderStatus = 'Approved' or orderStatus='Delivered' AND orderDate = ?";
            
            PreparedStatement ps = con.prepareStatement(query);
            ps.setDate(1, new java.sql.Date(previousDay.getTime()));

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                int customerId = rs.getInt("customerId");
                
               
                double orderValue = orderValue(orderId); // Implement this method
                double gst = 0.10 * orderValue;
                double shcost=totalShippingCost(orderId)
                
                // Create an Invoice object and set its properties
                Invoice invoice = new Invoice();
                invoice.setInvoiceDate(new Date()); // Set the current date
                invoice.getOrderDetails().setOrderId(orderId);
                invoice.getCustomerDetails().setCustomerId(customerId);
                invoice.setTypeOfGst("Flat Rate (10%)");
                invoice.setTotalGstAmount(gst);
                invoice.setTotalInvoiceValue(orderValue + gst);
                invoice.setInvoiceStatus("Generated");
                
                // Update the database with the generated invoice
                insertInvoiceToDatabase(invoice); // Implement this method
            }

            // Close resources
            rs.close();
            ps.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
	private void insertInvoiceToDatabase(Invoice invoice) {
	    try {
	        // Check if the current time is 12:00 AM (midnight) before proceeding
	        Calendar calendar = Calendar.getInstance();
	        calendar.setTime(invoice.getInvoiceDate());
	        
	        int hour = calendar.get(Calendar.HOUR_OF_DAY); // Get the current hour
	        
	        if (hour != 0) {
	            System.out.println("Invoice insertion skipped. It's not 12:00 AM.");
	            return; // Exit the method if it's not 12:00 AM
	        }

	        // Define the INSERT SQL query for inserting the invoice details into the database
	        String insertQuery = "INSERT INTO invoices (invoiceDate, orderId, customerId, typeOfGst, totalGstAmount, totalInvoiceValue, invoiceStatus) " +
	                             "VALUES (?, ?, ?, ?, ?, ?, ?)";
	        
	        // Create a PreparedStatement for the INSERT query
	        PreparedStatement preparedStatement = con.prepareStatement(insertQuery);

	        // Set the parameter values for the PreparedStatement
	        preparedStatement.setDate(1, new java.sql.Date(invoice.getInvoiceDate().getTime()));
	        preparedStatement.setInt(2, invoice.getOrderDetails().getOrderId());
	        preparedStatement.setInt(3, invoice.getCustomerDetails().getCustomerId());
	        preparedStatement.setString(4, invoice.getTypeOfGst());
	        preparedStatement.setDouble(5, invoice.getTotalGstAmount());
	        preparedStatement.setDouble(6, invoice.getTotalInvoiceValue());
	        preparedStatement.setString(7, invoice.getInvoiceStatus());

	        // Execute the INSERT query to insert the invoice into the database
	        int rowsInserted = preparedStatement.executeUpdate();

	        // Check if the INSERT was successful
	        if (rowsInserted > 0) {
	            System.out.println("Invoice inserted into the database successfully.");
	        } else {
	            System.out.println("Failed to insert invoice into the database.");
	        }

	        // Close the PreparedStatement
	        preparedStatement.close();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

		       
	}

	        
	        
