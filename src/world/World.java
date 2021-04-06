package world;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import entities.ammo;
import entities.enemy;
import entities.entity;
import entities.gun;
import entities.lifePack;

public class World {
	
	public static Tile[] tiles;
	public static int WIDTH,HEIGTH;
	public static final int TILE_SIZE = 16;
	
	public World(String path) {
		try {
			BufferedImage map = ImageIO.read(getClass().getResource(path));
			int[] pixels = new int[map.getWidth() * map.getHeight()];
			WIDTH = map.getWidth();
			HEIGTH = map.getHeight();
			tiles = new Tile[map.getWidth() * map.getHeight()];
			map.getRGB(0, 0, map.getWidth(), map.getHeight(), pixels, 0, map.getWidth());
			
			for(int xx = 0; xx < map.getWidth(); xx++) {
				for(int yy = 0; yy < map.getHeight(); yy++) {
					tiles[xx + (yy * map.getWidth())] = new FloorTile(xx*16, yy*16, Tile.TILE_FLOOR);
					
					if(pixels[xx + (yy * map.getWidth())] == 0xFFFFFFFF) {
						//parede
						tiles[xx + (yy * map.getWidth())] = new WallTile(xx*16, yy*16, Tile.TILE_WALL);
					}
					else if(pixels[xx + (yy * map.getWidth())] == 0xFF000000) {
						//chao
						tiles[xx + (yy * WIDTH)] = new FloorTile(xx*16, yy*16, Tile.TILE_FLOOR);
					}
					else if(pixels[xx + (yy * map.getWidth())] == 0xFF0026FF) {
						//player
						Main.Main.player.setX(xx*16);
						Main.Main.player.setY(yy*16);
					}
					else if(pixels[xx + (yy * map.getWidth())] == 0xFFFF0000) {
						// enemy
						Main.Main.entities.add(new enemy(xx*16,yy*16,16,16, entity.ENEMY_EN));
					}
					else if(pixels[xx + (yy * map.getWidth())] == 0xFFFFD800) {
						// municao
						Main.Main.entities.add(new ammo(xx*16,yy*16,16,16, entity.AMMO_EN));
					}
					else if(pixels[xx + (yy * map.getWidth())] == 0xFF404040) {
						// arma
						Main.Main.entities.add(new gun(xx*16,yy*16,16,16, entity.GUN_EN));
					}
					else if(pixels[xx + (yy * map.getWidth())] == 0xFFFF006E) {
						// lifepack
						Main.Main.entities.add(new lifePack(xx*16,yy*16,16,16, entity.LIFEPACK_EN));
					}
				}
				
				
			}
			
		} catch (IOException e) { 
			e.printStackTrace();
		}
	}
		
		public static boolean isFree(int xNext,int yNext) {
		int x1 = xNext / TILE_SIZE;
		int y1 = yNext / TILE_SIZE;
		
		int x2 = (xNext+TILE_SIZE-1) / TILE_SIZE;
		int y2 = yNext / TILE_SIZE;
		
		int x3 = xNext / TILE_SIZE;
		int y3 = (yNext+TILE_SIZE-1) / TILE_SIZE;
		
		int x4 = (xNext+TILE_SIZE-1) / TILE_SIZE;
		int y4 = (yNext+TILE_SIZE-1) / TILE_SIZE;
		
		return !((tiles[x1 + (y1*World.WIDTH)] instanceof WallTile) ||
				(tiles[x2 + (y2*World.WIDTH)] instanceof WallTile) ||
				(tiles[x3 + (y3*World.WIDTH)] instanceof WallTile) ||
				(tiles[x4 + (y4*World.WIDTH)] instanceof WallTile));
		}

	
	public void render(Graphics g) {
		int xStart = camera.x/16;
		int yStart = camera.y/16;
		
		int xFinal = xStart + (Main.Main.WIDTH / 16);
		int yFinal = yStart + (Main.Main.HEIGHT / 16);
		for(int xx = xStart; xx <= xFinal; xx++) {
			for(int yy = yStart; yy <= yFinal; yy++) {
				if(xx < 0 || yy < 0 || xx >= WIDTH || yy >= HEIGTH) {
					continue;
				}
				Tile tile = tiles[xx + (yy * WIDTH)];
				tile.render(g);
			}
		}
	}
	
}
