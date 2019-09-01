package com.sda.jdbc;

import java.sql.*;

public class JDBCTransactions {

    public static void main(String[] args) throws SQLException {

        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/company_db",
                "company_admin",
                "company1234")) {
            if (conn != null) {
                System.out.println(("Connection created succesfully!"));
            } else {
                System.out.println(("Connection creation failed!"));
            }

            conn.setAutoCommit(false);

            String sql = "DELETE FROM countries WHERE REGION_ID = ?";


            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

                pstmt.setInt(1, 1);

                pstmt.executeUpdate();

            } catch (SQLException err) {
                conn.rollback();
                conn.setAutoCommit(true);
                throw err;
            }
            String sql2 = "DELETE FROM regions WHERE REGION_NAME = ?";


            try (PreparedStatement pstmt = conn.prepareStatement(sql2)) {

                pstmt.setString(1, "Europe");

                pstmt.executeUpdate();

            } catch (SQLException err) {
                conn.rollback();
                conn.setAutoCommit(true);
                throw err;
            }
            conn.commit();
            conn.setAutoCommit(true);
        }
    }
}

