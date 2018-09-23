package hackathon.sdlc.frontend;
import java.io.*;
import java.util.*;


import java.awt.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.net.ftp.FTPClient;
import org.omg.CORBA.portable.InputStream;

import com.mysql.jdbc.Constants;

import hackathon.sdlc.ftp.FTPServer;
import hackathon.sdlc.ftp.FTPUser;
import hackathon.sdlc.ftp.FileActions;



import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;

@WebServlet("/homePage")
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Home() {}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

    
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// response.getWriter().append("Served at: YOLOSWAG ").append(request.getContextPath());
		// READ IN HTML FILE 
		StringBuilder htmlHomePageContent = new StringBuilder();
		try {
			String filePath = "/frontEndRes/hackathonProject.html";
			BufferedReader input = new BufferedReader (new FileReader(getResourceFile(filePath)));
			String ln = "";
			while((ln = input.readLine())!= null) {
				htmlHomePageContent.append(ln);
				//System.out.println(htmlHomePageContent);
			}
			input.close();
		} 
		catch(IOException e){
			String error = e.getMessage();
			response.getWriter().append(error);
		}
		
		response.getWriter().append(htmlHomePageContent);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String [] temp = request.getParameterValues("pdfCollect");
		for(int i =0; i < temp.length; i++) {
		System.out.println(temp[i]);
		}
		

	
	}
		
	
	
	public File getResourceFile(String fileName) {
		// Returns a file from the project resources based on the path name.
		try {
			String OS = System.getProperty("os.name").toLowerCase();
			if(OS.indexOf("win") >= 0) {
				return new File(java.net.URLDecoder.decode(getClass().getResource("/res" + fileName).
						toString().substring(6), "UTF-8"));
			}
			else {
				return new File("/" + java.net.URLDecoder.decode(getClass().getResource("/res" + fileName).
						toString().substring(6), "UTF-8"));
			}
			
		} catch (UnsupportedEncodingException e) {}
		return null;
	}
	
	

	
	


}
