import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
Rocketship rocket;
Projectile projectile; 
Random rand = new Random();
ArrayList<Alien> aliens = new ArrayList<Alien>();

ObjectManager(Rocketship rocket){
	this.rocket=rocket;
}


void addAlien() {
	aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH),0,50,50));
}


void update() {
	for(int i = 0; i<aliens.size(); i++) {
		aliens.get(i).update();
	}
}


void draw(Graphics g) {
 rocket.draw(g);
}


@Override
public void actionPerformed(ActionEvent arg0) {
	// TODO Auto-generated method stub
	addAlien();
}
}
