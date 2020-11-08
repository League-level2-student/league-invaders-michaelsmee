import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Rocketship extends GameObject{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		
		
	}
void draw(Graphics g) { 
	g.setColor(Color.BLUE);
	g.fillRect(x, y , width, height);
}
		
public void right() {
	x+=speed;
}
public void left() {
	x-=speed;
}
public void up() {
	y-=speed;
}
public void down() {
	y+=speed;
} 


}

