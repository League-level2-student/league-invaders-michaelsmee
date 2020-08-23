import javax.swing.JFrame;

public class LeagueInvaders {
	JFrame frame;
	public static final int WIDTH=500;
	public static final int HEIGHT = 800;
	public static void main(String[] args) {
	LeagueInvaders=new LeagueInvaders();	
	
}
	 LeagueInvaders() {
		 frame = new JFrame();
		 frame.setVisible(true);
		 
	 }
		
	 void setup() {
		 frame.setSize(WIDTH, HEIGHT);
		 
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 }
	 
	}