package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class player extends entity{

	public int right_dir = 0, left_dir = 1;
	public int dir = 0;
	
	public boolean right, left, up, down;
	public double speed = 0.9;
	
	private int frames = 0;
	private BufferedImage[] rightPlayer;
	private BufferedImage[] leftPlayer;

	public player(int X, int Y, int WIDTH, int HEIGHT, BufferedImage sprite) {
		super(X, Y, WIDTH, HEIGHT, sprite);
		
		rightPlayer = new BufferedImage[4];
		leftPlayer = new BufferedImage[4];
		
		for(int i = 0; i < 4;i++) {
			rightPlayer[i] =  Main.Main.spritesheet.getSprite(32 + (i*16), 0, 16, 16);
		}
		for(int i = 0; i < 4;i++) {
			leftPlayer[i] =  Main.Main.spritesheet.getSprite(32 + (i*16), 16, 16, 16);
		}
	}
	
	public void tick() {
		if(right) {
			dir = right_dir;
			x+=speed;
		}else if(left) {
			x-=speed;
			dir = left_dir;
		}
		if(up) {
			y-=speed;
		}else if(down) {
			y+=speed;
		}
	}
	public void render(Graphics g) {
		if(dir == right_dir) {
			g.drawImage(rightPlayer[0],this.getX(), this.getY(), null);
		}else if(dir == left_dir) {
			g.drawImage(leftPlayer[3],this.getX(), this.getY(), null);
		}
	}
}
