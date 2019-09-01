package com.sda.jdbc;

import com.sda.jdbc.dbcore.DatabaseManager;
import com.sda.jdbc.dbcore.MySQLJDBCDatabaseManager;

public class JDBCDeleteApp {

    public static void main(String[] args) {
        DatabaseManager databaseManager = new MySQLJDBCDatabaseManager("company_db", "company_admin",
                "company1234");
        try {
            databaseManager.executeUpdate("DELETE FROM employees WHERE EMPLOYEE_ID = 105");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
