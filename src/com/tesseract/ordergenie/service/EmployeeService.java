package com.tesseract.ordergenie.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.time.LocalDate;
import java.util.HashMap;

import com.tesseract.ordergenie.exception.EmployeeDoesNotExistException;
import com.tesseract.ordergenie.model.LoggedInDetails;

public class EmployeeService {

    HashMap<Integer,LoggedInDetails> loggedIn=new HashMap<>();

    static Connection con=null;
    public static Connection getConnection()
    {

        String dbUrl="jdbc:mysql://localhost:3306/order-genie";
        String username="root",password="Parag@1967";
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

    public boolean validateEmployeeLogin(int id, String password) throws EmployeeDoesNotExistException {
        if(isEmployeeLoggedIn(id)){
            return false;
        }
        try{
            Connection con=null;
            con=getConnection();
            String queryString = "SELECT * FROM employee";
            Statement st= con.createStatement();
            PreparedStatement ps=con.prepareStatement(queryString);
            ResultSet results = ps.executeQuery(queryString);
            while(results.next()) {
                int un = results.getInt("employeeId");
                String pwd = results.getString("password");
                if (un == id && pwd.equals(password))
                    return true;
            }
            throw new EmployeeDoesNotExistException("Employee Does Not Exist.");
        }
        catch(SQLException sql) {
            System.out.println(sql);
        }
        return false;
    }

    public void logIn(int id){
        try{
            Connection con=null;
            con=getConnection();
            String queryString="UPDATE Employee SET employeeLoginStatus=1 WHERE employeeId="+id;
            Statement st= con.createStatement();
            st.executeUpdate(queryString);
            LoggedInDetails li=new LoggedInDetails();
            li.setDate(LocalDate.now());
            li.setLoggedIn(true);
            loggedIn.put(id,li);
        }
        catch(SQLException sql) {
            System.out.println(sql);
        }
    }

    public void logOut(int id){
        try{
            Connection con=null;
            con=getConnection();
            String queryString="UPDATE Employee SET employeeLoginStatus=0 WHERE employeeId="+id;
            Statement st= con.createStatement();
            st.executeUpdate(queryString);
            loggedIn.remove(id);
        }
        catch(SQLException sql) {
            System.out.println(sql);
        }
    }

    public void displayEmployeeDetails(int id){
        try {
            Connection con=null;
            con=getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from Employee where employeeId="+id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                System.out.println("Employee Id : "+rs.getInt(1) + "\nEmployee Name : " + rs.getString(2)+"\nEmployee Logged In : "+rs.getBoolean(4));
            }
        }
        catch(SQLException sql) {
            System.out.println(sql);
        }
    }

    public boolean isEmployeeLoggedIn(int id){
        boolean f=true;
        try {
            Connection con = null;
            con = getConnection();
            PreparedStatement stmt = con.prepareStatement("select * from Employee where employeeId="+id);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                f=rs.getBoolean(4);
            }

            return f;
        }
        catch(SQLException sql) {
            System.out.println(sql);
        }
        return f;
    }
}
