package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dto.Emp;

public class OjdbcEx_05 {
	//OJDBC ����̹�
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB���� ����
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//OJDBC ��ü
	private static Connection conn = null; //DB���ᰴü
	private static PreparedStatement ps = null; //SQL���ఴü
	private static ResultSet rs = null; //��ȸ�����ü

	
	
	public static void main(String[] args) {
	
		//--- ����̹� �ε� ---
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//---------------------
		
		
		//--- ��ȸ�� job �Է¹ޱ� ---
		Scanner sc = new Scanner(System.in);
		System.out.print("��ȸ�� job �Է� : ");
		String job = sc.nextLine();
		//---------------------------
		
		
		//--- SQL �ۼ� ---
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " WHERE job = ?";
		sql += " ORDER BY empno";
		//----------------
		
		
		//--- ��ȸ ��� ������ ����Ʈ ---
		List<Emp> list = new ArrayList<>();
		//-------------------------------
		
		
		
		try {
			//--- DB ���� ---
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//---------------
			
			//--- SQL ���� ��ü ---
			ps = conn.prepareStatement(sql);
			ps.setString(1, job);
			
			rs = ps.executeQuery();
			//---------------------

			//--- ��ȸ ��� ó�� ---
			while(rs.next()) {
				
				//�� ���� �����͸� ������ Emp��ü ����
				Emp emp = new Emp();

				emp.setEmpno( rs.getInt("empno") );
				emp.setEname( rs.getString("ename") );
				emp.setJob( rs.getString("job") );
				emp.setMgr( rs.getInt("mgr") );
				emp.setHiredate( rs.getDate("hiredate") );
				emp.setSal( rs.getDouble("sal") );
				emp.setComm( rs.getDouble("comm") );
				emp.setDeptno( rs.getInt("deptno") );
				
				list.add( emp );
			}
			//----------------------
			
			
			//--- ���� ��� ��� ---
			for( Emp e : list ) {
				System.out.println( e );
			}
			//----------------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				//�ڿ� ����
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				if(conn!=null)	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}














