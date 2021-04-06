package graficos;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class sprite_sheet {
	private BufferedImage maincharsprite;
	
	public sprite_sheet(String path) {
		try {
			maincharsprite = ImageIO.read(getClass().getResource(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public BufferedImage getSprite(int X, int Y, int SIZEONE, int SIZETWO) {
		return maincharsprite.getSubimage(X, Y, SIZEONE, SIZETWO);
		}
	
}
