package hackathon.sdlc.database;

public class DbTest {
	public static void main(String[] args) {
		DbConn conn = new DbConn();
		try {
			conn.writeGenInfo("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13");
			conn.writeInsuranceInfo("14", "15", "16", "17", "18");
			conn.writeDependentInfo("19", "20", "21", "22", "23", "24", "25", "26");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
