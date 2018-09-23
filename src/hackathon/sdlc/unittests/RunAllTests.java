package hackathon.sdlc.unittests;

public class RunAllTests {
	// Run all unit tests.
	public static void main(String[] args) {
		new FTPTest();
		new ImageTest();
		new RequestTest();
		System.out.println("Completed all unit tests.");
	}
}
