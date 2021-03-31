import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Main extends Canvas implements Runnable{
	
	public static JFrame frame;
	private Thread thread;
	private boolean isRunning = true;
	private final int WIDTH = 160;
	private final int HEIGHT = 120;
	private final int SCALE = 4;
	
	private BufferedImage image;
	
	public Main() {
		this.setPreferredSize(new Dimension(WIDTH*SCALE, HEIGHT*SCALE));
		initFrame();
		image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	}
	public void initFrame() {
		frame = new JFrame("Rinha De galo");	
		frame.add(this);
		frame.setResizable(false);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	public synchronized void start() {
		thread = new Thread(this);
		isRunning = true;
		thread.start();
	}
	public synchronized void stop() {
		isRunning = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		}
	public static void main(String[] args) {
		Main main = new Main();
		main.start();
	}
	
	public void tick() {
		
	}
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = image.getGraphics();
		g.setColor(new Color(0,0,0));
		g.fillRect(0, 0,160,120);
		
//		g.setColor(new Color(200,200,200));
//		g.fillRect(0, 0, 5, 120);
		
		g.setFont(new Font("Arial",Font.BOLD, 20));
		g.setColor(Color.white);
		g.drawString("Rinha De Galo", 15,50);
		
		g = bs.getDrawGraphics();
		g.drawImage(image, 0,0,WIDTH*SCALE,HEIGHT*SCALE, null);
		bs.show();
	}
	
	public void run() {
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		while(isRunning) {
			long now = System.nanoTime();	
			delta += (now - lastTime) / ns;
			now = lastTime;
			if(delta >= 1) {
				tick();
				render();
				delta--;
			}
	}
		stop();
}
}