package puzzleGame;

import java.awt.*;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.IOException;

public class Normal extends JFrame implements ActionListener {
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16;
	JMenu menu, level, help;
	JMenuItem resetGame, easy, normal, hard;
	JMenuBar mb = new JMenuBar(), hb = new JMenuBar();
	JLabel jLabel;
	Image icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9, icon10, icon11, icon12, icon13, icon14, icon15,
			empty;
	ImageIcon iconI1, iconI2, iconI3, iconI4, iconI5, iconI6, iconI7, iconI8, iconI9, iconI10, iconI11, iconI12,
			iconI13, iconI14, iconI15, iconIempty;
	private pointKeeper pointKeeper;
	private String username;
	int pointPlus = 0;

	public Normal(String username) {
		super("Puzzle Game");
		b1 = new JButton();
		b2 = new JButton();
		b3 = new JButton();
		b4 = new JButton();
		b5 = new JButton();
		b6 = new JButton();
		b7 = new JButton();
		b8 = new JButton();
		b9 = new JButton();
		b10 = new JButton();
		b11 = new JButton();
		b12 = new JButton();
		b13 = new JButton();
		b14 = new JButton();
		b15 = new JButton();
		b16 = new JButton();
		menu = new JMenu("Menu Game");
		level = new JMenu("Level");
		resetGame = new JMenuItem("Reset Game");
		easy = new JMenuItem("Easy");
		normal = new JMenuItem("Normal");
		hard = new JMenuItem("Hard");
		help = new JMenu("Help");

		// điểm
		pointKeeper = new pointKeeper(username);
		// Tạo JPanel mới để chứa JLabel
		JPanel pointPanel = new JPanel();
		pointPanel.add(pointKeeper.getpointLabel());
		// Thêm scorePanel vào JFrame
		this.add(pointPanel, BorderLayout.NORTH);
//        this.repaint();
//        this.revalidate();

		// Set icon game
		Image imageIcon1 = Toolkit.getDefaultToolkit()
				.createImage(puzzle.class.getResource("/puzzleGame/puzzle-icon.png"));
		this.setIconImage(imageIcon1);
		menu.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/icons8-menu-16.png"))));
		resetGame.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/icons_reset.png"))));
		help.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/icon_help.png"))));
		level.setIcon(new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/icon_level.png"))));
		try {
			icon1 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-1.png"));
			icon2 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-2.png"));
			icon3 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-3.png"));
			icon4 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-4.png"));
			icon5 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-5.png"));
			icon6 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-6.png"));
			icon7 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-7.png"));
			icon8 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-8.png"));
			icon9 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-9.png"));
			icon10 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-10.png"));
			icon11 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-11.png"));
			icon12 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-12.png"));
			icon13 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-13.png"));
			icon14 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-14.png"));
			icon15 = ImageIO.read(getClass().getResource("/puzzleGame/lv2-15.png"));
			empty = ImageIO.read(getClass().getResource("/puzzleGame/empty.png"));
			iconI1 = new ImageIcon(icon1);
			iconI2 = new ImageIcon(icon2);
			iconI3 = new ImageIcon(icon3);
			iconI4 = new ImageIcon(icon4);
			iconI5 = new ImageIcon(icon5);
			iconI6 = new ImageIcon(icon6);
			iconI7 = new ImageIcon(icon7);
			iconI8 = new ImageIcon(icon8);
			iconI9 = new ImageIcon(icon9);
			iconI10 = new ImageIcon(icon10);
			iconI11 = new ImageIcon(icon11);
			iconI12 = new ImageIcon(icon12);
			iconI13 = new ImageIcon(icon13);
			iconI14 = new ImageIcon(icon14);
			iconI15 = new ImageIcon(icon15);
			iconIempty = new ImageIcon(empty);

		} catch (IOException e) {
			e.printStackTrace();
		}
		// Cấu hình ban đầu
		b1.setIcon(iconI1);
		b2.setIcon(iconI2);
		b3.setIcon(iconI3);
		b4.setIcon(iconI4);
		b5.setIcon(iconI5);
		b6.setIcon(iconI6);
		b7.setIcon(iconI7);
		b8.setIcon(iconI8);
		b9.setIcon(iconI9);
		b10.setIcon(iconI10);
		b11.setIcon(iconI11);
		b12.setIcon(iconI12);
		b13.setIcon(iconI13);
		b14.setIcon(iconI14);
		b15.setIcon(iconIempty);
		b16.setIcon(iconI15);

		// JPanel
		JPanel jPanel_Buttons = new JPanel();
//		jPanel_Buttons.setSize(300, 300);
		jPanel_Buttons.setLayout(new GridLayout(4, 4));
		jPanel_Buttons.add(b1);
		jPanel_Buttons.add(b2);
		jPanel_Buttons.add(b3);
		jPanel_Buttons.add(b4);
		jPanel_Buttons.add(b5);
		jPanel_Buttons.add(b6);
		jPanel_Buttons.add(b7);
		jPanel_Buttons.add(b8);
		jPanel_Buttons.add(b9);
		jPanel_Buttons.add(b10);
		jPanel_Buttons.add(b11);
		jPanel_Buttons.add(b12);
		jPanel_Buttons.add(b13);
		jPanel_Buttons.add(b14);
		jPanel_Buttons.add(b15);
		jPanel_Buttons.add(b16);

//kích thước cửa sổ
		this.setSize(700, 750);
		this.setLocationRelativeTo(null);

		this.setJMenuBar(mb);

		menu.add((resetGame));
		level.add((easy));
		level.add((normal));
		level.add((hard));
		menu.add(level);
		mb.add(menu);
		mb.add(help);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		b15.addActionListener(this);
		b16.addActionListener(this);
		resetGame.addActionListener(this);
		easy.addActionListener(this);
		normal.addActionListener(this);
		hard.addActionListener(this);

		this.setLayout(new BorderLayout());
		this.add(jPanel_Buttons, BorderLayout.CENTER);

		repaint();
		setVisible(true); // cho phép hiển thị
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

	}// ket thuc constructor

	public void actionPerformed(ActionEvent e) {

		// Tạo cửa sổ thông báo
		JDialog dialog = new JDialog();
		dialog.setLayout(new FlowLayout());
		dialog.setTitle("CONGRATULATION!");
		dialog.setLocationRelativeTo(null);

		// Thêm hình ảnh
		ImageIcon imageIcon = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/congratulation_2.png")));
		JLabel label = new JLabel("!!!YOU WON!!!", imageIcon, JLabel.CENTER);
		dialog.add(label);

		// Thêm điểm số
		JLabel scoreLabel = new JLabel("Points: " + pointKeeper.getpoint());
		dialog.add(scoreLabel);

		// Tạo nút Replay
		JButton replayButton = new JButton("Replay");
		replayButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Đóng cửa sổ thông báo
				dialog.dispose();
			}
		});
		dialog.add(replayButton);

		// Tạo nút Exit Game
		JButton exitButton = new JButton("Exit Game");
		exitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Đóng cửa sổ thông báo
				dialog.dispose();

				// Đóng cửa sổ game và dừng chương trình
				hideWin();
			}
		});
		dialog.add(exitButton);

		// Hiển thị cửa sổ thông báo
		dialog.pack();
		dialog.setVisible(false);

//nếu nhấn nút reset sẽ random các nút
		if (e.getSource() == resetGame) {
			// vòng lặp random đến khi có cấu hình hợp lệ
			do {
				randomizeButtons4x4();
			} while (!isSolvable4x4());
		}

//Các nút level
		if (e.getSource() == easy) {
			repaint();
			dialog.dispose();
			// Mở cửa sổ class puzzle
			new puzzle(username).setVisible(true);
			// Đóng cửa sổ hiện tại
			dispose();
		} else if (e.getSource() == normal) {
			repaint();
			dialog.dispose();
			// Mở cửa sổ class Normal
			new Normal(username).setVisible(true);
			// Đóng cửa sổ hiện tại
			dispose();
		} else if (e.getSource() == hard) {
			repaint();
			dialog.dispose();
			// Mở cửa sổ class Hard
			new Hard(username).setVisible(true);
			// Đóng cửa sổ hiện tại
			dispose();
		}

//nhấn vào một nút sẽ check các ô xung quanh nếu có ô trống sẽ hoán đổi vị trí
		if (e.getSource() == b1) {
			Icon s = b1.getIcon();
			if (b2.getIcon() == iconIempty) {
				b2.setIcon(s);
				b1.setIcon(iconIempty);
			} else if (b5.getIcon() == iconIempty) {
				b5.setIcon(s);
				b1.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b2) {
			Icon s = b2.getIcon();
			if (b1.getIcon() == iconIempty) {
				b1.setIcon(s);
				b2.setIcon(iconIempty);
			} else if (b3.getIcon() == iconIempty) {
				b3.setIcon(s);
				b2.setIcon(iconIempty);
			} else if (b6.getIcon() == iconIempty) {
				b6.setIcon(s);
				b2.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b3) {
			Icon s = b3.getIcon();
			if (b2.getIcon() == iconIempty) {
				b2.setIcon(s);
				b3.setIcon(iconIempty);
			} else if (b4.getIcon() == iconIempty) {
				b4.setIcon(s);
				b3.setIcon(iconIempty);
			} else if (b7.getIcon() == iconIempty) {
				b7.setIcon(s);
				b3.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b4) {
			Icon s = b4.getIcon();
			if (b3.getIcon() == iconIempty) {
				b3.setIcon(s);
				b4.setIcon(iconIempty);
			} else if (b8.getIcon() == iconIempty) {
				b8.setIcon(s);
				b4.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b5) {
			Icon s = b5.getIcon();
			if (b1.getIcon() == iconIempty) {
				b1.setIcon(s);
				b5.setIcon(iconIempty);
			} else if (b6.getIcon() == iconIempty) {
				b6.setIcon(s);
				b5.setIcon(iconIempty);
			} else if (b9.getIcon() == iconIempty) {
				b9.setIcon(s);
				b5.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b6) {
			Icon s = b6.getIcon();
			if (b2.getIcon() == iconIempty) {
				b2.setIcon(s);
				b6.setIcon(iconIempty);
			} else if (b5.getIcon() == iconIempty) {
				b5.setIcon(s);
				b6.setIcon(iconIempty);
			} else if (b7.getIcon() == iconIempty) {
				b7.setIcon(s);
				b6.setIcon(iconIempty);
			} else if (b10.getIcon() == iconIempty) {
				b10.setIcon(s);
				b6.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b7) {
			Icon s = b7.getIcon();
			if (b3.getIcon() == iconIempty) {
				b3.setIcon(s);
				b7.setIcon(iconIempty);
			} else if (b6.getIcon() == iconIempty) {
				b6.setIcon(s);
				b7.setIcon(iconIempty);
			} else if (b8.getIcon() == iconIempty) {
				b8.setIcon(s);
				b7.setIcon(iconIempty);
			} else if (b11.getIcon() == iconIempty) {
				b11.setIcon(s);
				b7.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b8) {
			Icon s = b8.getIcon();
			if (b4.getIcon() == iconIempty) {
				b4.setIcon(s);
				b8.setIcon(iconIempty);
			} else if (b7.getIcon() == iconIempty) {
				b7.setIcon(s);
				b8.setIcon(iconIempty);
			} else if (b12.getIcon() == iconIempty) {
				b12.setIcon(s);
				b8.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b9) {
			Icon s = b9.getIcon();
			if (b5.getIcon() == iconIempty) {
				b5.setIcon(s);
				b9.setIcon(iconIempty);
			} else if (b10.getIcon() == iconIempty) {
				b10.setIcon(s);
				b9.setIcon(iconIempty);
			} else if (b13.getIcon() == iconIempty) {
				b13.setIcon(s);
				b9.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b10) {
			Icon s = b10.getIcon();
			if (b6.getIcon() == iconIempty) {
				b6.setIcon(s);
				b10.setIcon(iconIempty);
			} else if (b9.getIcon() == iconIempty) {
				b9.setIcon(s);
				b10.setIcon(iconIempty);
			} else if (b11.getIcon() == iconIempty) {
				b11.setIcon(s);
				b10.setIcon(iconIempty);
			} else if (b14.getIcon() == iconIempty) {
				b14.setIcon(s);
				b10.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b11) {
			Icon s = b11.getIcon();
			if (b7.getIcon() == iconIempty) {
				b7.setIcon(s);
				b11.setIcon(iconIempty);
			} else if (b10.getIcon() == iconIempty) {
				b10.setIcon(s);
				b11.setIcon(iconIempty);
			} else if (b12.getIcon() == iconIempty) {
				b12.setIcon(s);
				b11.setIcon(iconIempty);
			} else if (b15.getIcon() == iconIempty) {
				b15.setIcon(s);
				b11.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b12) {
			Icon s = b12.getIcon();
			if (b8.getIcon() == iconIempty) {
				b8.setIcon(s);
				b12.setIcon(iconIempty);
			} else if (b11.getIcon() == iconIempty) {
				b11.setIcon(s);
				b12.setIcon(iconIempty);
			} else if (b16.getIcon() == iconIempty) {
				b16.setIcon(s);
				b12.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b13) {
			Icon s = b13.getIcon();
			if (b9.getIcon() == iconIempty) {
				b9.setIcon(s);
				b13.setIcon(iconIempty);
			} else if (b14.getIcon() == iconIempty) {
				b14.setIcon(s);
				b13.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b14) {
			Icon s = b14.getIcon();
			if (b10.getIcon() == iconIempty) {
				b10.setIcon(s);
				b14.setIcon(iconIempty);
			} else if (b13.getIcon() == iconIempty) {
				b13.setIcon(s);
				b14.setIcon(iconIempty);
			} else if (b15.getIcon() == iconIempty) {
				b15.setIcon(s);
				b14.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b15) {
			Icon s = b15.getIcon();
			if (b11.getIcon() == iconIempty) {
				b11.setIcon(s);
				b15.setIcon(iconIempty);
			} else if (b14.getIcon() == iconIempty) {
				b14.setIcon(s);
				b15.setIcon(iconIempty);
			} else if (b16.getIcon() == iconIempty) {
				b16.setIcon(s);
				b15.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b16) {
			Icon s = b16.getIcon();
			if (b12.getIcon() == iconIempty) {
				b12.setIcon(s);
				b16.setIcon(iconIempty);
			} else if (b15.getIcon() == iconIempty) {
				b15.setIcon(s);
				b16.setIcon(iconIempty);
			}
		} // ket thuc if

		// Gán ảnh cho biến
		ImageIcon icon1 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-1.png")));
		ImageIcon icon2 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-2.png")));
		ImageIcon icon3 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-3.png")));
		ImageIcon icon4 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-4.png")));
		ImageIcon icon5 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-5.png")));
		ImageIcon icon6 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-6.png")));
		ImageIcon icon7 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-7.png")));
		ImageIcon icon8 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-8.png")));
		ImageIcon icon9 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-9.png")));
		ImageIcon icon10 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-10.png")));
		ImageIcon icon11 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-11.png")));
		ImageIcon icon12 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-12.png")));
		ImageIcon icon13 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-13.png")));
		ImageIcon icon14 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-14.png")));
		ImageIcon icon15 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv2-15.png")));

//check các nút sắp xếp theo thứ tự từ 1 đến 8 với ô 9 là trống, nếu đúng => you won
		if (compareImageIcons((ImageIcon) b1.getIcon(), icon1) && compareImageIcons((ImageIcon) b2.getIcon(), icon2)
				&& compareImageIcons((ImageIcon) b3.getIcon(), icon3)
				&& compareImageIcons((ImageIcon) b4.getIcon(), icon4)
				&& compareImageIcons((ImageIcon) b5.getIcon(), icon5)
				&& compareImageIcons((ImageIcon) b6.getIcon(), icon6)
				&& compareImageIcons((ImageIcon) b7.getIcon(), icon7)
				&& compareImageIcons((ImageIcon) b8.getIcon(), icon8)
				&& compareImageIcons((ImageIcon) b9.getIcon(), icon9)
				&& compareImageIcons((ImageIcon) b10.getIcon(), icon10)
				&& compareImageIcons((ImageIcon) b11.getIcon(), icon11)
				&& compareImageIcons((ImageIcon) b12.getIcon(), icon12)
				&& compareImageIcons((ImageIcon) b13.getIcon(), icon13)
				&& compareImageIcons((ImageIcon) b14.getIcon(), icon14)
				&& compareImageIcons((ImageIcon) b15.getIcon(), icon15) && b16.getIcon() == iconIempty) {
			repaint();
			pointKeeper.addpoint(pointPlus);
			scoreLabel.setText("Points: " + pointPlus);
			dialog.setVisible(true);
			do {
				randomizeButtons4x4();
				pointPlus = 20;
			} while (!isSolvable4x4());
		}

	}// ket thuc actionPerformed

	private void hideWin() {
		this.dispose();
	}

	public void addpoint(int scores) {
		pointKeeper.addpoint(scores);
	}

//So sánh nội dung 2 ImageIcon
	public boolean compareImageIcons(ImageIcon icon1, ImageIcon icon2) {
		Image image1 = icon1.getImage();
		Image image2 = icon2.getImage();

		BufferedImage bufferedImage1 = new BufferedImage(image1.getWidth(null), image1.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);
		Graphics g1 = bufferedImage1.createGraphics();
		g1.drawImage(image1, 0, 0, null);
		g1.dispose();

		BufferedImage bufferedImage2 = new BufferedImage(image2.getWidth(null), image2.getHeight(null),
				BufferedImage.TYPE_INT_ARGB);
		Graphics g2 = bufferedImage2.createGraphics();
		g2.drawImage(image2, 0, 0, null);
		g2.dispose();

		DataBuffer db1 = bufferedImage1.getData().getDataBuffer();
		int size1 = db1.getSize();
		DataBuffer db2 = bufferedImage2.getData().getDataBuffer();
		int size2 = db2.getSize();

		if (size1 != size2) {
			return false;
		} else {
			for (int i = 0; i < size1; i++) {
				if (db1.getElem(i) != db2.getElem(i)) {
					return false;
				}
			}
		}

		return true;
	}

	// random 16 nút cho 4x4
	public void randomizeButtons4x4() {
		List<ImageIcon> labels = Arrays.asList(iconI1, iconI2, iconI3, iconI4, iconI5, iconI6, iconI7, iconI8, iconI9,
				iconI10, iconI11, iconI12, iconI13, iconI14, iconI15, iconIempty);
		Collections.shuffle(labels);
		b1.setIcon(labels.get(0));
		b2.setIcon(labels.get(1));
		b3.setIcon(labels.get(2));
		b4.setIcon(labels.get(3));
		b5.setIcon(labels.get(4));
		b6.setIcon(labels.get(5));
		b7.setIcon(labels.get(6));
		b8.setIcon(labels.get(7));
		b9.setIcon(labels.get(8));
		b10.setIcon(labels.get(9));
		b11.setIcon(labels.get(10));
		b12.setIcon(labels.get(11));
		b13.setIcon(labels.get(12));
		b14.setIcon(labels.get(13));
		b15.setIcon(labels.get(14));
		b16.setIcon(labels.get(15));
	}

	public boolean isSolvable4x4() {
		int[] puzzle = new int[16];
		List<ImageIcon> labels = Arrays.asList(iconI1, iconI2, iconI3, iconI4, iconI5, iconI6, iconI7, iconI8, iconI9,
				iconI10, iconI11, iconI12, iconI13, iconI14, iconI15, iconIempty);

		for (int i = 0; i < 16; i++) {
			ImageIcon icon = null;
			switch (i) {
			case 0:
				icon = (ImageIcon) b1.getIcon();
				break;
			case 1:
				icon = (ImageIcon) b2.getIcon();
				break;
			case 2:
				icon = (ImageIcon) b3.getIcon();
				break;
			case 3:
				icon = (ImageIcon) b4.getIcon();
				break;
			case 4:
				icon = (ImageIcon) b5.getIcon();
				break;
			case 5:
				icon = (ImageIcon) b6.getIcon();
				break;
			case 6:
				icon = (ImageIcon) b7.getIcon();
				break;
			case 7:
				icon = (ImageIcon) b8.getIcon();
				break;
			case 8:
				icon = (ImageIcon) b9.getIcon();
				break;
			case 9:
				icon = (ImageIcon) b10.getIcon();
				break;
			case 10:
				icon = (ImageIcon) b11.getIcon();
				break;
			case 11:
				icon = (ImageIcon) b12.getIcon();
				break;
			case 12:
				icon = (ImageIcon) b13.getIcon();
				break;
			case 13:
				icon = (ImageIcon) b14.getIcon();
				break;
			case 14:
				icon = (ImageIcon) b15.getIcon();
				break;
			case 15:
				icon = (ImageIcon) b16.getIcon();
				break;
			}
			int index = labels.indexOf(icon);
			puzzle[i] = index != -1 ? index + 1 : 0;
		}

		int parity = 0;
		int gridWidth = (int) Math.sqrt(puzzle.length);
		int blankRow = 0; // the row with the blank tile

		for (int i = 0; i < puzzle.length; i++) {
			if (puzzle[i] == 0) { // the blank tile
				blankRow = (i / gridWidth) + 1; // save the row on which encountered
				continue;
			}
			for (int j = i + 1; j < puzzle.length; j++) {
				if (puzzle[i] > puzzle[j] && puzzle[j] != 0) {
					parity++;
				}
			}
		}

		if (gridWidth % 2 == 0) { // even grid
			return blankRow % 2 == parity % 2;
		} else { // odd grid
			return parity % 2 == 0;
		}
	}

//phương thức chỉnh kích thước ảnh phù hợp kích thước nút

	public void setIcona(JButton button, String path) throws IOException {
		Image image = ImageIO.read(getClass().getResource(path));
		Image scaledImage = image.getScaledInstance(button.getWidth(), button.getHeight(), Image.SCALE_SMOOTH);
		ImageIcon icon = new ImageIcon(scaledImage);
		button.setIcon(icon);
	}
}