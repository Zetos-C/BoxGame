package puzzleGame;

import javax.swing.JLabel;
import javax.swing.SwingWorker;

import Items.Items;
import loginPage.LoginModel;
import mineSweeper.Minesweeper;

public class pointKeeper {
    private int point;
    private JLabel pointLabel;
    private LoginModel loginModel;
    private String username;

    public pointKeeper(String username) {
    	this.username = username;
        point = 0;
        pointLabel = new JLabel("point: " + point);
        loginModel = new LoginModel();
        loginModel.setUsername(username);
        
    }

    public void addpoint(int point) {
    	SwingWorker<Void, Void> worker = new SwingWorker<>() {
			@Override
			protected Void doInBackground() {
				loginModel.updatePoint(point);
				return null;
			}

			@Override
			protected void done() {
			}
		};

		worker.execute();
    	
        pointLabel.setText("point: " + point);
    }

    public JLabel getpointLabel() {
        return pointLabel;
    }

	public int getpoint() {
		return point;
	}
}
