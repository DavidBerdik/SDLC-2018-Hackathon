package hackathon.sdlc.ftp;

import java.io.IOException;

import org.apache.commons.net.ftp.FTPClient;

public class FTPUser {

	private String user;
	private String pass;
	
	public FTPUser(String u, String p) {
		this.user = u;
		this.pass = p;
	}
	
	public void login(FTPClient client) {
		// Take a reference to an FTP client and log this user into it.
		try {
			client.login(this.user, this.pass);
		} catch (IOException e) {
			System.out.println("FTPUser::login -> IOExeption");
			return;
		}
	}
	
}
