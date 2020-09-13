import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	GamePanel tyler;
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;

	public static void main(String[] args) {
		LeagueInvaders leagueInvaders = new LeagueInvaders();
		leagueInvaders.setup();
	}

	LeagueInvaders() {
		frame = new JFrame();
		frame.setVisible(true);
		tyler = new GamePanel();
		frame.add(tyler);
	}

	void setup() {
		frame.setSize(WIDTH, HEIGHT);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}