package com.sda.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCInsertApp {

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

            String sql = "INSERT INTO countries (COUNTRY_ID, COUNTRY_NAME, REGION_ID) VALUES ('PL', 'Poland', 1)";

            stmt.executeUpdate(sql);


        } catch (SQLException e) {
            System.out.println("SQL state: " + e.getSQLState() + ", msg: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Msg: " + e.getMessage());
        }
    }
}
