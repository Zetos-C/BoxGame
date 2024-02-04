package mineSweeper;

public class Difficulty {
	byte rows;
	byte cols;
	byte mines;

    public Difficulty() {
        // private constructor to enforce singleton pattern
    }


    public void equalDifficulty(int difficulty) {
        switch (difficulty) {
            case 1:
                setDifficulty((byte)9, (byte)9,(byte) 5);
                break;
            case 2:
                setDifficulty((byte)9, (byte)16, (byte)20);
                break;
            case 3:
                setDifficulty((byte)10, (byte)17, (byte)40);
                break;
            case 4:
                setDifficulty((byte)10, (byte)20, (byte)70);
                break;
            case 5:
                setDifficulty((byte)10,(byte) 20,  (byte)99);
                break;
        }
    }

    private void setDifficulty(byte rows, byte cols, byte mines) {
        this.rows = rows;
        this.cols = cols;
        this.mines = mines;
    }
}