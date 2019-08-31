package com.sda.jdbc;

import java.sql.*;

public class JDBCUpdateApp {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db",
                "company_admin",
                "company1234")) {
            if (conn != null) {
                System.out.println(("Connection created succesfully!"));
            } else {
                System.out.println(("Connection creation failed!"));
            }


            Statement stmt = conn.createStatement();

            String sql = "UPDATE employees SET SALARY = 5200 WHERE FIRST_NAME = 'David' AND LAST_NAME = 'Austin'";

            stmt.executeUpdate(sql);


        } catch (SQLException e) {
            System.out.println("SQL state: " + e.getSQLState() + ", msg: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Msg: " + e.getMessage());
        }
    }
}

