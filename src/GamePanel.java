import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener { 
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
final int MENU = 0;
Rocketship rocketship = new Rocketship(250, 750 , 50, 50);
final int GAME = 1;
final int END = 2;
ObjectManager objectManager= new ObjectManager(rocketship);
Font titleFont;
Font gameFont;
Font gameInstructions;
Timer frameDraw;
Timer alienSpawn;
GamePanel (){
	frameDraw = new Timer(1000/60, this);
	frameDraw.start();
	if (needImage) {
	    loadImage ("space.png");
	}
	
titleFont =  new Font("Arial", Font.PLAIN, 30);
gameFont =  new Font("Arial", Font.PLAIN, 30);
gameInstructions =  new Font("Arial", Font.PLAIN, 30);
 
}
int currentState = MENU;

void startGame() {
    alienSpawn = new Timer(1000 , objectManager);
    alienSpawn.start();
}


void updateMenuState() {}
void updateGameState() {
	objectManager.update();
	if(rocketship.active==false) {
		currentState=END;
	}
}
void updateEndState() {}
void drawMenuState(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setColor(Color.YELLOW);
	g.setFont(titleFont);
	g.drawString("Welcome", 150, 250);
	g.drawString("Press Enter to start", 50, 300);
	g.drawString("Press space for info", 50, 500);
}
void drawGameState(Graphics g) {
	if (gotImage) {
		g.drawImage(image, WIDTH, HEIGHT, null);
	} else {
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	}
	
	objectManager.draw(g);
	
	//System.out.println("Rocket");
	
}
void loadImage(String imageFile) {
    if (needImage) {
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
	    gotImage = true;
        } catch (Exception e) {
            
        }
        needImage = false;
    }
}

void drawEndState(Graphics g) {
	g.setColor(Color.RED);
	g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
	g.setColor(Color.YELLOW);
	g.setFont(titleFont);
	g.drawString("Game Over", 150, 250);
	g.drawString("You kill "+ objectManager.getScore() +" many enimies", 50, 300);
	g.drawString("Press ENTER to restart", 50, 400);
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
	System.out.println("Before " + currentState);
	if(arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		if(currentState == END) {
			alienSpawn.stop();
			rocketship = new Rocketship(250, 750, 50, 50);
			objectManager = new ObjectManager(rocketship);
			currentState = MENU;}
		else {
			currentState++;
		}
		if(currentState == GAME) {
			startGame();
		}
	}
	System.out.println("After " + currentState);
	
	if(arg0.getKeyCode()==KeyEvent.VK_SPACE && currentState == MENU) {
		JOptionPane.showMessageDialog(null, "Use WASD to move and press space to fire");
	}
	
	if(arg0.getKeyCode()==KeyEvent.VK_SPACE) {
		if(currentState == GAME) {
		objectManager.addProjectile(rocketship.getProjectile());	
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
