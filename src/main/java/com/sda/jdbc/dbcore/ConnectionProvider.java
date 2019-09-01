package com.sda.jdbc.dbcore;

import java.sql.Connection;

public interface ConnectionProvider {

    Connection createLocalConnection(String dbName, String user, String password) throws Exception;

}
