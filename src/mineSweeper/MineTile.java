package mineSweeper;

import javax.swing.JButton;

public class MineTile extends JButton {
    int r;
    int c;

    public MineTile(int r, int c) {
        this.r = r;
        this.c = c;
    }
}

