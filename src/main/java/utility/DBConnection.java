package utility;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;

public class DBConnection {
	public static Connection getConnection() {
		Connection con = null;
		String url = "jdbc:mysql://localhost:3306/GrazeNex";
		String user = "root";
		String password = "Shreyas@7154";
		try {
			// Load the Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Creating connection
			con = DriverManager.getConnection(url,user,password);
			
			System.out.println("Database Connected Successfully!");
			
		}catch (Exception e) {
			System.out.println("Connection Failed");
			e.printStackTrace();
		}
		return con;
	}
}
