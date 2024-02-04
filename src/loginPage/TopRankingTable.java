package loginPage;

import java.sql.*;
import javax.swing.table.DefaultTableModel;

import databaseConnect.DatabaseConnection;

public class TopRankingTable extends DefaultTableModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	public TopRankingTable() {
        addColumn("Top");
        addColumn("Username");
        addColumn("Point");
        
        addRow(new Object[]{"Top", "Username", "Point"});

        updateTableData();
    }
	 void updateTableData() {
		 try (Connection connection = DatabaseConnection.getConnection()) {
	            String query = "SELECT username, points FROM Users ORDER BY points DESC LIMIT 20";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(query);
	                 ResultSet resultSet = preparedStatement.executeQuery()) {

	                //delete old table data
	                setRowCount(0);

	                //add data to table
	                int top =0;
	                while (resultSet.next()) {
	                	String username = resultSet.getString("username");
	                    int points = resultSet.getInt("points");
	                	top+=1;
	                	addRow(new Object[]{top, username, points});
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
