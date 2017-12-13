package bookstoreDao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Dbcp {

	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
	}
	
	//返回一个连接对象
	public static Connection getCon() throws SQLException {
		return DriverManager.getConnection("jdbc:mysql://localhost:3305/bookstore", "root", "root");
	}

}
