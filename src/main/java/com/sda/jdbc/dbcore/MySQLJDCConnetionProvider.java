package com.sda.jdbc.dbcore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLJDCConnetionProvider implements ConnectionProvider {


    @Override
    public Connection createLocalConnection(String dbName, String user, String password) throws Exception {
        Connection conn = null;

        String errorMessage = "";

        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + dbName,
                    user, password);
        } catch (SQLException e) {
            errorMessage = "SQL state: " + e.getSQLState() + ", msg: " + e.getMessage();
        } catch (Exception e) {
            errorMessage = "Msg: " + e.getMessage();
        }

        if (conn == null) {
        throw new Exception(errorMessage);
        }

        return conn;
    }
}
