package hackathon.sdlc.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbConn {
	private Connection dbConn;
	int id = 0; // For storing the entry ID referenced by all tables when querying.
	
	public DbConn() {
		// Connect to the database.
		try {
			Class.forName("com.mysql.jdbc.Driver");
			dbConn = DriverManager.getConnection("jdbc:mysql://localhost/feedback?user=sdlc&password=abc@123&useSSL=false");
		} catch (Exception e) {}
	}
	
	public void writeGenInfo(String nameFirst, String nameLast, String date, String streetAddress, 
			String apartmentNum, String city, String state, String zip, String phone, String email,
			String dob, String birthSex, String selfIdSex) throws SQLException {
		// Write to the "General Information" table and acquire the ID of writing the data.
		PreparedStatement query = dbConn.prepareStatement("INSERT INTO sdlc.general (nameFirst, nameLast, "
				+ "date, streetAddress, apartmentNum, city, state, zip, phone, email, dob, birthSex, "
				+ "selfIdSex) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");// SELECT LAST_INSERT_ID();");
		
		query.setString(1, nameFirst);
		query.setString(2, nameLast);
		query.setString(3, date);
		query.setString(4, streetAddress);
		query.setString(5, apartmentNum);
		query.setString(6, city);
		query.setString(7, state);
		query.setString(8, zip);
		query.setString(9, phone);
		query.setString(10, email);
		query.setString(11, dob);
		query.setString(12, birthSex);
		query.setString(13, selfIdSex);
		
		// Store the ID of the user that was just inserted in "id."
		ResultSet results = query.executeQuery();
		id = results.getInt("LAST_INSERT_ID()");
		System.out.print("ID is " + id);
	}

}
