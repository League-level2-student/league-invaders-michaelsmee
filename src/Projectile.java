
public class Projectile extends GameObject {

	Projectile(int x, int y, int width, int height) {
		super(x, y, width, height);
		// TODO Auto-generated constructor stub
		this.speed = 10;
	}
	void update() {
		y-=10;
	}
}
