package hackathon.sdlc.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.Statement;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class DbConn {
	private Connection dbConn;
	int id = 0; // For storing the entry ID referenced by all tables when querying.
	
	public DbConn() {
		// Connect to the database.
		try {
			MysqlDataSource dS = new MysqlDataSource();
			dS.setUser("sdlc");
			dS.setPassword("abc@123");
			dS.setDatabaseName("sdlc");
			dS.setUseSSL(false);
			dbConn = dS.getConnection();
		} catch (Exception e) {}
	}
	
	public boolean writeToDb(String genNameFirst, String genNameLast, String genDate, 
			String genStreetAddress, String genApartmentNum, String genCity, String genState, 
			String genZip, String genPhone, String genEmail, String genDob, String genBirthSex, 
			String genSelfIdSex, String insInsuranceId, String insGroupCode, String insStartDate, 
			String insEndDate, String insCoverageType, String depNameFirst, String depNameMiddleInitial, 
			String depNameLast, String depDob, String depBirthSex, String depSelfIdSex, String depPhone, 
			String depEmail) {
		// Write the data that has been passed in to the function to the database. Return true if the write
		// operation completes without exceptions and false if it doesn't.
		try {
			writeGenInfo(genNameFirst, genNameLast, genDate, genStreetAddress, genApartmentNum, genCity, 
					genState, genZip, genPhone, genEmail, genDob, genBirthSex, genSelfIdSex);
			writeInsuranceInfo(insInsuranceId, insGroupCode, insStartDate, insEndDate, insCoverageType);
			writeDependentInfo(depNameFirst, depNameMiddleInitial, depNameLast, depDob, depBirthSex, 
					depSelfIdSex, depPhone, depEmail);
			return true;
		} catch (Exception e) {return false;}
	}
	
	private void writeGenInfo(String nameFirst, String nameLast, String date, String streetAddress, 
			String apartmentNum, String city, String state, String zip, String phone, String email,
			String dob, String birthSex, String selfIdSex) throws SQLException {
		// Write to the "General Information" table.
		PreparedStatement query = dbConn.prepareStatement("INSERT INTO sdlc.general (nameFirst, nameLast, "
				+ "date, streetAddress, apartmentNum, city, state, zip, phone, email, dob, birthSex, "
				+ "selfIdSex) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
		
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
		query.executeUpdate();
		
		// Acquire the ID of the entry that was just inserted into the table.
		ResultSet results = query.getGeneratedKeys();
		if(results.next())
			id = results.getInt(1);
	}
	
	private void writeInsuranceInfo(String insuranceId, String groupCode, String startDate, 
			String endDate, String coverageType) throws SQLException {
		// Write to the "Insurance Information" table.
		PreparedStatement query = dbConn.prepareStatement("INSERT INTO sdlc.insurance VALUES (?, ?, ?, ?, ?, ?)");
		query.setInt(1, id);
		query.setString(2, insuranceId);
		query.setString(3, groupCode);
		query.setString(4, startDate);
		query.setString(5, endDate);
		query.setString(6, coverageType);
		query.executeUpdate();
	}
	
	private void writeDependentInfo(String nameFirst, String nameMiddleInitial, String nameLast, 
			String dob, String birthSex, String selfIdSex, String phone, String email) throws SQLException {
		// Write to the "Dependent Information" table.
		PreparedStatement query = dbConn.prepareStatement("INSERT INTO sdlc.dependent VALUES (?, ?, ?, ?, ?, "
				+ "?, ?, ?, ?)");
		query.setInt(1, id);
		query.setString(2, nameFirst);
		query.setString(3, nameMiddleInitial);
		query.setString(4, nameLast);
		query.setString(5, dob);
		query.setString(6, birthSex);
		query.setString(7, selfIdSex);
		query.setString(8, phone);
		query.setString(9, email);
		query.executeUpdate();
	}

}
