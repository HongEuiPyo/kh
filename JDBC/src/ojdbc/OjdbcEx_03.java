package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class OjdbcEx_03 {

	//OJDBC ����̹�
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB���� ����
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//OJDBC ��ü
	private static Connection conn = null; //DB���ᰴü
	
	private static Statement st = null; //SQL���ఴü
	private static PreparedStatement ps = null; //SQL���ఴü
	
	private static ResultSet rs = null; //��ȸ�����ü

	
	
	public static void main(String[] args) {
		//----- ����̹� �ε� -----
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//-------------------------

		
		//----- ��ȸ�� job �Է¹ޱ� -----
		Scanner sc = new Scanner(System.in);
		System.out.print("��ȸ�� job �Է� : ");
		String job = sc.nextLine();
		//-------------------------------
		
		
		//---- SQL �ۼ� -----
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " WHERE job = '" + job + "'";
		//-------------------
		
//		System.out.println( sql );
		
		
		try {
			//----- DB ���� -----
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//-------------------

			//----- SQL ���� ��ü -----
			st = conn.createStatement(); //Statement��ü ����
			
			rs = st.executeQuery(sql); //SQL���� �� ��� ����
			//-------------------------
			
			//----- SQL ��ȸ ��� ó�� -----
			while(rs.next()) {
				System.out.print( rs.getString("empno") + ", ");
				System.out.print( rs.getString("ename") + ", ");
				System.out.println( rs.getString("job") );
			}
			//------------------------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs!=null)	rs.close();
				if(st!=null)	st.close();
				if(conn!=null)	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}


















