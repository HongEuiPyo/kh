package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC ���̺귯�� ��� ���
//	1. JDBC ����̹�(driver) �ε�
//	2. DB ����(����, Connection)
//	3. SQL���� ����
//	4. ����� ó��
//	5. ���� ����

public class OjdbcEx_01 {
	public static void main(String[] args) {
//	1. JDBC ����̹�(driver) �ε�
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		//--- OJDBC ��뿡 �ʿ��� ������ ---
		Connection conn = null; //DB���� ��ü(���� ��ü)
		
		Statement st = null; //SQL���� ���� �� SQL���� ���� ��ü
		ResultSet rs = null; //��ȸ ��� ��ȯ ��ü (��� ���� ó��)
		//----------------------------------
		
		
		
		try {

			//	2. DB ����(����, Connection)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe"
					, "scott"
					, "tiger");
			
			
			//	3. SQL���� ����
			
			//	3-1. SQL������ �����ϴ� ��ü ����
			st = conn.createStatement();
			
			//	3-2. SQL���� ���� �� ���(ResultSet) ����
			rs = st.executeQuery("SELECT * FROM emp ORDER BY empno");
			

			//	4. ����� ó��
			//	��ȸ�� ������� �����ϴ� ��ŭ �ݺ��ϵ��� �ۼ��Ѵ�
			
			//	rs.next() �޼ҵ�
			//	 -> ��ȸ ����� ���������� �� �྿ �����Ѵ� (������ ������ true ��ȯ)
			//	 -> ��� ��ȸ ����� ������ ���Ŀ��� ���������� false�� ��ȯ�Ѵ�
			while( rs.next() ) {
				System.out.print( rs.getString("empno") + ", " );
				System.out.print( rs.getString("ename") + ", " );
				System.out.print( rs.getString("job") + ", " );
				System.out.print( rs.getString("mgr") + ", " );
				System.out.print( rs.getString("hiredate") + ", " );
				System.out.print( rs.getString("sal") + ", " );
				System.out.print( rs.getString("comm") + ", " );
				System.out.println( rs.getString("deptno") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		
			//	5. ���� ����
			try {
				//�ڿ� ����
				if(rs!=null)	rs.close();
				if(st!=null)	st.close();
				if(conn!=null)	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}














