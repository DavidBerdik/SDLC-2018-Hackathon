package hackathon.sdlc.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

public class ImageTest {

	// Load files from local system (John Natale) and attempt to properly process them, then save them onto the desktop.
	public static void start() {
		ConversionUtilities.addFileToQueue(new File("C:\\Users\\Administrator\\Desktop\\Hackathon\\test-data\\01.pdf"));
		ConversionUtilities.addFileToQueue(new File("C:\\Users\\Administrator\\Desktop\\Hackathon\\test-data\\02.pdf"));
		ConversionUtilities.addFileToQueue(new File("C:\\Users\\Administrator\\Desktop\\Hackathon\\test-data\\03.pdf"));
		ConversionUtilities.addFileToQueue(new File("C:\\Users\\Administrator\\Desktop\\Hackathon\\test-data\\04.pdf"));
		ConversionUtilities.addFileToQueue(new File("C:\\Users\\Administrator\\Desktop\\Hackathon\\test-data\\05.pdf"));
		ConversionUtilities.addFileToQueue(new File("C:\\Users\\Administrator\\Desktop\\Hackathon\\test-data\\06.pdf"));
		ConversionUtilities.addFileToQueue(new File("C:\\Users\\Administrator\\Desktop\\Hackathon\\test-data\\07.pdf"));
		ConversionUtilities.addFileToQueue(new File("C:\\Users\\Administrator\\Desktop\\Hackathon\\test-data\\08.pdf"));
		ConversionUtilities.addFileToQueue(new File("C:\\Users\\Administrator\\Desktop\\Hackathon\\test-data\\09.pdf"));
		ConversionUtilities.addFileToQueue(new File("C:\\Users\\Administrator\\Desktop\\Hackathon\\test-data\\10.pdf"));
		
		List<BufferedImage> list = ConversionUtilities.processQueue();
		
		PNGWriter.create("C:\\Users\\Administrator\\Desktop\\01", list.get(0));
		PNGWriter.create("C:\\Users\\Administrator\\Desktop\\02", list.get(1));
		PNGWriter.create("C:\\Users\\Administrator\\Desktop\\03", list.get(2));
		PNGWriter.create("C:\\Users\\Administrator\\Desktop\\04", list.get(3));
		PNGWriter.create("C:\\Users\\Administrator\\Desktop\\05", list.get(4));
		PNGWriter.create("C:\\Users\\Administrator\\Desktop\\06", list.get(5));
		PNGWriter.create("C:\\Users\\Administrator\\Desktop\\07", list.get(6));
		PNGWriter.create("C:\\Users\\Administrator\\Desktop\\08", list.get(7));
		PNGWriter.create("C:\\Users\\Administrator\\Desktop\\09", list.get(8));
		PNGWriter.create("C:\\Users\\Administrator\\Desktop\\10", list.get(9));
	}
	
}
