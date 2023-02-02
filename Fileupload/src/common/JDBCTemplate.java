package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	//OJDBC µå¶óÀÌ¹ö
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB¿­°á Á¤º¸
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//private »ý¼ºÀÚ
	private JDBCTemplate() { }

	//DB¿¬°á °´Ã¼
	private static Connection conn;
	
	//Connection°´Ã¼ ¹ÝÈ¯ - ½Ì±ÛÅæÆÐÅÏ Àû¿ë
	public static Connection getConnection() {
		
		if( conn == null ) {
			try {
				//µå¶óÀÌ¹ö ·Îµå
				Class.forName(DRIVER);
				
				//DB ¿¬°á
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
				//AutoCommit ¼³Á¤ ²ô±â
				conn.setAutoCommit(false);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//DB¿¬°á °´Ã¼ ¹ÝÈ¯
		return conn;		
	}
	
	//Connection °´Ã¼ ´Ý±â
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Statement °´Ã¼ ´Ý±â
	public static void close(Statement st) {
		try {
			if(st!=null && !st.isClosed())	st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//PreparedStatement °´Ã¼ ´Ý±â
	public static void close(PreparedStatement ps) {
		try {
			if(ps!=null && !ps.isClosed())	ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ResultSet °´Ã¼ ´Ý±â
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed())	rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//commit ¼öÇà
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())	conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//rollback ¼öÇà
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())	conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

