package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import world.World;
import world.camera;

public class player extends entity{

	public int right_dir = 0, left_dir = 1;
	public int dir = 0;
	
	public boolean right, left, up, down;
	public double speed = 0.9;
	
	private int frames = 0, maxFrames = 5, index = 0, maxIndex = 3;
	private boolean moved = false;
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
		moved = false;
		if(right && World.isFree((int)(x+speed),this.getY())) {
			moved = true;
			dir = right_dir;
			x+=speed;
		}else if(left && World.isFree((int)(x-speed),this.getY())) {
			moved = true;
			x-=speed;
			dir = left_dir;
		}
		if(up && World.isFree(this.getX(),(int)(y - speed))) {
			moved = true;
			y-=speed;
		}else if(down && World.isFree(this.getX(),(int)(y+speed))) {
			moved = true;
			y+=speed;
		}
		if(moved) {
			frames++;
			if(frames == maxFrames) {
				frames = 0;
				index++;
				if(index > maxIndex) {
					index = 0;
				}
			}
		}
		
		camera.x = camera.clamp(this.getX() - (Main.Main.WIDTH/2), 0, (World.WIDTH*16) - Main.Main.WIDTH);
		camera.y = camera.clamp(this.getY() - (Main.Main.HEIGHT/2), 0, (World.HEIGTH*16) - Main.Main.HEIGHT);
		
	}
	public void render(Graphics g) {
		if(dir == right_dir) {
			g.drawImage(rightPlayer[index],this.getX() - camera.x, this.getY() - camera.y, null);
		}else if(dir == left_dir) {
			g.drawImage(leftPlayer[index],this.getX() - camera.x, this.getY() - camera.y, null);
		}
	}
}
