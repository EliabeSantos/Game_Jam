package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class entity {
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
		g.drawImage(sprite,this.getX(), this.getY(), null);
	}
}