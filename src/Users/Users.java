package Users;

import java.sql.*;
import Items.Items;
import databaseConnect.DatabaseConnection;

public class Users {
	private Connection conn;
	private int id = -1;
	private String username;
	Items items;
	public Users(String username) {
		this.username = username;
		getIdFromUsername();
		items = new Items(id);
	}
	
	public int getIdUser() {
		return id;
	}

	public void setIdUser(int id) {
		this.id = id;
	}

	public boolean hasItems(int itemId) {
		if(items.hasUserPurchasedItem(itemId)) {
			return true;
		}
		else {
			return false;
		}
	}
	private void getIdFromUsername() {
		this.conn = DatabaseConnection.getConnection();
		String query = "SELECT * FROM Users WHERE username = ?";
		try {
			PreparedStatement statememt = conn.prepareStatement(query);
			statememt.setString(1, username);
			ResultSet resultSet = statememt.executeQuery();
			
			if (resultSet.next()) {
				int id = resultSet.getInt("id");
				this.id = id;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	public int getCurrentPointsFromDatabase() {
		this.conn = DatabaseConnection.getConnection();
        String query = "SELECT * FROM Users WHERE id = ?";
        
        try {
        	PreparedStatement statement = conn.prepareStatement(query);
        	statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt("points");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return 0;
    }
	public int getCurrentCoinsFromDatabase() {
		this.conn = DatabaseConnection.getConnection();
        String query = "SELECT coin FROM Users WHERE id = ?";
        try {
        	PreparedStatement statement = conn.prepareStatement(query);
        	statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return resultSet.getInt("coin");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
        return 0;
    }
	private void updatePointsInDatabase(int newPoints) {
		this.conn = DatabaseConnection.getConnection();
        String query = "UPDATE Users SET points = ? WHERE id = ?";
        try {
        	PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, newPoints);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCoinsInDatabase(int newCoins) {
    	this.conn = DatabaseConnection.getConnection();
        String query = "UPDATE Users SET coin = ? WHERE id = ?";
        try {
        	PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, newCoins);
            statement.setInt(2, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
    }

	public boolean tradePointsToCoin(int pointsToTrade) {

        int currentPoints = getCurrentPointsFromDatabase();
        int currentCoins = getCurrentCoinsFromDatabase();

        if (currentPoints >= pointsToTrade) {
            int newPoints = currentPoints - pointsToTrade;
            int newCoins = currentCoins + pointsToTrade/10;

            //update coin and point
            updatePointsInDatabase(newPoints);
            updateCoinsInDatabase(newCoins);
            return true;
        } 
        else {
        	return false;
        }
    }
	public int getSelectedThemeIdFromDatabase() {
		this.conn = DatabaseConnection.getConnection();
	    String query = "SELECT themeId FROM UserTheme WHERE userId = ?";
	    try (PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setInt(1, id);
	        try (ResultSet resultSet = statement.executeQuery()) {
	            if (resultSet.next()) {
	                return resultSet.getInt("themeId");
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	    return -1;
	}

	public void setSelectedThemeIdInDatabase(int themeId) {
		this.conn = DatabaseConnection.getConnection();
//		INSERT INTO UserTheme (userId, themeId) VALUES (?, ?)
	    String query = "UPDATE UserTheme SET themeId = ? WHERE userId = ?";
	    try (PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setInt(1, themeId);
	        statement.setInt(2, id);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void setDefaultThemeIdInDatabase(int themeId) {
		this.conn = DatabaseConnection.getConnection();
	    String query = "INSERT INTO UserTheme (userId, themeId) VALUES (?, ?)";
	    try (PreparedStatement statement = conn.prepareStatement(query)) {
	        statement.setInt(1, id);
	        statement.setInt(2, themeId);
	        statement.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}