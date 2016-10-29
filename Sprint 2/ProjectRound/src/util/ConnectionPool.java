package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionPool {
	public static Connection getConnection(){
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		//step2 create  the connection object  
		Connection con = null;
		try {
			String url ="jdbc:oracle:thin:@localhost:1521:xe";
			Properties prop = System.getProperties();
			prop.put("user","system");
			prop.put("password","system");
			/*con = DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe","system","system");*/
			con = DriverManager.getConnection(url,prop);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		  
		return con;
	}
}
