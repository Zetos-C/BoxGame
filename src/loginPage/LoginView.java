package loginPage;

import java.io.IOException;

import javax.imageio.ImageIO;
import java.awt.*;
import javax.swing.*;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;

public class LoginView extends JFrame {

	private static final long serialVersionUID = 1L;

	JLabel loginTop_Label = new JLabel("Login");
	LoginController loginController = new LoginController(this);
	ImageIcon firstBackground, loginButton_img, loginButtonWhenClicked_img, secondBackground, signupPane_img,
			signupButtonOnLoginPane_img, signupButtonOnLoginPaneWhenCLick_img;
	ImageIcon signupButton_img, signupButtonWhenClick_img, loginButton2_img, loginButtonWhenClick2_img,
			minesweeperButton_img, tetrisButton_img, puzzelSlidingButton_img;
	JPanel firstContentPane = new JPanel();
	JLabel firstBackground_Label = new JLabel();

	JPanel secondContentPane = new JPanel();
	JPanel loginPane = new JPanel();
	JButton loginButton = new JButton("");
	JPasswordField password_TextFieldLG = new JPasswordField();
	JTextField username_TextFieldLG = new JTextField();

	JPasswordField password_TextFieldSU = new JPasswordField();
	JTextField username_TextFieldSU = new JTextField();

	JPanel signupContentPane = new JPanel();
	JLabel signupPaneBackground = new JLabel();
	JButton signupButtonOnLogin = new JButton();
	JPanel signupPaneItems = new JPanel();
	JButton signupButton = new JButton();
	JTextField email_TextField = new JTextField();
	JPasswordField confirmPassword_TextField = new JPasswordField();
	JButton loginButtonOnSignInpage = new JButton();
	JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
	private final JPanel tabGamePane = new JPanel();
	JButton minesweeperGameButton = new JButton();
	JButton tetrisGameButton = new JButton();

	CardLayout cardLayout;

	private JPanel cardPanel;

	JButton puzzleSlidingGameButton = new JButton();

	TopRankingTable tableModel = new TopRankingTable();
	JTable topTable = new JTable(tableModel);
	private JScrollPane topPane = new JScrollPane(topTable);
	private final JPanel profilePane = new JPanel();
	JLabel usernameProLabel = new JLabel("Username: ?");
	JLabel pointProLabel = new JLabel("Point : ?");

	JButton logoutButton = new JButton("");
	private final JScrollPane shopPane = new JScrollPane();
	private final JLabel shopHeader = new JLabel("Shop");
	private final JPanel shopViewport = new JPanel();
	private final JPanel tradeCoinPane = new JPanel();
	JTextField tradeTextField;
	private final JPanel panel_2_1_1 = new JPanel();
	private final JLabel previewIconCT2 = new JLabel("");
	private final JLabel previewIconCT1 = new JLabel("");
	private final JLabel previewIconCT3 = new JLabel("");
	
	private final JLabel priceCuteTheme = new JLabel("Cute Theme :  400 coin");
	JButton buyCuteThemeButton = new JButton("Buy");
	JButton buyWindowThemeButton = new JButton("Buy");
	JButton buyKingThemeButton = new JButton("Buy");
	JButton tradeButton = new JButton("Trade");
	
	JLabel pointCurrenLabel = new JLabel("Your Point: ?");
	JLabel coinCurrenLabel = new JLabel("Your Coin: ? ");
	private final JPanel panel_2_1_1_1 = new JPanel();
	private final JLabel previewIconDF2 = new JLabel("");
	private final JLabel previewIconDF1 = new JLabel("");
	private final JLabel previewIconDF3 = new JLabel("");
	private final JLabel priceDfTheme = new JLabel("Default theme");
	JButton chooseDefaultButton = new JButton("Choose");
	JButton chooseCuteButton = new JButton("Choose");
	JButton chooseKingButton = new JButton("Choose");
	JButton chooseWinButton = new JButton("Choose");

	public LoginView() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginView.class.getResource("/boxGame/iconGame.png")));
		init();
		loadImage();
		loadCardLayout();
		showCard("login");
		repaint();

		loginPane.requestFocus();
		setVisible(true);
	}

	void loadImage() {
		try {
			signupPane_img = new ImageIcon(ImageIO.read(getClass().getResource("/loginPaneIcon/signupBackground.png")));
			firstBackground = new ImageIcon(ImageIO.read(getClass().getResource("/loginPaneIcon/firstBackground.png")));
			loginButton_img = new ImageIcon(ImageIO.read(getClass().getResource("/loginPaneIcon/loginButton.png")));
			loginButtonWhenClicked_img = new ImageIcon(
					ImageIO.read(getClass().getResource("/loginPaneIcon/loginButtonWhenClicked.png")));
			secondBackground = new ImageIcon(ImageIO.read(getClass().getResource("/loginPaneIcon/secondBackground.png")));
			signupButtonOnLoginPane_img = new ImageIcon(ImageIO.read(getClass().getResource("/loginPaneIcon/signupButton.png")));
			signupButtonOnLoginPaneWhenCLick_img = new ImageIcon(
					ImageIO.read(getClass().getResource("/loginPaneIcon/signupButtonWhenClick.png")));
			signupButton_img = new ImageIcon(ImageIO.read(getClass().getResource("/loginPaneIcon/signupButton2.png")));
			signupButtonWhenClick_img = new ImageIcon(
					ImageIO.read(getClass().getResource("/loginPaneIcon/signupButtonWhenClick2.png")));
			loginButton2_img = new ImageIcon(ImageIO.read(getClass().getResource("/loginPaneIcon/loginButton2.png")));
			loginButtonWhenClick2_img = new ImageIcon(
					ImageIO.read(getClass().getResource("/loginPaneIcon/loginButtonWhenClick2.png")));
			minesweeperButton_img = new ImageIcon(ImageIO.read(getClass().getResource("/loginPaneIcon/minesweeperGame.png")));
			tetrisButton_img = new ImageIcon(ImageIO.read(getClass().getResource("/loginPaneIcon/tetrisGame.png")));
			puzzelSlidingButton_img = new ImageIcon(ImageIO.read(getClass().getResource("/loginPaneIcon/puzzleSlidingGame.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	void loadLoginFrame() {
		loginPane.setFont(new Font("Yu Gothic", Font.PLAIN, 14));
		loginPane.setOpaque(false);

		loginPane.setBounds(0, 0, 768, 768);

		firstBackground_Label.add(loginPane);
		loginPane.setLayout(null);

		loginButton.addActionListener(loginController);
		loginButton.addMouseListener(loginController);
		loginButton.setOpaque(false);
		loginButton.setBorderPainted(false);
		loginButton.setContentAreaFilled(false);
		loginButton.setIcon(loginButton_img);
		loginButton.setBounds(251, 426, 269, 63);
		loginPane.add(loginButton);

		password_TextFieldLG.setText("Password");
		password_TextFieldLG.addFocusListener(loginController);
		password_TextFieldLG.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		password_TextFieldLG.setForeground(Color.GRAY);
		password_TextFieldLG.setBorder(null);
		password_TextFieldLG.setOpaque(false);
		password_TextFieldLG.setBounds(266, 357, 237, 42);
		password_TextFieldLG.setEchoChar((char) 0);
		loginPane.add(password_TextFieldLG);

		username_TextFieldLG.setText("Username");
		username_TextFieldLG.addFocusListener(loginController);
		username_TextFieldLG.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		username_TextFieldLG.setForeground(Color.GRAY);
		username_TextFieldLG.setBorder(null);
		username_TextFieldLG.setOpaque(false);
		username_TextFieldLG.setBounds(266, 297, 237, 42);
		loginPane.add(username_TextFieldLG);

		signupButtonOnLogin.setFocusPainted(false);

		signupButtonOnLogin.addMouseListener(loginController);
		signupButtonOnLogin.addActionListener(loginController);
		signupButtonOnLogin.setOpaque(false);
		signupButtonOnLogin.setBorderPainted(false);
		signupButtonOnLogin.setContentAreaFilled(false);
		signupButtonOnLogin.setIcon(signupButtonOnLoginPane_img);
		signupButtonOnLogin.setBounds(251, 536, 269, 63);

		loginPane.add(signupButtonOnLogin);

		firstBackground_Label.setIcon(firstBackground);
		firstContentPane.add(firstBackground_Label);
		firstBackground_Label.setOpaque(false);

		loginPane.addMouseListener(loginController);
		firstContentPane.repaint();
		cardPanel.add(firstContentPane, "login");
	}

	void loadSignupFrame() {
		signupPaneItems.setOpaque(false);
		signupPaneItems.setBounds(0, 0, 768, 768);
		signupPaneBackground.setIcon(signupPane_img);
		signupPaneBackground.add(signupPaneItems);
		signupPaneItems.setLayout(null);

		signupButton.setBorderPainted(false);
		signupButton.setOpaque(false);
		signupButton.setContentAreaFilled(false);
		signupButton.setIcon(signupButton_img);
		signupButton.setBounds(252, 507, 266, 58);
		signupButton.addActionListener(loginController);
		signupButton.addMouseListener(loginController);

		password_TextFieldSU.setText("Password");
		password_TextFieldSU.addFocusListener(loginController);
		password_TextFieldSU.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		password_TextFieldSU.setForeground(Color.GRAY);
		password_TextFieldSU.setBorder(null);
		password_TextFieldSU.setOpaque(false);
		password_TextFieldSU.setBounds(266, 373, 237, 42);
		password_TextFieldSU.setEchoChar((char) 0);
		password_TextFieldLG.addFocusListener(loginController);
		signupPaneItems.add(password_TextFieldSU);

		username_TextFieldSU.setText("Username");
		username_TextFieldSU.addFocusListener(loginController);
		username_TextFieldSU.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		username_TextFieldSU.setForeground(Color.GRAY);
		username_TextFieldSU.setBorder(null);
		username_TextFieldSU.setOpaque(false);
		username_TextFieldSU.setBounds(266, 245, 237, 42);
		username_TextFieldSU.addFocusListener(loginController);
		signupPaneItems.add(username_TextFieldSU);

		signupPaneItems.add(signupButton);

		email_TextField.setText("Email");
		email_TextField.addFocusListener(loginController);
		email_TextField.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		email_TextField.setForeground(Color.GRAY);
		email_TextField.setBorder(null);
		email_TextField.setOpaque(false);
		email_TextField.setBounds(266, 311, 237, 42);
		signupPaneItems.add(email_TextField);
		email_TextField.setColumns(10);

		confirmPassword_TextField.setText("Confirm Password");
		confirmPassword_TextField.addFocusListener(loginController);
		confirmPassword_TextField.setFont(new Font("Yu Gothic UI", Font.BOLD, 16));
		confirmPassword_TextField.setForeground(Color.GRAY);
		confirmPassword_TextField.setBorder(null);
		confirmPassword_TextField.setOpaque(false);
		confirmPassword_TextField.setEchoChar((char) 0);
		confirmPassword_TextField.setBounds(266, 439, 237, 42);
		signupPaneItems.add(confirmPassword_TextField);
		loginButtonOnSignInpage.setBorderPainted(false);
		loginButtonOnSignInpage.setOpaque(false);
		loginButtonOnSignInpage.setContentAreaFilled(false);
		loginButtonOnSignInpage.setFocusPainted(false);
		loginButtonOnSignInpage.addMouseListener(loginController);

		loginButtonOnSignInpage.setBounds(252, 590, 266, 67);
		loginButtonOnSignInpage.setIcon(loginButton2_img);
		loginButtonOnSignInpage.addActionListener(loginController);

		signupPaneItems.add(loginButtonOnSignInpage);

		signupContentPane.add(signupPaneBackground);
		repaint();

		cardPanel.add(signupContentPane, "signup");
	}

	void loadCardLayout() {
		cardLayout = new CardLayout();
		cardPanel = new JPanel(cardLayout);

		loadLoginFrame();
		loadSignupFrame();
		loadSecondFrame();
		// Add more panels as needed

		setContentPane(cardPanel);

		this.pack();
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}

	void showCard(String cardName) {
		cardLayout.show(cardPanel, cardName);
	}

	void loadSignupPane() {

	}

	void signupItems() {

	}

	void loadFirstFrame() {
		setContentPane(firstContentPane);
		pack();
	}

	void secondFrameItems() {
		secondContentPane.setBackground(new Color(192, 192, 192));
		secondContentPane.setLayout(null);
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 778, 778);
		secondContentPane.add(tabbedPane);
		tabGamePane.setBackground(new Color(250, 246, 228));

		tabGamePane.setLayout(null);
		minesweeperGameButton.setBounds(45, 21, 689, 191);
		minesweeperGameButton.setOpaque(false);
		minesweeperGameButton.setContentAreaFilled(false);
		minesweeperGameButton.setBorderPainted(false);
		minesweeperGameButton.setIcon(minesweeperButton_img);
		minesweeperGameButton.addActionListener(loginController);

		tabGamePane.add(minesweeperGameButton);

		tetrisGameButton.setBounds(45, 261, 689, 167);
		tetrisGameButton.setOpaque(false);
		tetrisGameButton.setContentAreaFilled(false);
		tetrisGameButton.setBorderPainted(false);
		tetrisGameButton.setIcon(tetrisButton_img);
		tetrisGameButton.addActionListener(loginController);

		tabGamePane.add(tetrisGameButton);

		puzzleSlidingGameButton.setBounds(45, 497, 684, 167);
		puzzleSlidingGameButton.setOpaque(false);
		puzzleSlidingGameButton.setContentAreaFilled(false);
		puzzleSlidingGameButton.setBorderPainted(false);
		puzzleSlidingGameButton.setIcon(puzzelSlidingButton_img);
		puzzleSlidingGameButton.addActionListener(loginController);

		tabGamePane.add(puzzleSlidingGameButton);
		
		topTable.setBackground(new Color(250, 246, 228));
		topTable.setFont(new Font("Tahoma", Font.BOLD, 14));
		topTable.setRowHeight(37);
		topTable.setEnabled(false);

		topTable.getTableHeader().setFont(new Font("SansSerif", Font.BOLD | Font.ITALIC, 16));
		tabbedPane.addTab("", new ImageIcon(LoginView.class.getResource("/rankPane/joystick.png")), tabGamePane, null);
		topPane.setBackground(new Color(250, 246, 228));
		topPane.setFont(new Font("Tahoma", Font.BOLD, 16));

		tabbedPane.addTab("", new ImageIcon(LoginView.class.getResource("/rankPane/leaderboard.png")), topPane, null);
		
		tabbedPane.addTab("", new ImageIcon(LoginView.class.getResource("/tabIcon/store.png")), shopPane, null);
		shopHeader.setFont(new Font("Tahoma", Font.BOLD, 36));
		shopHeader.setHorizontalAlignment(SwingConstants.CENTER);
		
		shopPane.setColumnHeaderView(shopHeader);
		shopViewport.setBackground(new Color(250, 246, 228));
		
		shopPane.setViewportView(shopViewport);
		shopViewport.setLayout(null);
		tradeCoinPane.setBackground(new Color(255, 255, 255));
		tradeCoinPane.setBounds(59, 56, 649, 138);
		
		shopViewport.add(tradeCoinPane);
		tradeCoinPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Trade Coin: ");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(32, 11, 101, 14);
		tradeCoinPane.add(lblNewLabel);
		
		tradeTextField = new JTextField();
		tradeTextField.setBounds(381, 47, 101, 23);
		tradeCoinPane.add(tradeTextField);
		tradeTextField.setColumns(10);
		
		JLabel valueTradeLebel = new JLabel("10 point = 1 coin");
		valueTradeLebel.setFont(new Font("Arial", Font.PLAIN, 15));
		valueTradeLebel.setBounds(133, 12, 138, 14);
		tradeCoinPane.add(valueTradeLebel);
		
		tradeButton.setBorder(null);
		tradeButton.setBounds(289, 90, 89, 23);
		tradeCoinPane.add(tradeButton);
		tradeButton.addActionListener(loginController);
		
		JLabel noteTrade = new JLabel("Enter a point divisible by 10 and ≥10:");
		noteTrade.setFont(new Font("Tahoma", Font.BOLD, 12));
		noteTrade.setBounds(103, 50, 258, 14);
		tradeCoinPane.add(noteTrade);
		
		coinCurrenLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		coinCurrenLabel.setBounds(59, 24, 208, 14);
		shopViewport.add(coinCurrenLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.getVerticalScrollBar().setUnitIncrement(20);
		scrollPane_1.setBounds(59, 243, 649, 381);
		shopViewport.add(scrollPane_1);
		
		buyCuteThemeButton.addActionListener(loginController);
		buyKingThemeButton.addActionListener(loginController);
		buyWindowThemeButton.addActionListener(loginController);
		
		chooseCuteButton.addActionListener(loginController);
		chooseDefaultButton.addActionListener(loginController);
		chooseKingButton.addActionListener(loginController);
		chooseWinButton.addActionListener(loginController);
		
		JPanel panel_1 = new JPanel();
		scrollPane_1.setViewportView(panel_1);
		panel_1.setPreferredSize(new Dimension(619,772));
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(95, 32, 437, 153);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel previewIconWT2 = new JLabel("");
		previewIconWT2.setBounds(140, 36, 64, 64);
		panel_2.add(previewIconWT2);
		previewIconWT2.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/flagWindow.png")));
		
		JLabel previewIconWT1 = new JLabel("");
		previewIconWT1.setBounds(54, 36, 64, 64);
		panel_2.add(previewIconWT1);
		previewIconWT1.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareWindow.png")));
		
		JLabel previewIconWT3 = new JLabel("");
		previewIconWT3.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/explosionWindow.png")));
		previewIconWT3.setBounds(318, 36, 64, 64);
		panel_2.add(previewIconWT3);
		
		JLabel priceWindowTheme = new JLabel("Window Theme : 100 coin");
		priceWindowTheme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		priceWindowTheme.setBounds(126, 11, 166, 14);
		panel_2.add(priceWindowTheme);
		
		buyWindowThemeButton.setBounds(115, 111, 89, 23);
		panel_2.add(buyWindowThemeButton);
		
		chooseWinButton.setBounds(242, 111, 89, 23);
		panel_2.add(chooseWinButton);
		
		JLabel previewIconWT2_1 = new JLabel("");
		previewIconWT2_1.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareQuesWin.png")));
		previewIconWT2_1.setBounds(228, 36, 64, 64);
		panel_2.add(previewIconWT2_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBounds(95, 217, 437, 153);
		panel_2_1.setLayout(null);
		panel_1.add(panel_2_1);
		
		JLabel previewIconKT2 = new JLabel("");
		previewIconKT2.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/flagKing.png")));
		previewIconKT2.setBounds(140, 36, 64, 64);
		panel_2_1.add(previewIconKT2);
		
		JLabel previewIconKT1 = new JLabel("");
		previewIconKT1.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareKing.png")));
		previewIconKT1.setBounds(54, 36, 64, 64);
		panel_2_1.add(previewIconKT1);
		
		JLabel previewIconKT3 = new JLabel("");
		previewIconKT3.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/explosionKing.png")));
		previewIconKT3.setBounds(318, 36, 64, 64);
		panel_2_1.add(previewIconKT3);
		
		JLabel priceKingTheme = new JLabel("King Theme : 200 coin");
		priceKingTheme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		priceKingTheme.setBounds(126, 11, 166, 14);
		panel_2_1.add(priceKingTheme);
		
		buyKingThemeButton.setBounds(115, 111, 89, 23);
		panel_2_1.add(buyKingThemeButton);
		
		chooseKingButton.setBounds(242, 111, 89, 23);
		panel_2_1.add(chooseKingButton);
		
		JLabel previewIconKT2_1 = new JLabel("");
		previewIconKT2_1.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareQuesKing.png")));
		previewIconKT2_1.setBounds(228, 36, 64, 64);
		panel_2_1.add(previewIconKT2_1);
		panel_2_1_1.setBounds(95, 402, 437, 153);
		panel_1.add(panel_2_1_1);
		panel_2_1_1.setLayout(null);
		previewIconCT2.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/flagBlue.png")));
		previewIconCT2.setBounds(140, 36, 64, 64);
		
		panel_2_1_1.add(previewIconCT2);
		previewIconCT1.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareBlue.png")));
		previewIconCT1.setBounds(54, 36, 64, 64);
		
		panel_2_1_1.add(previewIconCT1);
		previewIconCT3.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/explosionBlue.png")));
		previewIconCT3.setBounds(313, 36, 64, 64);
		
		panel_2_1_1.add(previewIconCT3);
		priceCuteTheme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		priceCuteTheme.setBounds(126, 11, 166, 14);
		
		panel_2_1_1.add(priceCuteTheme);
		buyCuteThemeButton.setBounds(115, 111, 89, 23);
		
		panel_2_1_1.add(buyCuteThemeButton);
		
		chooseCuteButton.setBounds(242, 111, 89, 23);
		panel_2_1_1.add(chooseCuteButton);
		
		JLabel previewIconCT4 = new JLabel("");
		previewIconCT4.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareQuesBlue.png")));
		previewIconCT4.setBounds(228, 36, 64, 64);
		panel_2_1_1.add(previewIconCT4);
		panel_2_1_1_1.setLayout(null);
		panel_2_1_1_1.setBounds(95, 587, 437, 153);
		
		panel_1.add(panel_2_1_1_1);
		previewIconDF2.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareGreenFlag.png")));
		previewIconDF2.setBounds(140, 36, 64, 64);
		
		panel_2_1_1_1.add(previewIconDF2);
		previewIconDF1.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareGreen.png")));
		previewIconDF1.setBounds(54, 36, 64, 64);
		
		panel_2_1_1_1.add(previewIconDF1);
		previewIconDF3.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/explosion.png")));
		previewIconDF3.setBounds(318, 36, 64, 64);
		
		panel_2_1_1_1.add(previewIconDF3);
		priceDfTheme.setHorizontalAlignment(SwingConstants.CENTER);
		priceDfTheme.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 13));
		priceDfTheme.setBounds(126, 11, 166, 14);
		
		panel_2_1_1_1.add(priceDfTheme);
		chooseDefaultButton.setBounds(171, 111, 89, 23);
		
		panel_2_1_1_1.add(chooseDefaultButton);
		
		JLabel previewIconKT2_1_1 = new JLabel("");
		previewIconKT2_1_1.setIcon(new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareGreenDebug.png")));
		previewIconKT2_1_1.setBounds(228, 36, 64, 64);
		panel_2_1_1_1.add(previewIconKT2_1_1);
		
		JLabel minesweeperShop = new JLabel("          Minesweeper Shop:");
		minesweeperShop.setBackground(new Color(255, 255, 255));
		scrollPane_1.setColumnHeaderView(minesweeperShop);
		minesweeperShop.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		pointCurrenLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		pointCurrenLabel.setBounds(500, 26, 208, 14);
		shopViewport.add(pointCurrenLabel);
		profilePane.setBackground(new Color(250, 246, 228));

		tabbedPane.addTab("", new ImageIcon(LoginView.class.getResource("/profileIcon/profileTop.png")), profilePane, null);
		profilePane.setLayout(null);

		JLabel iconProfile = new JLabel("");
		iconProfile.setIcon(new ImageIcon(LoginView.class.getResource("/profileIcon/profile.png")));
		iconProfile.setBounds(257, 45, 256, 256);
		profilePane.add(iconProfile);
		usernameProLabel.setFont(new Font("Arial", Font.BOLD, 32));
		usernameProLabel.setHorizontalAlignment(SwingConstants.CENTER);
		usernameProLabel.setBounds(135, 333, 507, 48);

		profilePane.add(usernameProLabel);
		pointProLabel.setFont(new Font("Arial", Font.BOLD, 30));
		pointProLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pointProLabel.setBounds(135, 399, 507, 48);

		profilePane.add(pointProLabel);

		logoutButton.addActionListener(loginController);
		logoutButton.setOpaque(false);
		logoutButton.setBorderPainted(false);
		logoutButton.setBorder(new SoftBevelBorder(BevelBorder.RAISED, null, null, null, null));
		logoutButton.setIcon(new ImageIcon(LoginView.class.getResource("/profileIcon/logout.png")));
		logoutButton.setBounds(334, 549, 84, 84);
		profilePane.add(logoutButton);

		tabbedPane.addChangeListener(loginController);
	}

	void loadSecondFrame() {
		secondFrameItems();
		repaint();
		cardPanel.add(secondContentPane, "secondPane");
	}

	private void init() {
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				int confirmed = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit Box Game",
						JOptionPane.YES_NO_OPTION);

				if (confirmed == JOptionPane.YES_OPTION) {
					setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
				} else {
					setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
				}
			}
		});
		this.setResizable(false);
		this.setSize(768, 768);
		this.setTitle("Box Game");
		this.setLocationRelativeTo(null);
	}
}
