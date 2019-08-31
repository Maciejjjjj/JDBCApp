package com.sda.jdbc;

import java.sql.*;

public class JDBCParametrizedUpdateApp {

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db",
                "company_admin",
                "company1234")) {
            if (conn != null) {
                System.out.println(("Connection created succesfully!"));
            } else {
                System.out.println(("Connection creation failed!"));
            }




            String sql = "UPDATE employees SET SALARY = ? WHERE FIRST_NAME = ? AND LAST_NAME = ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setInt(1, 3000);
            pstmt.setString(2, "David");
            pstmt.setString(3, "Austin");

            pstmt.executeUpdate();


        } catch (SQLException e) {
            System.out.println("SQL state: " + e.getSQLState() + ", msg: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Msg: " + e.getMessage());
        }
    }
}
