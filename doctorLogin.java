package Team_Pandemic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class doctorLogin {
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet myRs = null;
	private String doctor_FirstName;
	private String doctor_LastName;
	private int doctor_ID;
	private String speciality;
	static String ssn,ans,select,type,last;
	public doctorLogin() {
		
	}
	
	@SuppressWarnings({ "unlikely-arg-type", "resource" })
	public static void doctor_login() throws SQLException {

		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "root");
        Statement myStmt = myConn.createStatement();
        ResultSet rs = myStmt.executeQuery("SELECT * FROM Doctor");
        Scanner myObj = new Scanner(System.in);
        System.out.println("Enter your social-security number xxx-xx-xxxx");
        ssn= myObj.nextLine();
        int succ= 0;
        int pl1;
        while (rs.next()) {
//        	System.out.println(ssn);
//        	System.out.println(rs.getString("ssn"));
        	if (ssn.equals(rs.getString("ssn"))) {
        		System.out.println("Login Successful: " + rs.getString("Doctor_FirstName") + ", " + rs.getString("doctor_LastName") + " of "+ rs.getString("speciality")+ ", " + "Your ID is: " + rs.getInt("doctor_ID"));
        		int myid=rs.getInt("doctor_ID");
        		System.out.println("Would you like to go over treatment plans for your Pt's?");
                ans= myObj.nextLine();
                if ("yes".contentEquals(ans)||"Yes".contentEquals(ans)) {
                	System.out.println("Here are your current Pt's\n");
                	Person.readoff();
            		myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root" , "root");
                    myStmt = myConn.createStatement();
                    rs = myStmt.executeQuery("SELECT * FROM Person");
                	System.out.println("Type thier ID to start a plan");
                	 pl1=myObj.nextInt();
                    while (rs.next()) {
                    	if (pl1==rs.getInt("person_id")) {
                    		LocalDate newObj = LocalDate.now();
                    		Scanner myObj1 = new Scanner(System.in);
                    			System.out.println("Enter treatment type: ");
                    			type = myObj1.nextLine();
                    			System.out.println("Enter Treatment descrition: ");
                    			last = myObj1.nextLine();
                    		Treatment.insert(type, last, newObj, myid);
                    			System.out.println("Completed-Here is the summary");
                    		break;
                    		}
                    	}
                    
        		succ=1;
                    }
                }
               }
        	
            if(succ == 0) {
        		System.out.println("Login Failed");
        	}
            Treatment.readoff();
        }
        
        
        

	
}

	

