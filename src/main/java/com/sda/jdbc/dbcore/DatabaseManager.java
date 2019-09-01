package com.sda.jdbc.dbcore;

import java.util.List;

public interface DatabaseManager {

    List<String> executeOneColumnStringSelect(String sql) throws Exception;

    void executeUpdate(String sql) throws Exception;

}
