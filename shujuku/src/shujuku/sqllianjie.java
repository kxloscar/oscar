package shujuku;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class sqllianjie {

	public static void main(String[] args) {
		
		try {
			String insert = "insert into student values(";
			String selectMaxSid = "select max(sno) from student";
			String sql = "select * from league";
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3305/league";
			Connection con = DriverManager.getConnection(url, "root", "root");
			System.out.println("链接成功");
			Statement stmt =  con.createStatement();
			ResultSet rs = stmt.executeQuery(selectMaxSid);
			rs.next();
			int maxid=rs.getInt(1)+1;
			System.out.println(maxid);
			
			stmt.executeUpdate(insert+maxid+",'kokokoip','"+"oioi"+"',"+11+",'"+"男"+"',"+"'"+"lili"+"',"+89.0+","+555+")");
			rs = stmt.executeQuery(sql);
			rs.close();
			stmt.close();
			con.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
