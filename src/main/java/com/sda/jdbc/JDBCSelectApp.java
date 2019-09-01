package com.sda.jdbc;

import com.sda.jdbc.dbcore.DatabaseManager;
import com.sda.jdbc.dbcore.MySQLJDBCDatabaseManager;

import java.util.List;

public class JDBCSelectApp {

    public static void main(String[] args) {
        DatabaseManager databaseManager = new MySQLJDBCDatabaseManager("company_db", "company_admin",
                "company1234");
        try {
            List<String> resultList = databaseManager.executeOneColumnStringSelect("SELECT COUNTRY_NAME FROM countries WHERE COUNTRY_NAME LIKE 'A%'");
            for (String value : resultList){
                System.out.println(value);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}
