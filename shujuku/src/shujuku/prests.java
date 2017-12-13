package shujuku;


import java.awt.Container;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;




public class prests {
	private static String drvierClass = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://localhost:3305/league";
	private static String username = "root";
	private static String password = "root";
	private static String selectLeague = "select * from student where Sname=? and Sage=?";
	private static String maxSid = "select max(sid) from stu";
	private static String  insert  = "insert into student(sname,sage,ssex,Sbirthday) values(?,?,?,?)";
	private static String delete = "delete from stu where sname=?";
	private static String update = "update student set sname=?,sage=? where sno=?";
	public static void main(String[] args) {
		try {
			Connection con=dbcp.getCon();
			ResultSet rs=null;
			PreparedStatement pstmt= con.prepareStatement(insert,Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, "jakc");
			pstmt.setInt(2, 20);
			pstmt.setString(3, "男");
			pstmt.setString(4, "2018-9-9");
			
			pstmt.executeUpdate();
			rs=pstmt.getGeneratedKeys();
			rs.next();
			int num=rs.getInt(1);
			System.out.println(num);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
