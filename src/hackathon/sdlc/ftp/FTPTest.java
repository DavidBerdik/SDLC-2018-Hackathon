package hackathon.sdlc.ftp;

import java.io.File;

import org.apache.commons.net.ftp.FTPClient;

public class FTPTest {

	public static void main(String[] args) {
		start();
	}
	
	public static void start() {
		System.out.println("Beginning FTP unit test.");
		
		FTPServer server = new FTPServer("sdlc.drewerth.ehst.co", 21);
		FTPClient client = server.connect();
		
		FTPUser user = new FTPUser("sdlc_user", "Bxz4#8y7");
		user.login(client);
		
		FileActions.upload(client, "memes.pdf", new File("C:\\Users\\Administrator\\Desktop\\Hackathon\\src\\res\\01.pdf"));
		FileActions.download(client, "memes.pdf", "testobj.pdf");
		
		System.out.println("Finishing FTP unit test.");
	}
	
}
