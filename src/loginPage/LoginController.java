package loginPage;

import java.awt.Color;
import puzzleGame.*;
import tetrisGame.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseListener;
import mineSweeper.*;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import Items.Items;
import Users.Users;

public class LoginController implements FocusListener, ActionListener, MouseListener, ChangeListener {
	LoginView loginView;
	LoginModel loginModel = new LoginModel();
	Users users;
	Items items;
	int tradeCoin = 0;
	private String username;
	Minesweeper minesweeper;

	int themeId;

	public LoginController(LoginView loginView) {
		this.loginView = loginView;

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == loginView.loginButton) {
			if (loginUser()) {
				loginView.showCard("secondPane");
				loginView.usernameProLabel.setText("Username: " + username);
				users = new Users(username);
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() {
						
						
						themeId = users.getSelectedThemeIdFromDatabase();
						System.out.println(themeId);
						items = new Items(users.getIdUser());
						loginView.pointProLabel.setText("Point: " + loginModel.checkPoint(username));
						minesweeper = new Minesweeper(username, themeId);
						return null;
					}

					@Override
					protected void done() {
					}
				};

				worker.execute();

			}
		} else if (e.getSource() == loginView.signupButtonOnLogin) {
			loginView.showCard("signup");
		} else if (e.getSource() == loginView.signupButton) {
			if (registerUser()) {

			}
		} else if (e.getSource() == loginView.loginButtonOnSignInpage) {
			loginView.showCard("login");
		} else if (e.getSource() == loginView.minesweeperGameButton) {
			minesweeper.difficulty = 1;
			minesweeper.newGame();
			minesweeper.setVisible(true);
		} else if (e.getSource() == loginView.tetrisGameButton) {
			new Tetris(username);
		} else if (e.getSource() == loginView.puzzleSlidingGameButton) {
			new puzzle(username);
		} else if (e.getSource() == loginView.logoutButton) {
			loginView.username_TextFieldLG.setText("Username");
			loginView.username_TextFieldLG.setForeground(Color.GRAY);
			loginView.password_TextFieldLG.setText("Password");
			loginView.password_TextFieldLG.setEchoChar((char) 0);
			loginView.password_TextFieldLG.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
			loginView.password_TextFieldLG.setForeground(Color.GRAY);
			loginView.loginPane.requestFocus();
			loginView.showCard("login");
		} else if (e.getSource() == loginView.tradeButton) {
			tradeCoin = 0;
			String tradeCoinText = loginView.tradeTextField.getText();
			if (!isInteger(tradeCoinText)) {
				JOptionPane.showMessageDialog(loginView, "Please enter a number ≥10.", "Error", 0);
			} else if (Integer.parseInt(tradeCoinText) < 10) {
				JOptionPane.showMessageDialog(loginView, "Please enter a number ≥10.", "Error", 0);
			} else if (Integer.parseInt(tradeCoinText) % 10 != 0) {
				JOptionPane.showMessageDialog(loginView, "Please enter a number divisible by 10.", "Error", 0);
			} else if (Integer.parseInt(tradeCoinText) >= 10) {
				tradeCoin = Integer.parseInt(tradeCoinText);
				SwingWorker<Void, Void> worker = new SwingWorker<>() {
					@Override
					protected Void doInBackground() {
						if (users.tradePointsToCoin(tradeCoin)) {
							SwingWorker<Void, Void> worker = new SwingWorker<>() {
								@Override
								protected Void doInBackground() {
									loginView.tradeTextField.setText("");
									loginView.coinCurrenLabel.setText("Your Coin: " + users.getCurrentCoinsFromDatabase());
									loginView.pointCurrenLabel.setText("Your Point: " + users.getCurrentPointsFromDatabase());
									return null;
								}

								@Override
								protected void done() {
								}
							};
							worker.execute();
							JOptionPane.showMessageDialog(loginView, "Trade complete", "Ting!", 1);
						} else {
							JOptionPane.showMessageDialog(loginView, "You don't have enough point!", "Error", 0);
						}
						return null;
					}

					@Override
					protected void done() {
					}
				};
				worker.execute();
			}
		} else if (e.getSource() == loginView.buyWindowThemeButton) {
			System.out.println(users.getCurrentCoinsFromDatabase());
			System.out.println(items.getThemePrice(2));
			if (users.getCurrentCoinsFromDatabase() >= items.getThemePrice(2)) {
				if (items.purchaseItem(username,2)) {
					JOptionPane.showMessageDialog(loginView, "Successful purchase!");
				} else {
					JOptionPane.showMessageDialog(loginView, "You already have this theme!", "Error", 0);
				}
			}
			else {
				JOptionPane.showMessageDialog(loginView, "You don't have enough coin!", "Error", 0);
			}
		} else if (e.getSource() == loginView.buyKingThemeButton) {
			if (users.getCurrentCoinsFromDatabase() >= items.getThemePrice(3)) {
				if (items.purchaseItem(username,3)) {
					JOptionPane.showMessageDialog(loginView, "Successful purchase!");
				} else {
					JOptionPane.showMessageDialog(loginView, "You already have this theme!", "Error", 0);
				}
			}
			else {
				JOptionPane.showMessageDialog(loginView, "You don't have enough coin!", "Error", 0);
			}
		} else if (e.getSource() == loginView.buyCuteThemeButton) {
			if (users.getCurrentCoinsFromDatabase() >= items.getThemePrice(4)) {
				if (items.purchaseItem(username,4)) {
					JOptionPane.showMessageDialog(loginView, "Successful purchase!");
				} else {
					JOptionPane.showMessageDialog(loginView, "You already have this theme!", "Error", 0);
				}
			}
			else {
				JOptionPane.showMessageDialog(loginView, "You don't have enough coin!", "Error", 0);
			}
		} else if (e.getSource() == loginView.chooseDefaultButton) {
			users.setSelectedThemeIdInDatabase(1);
			minesweeper.loadTheme();
			minesweeper = new Minesweeper(username, themeId);
			JOptionPane.showMessageDialog(loginView, "Successful!");
		} else if (e.getSource() == loginView.chooseWinButton) {
			if (items.hasUserPurchasedItem(2)) {
				users.setSelectedThemeIdInDatabase(2);
				minesweeper.loadTheme();
				themeId = 2;
				minesweeper = new Minesweeper(username, themeId);
				JOptionPane.showMessageDialog(loginView, "Successful!");
			} else {
				JOptionPane.showMessageDialog(loginView, "You don't have this theme please purchase!", "Error", 0);
			}
		} else if (e.getSource() == loginView.chooseKingButton) {
			if (items.hasUserPurchasedItem(3)) {
				themeId = 3;
				users.setSelectedThemeIdInDatabase(3);
				minesweeper.loadTheme();
				minesweeper = new Minesweeper(username, themeId);
				JOptionPane.showMessageDialog(loginView, "Successful!");
			} else {
				JOptionPane.showMessageDialog(loginView, "You don't have this theme please purchase!", "Error", 0);
			}
		} else if (e.getSource() == loginView.chooseCuteButton) {
			if (items.hasUserPurchasedItem(4)) {
				themeId = 4;
				users.setSelectedThemeIdInDatabase(4);
				minesweeper.loadTheme();
				minesweeper = new Minesweeper(username, themeId);
				JOptionPane.showMessageDialog(loginView, "Successful!");
			} else {
				JOptionPane.showMessageDialog(loginView, "You don't have this theme please purchase!", "Error", 0);
			}
		}

	}

	public static boolean isInteger(String str) {
		try {
			Integer.parseInt(str);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void focusGained(FocusEvent e) {
		if (e.getSource() == loginView.username_TextFieldLG) {
			if (loginView.username_TextFieldLG.getText().equals("Username")) {
				loginView.username_TextFieldLG.setText("");
				loginView.username_TextFieldLG.setForeground(Color.BLACK);
			}
		} else if (e.getSource() == loginView.password_TextFieldLG) {
			if (loginView.password_TextFieldLG.getText().equals("Password")) {
				loginView.password_TextFieldLG.setText("");
				loginView.password_TextFieldLG.setEchoChar('●');
				loginView.password_TextFieldLG.setFont(new Font("Tahoma", Font.PLAIN, 13));
				loginView.password_TextFieldLG.setForeground(Color.BLACK);
			}
		} else if (e.getSource() == loginView.username_TextFieldSU) {
			if (loginView.username_TextFieldSU.getText().equals("Username")) {
				loginView.username_TextFieldSU.setText("");
				loginView.username_TextFieldSU.setForeground(Color.BLACK);
			}
		} else if (e.getSource() == loginView.password_TextFieldSU) {
			if (loginView.password_TextFieldSU.getText().equals("Password")) {
				loginView.password_TextFieldSU.setText("");
				loginView.password_TextFieldSU.setEchoChar('●');
				loginView.password_TextFieldSU.setFont(new Font("Tahoma", Font.PLAIN, 13));
				loginView.password_TextFieldSU.setForeground(Color.BLACK);
			}
		} else if (e.getSource() == loginView.confirmPassword_TextField) {
			if (loginView.confirmPassword_TextField.getText().equals("Confirm Password")) {
				loginView.confirmPassword_TextField.setText("");
				loginView.confirmPassword_TextField.setEchoChar('●');
				loginView.confirmPassword_TextField.setFont(new Font("Tahoma", Font.PLAIN, 13));
				loginView.confirmPassword_TextField.setForeground(Color.BLACK);
			}
		} else if (e.getSource() == loginView.email_TextField) {
			if (loginView.email_TextField.getText().equals("Email")) {
				loginView.email_TextField.setText("");
				loginView.email_TextField.setForeground(Color.BLACK);
			}
		}

	}

	@SuppressWarnings("deprecation")
	@Override
	public void focusLost(FocusEvent e) {
		if (e.getSource() == loginView.username_TextFieldLG) {
			if (loginView.username_TextFieldLG.getText().isEmpty()) {
				loginView.username_TextFieldLG.setText("Username");
				loginView.username_TextFieldLG.setForeground(Color.GRAY);
			}
		} else if (e.getSource() == loginView.password_TextFieldLG) {
			if (loginView.password_TextFieldLG.getText().isEmpty()) {
				loginView.password_TextFieldLG.setText("Password");
				loginView.password_TextFieldLG.setEchoChar((char) 0);
				loginView.password_TextFieldLG.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
				loginView.password_TextFieldLG.setForeground(Color.GRAY);
			}

		} else if (e.getSource() == loginView.username_TextFieldSU) {
			if (loginView.username_TextFieldSU.getText().isEmpty()) {
				loginView.username_TextFieldSU.setText("Username");
				loginView.username_TextFieldSU.setForeground(Color.GRAY);
			}
		} else if (e.getSource() == loginView.password_TextFieldSU) {
			if (loginView.password_TextFieldSU.getText().isEmpty()) {
				loginView.password_TextFieldSU.setText("Password");
				loginView.password_TextFieldSU.setEchoChar((char) 0);
				loginView.password_TextFieldSU.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
				loginView.password_TextFieldSU.setForeground(Color.GRAY);
			}

		} else if (e.getSource() == loginView.confirmPassword_TextField) {
			if (loginView.confirmPassword_TextField.getText().isEmpty()) {
				loginView.confirmPassword_TextField.setText("Confirm Password");
				loginView.confirmPassword_TextField.setEchoChar((char) 0);
				loginView.confirmPassword_TextField.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
				loginView.confirmPassword_TextField.setForeground(Color.GRAY);
			}
		} else if (e.getSource() == loginView.email_TextField) {
			if (loginView.email_TextField.getText().isEmpty()) {
				loginView.email_TextField.setText("Email");
				loginView.email_TextField.setForeground(Color.GRAY);
			}
		}
	}

	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {

		if (e.getSource() == loginView.loginPane) {
			loginView.loginPane.requestFocus();
		}
	}

	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		if (e.getSource() == loginView.loginButton) {
			loginView.loginButton.setIcon(loginView.loginButtonWhenClicked_img);
		} else if (e.getSource() == loginView.signupButtonOnLogin) {
			loginView.signupButtonOnLogin.setIcon(loginView.signupButtonOnLoginPaneWhenCLick_img);
		} else if (e.getSource() == loginView.signupButton) {
			loginView.signupButton.setIcon(loginView.signupButtonWhenClick_img);
		} else if (e.getSource() == loginView.loginButtonOnSignInpage) {
			loginView.loginButtonOnSignInpage.setIcon(loginView.loginButtonWhenClick2_img);
		}
	}

	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		if (e.getSource() == loginView.loginButton) {
			loginView.loginButton.setIcon(loginView.loginButton_img);
		} else if (e.getSource() == loginView.signupButtonOnLogin) {
			loginView.signupButtonOnLogin.setIcon(loginView.signupButtonOnLoginPane_img);
		} else if (e.getSource() == loginView.signupButton) {
			loginView.signupButton.setIcon(loginView.signupButton_img);
		} else if (e.getSource() == loginView.loginButtonOnSignInpage) {
			loginView.loginButtonOnSignInpage.setIcon(loginView.loginButton2_img);
		}
	}

	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {

	}

	private boolean loginUser() {
		String username = loginView.username_TextFieldLG.getText();
		this.username = username;
		String password = new String(loginView.password_TextFieldLG.getPassword());

		if (loginModel.loginUser(username, password)) {
			JOptionPane.showMessageDialog(loginView, "Login successful!");
			return true;
		} else {
			JOptionPane.showMessageDialog(loginView, "Login failed. Please check your username and password.");
			return false;
		}
	}

	private boolean registerUser() {

		String username = loginView.username_TextFieldSU.getText();
		String email = loginView.email_TextField.getText();

		String password = new String(loginView.password_TextFieldSU.getPassword());
		String confirmPassword = new String(loginView.confirmPassword_TextField.getPassword());
		if (loginView.username_TextFieldSU.getForeground() == Color.GRAY) {
			JOptionPane.showMessageDialog(loginView, "Username can't empty", "Error", 0);
			return false;
		}
		if (loginView.password_TextFieldSU.getForeground() == Color.GRAY) {
			JOptionPane.showMessageDialog(loginView, "Password can't empty", "Error", 0);
			return false;
		}
		if (loginView.confirmPassword_TextField.getForeground() == Color.GRAY) {
			JOptionPane.showMessageDialog(loginView, "Confirm password can't empty", "Error", 0);
			return false;
		}

		if (loginModel.isUsernameTaken(username)) {
			JOptionPane.showMessageDialog(loginView, "Username already exists!", "Username error", 0);
			return false;
		} else if (!password.equals(confirmPassword)) {
			JOptionPane.showMessageDialog(loginView, "Your password do not match. Please try again.", "Error password",
					0);
			return false;
		} else if (loginModel.registerUser(username, password, email)) {
			JOptionPane.showMessageDialog(loginView, "Registration successful!");
			return true;
		} else {
			JOptionPane.showMessageDialog(loginView, "Registration failed. Please check username.");
			return false;
		}
	}

	@Override
	public void stateChanged(ChangeEvent e) {
		int selectedIndex = loginView.tabbedPane.getSelectedIndex();

		// check tab
		if (selectedIndex == 1) {
			SwingWorker<Void, Void> worker = new SwingWorker<>() {
				@Override
				protected Void doInBackground() {
					loginView.tableModel.updateTableData();
					return null;
				}

				@Override
				protected void done() {
					loginView.repaint();
				}
			};

			worker.execute();
		}
		if (selectedIndex == 3) {
			SwingWorker<Void, Void> worker = new SwingWorker<>() {
				@Override
				protected Void doInBackground() {
					loginView.pointProLabel.setText("Point: " + loginModel.checkPoint(username));
					return null;
				}

				@Override
				protected void done() {
				}
			};
			worker.execute();
		}
		if (selectedIndex == 2) {
			SwingWorker<Void, Void> worker = new SwingWorker<>() {
				@Override
				protected Void doInBackground() {
					loginView.coinCurrenLabel.setText("Your coin: " + users.getCurrentCoinsFromDatabase());
					loginView.pointCurrenLabel.setText("Your point: " + users.getCurrentPointsFromDatabase());
					users.getCurrentCoinsFromDatabase();
					return null;
				}

				@Override
				protected void done() {
				}
			};
			worker.execute();
		}
	}

}
