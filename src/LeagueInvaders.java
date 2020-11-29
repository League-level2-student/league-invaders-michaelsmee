import java.awt.Graphics;

import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame; 
	GamePanel panel;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800; 

	public static void main(String[] args) {
		LeagueInvaders leagueInvaders = new LeagueInvaders();
		leagueInvaders.setup();
	}

	LeagueInvaders() {
		frame = new JFrame();
		frame.setVisible(true);
		panel = new GamePanel();
		frame.add(panel);
		frame.addKeyListener(panel);
	}

	void setup() {
		frame.setSize(WIDTH, HEIGHT);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}