package Items;

import java.sql.*;

import Users.Users;
import databaseConnect.DatabaseConnection;

public class Items {
	private Connection connection;
	private int userID;
	public Items(int userID) {
		// TODO Auto-generated constructor stub
		this.userID = userID;
	}

	public boolean hasUserPurchasedItem(int itemId) {
		this.connection = DatabaseConnection.getConnection();
	    String query = "SELECT * FROM UserItems WHERE userId = ? AND itemId = ?";
	    try (PreparedStatement statement = connection.prepareStatement(query)) {
	        statement.setInt(1, userID);
	        statement.setInt(2, itemId);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            return resultSet.next();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    return false;
	}
	
	public int getThemePrice(int themeId) {
		this.connection = DatabaseConnection.getConnection();
        int price = -1;

        try {
            String query = "SELECT price FROM Items WHERE id = ?";
            try (PreparedStatement statement = connection.prepareStatement(query)) {
                statement.setInt(1, themeId);
                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        price = resultSet.getInt("price");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return price;
    }


    public boolean purchaseItem(String username,int itemID) {
    	if (hasUserPurchasedItem(itemID)) {
    		return false;
        }
    	
    	int newCoin;
    	
    	this.connection = DatabaseConnection.getConnection();
        String purchaseQuery = "INSERT INTO UserItems (userId, itemId) VALUES (?, ?)";
        try (PreparedStatement purchaseStatement = connection.prepareStatement(purchaseQuery)) {
            purchaseStatement.setInt(1, userID);
            purchaseStatement.setInt(2,itemID );
            purchaseStatement.executeUpdate();
            Users user = new Users(username);
            newCoin = user.getCurrentCoinsFromDatabase() - getThemePrice(itemID);
            user.updateCoinsInDatabase(newCoin);
            return true;
            // please update gui
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return false;
    }
    
}
