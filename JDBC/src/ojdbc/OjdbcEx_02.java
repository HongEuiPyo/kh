package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OjdbcEx_02 {
	
	//OJDBC ����̹�
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB���� ����
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//OJDBC ��ü
	private static Connection conn = null; //DB���ᰴü
	private static Statement st = null; //SQL���ఴü
	private static ResultSet rs = null; //��ȸ�����ü
	
	public static void main(String[] args) {

		//----- ����̹� �ε� -----
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//-------------------------
		
		//----- SQL �ۼ� -----
		String sql1 = "";
		sql1 += "CREATE TABLE userTest (";
		sql1 += "	idx NUMBER CONSTRAINT pk_user_test PRIMARY KEY";
		sql1 += "	, name VARCHAR2(50) NOT NULL";
		sql1 += "	, phone VARCHAR2(50) NOT NULL";
		sql1 += ")";
		
		String sql2 = "";
		sql2 += "CREATE SEQUENCE seq_usertest";
		sql2 += " INCREMENT BY 1";
		sql2 += " START WITH 1";
		//--------------------
		
		
		try {
			//----- DB���� -----
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//------------------
			
			
			//----- SQL ���� -----
			st = conn.createStatement(); //Statement ��ü ���
			
			st.execute(sql1); //���̺� �������� ����
			st.execute(sql2); //������ �������� ����
			//--------------------
			
			
			//----- ���̺� ���� Ȯ�� -----
			String sql = "";
			sql += "SELECT count(*) cnt_tb FROM tabs"; 
			sql += " WHERE table_name = upper('userTest')";
			
			//SELECT ���� ���� �� ��� ����
			rs = st.executeQuery(sql);
			
			//��ȸ�� ù��° ���� �����ϵ��� �����
			rs.next();
			
			//��ȸ���(ResultSet)�� �÷����� "cnt_tb"�� �� ������
			int tb_cnt = rs.getInt("cnt_tb");
			
			//��ȸ����� �̿��� ���
			if( tb_cnt > 0 ) {
				System.out.println("���̺� ���� �Ϸ�");
			} else {
				System.out.println("���̺� ���� ����");
			}
			//----------------------------
			
			//----- ������ ���� Ȯ�� -----
			sql = "";
			sql += "SELECT count(*) cnt_seq FROM user_sequences";
			sql += " WHERE sequence_name = upper('seq_usertest')";
			
			//SQL ���� �� ��� ����
			rs = st.executeQuery(sql);
			
			//��ȸ����� ù��° �� �����ϱ�
			rs.next();
			
			//��ȸ��� �߿��� ù��° �÷��� ���� int������ ��ȯ�ϱ�
			int seq_cnt = rs.getInt(1);
			
			
			if(seq_cnt > 0) {
				System.out.println("������ ���� �Ϸ�");
			} else {
				System.out.println("������ ���� ����");
			}
			//----------------------------
			
			
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















