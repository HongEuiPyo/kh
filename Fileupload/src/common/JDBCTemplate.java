package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTemplate {

	//OJDBC ����̹�
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB���� ����
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//private ������
	private JDBCTemplate() { }

	//DB���� ��ü
	private static Connection conn;
	
	//Connection��ü ��ȯ - �̱������� ����
	public static Connection getConnection() {
		
		if( conn == null ) {
			try {
				//����̹� �ε�
				Class.forName(DRIVER);
				
				//DB ����
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
				
				//AutoCommit ���� ����
				conn.setAutoCommit(false);
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		//DB���� ��ü ��ȯ
		return conn;		
	}
	
	//Connection ��ü �ݱ�
	public static void close(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())	conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//Statement ��ü �ݱ�
	public static void close(Statement st) {
		try {
			if(st!=null && !st.isClosed())	st.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//PreparedStatement ��ü �ݱ�
	public static void close(PreparedStatement ps) {
		try {
			if(ps!=null && !ps.isClosed())	ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//ResultSet ��ü �ݱ�
	public static void close(ResultSet rs) {
		try {
			if(rs!=null && !rs.isClosed())	rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//commit ����
	public static void commit(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())	conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	//rollback ����
	public static void rollback(Connection conn) {
		try {
			if(conn!=null && !conn.isClosed())	conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

