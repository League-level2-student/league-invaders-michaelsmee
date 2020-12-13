import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener{
Rocketship rocket;
Random rand = new Random();
ArrayList<Alien> aliens = new ArrayList<Alien>();
ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
ObjectManager(Rocketship rocket){
	this.rocket=rocket;
}


void addAlien() {
	aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH),0,50,50));
}
void addProjectile(Projectile projectile) {
	projectiles.add(projectile);
}

void update() {
	for(int i = 0; i<aliens.size(); i++) {
		aliens.get(i).update();
		if(aliens.get(i).y>LeagueInvaders.HEIGHT) {
			aliens.get(i).active=false;
		}
	}
	for(int i = 0; i<projectiles.size(); i++) {
		projectiles.get(i).update();
		if(projectiles.get(i).y<0) {
			projectiles.get(i).active=false;
		}
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
