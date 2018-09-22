package hackathon.sdlc.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;

public class ConversionUtilities {
	
	private static List<PDDocument> renderQueue = new LinkedList<PDDocument>();

	public static boolean addFileToQueue(File file) {
		// Confirm that we have a real file before progressing.
		if (!file.exists()) return false; 
	
		// Make an attempt to load the file into a PDF document.
		PDDocument pdf;
		try {
			pdf = PDDocument.load(file);
		} catch (InvalidPasswordException e) {
			System.out.println("ConversionUtilities::addFileToQueue -> InvalidPasswordException");
			return false;
		} catch (IOException e) {
			System.out.println("ConversionUtilities::addFileToQueue -> IOException");
			return false;
		}
		
		// Add our new PDF to the queue.
		renderQueue.add(pdf);
		return true;
	}
	
	public static List<BufferedImage> processQueue() {
		List<BufferedImage> processed = new LinkedList<BufferedImage>();
	}

}
