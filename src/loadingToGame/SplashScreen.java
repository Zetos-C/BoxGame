package loadingToGame;

import javax.swing.*;
import loginPage.LoginView;
import jaco.mp3.player.MP3Player;

import java.io.File;
import java.awt.*;

public class SplashScreen {
	public static void main(String[] args) {
		JWindow window = new JWindow();
		window.setBackground(new Color(0, 0, 0, 0));
		MP3Player song = new MP3Player(LoginView.class.getResource("/boxGame/gameSong.mp3"));
		ImageIcon imageIcon = new ImageIcon(LoginView.class.getResource("/boxGame/loading2.png"));

		JLabel label = new JLabel(imageIcon);

		label.setOpaque(false);

		window.getContentPane().add(label);



		JPanel panel = new JPanel(new BorderLayout());

		window.getContentPane().add(panel, BorderLayout.SOUTH);

		window.setSize(imageIcon.getIconWidth(), imageIcon.getIconHeight() );
		window.setLocationRelativeTo(null);
		window.setVisible(true);

		
        SwingWorker<Void, Void> worker = new SwingWorker<>() {
            @Override
            protected Void doInBackground() throws Exception {
            	new LoginView();
                return null;
            }

            @Override
            protected void done() {
            	song.play();
                window.dispose();
            }
        };

        worker.execute();
	}
}
