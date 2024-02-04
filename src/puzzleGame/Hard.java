package puzzleGame;

import java.awt.*;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.AncestorListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.DataBuffer;
import java.io.IOException;

public class Hard extends JFrame implements ActionListener {
	JButton b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23,
			b24, b25;
	JMenu menu, level, help;
	JMenuItem resetGame, easy, normal, hard;
	JMenuBar mb = new JMenuBar(), hb = new JMenuBar();
	JLabel jLabel;
	Image icon1, icon2, icon3, icon4, icon5, icon6, icon7, icon8, icon9, icon10, icon11, icon12, icon13, icon14, icon15,
			icon16, icon17, icon18, icon19, icon20, icon21, icon22, icon23, icon24, empty;
	ImageIcon iconI1, iconI2, iconI3, iconI4, iconI5, iconI6, iconI7, iconI8, iconI9, iconI10, iconI11, iconI12,
			iconI13, iconI14, iconI15, iconI16, iconI17, iconI18, iconI19, iconI20, iconI21, iconI22, iconI23, iconI24,
			iconIempty;
	private pointKeeper pointKeeper;
	private String username;
	private int pointPlus = 0;

	public Hard(String username) {
		super("Puzzle Game");
		this.username = username;
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
		b17 = new JButton();
		b18 = new JButton();
		b19 = new JButton();
		b20 = new JButton();
		b21 = new JButton();
		b22 = new JButton();
		b23 = new JButton();
		b24 = new JButton();
		b25 = new JButton();
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
			icon1 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-1.png"));
			icon2 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-2.png"));
			icon3 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-3.png"));
			icon4 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-4.png"));
			icon5 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-5.png"));
			icon6 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-6.png"));
			icon7 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-7.png"));
			icon8 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-8.png"));
			icon9 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-9.png"));
			icon10 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-10.png"));
			icon11 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-11.png"));
			icon12 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-12.png"));
			icon13 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-13.png"));
			icon14 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-14.png"));
			icon15 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-15.png"));
			icon16 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-16.png"));
			icon17 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-17.png"));
			icon18 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-18.png"));
			icon19 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-19.png"));
			icon20 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-20.png"));
			icon21 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-21.png"));
			icon22 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-22.png"));
			icon23 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-23.png"));
			icon24 = ImageIO.read(getClass().getResource("/puzzleGame/lv3-24.png"));
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
			iconI16 = new ImageIcon(icon16);
			iconI17 = new ImageIcon(icon17);
			iconI18 = new ImageIcon(icon18);
			iconI19 = new ImageIcon(icon19);
			iconI20 = new ImageIcon(icon20);
			iconI21 = new ImageIcon(icon21);
			iconI22 = new ImageIcon(icon22);
			iconI23 = new ImageIcon(icon23);
			iconI24 = new ImageIcon(icon24);
			iconIempty = new ImageIcon(empty);

		} catch (IOException e) {
			e.printStackTrace();
		}

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
		b15.setIcon(iconI15);
		b16.setIcon(iconI16);
		b17.setIcon(iconI17);
		b18.setIcon(iconI18);
		b19.setIcon(iconI19);
		b20.setIcon(iconI20);
		b21.setIcon(iconI21);
		b22.setIcon(iconI22);
		b23.setIcon(iconI23);
		b24.setIcon(iconIempty);
		b25.setIcon(iconI24);
		// JPanel
		JPanel jPanel_Buttons = new JPanel();
//		jPanel_Buttons.setSize(300, 300);
		jPanel_Buttons.setLayout(new GridLayout(5, 5));
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
		jPanel_Buttons.add(b17);
		jPanel_Buttons.add(b18);
		jPanel_Buttons.add(b19);
		jPanel_Buttons.add(b20);
		jPanel_Buttons.add(b21);
		jPanel_Buttons.add(b22);
		jPanel_Buttons.add(b23);
		jPanel_Buttons.add(b24);
		jPanel_Buttons.add(b25);

//kích thước cửa sổ
		this.setSize(800, 850);
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
		b17.addActionListener(this);
		b18.addActionListener(this);
		b19.addActionListener(this);
		b20.addActionListener(this);
		b21.addActionListener(this);
		b22.addActionListener(this);
		b23.addActionListener(this);
		b24.addActionListener(this);
		b25.addActionListener(this);
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
		JLabel pointLabel = new JLabel("Points: " + pointKeeper.getpoint());
		dialog.add(pointLabel);

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
				randomizeButtons();
			} while (!isSolvable());
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
			} else if (b6.getIcon() == iconIempty) {
				b6.setIcon(s);
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
			} else if (b7.getIcon() == iconIempty) {
				b7.setIcon(s);
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
			} else if (b8.getIcon() == iconIempty) {
				b8.setIcon(s);
				b3.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b4) {
			Icon s = b4.getIcon();
			if (b3.getIcon() == iconIempty) {
				b3.setIcon(s);
				b4.setIcon(iconIempty);
			} else if (b5.getIcon() == iconIempty) {
				b5.setIcon(s);
				b4.setIcon(iconIempty);
			} else if (b9.getIcon() == iconIempty) {
				b9.setIcon(s);
				b4.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b5) {
			Icon s = b5.getIcon();
			if (b4.getIcon() == iconIempty) {
				b4.setIcon(s);
				b5.setIcon(iconIempty);
			} else if (b10.getIcon() == iconIempty) {
				b10.setIcon(s);
				b5.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b6) {
			Icon s = b6.getIcon();
			if (b1.getIcon() == iconIempty) {
				b1.setIcon(s);
				b6.setIcon(iconIempty);
			} else if (b7.getIcon() == iconIempty) {
				b7.setIcon(s);
				b6.setIcon(iconIempty);
			} else if (b11.getIcon() == iconIempty) {
				b11.setIcon(s);
				b6.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b7) {
			Icon s = b7.getIcon();
			if (b2.getIcon() == iconIempty) {
				b2.setIcon(s);
				b7.setIcon(iconIempty);
			} else if (b6.getIcon() == iconIempty) {
				b6.setIcon(s);
				b7.setIcon(iconIempty);
			} else if (b8.getIcon() == iconIempty) {
				b8.setIcon(s);
				b7.setIcon(iconIempty);
			} else if (b12.getIcon() == iconIempty) {
				b12.setIcon(s);
				b7.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b8) {
			Icon s = b8.getIcon();
			if (b3.getIcon() == iconIempty) {
				b3.setIcon(s);
				b8.setIcon(iconIempty);
			} else if (b7.getIcon() == iconIempty) {
				b7.setIcon(s);
				b8.setIcon(iconIempty);
			} else if (b9.getIcon() == iconIempty) {
				b9.setIcon(s);
				b8.setIcon(iconIempty);
			} else if (b13.getIcon() == iconIempty) {
				b13.setIcon(s);
				b8.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b9) {
			Icon s = b9.getIcon();
			if (b4.getIcon() == iconIempty) {
				b4.setIcon(s);
				b9.setIcon(iconIempty);
			} else if (b8.getIcon() == iconIempty) {
				b8.setIcon(s);
				b9.setIcon(iconIempty);
			} else if (b10.getIcon() == iconIempty) {
				b10.setIcon(s);
				b9.setIcon(iconIempty);
			} else if (b14.getIcon() == iconIempty) {
				b14.setIcon(s);
				b9.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b10) {
			Icon s = b10.getIcon();
			if (b5.getIcon() == iconIempty) {
				b5.setIcon(s);
				b10.setIcon(iconIempty);
			} else if (b9.getIcon() == iconIempty) {
				b9.setIcon(s);
				b10.setIcon(iconIempty);
			} else if (b15.getIcon() == iconIempty) {
				b15.setIcon(s);
				b10.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b11) {
			Icon s = b11.getIcon();
			if (b6.getIcon() == iconIempty) {
				b6.setIcon(s);
				b11.setIcon(iconIempty);
			} else if (b12.getIcon() == iconIempty) {
				b12.setIcon(s);
				b11.setIcon(iconIempty);
			} else if (b16.getIcon() == iconIempty) {
				b16.setIcon(s);
				b11.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b12) {
			Icon s = b12.getIcon();
			if (b7.getIcon() == iconIempty) {
				b7.setIcon(s);
				b12.setIcon(iconIempty);
			} else if (b11.getIcon() == iconIempty) {
				b11.setIcon(s);
				b12.setIcon(iconIempty);
			} else if (b13.getIcon() == iconIempty) {
				b13.setIcon(s);
				b12.setIcon(iconIempty);
			} else if (b17.getIcon() == iconIempty) {
				b17.setIcon(s);
				b12.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b13) {
			Icon s = b13.getIcon();
			if (b8.getIcon() == iconIempty) {
				b8.setIcon(s);
				b13.setIcon(iconIempty);
			} else if (b12.getIcon() == iconIempty) {
				b12.setIcon(s);
				b13.setIcon(iconIempty);
			} else if (b14.getIcon() == iconIempty) {
				b14.setIcon(s);
				b13.setIcon(iconIempty);
			} else if (b18.getIcon() == iconIempty) {
				b18.setIcon(s);
				b13.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b14) {
			Icon s = b14.getIcon();
			if (b9.getIcon() == iconIempty) {
				b9.setIcon(s);
				b14.setIcon(iconIempty);
			} else if (b13.getIcon() == iconIempty) {
				b13.setIcon(s);
				b14.setIcon(iconIempty);
			} else if (b15.getIcon() == iconIempty) {
				b15.setIcon(s);
				b14.setIcon(iconIempty);
			} else if (b19.getIcon() == iconIempty) {
				b19.setIcon(s);
				b14.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b15) {
			Icon s = b15.getIcon();
			if (b10.getIcon() == iconIempty) {
				b10.setIcon(s);
				b15.setIcon(iconIempty);
			} else if (b14.getIcon() == iconIempty) {
				b14.setIcon(s);
				b15.setIcon(iconIempty);
			} else if (b20.getIcon() == iconIempty) {
				b20.setIcon(s);
				b15.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b16) {
			Icon s = b16.getIcon();
			if (b11.getIcon() == iconIempty) {
				b11.setIcon(s);
				b16.setIcon(iconIempty);
			} else if (b17.getIcon() == iconIempty) {
				b17.setIcon(s);
				b16.setIcon(iconIempty);
			} else if (b21.getIcon() == iconIempty) {
				b21.setIcon(s);
				b16.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b17) {
			Icon s = b17.getIcon();
			if (b12.getIcon() == iconIempty) {
				b12.setIcon(s);
				b17.setIcon(iconIempty);
			} else if (b16.getIcon() == iconIempty) {
				b16.setIcon(s);
				b17.setIcon(iconIempty);
			} else if (b18.getIcon() == iconIempty) {
				b18.setIcon(s);
				b17.setIcon(iconIempty);
			} else if (b22.getIcon() == iconIempty) {
				b22.setIcon(s);
				b17.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b18) {
			Icon s = b18.getIcon();
			if (b13.getIcon() == iconIempty) {
				b13.setIcon(s);
				b18.setIcon(iconIempty);
			} else if (b17.getIcon() == iconIempty) {
				b17.setIcon(s);
				b18.setIcon(iconIempty);
			} else if (b19.getIcon() == iconIempty) {
				b19.setIcon(s);
				b18.setIcon(iconIempty);
			} else if (b23.getIcon() == iconIempty) {
				b23.setIcon(s);
				b18.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b19) {
			Icon s = b19.getIcon();
			if (b14.getIcon() == iconIempty) {
				b14.setIcon(s);
				b19.setIcon(iconIempty);
			} else if (b18.getIcon() == iconIempty) {
				b18.setIcon(s);
				b19.setIcon(iconIempty);
			} else if (b20.getIcon() == iconIempty) {
				b20.setIcon(s);
				b19.setIcon(iconIempty);
			} else if (b24.getIcon() == iconIempty) {
				b24.setIcon(s);
				b19.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b20) {
			Icon s = b20.getIcon();
			if (b15.getIcon() == iconIempty) {
				b15.setIcon(s);
				b20.setIcon(iconIempty);
			} else if (b19.getIcon() == iconIempty) {
				b19.setIcon(s);
				b20.setIcon(iconIempty);
			} else if (b25.getIcon() == iconIempty) {
				b25.setIcon(s);
				b20.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b21) {
			Icon s = b21.getIcon();
			if (b16.getIcon() == iconIempty) {
				b16.setIcon(s);
				b21.setIcon(iconIempty);
			} else if (b22.getIcon() == iconIempty) {
				b22.setIcon(s);
				b21.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b22) {
			Icon s = b22.getIcon();
			if (b17.getIcon() == iconIempty) {
				b17.setIcon(s);
				b22.setIcon(iconIempty);
			} else if (b21.getIcon() == iconIempty) {
				b21.setIcon(s);
				b22.setIcon(iconIempty);
			} else if (b23.getIcon() == iconIempty) {
				b23.setIcon(s);
				b22.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b23) {
			Icon s = b23.getIcon();
			if (b18.getIcon() == iconIempty) {
				b18.setIcon(s);
				b23.setIcon(iconIempty);
			} else if (b22.getIcon() == iconIempty) {
				b22.setIcon(s);
				b23.setIcon(iconIempty);
			} else if (b24.getIcon() == iconIempty) {
				b24.setIcon(s);
				b23.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b24) {
			Icon s = b24.getIcon();
			if (b19.getIcon() == iconIempty) {
				b19.setIcon(s);
				b24.setIcon(iconIempty);
			} else if (b23.getIcon() == iconIempty) {
				b23.setIcon(s);
				b24.setIcon(iconIempty);
			} else if (b25.getIcon() == iconIempty) {
				b25.setIcon(s);
				b24.setIcon(iconIempty);
			}
		} // ket thuc if

		if (e.getSource() == b25) {
			Icon s = b25.getIcon();
			if (b20.getIcon() == iconIempty) {
				b20.setIcon(s);
				b25.setIcon(iconIempty);
			} else if (b24.getIcon() == iconIempty) {
				b24.setIcon(s);
				b25.setIcon(iconIempty);
			}
		} // ket thuc if

		// Gán ảnh cho biến
		ImageIcon icon1 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-1.png")));
		ImageIcon icon2 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-2.png")));
		ImageIcon icon3 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-3.png")));
		ImageIcon icon4 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-4.png")));
		ImageIcon icon5 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-5.png")));
		ImageIcon icon6 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-6.png")));
		ImageIcon icon7 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-7.png")));
		ImageIcon icon8 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-8.png")));
		ImageIcon icon9 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-9.png")));
		ImageIcon icon10 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-10.png")));
		ImageIcon icon11 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-11.png")));
		ImageIcon icon12 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-12.png")));
		ImageIcon icon13 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-13.png")));
		ImageIcon icon14 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-14.png")));
		ImageIcon icon15 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-15.png")));
		ImageIcon icon16 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-16.png")));
		ImageIcon icon17 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-17.png")));
		ImageIcon icon18 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-18.png")));
		ImageIcon icon19 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-19.png")));
		ImageIcon icon20 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-20.png")));
		ImageIcon icon21 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-21.png")));
		ImageIcon icon22 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-22.png")));
		ImageIcon icon23 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-23.png")));
		ImageIcon icon24 = new ImageIcon(
				Toolkit.getDefaultToolkit().createImage(puzzle.class.getResource("/puzzleGame/lv3-24.png")));

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
				&& compareImageIcons((ImageIcon) b15.getIcon(), icon15)
				&& compareImageIcons((ImageIcon) b16.getIcon(), icon16)
				&& compareImageIcons((ImageIcon) b17.getIcon(), icon17)
				&& compareImageIcons((ImageIcon) b18.getIcon(), icon18)
				&& compareImageIcons((ImageIcon) b19.getIcon(), icon19)
				&& compareImageIcons((ImageIcon) b20.getIcon(), icon20)
				&& compareImageIcons((ImageIcon) b21.getIcon(), icon21)
				&& compareImageIcons((ImageIcon) b22.getIcon(), icon22)
				&& compareImageIcons((ImageIcon) b23.getIcon(), icon23)
				&& compareImageIcons((ImageIcon) b24.getIcon(), icon24) && b25.getIcon() == iconIempty) {
			repaint();
			pointLabel.setText("Points: " + pointPlus);
			pointKeeper.addpoint(pointPlus);
			dialog.setVisible(true);
			do {
				randomizeButtons();
				pointPlus = 30;
			} while (!isSolvable());
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

//random 9 nút
	public void randomizeButtons() {
		List<ImageIcon> labels = Arrays.asList(iconI1, iconI2, iconI3, iconI4, iconI5, iconI6, iconI7, iconI8, iconI9,
				iconI10, iconI11, iconI12, iconI13, iconI14, iconI15, iconI16, iconI17, iconI18, iconI19, iconI20,
				iconI21, iconI22, iconI23, iconI24, iconIempty);
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
		b17.setIcon(labels.get(16));
		b18.setIcon(labels.get(17));
		b19.setIcon(labels.get(18));
		b20.setIcon(labels.get(19));
		b21.setIcon(labels.get(20));
		b22.setIcon(labels.get(21));
		b23.setIcon(labels.get(22));
		b24.setIcon(labels.get(23));
		b25.setIcon(labels.get(24));
	}

//cấu hình hợp lệ để giải đc sau random
	public boolean isSolvable() {
		int[] puzzle = new int[25];
		List<ImageIcon> labels = Arrays.asList(iconI1, iconI2, iconI3, iconI4, iconI5, iconI6, iconI7, iconI8, iconI9,
				iconI10, iconI11, iconI12, iconI13, iconI14, iconI15, iconI16, iconI17, iconI18, iconI19, iconI20,
				iconI21, iconI22, iconI23, iconI24, iconIempty);

		for (int i = 0; i < 25; i++) {
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
			case 16:
				icon = (ImageIcon) b17.getIcon();
				break;
			case 17:
				icon = (ImageIcon) b18.getIcon();
				break;
			case 18:
				icon = (ImageIcon) b19.getIcon();
				break;
			case 19:
				icon = (ImageIcon) b20.getIcon();
				break;
			case 20:
				icon = (ImageIcon) b21.getIcon();
				break;
			case 21:
				icon = (ImageIcon) b22.getIcon();
				break;
			case 22:
				icon = (ImageIcon) b23.getIcon();
				break;
			case 23:
				icon = (ImageIcon) b24.getIcon();
				break;
			case 24:
				icon = (ImageIcon) b25.getIcon();
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

}// ket thuc class