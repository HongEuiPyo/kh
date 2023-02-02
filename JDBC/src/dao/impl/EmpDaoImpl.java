package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.face.EmpDao;
import dto.Emp;

public class EmpDaoImpl implements EmpDao {

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
	
	
	//������
	public EmpDaoImpl() {
		
		try {
			//����̹� �ε�
			Class.forName(DRIVER);
			
			//DB ����
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public List<Emp> selectAll() {
		
		//--- SQL �ۼ� ---
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " ORDER BY empno";
		//----------------
		
		
		//--- ��ȸ ����� ������ List ---
		List<Emp> list = new ArrayList();
		//-------------------------------
		
		
		try {
			//--- SQL ���� ��ü ���� ---
			ps = conn.prepareStatement(sql);
			//--------------------------

			//--- SQL ���� �� ��� ���� ---
			rs = ps.executeQuery();
			//-----------------------------

			//--- ��ȸ ��� ó�� ---
			while(rs.next()) {
				//�� ���� �����͸� ������ Emp��ü ����
				Emp emp = new Emp();
				
				//�� ���� �÷� �����͸� Emp DTO�� ����ʵ�� ����
				emp.setEmpno( rs.getInt("empno") );
				emp.setEname( rs.getString("ename") );
				emp.setJob( rs.getString("job") );
				emp.setMgr( rs.getInt("mgr") );
				emp.setHiredate( rs.getDate("hiredate") );
				emp.setSal( rs.getDouble("sal") );
				emp.setComm( rs.getDouble("comm") );
				emp.setDeptno( rs.getInt("deptno") );
				
				//��ȸ����� ����ִ� Emp��ü�� ����Ʈ�� �߰��ϱ�
				list.add( emp );
			}
			//----------------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				//--- �ڿ� ���� ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//--- ���� ��ȸ ��� ��ȯ ---
		return list;
		//---------------------------
	}


	
	@Override
	public List<Emp> selectByDeptno(int deptno) {
		
		//--- SQL �ۼ� ---
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " WHERE deptno = ?";
		sql += " ORDER BY empno";
		//----------------
		
		
		//--- ��ȸ ����� ������ List ---
		List<Emp> list = new ArrayList();
		//-------------------------------
		
		
		try {
			//--- SQL ���� ��ü ���� ---
			ps = conn.prepareStatement(sql);
			//--------------------------
			
			//--- SQL�� ? ä��� ---
			ps.setInt(1, deptno);
			//----------------------
			
			//--- SQL ���� �� ��� ���� ---
			rs = ps.executeQuery();
			//-----------------------------

			//--- ��ȸ ��� ó�� ---
			while(rs.next()) {
				//�� ���� �����͸� ������ Emp��ü ����
				Emp emp = new Emp();
				
				//�� ���� �÷� �����͸� Emp DTO�� ����ʵ�� ����
				emp.setEmpno( rs.getInt("empno") );
				emp.setEname( rs.getString("ename") );
				emp.setJob( rs.getString("job") );
				emp.setMgr( rs.getInt("mgr") );
				emp.setHiredate( rs.getDate("hiredate") );
				emp.setSal( rs.getDouble("sal") );
				emp.setComm( rs.getDouble("comm") );
				emp.setDeptno( rs.getInt("deptno") );
				
				//��ȸ����� ����ִ� Emp��ü�� ����Ʈ�� �߰��ϱ�
				list.add( emp );
			}
			//----------------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				//--- �ڿ� ���� ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//--- ���� ��ȸ ��� ��ȯ ---
		return list;
		//---------------------------
	}
	
	@Override
	public void insert(Emp insertEmp) {
		
		//--- SQL �ۼ� ---
		String sql = "";
		sql += "INSERT INTO emp ( empno, ename, deptno )";
		sql += " VALUES ( ?, ?, ? )";
		//----------------
		
	
		try {
			//--- SQL ���� ��ü ���� ---
			ps = conn.prepareStatement(sql);
			//--------------------------
			
			//--- SQL�� ? ä��� ---
			ps.setInt(1, insertEmp.getEmpno());
			ps.setString(2, insertEmp.getEname());
			ps.setInt(3, insertEmp.getDeptno());
			//----------------------
			
			//--- SQL ���� ---
			ps.executeUpdate();
			//----------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				//--- �ڿ� ���� ---
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Emp selectByEmpno(int empno) {
		
		//--- SQL �ۼ� ---
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " WHERE empno = ?";
		//----------------
		
		
		//--- ��ȸ ����� ������ DTO ��ü ---
		Emp emp = null;
		//-----------------------------------
		
		
		try {
			//--- SQL ���� ��ü ���� ---
			ps = conn.prepareStatement(sql);
			//--------------------------
			
			//--- SQL�� ? ä��� ---
			ps.setInt(1, empno);
			//----------------------
			
			//--- SQL ���� �� ��� ���� ---
			rs = ps.executeQuery();
			//-----------------------------
			
			//--- ��ȸ ��� ó�� ---
			while( rs.next() ) {
				emp = new Emp(); //��ȸ ����� �����ϸ� DTO��ü ����
				
				//�� ���� �÷� �����͸� Emp DTO�� ����ʵ�� ����
				emp.setEmpno( rs.getInt("empno") );
				emp.setEname( rs.getString("ename") );
				emp.setJob( rs.getString("job") );
				emp.setMgr( rs.getInt("mgr") );
				emp.setHiredate( rs.getDate("hiredate") );
				emp.setSal( rs.getDouble("sal") );
				emp.setComm( rs.getDouble("comm") );
				emp.setDeptno( rs.getInt("deptno") );
			}
			//----------------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				//--- �ڿ����� ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//--- ���� ��ȸ ��� ��ȯ ---
		return emp;
		//---------------------------
	}
}


















