import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener{ 
final int MENU = 0;
Rocketship rocketship = new Rocketship(250, 750 , 50, 50, 10, true);
final int GAME = 1;
final int END = 2;
Font titleFont;
Font gameFont;
Font gameInstructions;
Timer frameDraw;
GamePanel (){
	frameDraw = new Timer(1000/60, this);
	frameDraw.start();
	
titleFont =  new Font("Arial", Font.PLAIN, 48);
gameFont =  new Font("Arial", Font.PLAIN, 48);
gameInstructions =  new Font("Arial", Font.PLAIN, 48);


}
int currentState = MENU;
void updateMenuState() {}
void updateGameState() {}
void updateEndState() {}
void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setColor(Color.YELLOW);
	g.setFont(titleFont);
	g.drawString("Welcome", 150, 250);
	g.drawString("Press Enter to start", 20, 300);
	g.drawString("Press space for info", 20, 500);
}
void drawGameState(Graphics g) {
	g.setColor(Color.BLACK);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	rocketship.draw(g);
	//System.out.println("Rocket");
	
}
void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setColor(Color.YELLOW);
	g.setFont(titleFont);
	g.drawString("Game Over", 150, 250);
	g.drawString("You kill  many enimies", 20, 300);
	g.drawString("Press space for info", 20, 500);
}
@Override	
public void paintComponent (Graphics g) {
	if(currentState == MENU){
	    drawMenuState(g);
	}else if(currentState == GAME){
	    drawGameState(g);
	}else if(currentState == END){
	    drawEndState(g);
	}
	
}
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	if(currentState == MENU) {
		updateMenuState();
	}
	else if(currentState == GAME) {
		updateGameState();
	}
	else if(currentState == END) {
		updateEndState();
	}
	//System.out.println("action");
	repaint();
}
@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		if(currentState == END) {
			currentState = MENU;}
		else {
			currentState++;
		}
	}
	if(arg0.getKeyCode()==KeyEvent.VK_UP) {
		System.out.println("UP");
		rocketship.up();
	}
	if(arg0.getKeyCode()==KeyEvent.VK_LEFT) {
		System.out.println("LEFT");
		rocketship.left();
	}
	if(arg0.getKeyCode()==KeyEvent.VK_RIGHT) {
		System.out.println("RIGHT");
		rocketship.right();
	}
	if(arg0.getKeyCode()==KeyEvent.VK_DOWN) {
		System.out.println("DOWN");
		rocketship.down();
	}
	if(rocketship.x>450) {
		rocketship.x=450;
	}
	if(rocketship.x<0) {
		rocketship.x=0; 
	}
	if(rocketship.y>750) {
		rocketship.y=750;
	}
	if(rocketship.y<0) {
		rocketship.y=800;
	}
}
@Override
public void keyReleased(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyTyped(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}



}
