package CngBooking;


import java.sql.Connection;
import java.sql.DriverManager;

public class Dbconnection {
	
	
	public static Connection con=null;
	public static Connection connect() {
		try {
			if(con==null) {
				Class.forName("com.mysql.jdbc.Driver");
				try {
					con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cngbooking","root","");
					
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				//System.out.println("connection establish");
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return con;
	
	}
	
	

}