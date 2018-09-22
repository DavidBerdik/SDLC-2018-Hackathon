package hackathon.sdlc.ftp;

import java.io.IOException;
import java.net.SocketException;

import org.apache.commons.net.ftp.FTPClient;

public class FTPServer {

	private String host;
	private int port;
	private FTPClient ftp;
	
	public FTPServer(String h, int p) {
		this.host = h;
		this.port = p;
		
		ftp = new FTPClient();
	}
	
	public FTPClient connect() {
		// Create a new connection to our FTP client and return it.
		try {
			ftp.connect(host, port);
		} catch (SocketException e) {
			System.out.println("FTPServer::connect -> SocketExcepton");
			return null;
		} catch (IOException e) {
			System.out.println("FTPServer::connect -> IOException");
			return null;
		}
		
		return ftp;
	}
	
	public void disconnect() {
		if (!ftp.isConnected()) return;
		
		try {
			ftp.logout();
			ftp.disconnect();
		} catch (IOException e) {
			System.out.println("FTPServer::disconnect -> IOException");
		}
		
	}
	
}