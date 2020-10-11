import java.awt.Color;
import java.awt.Graphics;

public class Alien extends GameObject {
 
	Alien(int x, int y, int width, int height, int speed, boolean active) {
		super(x, y, width, height, speed, active);
		// TODO Auto-generated constructor stub
	this.x=x;
	this.y=y;
	this.width=width;
	this.height=height;
	this.speed=1;
	this.active=true;
	}


void update() {
	y+=1;
}


void draw(Graphics g) {
	g.setColor(Color.YELLOW);
	g.fillRect(x, y, width, height);
}

}
