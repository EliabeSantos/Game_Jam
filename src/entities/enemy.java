package entities;

import java.awt.image.BufferedImage;

import world.World;

public class enemy extends entity{
	
	private double speed = 0.4;

	public enemy(int X, int Y, int WIDTH, int HEIGHT, BufferedImage sprite) {
		super(X, Y, WIDTH, HEIGHT, sprite);
	}
	
	public void tick() {
		if(Main.Main.rand.nextInt(100) > 40) {
			if(x < Main.Main.player.getX()  && World.isFree((int)(x+speed), this.getY())) {
				x+=speed;
			}else if(x > Main.Main.player.getX() && World.isFree((int)(x-speed), this.getY())) {
				x-=speed;
			}
			if(y < Main.Main.player.getY() && World.isFree( this.getX(),(int)(y+speed))) {
				y+=speed;
			}else if(y > Main.Main.player.getY() && World.isFree(this.getX(),(int)(y+speed))) {
				y-=speed;
			}
		}
		}
}
