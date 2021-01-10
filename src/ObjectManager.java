import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager implements ActionListener {
	Rocketship rocket;
	Random rand = new Random();
	ArrayList<Alien> aliens = new ArrayList<Alien>();
	ArrayList<Projectile> projectiles = new ArrayList<Projectile>();
	int score = 0;

	ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}
	int getScore() {
		return score;
	}
	
	void purgeObjects() {
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).active == false) {
				projectiles.remove(projectiles.get(i));
			}
		}

		for (int i = 0; i < aliens.size(); i++) {
			if (aliens.get(i).active == false) {
				aliens.remove(aliens.get(i));
			}
		}
	}

	void addAlien() {
		aliens.add(new Alien(rand.nextInt(LeagueInvaders.WIDTH), 0, 50, 50));
	}

	void addProjectile(Projectile projectile) {
		projectiles.add(projectile);
	}

	void update() {
		
		rocket.update();
		
		if (rocket.active == true) {

			for (int i = 0; i < aliens.size(); i++) {
				aliens.get(i).update();
				if (aliens.get(i).y > LeagueInvaders.HEIGHT) {
					aliens.get(i).active = false;
				}
			}
			for (int i = 0; i < projectiles.size(); i++) {
				projectiles.get(i).update();
				if (projectiles.get(i).y < 0) {
					projectiles.get(i).active = false;
					score+=1;
				}
			}
			checkCollision();
			purgeObjects();
		}
	}

	void draw(Graphics g) {
		rocket.draw(g);
		for (int i = 0; i < aliens.size(); i++) {
			aliens.get(i).draw(g);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).draw(g);
		}
	}

	void checkCollision() {
		for (int i = 0; i < aliens.size(); i++) {
			if (rocket.collisionBox.intersects(aliens.get(i).collisionBox) == true) {
				rocket.active = false;
				aliens.get(i).active = false;
			}
			
		}
		for (int i = 0; i < aliens.size(); i++) {
			for(int i2=0; i2 < projectiles.size(); i2++) {
			if (projectiles.get(i2).collisionBox.intersects(aliens.get(i).collisionBox) == true) {
				projectiles.get(i2).active = false;
				aliens.get(i).active = false;
				}
		}
		}
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		addAlien();
	}
}
