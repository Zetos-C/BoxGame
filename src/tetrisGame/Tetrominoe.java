package tetrisGame;

import java.awt.*;

public enum Tetrominoe {

    NoShape(new Color(0, 0, 0)),
    ZShape(new Color(204, 102, 102)),
    SShape(new Color(102, 204, 102)),
    LineShape(new Color(102, 102, 204)),
    TShape(new Color(204, 204, 102)),
    SquareShape(new Color(204, 102, 204)),
    LShape(new Color(102, 204, 204)),
    MirroredLShape(new Color(218, 170, 0));

    private Color pieceColor;

    private Tetrominoe(Color color) {
        this.pieceColor = color;
    }

    public Color getColor() {
        return pieceColor;
    }
}


