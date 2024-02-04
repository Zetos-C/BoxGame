package tetrisGame;

import javax.imageio.ImageIO;
import javax.swing.*;

import loginPage.LoginModel;

import java.awt.*;
import java.awt.event.*;

import static javax.swing.JOptionPane.*;

public class Board extends JPanel implements ActionListener {


    private final int BOARD_WIDTH = 12;
    private final int BOARD_HEIGHT = 24;
    private int squareWidth() { return (int) getSize().getWidth() / BOARD_WIDTH; }
    private int squareHeight() { return (int) getSize().getHeight() / BOARD_HEIGHT; }
    private Timer timer;
    private boolean isFallingFinished = false;
    private boolean isStarted = false;
    private boolean isPaused = false;
    private int numLinesRemoved = 0;
    private int curX = 0;
    private int curY = 0;
    private Shape curPiece;
    private Tetrominoe[] board;
    private JLabel scoreDisplay;
    private int  score = 0 ;
    private JMenuBar menuBar;
    private JMenu difficultyMenu;
    private JMenuItem noobMenuItem;
    private JMenuItem proMenuItem;
    private JMenuItem hackerMenuItem;
    
    private String username;
    
    private LoginModel loginModel = new LoginModel();;

    public Board(String username) {
    	loginModel.setUsername(username);
		
		this.username = username;
        setFocusable(true);
        setSize(400, 400);
        menuBar = new JMenuBar();
        // Tạo menu "Độ khó"
        difficultyMenu = new JMenu("Độ khó");
        menuBar.add(difficultyMenu);

        // Tạo các mục menu cho mỗi mức độ khó
        noobMenuItem = new JMenuItem("Noob");
        proMenuItem = new JMenuItem("Pro");
        hackerMenuItem = new JMenuItem("Hacker");

        // Thêm các mục menu vào menu "Độ khó"
        difficultyMenu.add(noobMenuItem);
        difficultyMenu.add(proMenuItem);
        difficultyMenu.add(hackerMenuItem);

        // Thêm các ActionListener cho mỗi mục menu
        noobMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cài đặt delay cho mức độ "Noob"
                setDelay(400);
            }
        });
        proMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cài đặt delay cho mức độ "Pro"
                setDelay(200);
            }
        });

        hackerMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Cài đặt delay cho mức độ "Hacker"
                setDelay(50);
            }
        });
        add(menuBar);
        curPiece = new Shape();
        timer = new Timer(difficultyMenu.getDelay(),this::actionPerformed);
        board = new Tetrominoe[BOARD_WIDTH * BOARD_HEIGHT];
        addKeyListener(new TAdapter());
        clearBoard();
        scoreDisplay = new JLabel("0");
        isStarted = true;
        scoreDisplay = new JLabel("Score: 0");
        add(scoreDisplay, BorderLayout.PAGE_END);

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
    public void start(){

        timer.start();

    }
    public void setDelay(int delay){
      timer.setDelay(delay);
    }
    public void actionPerformed(ActionEvent e) {
        if (isFallingFinished) {
            isFallingFinished = false;
            newPiece();
        } else {
            oneLineDown();
        }
    }



    private void clearBoard() {
        for (int i = 0; i < BOARD_HEIGHT*BOARD_WIDTH; ++i) {
            board[i] = Tetrominoe.NoShape;
        }
    }

    private void pieceDropped() {
        for (int i = 0; i < 4; ++i) {
            int x = curX + curPiece.x(i);
            int y = curY - curPiece.y(i);
            board[(y * BOARD_WIDTH) + x] = curPiece.getShape();
        }

        removeFullLines();

        if (!isFallingFinished) {
            newPiece();
        }
        isFallingFinished = true;

    }

    private void newPiece() {
        curPiece.setRandomShape();
        curX = BOARD_WIDTH/ 2 + 1-curPiece.minX();
        curY = BOARD_HEIGHT - 1 + curPiece.minY();

        if (!tryMove(curPiece, curX, curY)) {
            curPiece.setShape(Tetrominoe.NoShape);
            timer.stop();
            isStarted = false;
            threadUpdatePoint(numLinesRemoved);
            showMessageDialog(this, "Game Over !. Your point is : " +numLinesRemoved*1,  "Game  over  " , YES_NO_OPTION);
            restartGame();
        }
    }

    private boolean tryMove(Shape newPiece, int newX, int newY) {
        for (int i = 0; i < 4; ++i) {
            int x = newX + newPiece.x(i);
            int y = newY - newPiece.y(i);
            if (x < 0 || x >= BOARD_WIDTH || y < 0 || y >= BOARD_HEIGHT) {
                return false;
            }
            if (shapeAt(x, y) != Tetrominoe.NoShape) {
                return false;
            }
        }

        curPiece = newPiece;
        curX = newX;
        curY = newY;
        repaint();

        return true;
    }

    private void removeFullLines() {
        int numFullLines = 0;

        for (int i = BOARD_HEIGHT - 1; i >= 0; --i) {
            boolean lineIsFull = true;

            for (int j = 0; j < BOARD_WIDTH; ++j) {
                if (shapeAt(j, i) == Tetrominoe.NoShape) {
                    lineIsFull = false;
                    break;
                }
            }

            if (lineIsFull) {
                ++numFullLines;
                for (int k = i; k < BOARD_HEIGHT - 1; ++k) {
                    for (int j = 0; j < BOARD_WIDTH; ++j) {
                        board[(k * BOARD_WIDTH) + j] = shapeAt(j, k + 1);
                    }
                }
            }
        }

        if (numFullLines > 0) {
            numLinesRemoved += numFullLines;
            isFallingFinished = true;
            curPiece.setShape(Tetrominoe.NoShape);
            repaint();
        }
        updateScoreDisplay();
    }
    public void updateScoreDisplay() {

        scoreDisplay.setText("Your Point: " + numLinesRemoved*1);
    }
    public void oneLineDown() {
        if (!tryMove(curPiece, curX, curY - 1))
            pieceDropped();
    }
    public void dropDown() {
        int newY = curY;
        while (newY > 0) {
            if (!tryMove(curPiece, curX, newY - 1))
                break;
            --newY;
        }
        pieceDropped();
    }
    public void pause() {
        isPaused = !isPaused;
        if (isPaused) {
            timer.stop();
        } else {
            timer.start();
        }
        repaint();
    }
    public Tetrominoe shapeAt(int x, int y) {
        return board[(y * BOARD_WIDTH) + x];
    }
    public JLabel getStatusBar() {
        return scoreDisplay;
    }
    private class TAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {

            if (!isStarted || curPiece.getShape() == Tetrominoe.NoShape) {
                return;
            }

            int keycode = e.getKeyCode();

            if (keycode == 'p' || keycode == 'P') {
                pause();
                return;
            }

            if (isPaused)
                return;

            switch (keycode) {
                case KeyEvent.VK_LEFT:
                    tryMove(curPiece, curX - 1, curY);
                    break;
                case KeyEvent.VK_RIGHT:
                    tryMove(curPiece, curX + 1, curY);
                    break;
                case KeyEvent.VK_DOWN:
                    tryMove(curPiece.rotateRight(), curX, curY);
                    break;
                case KeyEvent.VK_UP:
                    tryMove(curPiece.rotateLeft(), curX, curY);
                    break;
                case KeyEvent.VK_SPACE:
                    dropDown();
                    break;
                case 'd':
                    oneLineDown();
                    break;
                case 'D':
                    oneLineDown();
                    break;
            }
            if (!isStarted && keycode == KeyEvent.VK_ENTER) {
                start();

            }
        }
    }
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }
    private void draw(Graphics g) {
        Dimension size = getSize();
        int boardTop = (int) size.getHeight() - BOARD_HEIGHT * squareHeight();

        for (int i = 0; i < BOARD_HEIGHT; ++i) {
            for (int j = 0; j < BOARD_WIDTH; ++j) {
                Tetrominoe shape = shapeAt(j, BOARD_HEIGHT - i - 1);
                if (shape != Tetrominoe.NoShape)
                    drawSquare(g, j * squareWidth(), boardTop + i * squareHeight(), shape);
            }
        }

        if (curPiece.getShape() != Tetrominoe.NoShape) {
            for (int i = 0; i < 4; ++i) {
                int x = curX + curPiece.x(i);
                int y = curY - curPiece.y(i);
                drawSquare(g, x * squareWidth(), boardTop + (BOARD_HEIGHT - y - 1) * squareHeight(), curPiece.getShape());
            }
        }
    }

    private void drawSquare(Graphics g, int x, int y, Tetrominoe shape) {
        Color colors[] = { new Color(0, 0, 0), new Color(204, 102, 102),
                new Color(102, 204, 102), new Color(102, 102, 204),
                new Color(204, 204, 102), new Color(204, 102, 204),
                new Color(102, 204, 204), new Color(218, 170, 0)
        };

        Color color = colors[shape.ordinal()];

        g.setColor(color);
        g.fillRect(x + 1, y + 1, squareWidth() - 2, squareHeight() - 2);

        g.setColor(color.brighter());
        g.drawLine(x, y + squareHeight() - 1, x, y);
        g.drawLine(x, y, x + squareWidth() - 1, y);

        g.setColor(color.darker());
        g.drawLine(x + 1, y + squareHeight() - 1, x + squareWidth() - 1, y + squareHeight() - 1);
        g.drawLine(x + squareWidth() - 1, y + squareHeight() - 1, x + squareWidth() - 1, y + 1);
    }
    public boolean gameover() {
        while (isFallingFinished == true ) {
        return true;
    }
        return false;
    }
    public void restartGame() {
        // Đặt lại trạng thái trò chơi
        isFallingFinished = false;
        isPaused = false;
        clearBoard();
        numLinesRemoved = 0;
        scoreDisplay.setText("Point: " + String.valueOf(numLinesRemoved));
        score = 0;
        start();
        updateScoreDisplay();
        isStarted = true;
        newPiece();
    }
    public void stopGame() {
        timer.stop();
    }




}


