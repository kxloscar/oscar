package bookstoreDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcTemplate {

	//添、删、改的模板方法
		public static void update(String sql , Object... params) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = Dbcp.getCon();
				pstmt = con.prepareStatement(sql);
				//设置占位符?的值
				for(int i = 0 ;i < params.length ;i++) {
					pstmt.setObject(i + 1, params[i]);
				}
				
				pstmt.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(pstmt != null) {
						pstmt.close();
					}
					if(con != null) {
						con.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		//查询的模板方法
		public static <T> T select(String sql , IResultSetHandler<T> sh , Object...params) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			try {
				con = Dbcp.getCon();
				pstmt = con.prepareStatement(sql);
				//设置未知参数值
				for(int i = 0 ;i < params.length ;i++) {
					pstmt.setObject(i+1, params[i]);
				}
				rs = pstmt.executeQuery();
				return sh.handler(rs);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if(rs != null) {
						rs.close();
					}
					if(pstmt != null) {
						pstmt.close();
					}
					if(con != null) {
						con.close();
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return null;
			
		}

}
