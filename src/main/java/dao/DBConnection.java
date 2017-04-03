package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by valeriyartemenko on 25.03.17.
 */
public class DBConnection {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost:3306/epam3";

    static final String USER = "root";

    static final String PASS = "";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
//            System.out.println("Connected OK");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Not Connection");
            e.printStackTrace();
        }

        return connection;
    }

}
