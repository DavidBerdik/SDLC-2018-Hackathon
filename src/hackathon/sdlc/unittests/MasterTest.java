package hackathon.sdlc.unittests;

import java.io.File;
import java.util.Scanner;

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
		
		System.out.println("Please enter an FTP post: (type 00 to use default settings)");
		int port = terminal.nextInt();
		if (port == 0)
			port = 21;
		
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
	}

}
