package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class player extends entity{

	
	
	public boolean right, left, up, down;
	public double speed = 0.9;
	
	private int frames = 0;
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;

	public player(int X, int Y, int WIDTH, int HEIGHT, BufferedImage sprite) {
		super(X, Y, WIDTH, HEIGHT, sprite);
		
		rightPlayer = new BufferedImage[4];
		leftPlayer = new BufferedImage[4];
		rightPlayer[0] =  Main.Main.spritesheet.getSprite(X, Y, WIDTH, HEIGHT);
//		rightPlayer[0] =  Main.spritesheet.getSprite(32, 0, 16, 16);
	}
	
	public void tick() {
		if(right) {
			x+=speed;
		}else if(left) {
			x-=speed;
		}
		if(up) {
			y-=speed;
		}else if(down) {
			y+=speed;
		}

	}
	public void render(Graphics g) {
		
	}
}
