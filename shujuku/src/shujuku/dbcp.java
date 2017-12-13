package shujuku;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class dbcp {
	private static Properties p=new Properties();
	private static DataSource ds;
	
		
		static {
			InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream("yui.properties");
			try {
				p.load(is);
				ds = BasicDataSourceFactory.createDataSource(p);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		public static Connection getCon() throws SQLException {
			return ds.getConnection();
		}
}
