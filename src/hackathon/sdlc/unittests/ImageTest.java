package hackathon.sdlc.unittests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;

import hackathon.sdlc.pdf.ConversionUtilities;
import hackathon.sdlc.pdf.PNGWriter;

public class ImageTest {

	public ImageTest() {
		System.out.println("Beginning ImageConverstion unit test.");
		
		// Manually add our files.
		ConversionUtilities.addFileToQueue(new File("test-data/01.pdf"));
		ConversionUtilities.addFileToQueue(new File("test-data/02.pdf"));
		ConversionUtilities.addFileToQueue(new File("test-data/03.pdf"));
		ConversionUtilities.addFileToQueue(new File("test-data/04.pdf"));
		ConversionUtilities.addFileToQueue(new File("test-data/05.pdf"));
		ConversionUtilities.addFileToQueue(new File("test-data/06.pdf"));
		ConversionUtilities.addFileToQueue(new File("test-data/07.pdf"));
		ConversionUtilities.addFileToQueue(new File("test-data/08.pdf"));
		ConversionUtilities.addFileToQueue(new File("test-data/09.pdf"));
		ConversionUtilities.addFileToQueue(new File("test-data/10.pdf"));
		
		// Convert to BufferedImage list.
		List<BufferedImage> list = ConversionUtilities.processQueue();
		
		// Write to disk.
		PNGWriter.create("01"+ "_test", list.get(0));
		PNGWriter.create("02"+ "_test", list.get(1));
		PNGWriter.create("03"+ "_test", list.get(2));
		PNGWriter.create("04"+ "_test", list.get(3));
		PNGWriter.create("05"+ "_test", list.get(4));
		PNGWriter.create("06"+ "_test", list.get(5));
		PNGWriter.create("07"+ "_test", list.get(6));
		PNGWriter.create("08"+ "_test", list.get(7));
		PNGWriter.create("09"+ "_test", list.get(8));
		PNGWriter.create("10"+ "_test", list.get(9));
		
		System.out.println("Finishing ImageConverstion unit test.");
	}
	
}
