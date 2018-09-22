package hackathon.sdlc.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class PNGWriter {
	
	public static void create(String name, BufferedImage image) {
		File out = new File(name + ".png");
		try {
			ImageIO.write(image, "png", out);
		} catch (IOException e) {
			System.out.println("PNGWriter::create -> IOException");
		}
	}
	
}
