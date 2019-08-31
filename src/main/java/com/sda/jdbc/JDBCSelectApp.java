package com.sda.jdbc;

import java.sql.*;

public class JDBCSelectApp {

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

            String sql = "SELECT COUNTRY_NAME FROM countries WHERE COUNTRY_NAME LIKE 'A%'";

            ResultSet rs = stmt.executeQuery(sql);

            String countryName;

            while (rs.next()) {
                countryName = rs.getString(1);
                System.out.println(countryName);
            }

        } catch (SQLException e) {
            System.out.println("SQL state: " + e.getSQLState() + ", msg: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Msg: " + e.getMessage());
        }
    }
}
