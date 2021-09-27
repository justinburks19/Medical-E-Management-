package Team_Pandemic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class login {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet myRs = null;
	public login() {
		
	}
	
	public static void loginPt() throws SQLException {

		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "root");
        Statement myStmt = myConn.createStatement();
        ResultSet rs = myStmt.executeQuery("SELECT * FROM Person");
        String ssn;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your social-security number xxx-xx-xxxx");
        ssn= myObj.nextLine();
        int succ= 0;
        while (rs.next()) {
//        	System.out.println(ssn);
//        	System.out.println(rs.getString("ssn"));
        	if (ssn.equals(rs.getString("ssn"))) {
        		System.out.println("Login Successful");
        		succ=1;
        		break;
        	}
		}
        if(succ == 0) {
    		System.out.println("Login Failed");
    	}
        
        
        

	
	}
}
