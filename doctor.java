package Team_Pandemic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class doctor {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet myRs = null;
	private String doctor_FirstName;
	private String doctor_LastName;
	private int doctor_ID;
	private String speciality;
	private String ssn;
	public doctor() {
		
	}
	
	public doctor(String doctor_FirstName, String doctor_LastName, String speciality, String ssn) {
		this.doctor_FirstName=doctor_FirstName;
		this.doctor_LastName=doctor_LastName;
		this.doctor_ID=doctor_ID;
		this.speciality=speciality;
		this.ssn=ssn;
	}
	public static void createTable() throws SQLException {

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			stmt = conn.createStatement();
			String sql = "CREATE TABLE IF NOT EXISTS Doctor(" 
					+ " Doctor_FirstName VARCHAR(45) NULL DEFAULT 'null',"
					+ " doctor_LastName VARCHAR(45) NULL DEFAULT 'null'," 
					+ " doctor_ID INT NOT NULL AUTO_INCREMENT," 
					+ " speciality VARCHAR(45) NULL DEFAULT 'null',"
					+ " ssn VARCHAR(45) NULL DEFAULT 'null',"
					+ " primary key (doctor_ID))";
			//sql="Drop TABLE treatment";
			stmt.executeUpdate(sql);
			System.out.println("Created Doctor in database...");
		} catch (SQLException se) {
			// Handle errors for JDBC
			se.printStackTrace();
		} catch (Exception e) {
			// Handle errors for Class.forName
			e.printStackTrace();
		} finally {
			// finally block used to close resources
			try {
				if (stmt != null)
					conn.close();
			} catch (SQLException se) {
			} // do nothing
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException se) {
				se.printStackTrace();
			}
		}
	}
	public static void insert(String doctor_FirstName, String doctor_LastName, String speciality, String ssn)
			throws SQLException {
		Database.executeUpdate("INSERT INTO Doctor (doctor_FirstName,doctor_LastName,speciality,ssn) " 
			+ " values ('" + doctor_FirstName + "','" + doctor_LastName + "','" + speciality + "','" + ssn + "')");
	}
	public void insert() throws SQLException {
		Database.executeUpdate("INSERT INTO Doctor (doctor_FirstName,doctor_LastName,speciality,ssn) "  
				+ " values ('" + this.doctor_FirstName + "','" + this.doctor_LastName + "','" + this.speciality + "','" + this.ssn + "')");
	}
	public static void readoff() throws SQLException {
        Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "root");
        Statement myStmt = myConn.createStatement();
        ResultSet rs = myStmt.executeQuery("SELECT * FROM Doctor");
		// 4. Process the result set
		while (rs.next()) {
			System.out.println(rs.getString("doctor_FirstName")+ ", "+ rs.getString("doctor_LastName") + ", " + rs.getString("speciality") + ", " + rs.getString("ssn"));
		}
}
}
