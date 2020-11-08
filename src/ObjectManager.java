import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
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
}
