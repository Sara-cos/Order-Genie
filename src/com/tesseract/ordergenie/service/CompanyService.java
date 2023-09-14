package com.tesseract.ordergenie.service;
import com.tesseract.ordergenie.model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class CompanyService {
	
	 static Connection con=null;
	    public static Connection getConnection()
	    {

	        String dbUrl="jdbc:mysql://localhost:3306/order-genie";
	        String username="root",password="123654";
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

	Company obj = new Company();
	

     public String getCompanyDetails() {
    Connection connection = getConnection();
    String query = "SELECT * FROM company WHERE company_name = ?"; 
    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
        preparedStatement.setString(1, obj.getCompanyName()); 
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            obj.setCompanyAddress(resultSet.getString("company_address"));
            obj.setCompanyCity(resultSet.getString("company_city"));
            obj.setCompanyGstNumber(resultSet.getString("company_GstNumber"));
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        closeConnection(connection);
    }
    return obj.toString();
}
     
     
     
     public List<Employee> getAllEmployees() {
    	    List<Employee> employees = new ArrayList<>();
    	    Connection connection = getConnection();
    	    String query = "SELECT * FROM employee"; 
    	    try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
    	        ResultSet resultSet = preparedStatement.executeQuery();
    	        while (resultSet.next()) {
    	            Employee employee = new Employee();
    	            employee.setEmployeeId(resultSet.getInt("employee_id"));
    	            employee.setUsername(resultSet.getString("employee_username"));
    	            employee.setPassword(resultSet.getString("employee_password"));
    	            employee.setEmployeeLoginStatus(resultSet.getBoolean("employee_loginStatus"));
    	           
    	            employees.add(employee);
    	        }
    	    } catch (SQLException e) {
    	        e.printStackTrace();
    	    } finally {
    	        closeConnection(connection);
    	    }
    	    return employees;
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
