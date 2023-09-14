package com.tesseract.ordergenie.service;
import com.tesseract.ordergenie.model.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class CompanyService {

    static Connection con=null;
    public static Connection getConnection()
    {

        String dbUrl="jdbc:mysql://localhost:3306/order-genie";
        String username="root",password="123456";
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


    public String getCompanyDetails(String companyName) {
        Connection connection = getConnection();
        try {

            Statement st = connection.createStatement();
            String query = "SELECT * FROM company";
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet results = ps.executeQuery(query);
            while (results.next()) {
                if(results.getString("companyName").equals(companyName)) {
                    obj.setCompanyName(results.getString("companyName"));
                    obj.setCompanyAddress(results.getString("companyAddress"));
                    obj.setCompanyCity(results.getString("companyCity"));
                    obj.setCompanyGstNumber(results.getString("companyGstNumber"));
                }
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
                employee.setEmployeeId(resultSet.getInt("employeeId"));
                employee.setUsername(resultSet.getString("username"));
                employee.setPassword(resultSet.getString("password"));
                employee.setEmployeeLoginStatus(resultSet.getBoolean("employeeLoginStatus"));

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
