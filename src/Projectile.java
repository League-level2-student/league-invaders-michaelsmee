
public class Projectile extends GameObject {

	Projectile(int x, int y, int width, int height, int speed, boolean active) {
		super(x, y, width, height, speed, active);
		// TODO Auto-generated constructor stub
		this.speed = 10;
	}
	void update() {
		y-=10;
	}
}
