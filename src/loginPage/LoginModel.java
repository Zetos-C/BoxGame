package loginPage;

import org.mindrot.jbcrypt.BCrypt;

import Items.Items;
import Users.Users;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import databaseConnect.*;

public class LoginModel {
	private String username;
	private Connection connection;
	private int point;
	
	public LoginModel() {
		this.connection = DatabaseConnection.getConnection();
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

	public boolean registerUser(String username, String password, String email) {
		if (isUsernameTaken(username)) {
			return false;
		}
		if (username.equals("Username")) {
			return false;
		} else {
			this.connection = DatabaseConnection.getConnection();
			
			String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());

			String query = "INSERT INTO Users (username, password_hash, email) VALUES (?, ?, ?)";
			try (PreparedStatement statement = connection.prepareStatement(query)) {
				statement.setString(1, username);
				statement.setString(2, hashedPassword);
				statement.setString(3, email);
				int rowsAffected = statement.executeUpdate();
				statement.close();
				Users user = new Users(username);
				Items items = new Items(user.getIdUser());
				items.purchaseItem(username,1);
				user.setDefaultThemeIdInDatabase(1);;
				return rowsAffected > 0;
			} catch (SQLException e) {
				e.printStackTrace();
				return false;
			} finally {
				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public boolean loginUser(String username, String password) {
		this.connection = DatabaseConnection.getConnection();
		String query = "SELECT * FROM Users WHERE username = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				String hashedPassword = resultSet.getString("password_hash");
				resultSet.close();
				statement.close();
				this.username = username;
				return BCrypt.checkpw(password, hashedPassword);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	public boolean isUsernameTaken(String username) {
		this.connection = DatabaseConnection.getConnection();
		String query = "SELECT * FROM Users WHERE username = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				statement.close();
				resultSet.close();
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return false;
	}
	
	public int checkPoint(String username) {
		this.connection = DatabaseConnection.getConnection();
		String query = "SELECT * FROM Users WHERE username = ?";
		try (PreparedStatement statement = connection.prepareStatement(query)) {
			statement.setString(1, username);
			ResultSet resultSet = statement.executeQuery();

			if (resultSet.next()) {
				int point = resultSet.getInt("points");
				this.point = point;
				return point;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return -1;

	}

	public void updatePoint(int pointPlus) {
		this.connection = DatabaseConnection.getConnection();
		try {
			String query = "SELECT points FROM Users WHERE username=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, username);

			ResultSet resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				int point = resultSet.getInt("points");
				int newPoint = point + pointPlus;

				// update point
				String updateQuery = "UPDATE Users SET points=? WHERE username=?";
				PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
				updateStatement.setInt(1, newPoint);
				updateStatement.setString(2, username);

				int rowsAffected = updateStatement.executeUpdate();

				if (rowsAffected > 0) {
					System.out.println("point updated!");
				} else {
					System.out.println("error update point");
				}

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
