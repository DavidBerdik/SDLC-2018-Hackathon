package hackathon.sdlc.unittests;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.net.ftp.FTPClient;

import hackathon.sdlc.cognitive.APIRequest;
import hackathon.sdlc.ftp.FTPServer;
import hackathon.sdlc.ftp.FTPUser;
import hackathon.sdlc.ftp.FileActions;
import hackathon.sdlc.pdf.ConversionUtilities;
import hackathon.sdlc.pdf.PNGWriter;

/**
 * MasterTest
 *
 * Running outside the Java Servlet, MasterTest allows an end-user to test the full
 * functionality of the application WITHOUT the necessity of running it inside a 
 * web server. It should demonstrate most core functionality of the program.
 */
public class MasterTest {

	public static void main(String[] args) {
		Scanner terminal = new Scanner(System.in);
		
		// Request a new file as input from the user via command line.
		File input;
		do {
			System.out.println("Please enter a file to be uploaded (ex: C:\\data\\file.pdf, test-data\\01.pdf)");
			input = new File(terminal.nextLine());
			
			if (!input.exists())
				System.out.println("\nThe file at `" + input.getAbsolutePath() + "` was not recognized!");
		} while(!input.exists());

		// Request FTP information from a user (or use default)!		
		System.out.println("\n\nPlease enter an FTP host: (type @def to use default settings)");
		String host = terminal.nextLine();
		if (host.equalsIgnoreCase("@def"))
			host = "sdlc.drewerth.ehst.co";
		
		int port = 21;
		
		System.out.println("Please enter an FTP user: (type @def to use default settings)");
		String user = terminal.nextLine();
		String pass;
		if (user.equalsIgnoreCase("@def")) {
			user = "sdlc_user";	
			pass = "Bxz4#8y7";
		}
		else {
			System.out.println("Please enter an FTP password:");
			pass = terminal.nextLine();
		}
		
		// Convert the PDF to a PNG file.
		System.out.println("\n\nConverting your file to a PNG image...");
		ConversionUtilities.addFileToQueue(input);
		List<BufferedImage> list = ConversionUtilities.processQueue();
		PNGWriter.create("upload_" + input.getName(), list.get(0));
		
		// Create an FTP login credential and open a connection.
		FTPServer server = new FTPServer(host, port);
		FTPClient client = server.connect();
		FTPUser access = new FTPUser(user, pass);
		access.login(client);
		
		// Prepare both an upload and download!
		System.out.println("Uploading your file to an FTP server...");
		File newFile = new File("upload_" + input.getName() + ".png");
		FileActions.upload(client, newFile.getName(), newFile);
		System.out.println("Uploaded and live at: " + host + "/" + "upload_" + input.getName() + ".png");
		FTPServer.disconnect();
	}

}
