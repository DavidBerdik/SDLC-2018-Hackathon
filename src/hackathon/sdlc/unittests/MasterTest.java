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
			System.out.println("Please enter a file to be uploaded (ex: C:\\data\\file.pdf, test-data\\01.pdf");
			input = new File(terminal.nextLine());
			
			if (!input.exists())
				System.out.println("\nThe file at `" + input.getAbsolutePath() + "` was not recognized!");
		} while(!input.exists());

		
	}

}
