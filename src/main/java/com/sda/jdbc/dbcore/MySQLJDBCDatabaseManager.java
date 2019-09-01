package com.sda.jdbc.dbcore;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MySQLJDBCDatabaseManager implements DatabaseManager {

    private ConnectionProvider connectionProvider;
    private String database;
    private String user;
    private String password;

    public MySQLJDBCDatabaseManager(String database, String user, String password) {
        this.database = database;
        this.user = user;
        this.password = password;

        this.connectionProvider = new MySQLJDCConnetionProvider();
    }


    @Override
    public List<String> executeOneColumnStringSelect(String sql) throws Exception {
        List<String> resultList = new ArrayList<>();

        try (Connection conn = connectionProvider.createLocalConnection(database, user, password)) {
            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);


            while (rs.next()) {
                resultList.add(rs.getString(1));
            }
        }

        return resultList;
    }

    @Override
    public void executeUpdate(String sql) throws Exception {

        try (Connection conn = connectionProvider.createLocalConnection(database, user, password)) {
            Statement stmt = conn.createStatement();

           int resultUpdate = stmt.executeUpdate(sql);

           if (resultUpdate == 0) {
               throw new Exception("Nothing was changed.");
           }


        }
    }
}
