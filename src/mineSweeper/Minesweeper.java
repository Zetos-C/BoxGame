package mineSweeper;

import java.util.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;

import Users.Users;
import loginPage.LoginModel;
import loginPage.LoginView;
import javax.imageio.ImageIO;
import java.io.IOException;

public class Minesweeper extends JFrame {

	private Difficulty dfc = new Difficulty();
	
	private String username;

	private byte numRows;
	private byte numCols;
	private byte count_flag = 0;
	private byte mineCount;
	private int tilesClicked = 0;
	private boolean gameOver = false;
	private ImageIcon img_tile, img_mine, img_flag, img_debug, img_1, img_2, img_3, img_4, img_5, img_6, img_7, img_8,
			img_empty;
	public int difficulty = 1;

	private JLabel mines_Count = new JLabel();
	private JPanel textPanel = new JPanel();
	private JPanel boardPanel = new JPanel();

	private MineTile[][] board = new MineTile[numRows][numCols];
	private ArrayList<MineTile> mineList;
	private Random random = new Random();

	private JTextField counter = new JTextField(4);

	JButton nextLevelButton = new JButton("Next Level");
	JButton playAgainButton = new JButton("Play Again");

	// Timer
	private byte seconds = 0;
	private int minutes = 0;
	Timer timer;
	
	private int themeId;
	
	LoginModel loginModel = new LoginModel();
	int pointPlus = 0;

	// Time count here
	final private ActionListener timetask = new ActionListener() {
		public void actionPerformed(ActionEvent evt) {
			if (seconds < 59) {
				seconds++;
			} else {
				minutes++;
				seconds = 0;
			}
			counter.setText(String.format("%02d:%02d", minutes, seconds));
		}
	};

	// Game here
	public Minesweeper(String username,int themeId) {
		loginModel.setUsername(username);
		
		this.username = username;
		
		this.themeId = themeId;
		
		timer = new Timer(1000, timetask);

		init();

		loadImages();

		counter.setHorizontalAlignment(JLabel.RIGHT);
		counter.setEditable(false);
		Font font1 = new Font("SansSerif", Font.BOLD, 30);
		counter.setFont(font1);
		counter.setForeground(Color.RED);

		mines_Count.setFont(new Font("Arial", Font.BOLD, 30));
		mines_Count.setHorizontalAlignment(JLabel.LEFT);
		mines_Count.setOpaque(true);
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setHgap(50);
		textPanel.setLayout(flowLayout);
		textPanel.add(mines_Count);
		textPanel.add(counter);
		// First start game here
		dfc.equalDifficulty(difficulty);
		newGame();

		// Create Menubar
		JMenuBar menuBar = new JMenuBar();
		JMenu game = new JMenu("Game");
		JMenu help = new JMenu("Help");

		// Create menu choose difficulty
		JMenu newGameMenu = new JMenu("New Game");
		JMenuItem beginnerItem = new JMenuItem("Beginner");
		beginnerItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				difficulty = 1;
				newGame();
			}
		});
		JMenuItem easyItem = new JMenuItem("Easy");
		easyItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				difficulty = 2;
				newGame();
			}
		});
		JMenuItem mediumItem = new JMenuItem("Medium");
		mediumItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				difficulty = 3;
				newGame();
			}
		});
		JMenuItem hardItem = new JMenuItem("Hard");
		hardItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				difficulty = 4;
				newGame();
			}
		});
		JMenuItem expertItem = new JMenuItem("Expert");
		expertItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				difficulty = 5;
				newGame();
			}
		});

		JMenuItem aboutItem = new JMenuItem("About");
		aboutItem.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(aboutItem, "Minesweeper v4.0  \n\nThe game is reprogrammed by DuongDat",
						"About Game", JOptionPane.INFORMATION_MESSAGE);

			}
		});

		newGameMenu.add(beginnerItem);
		newGameMenu.add(easyItem);
		newGameMenu.add(mediumItem);
		newGameMenu.add(hardItem);
		newGameMenu.add(expertItem);

		menuBar.add(game);
		menuBar.add(help);
		game.add(newGameMenu);
		help.add(aboutItem);
		setJMenuBar(menuBar);
		this.pack();
		this.setJMenuBar(menuBar);
	}

	private void hideFrame() {
		this.setVisible(false);
	}
	private void init() {
		this.setTitle("Minesweeper");
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
					hideFrame();
			}
		});
		this.setLayout(new BorderLayout());
	}
	public void loadTheme() {
		switch (themeId) {
		case 1: {
			try {
				img_tile = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/squareGreen.png")));
				img_mine = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/explosion.png")));
				img_flag = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/squareGreenFlag.png")));
				img_debug = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/squareGreenDebug.png")));
				repaint();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
		case 2: {
			try {
				img_tile = new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareWindow.png"));
				img_mine = new ImageIcon(LoginView.class.getResource("/minesweeperShop/explosionWindow.png"));
				img_flag = new ImageIcon(LoginView.class.getResource("/minesweeperShop/flagWindow.png"));
				img_debug = new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareQuesWin.png"));
				repaint();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
		case 3: {
			try {
				img_tile = new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareKing.png"));
				img_mine = new ImageIcon(LoginView.class.getResource("/minesweeperShop/explosionKing.png"));
				img_flag = new ImageIcon(LoginView.class.getResource("/minesweeperShop/flagKing.png"));
				img_debug = new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareQuesKing.png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
		case 4: {
			try {
				img_tile = new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareBlue.png"));
				img_mine = new ImageIcon(LoginView.class.getResource("/minesweeperShop/explosionBlue.png"));
				img_flag = new ImageIcon(LoginView.class.getResource("/minesweeperShop/flagBlue.png"));
				img_debug = new ImageIcon(LoginView.class.getResource("/minesweeperShop/squareQuesBlue.png"));
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			break;
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + themeId);
		}
	}

	private void loadImages() {
		try {
			loadTheme();
			img_empty = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/empty.png")));
			img_1 = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/number_1.png")));
			img_2 = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/number_2.png")));
			img_3 = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/number_3.png")));
			img_4 = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/number_4.png")));
			img_5 = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/number_5.png")));
			img_6 = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/number_6.png")));
			img_7 = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/number_7.png")));
			img_8 = new ImageIcon(ImageIO.read(getClass().getResource("/minesweeperGameIcon/number_8.png")));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void newGame() {

		count_flag = 0;
		dfc.equalDifficulty(difficulty);
		numRows = dfc.rows;
		numCols = dfc.cols;
		mineCount = dfc.mines;

		seconds = 0;
		minutes = 0;
		mines_Count.setText("Mine: " + Byte.toString((byte) (mineCount - count_flag)));
		resetTimer();
		timer.start();

		tilesClicked = 0;
		gameOver = false;

		boardPanel.setLayout(new GridLayout(numRows, numCols));
		this.add(textPanel, BorderLayout.SOUTH);

		if (boardPanel != null) {
			boardPanel.removeAll();
		}

		boardPanel.setLayout(new GridLayout(numRows, numCols));
		this.add(textPanel, BorderLayout.SOUTH);
		this.add(boardPanel);

		board = new MineTile[numRows][numCols];
		for (int r = 0; r < numRows; r++) {
			for (int c = 0; c < numCols; c++) {
				MineTile tile = new MineTile(r, c);
				board[r][c] = tile;

				tile.setFocusable(false);
				tile.setMargin(new Insets(0, 0, 0, 0));
				tile.setIcon(img_tile);
				tile.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if (gameOver) {
							timer.stop();
							return;
						}
						MineTile tile = (MineTile) e.getSource();

						// left click
						if (e.getButton() == MouseEvent.BUTTON1) {
							if (tile.getIcon() == img_tile || tile.getIcon() == img_debug) {
								if (mineList.contains(tile)) {
									revealMines();
									showLoseDialog();
								} else {
									checkMine(tile.r, tile.c);
								}
							}
						}

						// right click
						else if (e.getButton() == MouseEvent.BUTTON3) {
							if ((tile.getIcon() == img_tile) && tile.isEnabled()) {
								tile.setIcon(img_flag);
								count_flag += 1;
								mines_Count.setText("Mine: " + Byte.toString((byte) (mineCount - count_flag)));

							} else if (tile.getIcon() == img_flag) {
								tile.setIcon(img_debug);
								count_flag -= 1;
								mines_Count.setText("Mine: " + Byte.toString((byte) (mineCount - count_flag)));
							} else if (tile.getIcon() == img_debug) {
								tile.setIcon(img_tile);
							}

						}
					}
				});

				boardPanel.add(tile);

			}
		}
		boardPanel.repaint();
		setMines();
		this.pack();
		repaint();
		this.setLocationRelativeTo(null);
		this.setResizable(false);
	}

	void resetTimer() {
		seconds = 0;
		minutes = 0;
		counter.setText(String.format("%02d:%02d", minutes, seconds));
		timer.start();
	}

	void setMines() {
		mineList = new ArrayList<MineTile>();

		int mineLeft = mineCount;
		while (mineLeft > 0) {
			int r = random.nextInt(numRows); // 0 - <=numRows
			int c = random.nextInt(numCols);

			MineTile tile = board[r][c];
			if (!mineList.contains(tile)) {
				mineList.add(tile);
				mineLeft -= 1;
			}
		}
	}

	// When you click on mine
	void revealMines() {
		for (int i = 0; i < mineList.size(); i++) {
			MineTile tile = mineList.get(i);
			tile.setIcon(img_mine);
		}

		gameOver = true;
		timer.stop();
		mines_Count.setText("Game Over!");
	}

	void checkMine(int r, int c) {
		if (r < 0 || r >= numRows || c < 0 || c >= numCols) {
			return;
		}

		MineTile tile = board[r][c];
		if (!tile.isEnabled()) {
			return;
		}
		tile.setEnabled(false);
		tile.setContentAreaFilled(false);
		tilesClicked += 1;

		int minesFound = 0;

		// count mine around tile
		minesFound += countMine(r - 1, c - 1); // top left
		minesFound += countMine(r - 1, c); // top
		minesFound += countMine(r - 1, c + 1); // top right

		minesFound += countMine(r, c - 1); // left
		minesFound += countMine(r, c + 1); // right

		minesFound += countMine(r + 1, c - 1); // bottom left
		minesFound += countMine(r + 1, c); // bottom
		minesFound += countMine(r + 1, c + 1); // bottom right

		if (minesFound > 0) {
			// print out the number of mine
			switch (minesFound) {
			case 1:
				setIconWhenClick(tile, img_1);
				break;
			case 2:
				setIconWhenClick(tile, img_2);
				break;
			case 3:
				setIconWhenClick(tile, img_3);
				break;
			case 4:
				setIconWhenClick(tile, img_4);
				break;
			case 5:
				setIconWhenClick(tile, img_5);
				break;
			case 6:
				setIconWhenClick(tile, img_6);
				break;
			case 7:
				setIconWhenClick(tile, img_7);
				break;
			case 8:
				setIconWhenClick(tile, img_8);
				break;
			}

		} else {
			setIconWhenClick(tile, img_empty);
			// top 3
			checkMine(r - 1, c - 1); // top left
			checkMine(r - 1, c); // top
			checkMine(r - 1, c + 1); // top right

			// left and right
			checkMine(r, c - 1); // left
			checkMine(r, c + 1); // right

			// bottom 3
			checkMine(r + 1, c - 1); // bottom left
			checkMine(r + 1, c); // bottom
			checkMine(r + 1, c + 1); // bottom right
		}
		// When you win
		if (tilesClicked == numRows * numCols - mineList.size()) {
			gameOver = true;
			mines_Count.setText("You Won!");
			timer.stop();
			showWinDialog();
		}
	}

	void setIconWhenClick(MineTile tile, ImageIcon image) {
		if (tile.getIcon() != img_flag) {
			tile.setDisabledIcon(image);
		} else {
			tile.setEnabled(true);
		}
	}

	int countMine(int r, int c) {
		if (r < 0 || r >= numRows || c < 0 || c >= numCols) {
			return 0;
		}
		if (mineList.contains(board[r][c])) {
			return 1;
		}
		return 0;
	}

	private void showWinDialog() {
		
		switch (difficulty) {
		case 1: {
			pointPlus =5;
			threadUpdatePoint(pointPlus);
			break;
		}
		case 2: {
			pointPlus =10;
			threadUpdatePoint(pointPlus);
			break;
		}
		case 3: {
			pointPlus =15;
			threadUpdatePoint(pointPlus);
			break;
		}
		case 4: {
			pointPlus =20;
			threadUpdatePoint(pointPlus);
			break;
		}
		case 5: {
			pointPlus =25;
			threadUpdatePoint(pointPlus);
			break;
		}

		default:
			throw new IllegalArgumentException("Unexpected value: ");
		}
		// Show dialog with "Next Level" and "Exit" buttons
		int option = JOptionPane.showOptionDialog(this,
				"Congratulations! You Win!\nTime played: " + counter.getText()+"\nPoint: "+ pointPlus + "\nDo you want to play next level?",
				"You Win!", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
				new Object[] { "Next Level", "Exit" }, "default");

		if (option == JOptionPane.YES_OPTION) {
			if (difficulty < 5) {
				difficulty++;
				newGame();
			} else {

			}
		} else if (option == JOptionPane.NO_OPTION) {
			exitGame();
		}
	}
	private void threadUpdatePoint(int pointPlus) {
		SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() {
            	loginModel.updatePoint(pointPlus);
                return null;
            }

            @Override
            protected void done() {
                repaint();
            }
        };

        worker.execute();
	}

	private void showLoseDialog() {
		int option = JOptionPane.showOptionDialog(this, "You Lose! Do you want to play again?", "Game Over",
				JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, new Object[] { "Play Again", "Exit" },
				"default");

		if (option == JOptionPane.YES_OPTION) {
			newGame();
		} else if (option == JOptionPane.NO_OPTION) {
			exitGame();
		}
	}

	void exitGame() {
			this.dispose();
	}
}
