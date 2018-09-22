package hackathon.sdlc.pdf;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

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
		// Disallow processing when there's nothing to process.
		if (renderQueue.size() == 0) return null;
		
		List<BufferedImage> processed = new LinkedList<BufferedImage>();
			
		// Run through our entire list of PDF documents;
		renderQueue.forEach((document) -> {
			PDFRenderer render = new PDFRenderer(document);
			
			// Convert each page into a unique image.
			for (int page = 0; page < document.getNumberOfPages(); ++page) {
				try {
					processed.add(render.renderImageWithDPI(page, 80, ImageType.RGB));
				} catch (IOException e) {
					System.out.println("ConversionUtilities::addFileToQueue -> processQueue");
					return;
				}
			}
		});
		
		// Return our new buffered images.
		return processed;
	}

}
