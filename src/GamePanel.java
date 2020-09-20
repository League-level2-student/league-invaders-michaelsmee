import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener{ 
final int MENU = 0;
final int GAME = 1;
final int END = 2;
Font titleFont;
Font gameFont;
Font gameInstructions;
Timer frameDraw;
GamePanel (){
	
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
	g.setColor(Color.BLACK);
	g.setFont(titleFont);
	g.drawString("Welcome", 150, 250);
	g.drawString("Press Enter to start", 20, 300);
	g.drawString("Press space for instructions", 20, 500);
}
void drawGameState(Graphics g) {}
void drawEndState(Graphics g) {}
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
	
}



}
