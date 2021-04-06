package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import world.camera;

public class entity {
	
	public static BufferedImage LIFEPACK_EN = Main.Main.spritesheet.getSprite(7*16, 0, 16, 16);
	public static BufferedImage GUN_EN = Main.Main.spritesheet.getSprite(8*16, 0, 16, 16);
	public static BufferedImage AMMO_EN = Main.Main.spritesheet.getSprite(9*16, 0, 16, 16);
	public static BufferedImage ENEMY_EN = Main.Main.spritesheet.getSprite(6*16, 0, 16, 16);
	
	protected double x;
	protected double y;
	protected int width;
	protected int height;
	
	private BufferedImage sprite;
	
	public entity(int X, int Y, int WIDTH, int HEIGHT, BufferedImage sprite) {
		this.sprite = sprite;
		this.x = X;
		this.y = Y;
		this.width = WIDTH;
		this.height = HEIGHT;
	}
	
	public void setX(int newX) {
		this.x = newX;
	}
	public void setY(int newY) {
		this.y = newY;
	}
	public int getX() {
		return (int)this.x;
	}
	public int getY() {
		return (int)this.y;
	}
	public int getWIDTH() {
		return this.width;
	}
	public int getHEIGHT() {
		return this.height;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		g.drawImage(sprite,this.getX() - camera.x, this.getY() - camera.y, null);
	}
}
