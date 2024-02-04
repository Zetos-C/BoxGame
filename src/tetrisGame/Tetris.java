package tetrisGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class Tetris extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Board board;
    private int score ;
    private String username;

    public Tetris(String username) {
    	this.username = username;
        initUI();
     board.start();

    }

    private void initUI() {
        setLayout(new BorderLayout());
        board = new Board(username);
        add(board, BorderLayout.CENTER);
        setSize(400, 600);
        setTitle("Tetris");
        this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
					board.stopGame();
					setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			}
		});
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    public JLabel getStatusBar() {
        return board.getStatusBar();
    }
}

