package databaseConnect;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConnection {

//    private static final String JDBC_URL = "jdbc:sqlserver://localhost:1433;databaseName=BoxGame";
//    private static final String USER = "sa";
//    private static final String PASSWORD = "12345";
    
//    private static final String JDBC_URL = "jdbc:mysql://mygame.cneimk0ie6oh.ap-southeast-2.rds.amazonaws.com:3306/BoxGame";
//    private static final String USER = "duongdat030";
//    private static final String PASSWORD = "DkjJwhU76X";

    private static BasicDataSource dataSource;

    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl("jdbc:mysql://mygame.cneimk0ie6oh.ap-southeast-2.rds.amazonaws.com:3306/BoxGame");
        dataSource.setUsername("duongdat030");
        dataSource.setPassword("DkjJwhU76X");
        dataSource.setInitialSize(5); // Initial number of connections
        dataSource.setMaxTotal(20);   // Maximum number of connections
    }

    public static Connection getConnection(){
    	Connection conn;
		try {
			conn = dataSource.getConnection();
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return null;
    }

    public static void CheckConnect() {
        Connection connection = getConnection();
        if (connection != null) {
            System.out.println("Connected to the database!");
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Failed to connect to the database.");
        }
    }
}