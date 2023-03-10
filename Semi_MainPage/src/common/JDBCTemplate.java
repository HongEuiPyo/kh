package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	//OJDBC ??Ό?΄λ²?
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB?΄κ²? ? λ³?
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//private ??±?
	private JDBCTemplate() { }

	//DB?°κ²? κ°μ²΄
	private static Connection conn;
	
	//Connectionκ°μ²΄ λ°ν - ?±κΈ??€?¨?΄ ? ?©
	public static Connection getConnection() {
		
		if( conn == null ) {
			try {
				//??Ό?΄λ²? λ‘λ
				Class.forName(DRIVER);
				
				//DB ?°κ²?
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
				//AutoCommit ?€?  ?κΈ?
				conn.setAutoCommit(false);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//DB?°κ²? κ°μ²΄ λ°ν
		return conn;		
	}
	
	//Connection κ°μ²΄ ?«κΈ?
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Statement κ°μ²΄ ?«κΈ?
	public static void close(Statement st) {
		try {
			if(st!=null && !st.isClosed())	st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//PreparedStatement κ°μ²΄ ?«κΈ?
	public static void close(PreparedStatement ps) {
		try {
			if(ps!=null && !ps.isClosed())	ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ResultSet κ°μ²΄ ?«κΈ?
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed())	rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//commit ??
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())	conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//rollback ??
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())	conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
