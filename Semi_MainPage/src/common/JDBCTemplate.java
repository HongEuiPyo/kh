package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	//OJDBC ?ìú?ùº?ù¥Î≤?
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB?ó¥Í≤? ?†ïÎ≥?
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//private ?Éù?Ñ±?ûê
	private JDBCTemplate() { }

	//DB?ó∞Í≤? Í∞ùÏ≤¥
	private static Connection conn;
	
	//ConnectionÍ∞ùÏ≤¥ Î∞òÌôò - ?ã±Í∏??Ü§?å®?Ñ¥ ?†Å?ö©
	public static Connection getConnection() {
		
		if( conn == null ) {
			try {
				//?ìú?ùº?ù¥Î≤? Î°úÎìú
				Class.forName(DRIVER);
				
				//DB ?ó∞Í≤?
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
				//AutoCommit ?Ñ§?†ï ?ÅÑÍ∏?
				conn.setAutoCommit(false);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//DB?ó∞Í≤? Í∞ùÏ≤¥ Î∞òÌôò
		return conn;		
	}
	
	//Connection Í∞ùÏ≤¥ ?ã´Í∏?
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Statement Í∞ùÏ≤¥ ?ã´Í∏?
	public static void close(Statement st) {
		try {
			if(st!=null && !st.isClosed())	st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//PreparedStatement Í∞ùÏ≤¥ ?ã´Í∏?
	public static void close(PreparedStatement ps) {
		try {
			if(ps!=null && !ps.isClosed())	ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ResultSet Í∞ùÏ≤¥ ?ã´Í∏?
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed())	rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//commit ?àò?ñâ
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())	conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//rollback ?àò?ñâ
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())	conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
