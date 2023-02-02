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

	//OJDBC 드라이버
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB연결 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//OJDBC 객체
	private static Connection conn = null; //DB연결객체
	private static PreparedStatement ps = null; //SQL수행객체
	private static ResultSet rs = null; //조회결과객체
	
	
	//생성자
	public EmpDaoImpl() {
		
		try {
			//드라이버 로드
			Class.forName(DRIVER);
			
			//DB 연결
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	
	@Override
	public List<Emp> selectAll() {
		
		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " ORDER BY empno";
		//----------------
		
		
		//--- 조회 결과를 저장할 List ---
		List<Emp> list = new ArrayList();
		//-------------------------------
		
		
		try {
			//--- SQL 수행 객체 생성 ---
			ps = conn.prepareStatement(sql);
			//--------------------------

			//--- SQL 수행 및 결과 저장 ---
			rs = ps.executeQuery();
			//-----------------------------

			//--- 조회 결과 처리 ---
			while(rs.next()) {
				//각 행의 데이터를 저장할 Emp객체 생성
				Emp emp = new Emp();
				
				//각 행의 컬럼 데이터를 Emp DTO의 멤버필드로 저장
				emp.setEmpno( rs.getInt("empno") );
				emp.setEname( rs.getString("ename") );
				emp.setJob( rs.getString("job") );
				emp.setMgr( rs.getInt("mgr") );
				emp.setHiredate( rs.getDate("hiredate") );
				emp.setSal( rs.getDouble("sal") );
				emp.setComm( rs.getDouble("comm") );
				emp.setDeptno( rs.getInt("deptno") );
				
				//조회결과를 담고있는 Emp객체를 리스트에 추가하기
				list.add( emp );
			}
			//----------------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//--- 최종 조회 결과 반환 ---
		return list;
		//---------------------------
	}


	
	@Override
	public List<Emp> selectByDeptno(int deptno) {
		
		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " WHERE deptno = ?";
		sql += " ORDER BY empno";
		//----------------
		
		
		//--- 조회 결과를 저장할 List ---
		List<Emp> list = new ArrayList();
		//-------------------------------
		
		
		try {
			//--- SQL 수행 객체 생성 ---
			ps = conn.prepareStatement(sql);
			//--------------------------
			
			//--- SQL의 ? 채우기 ---
			ps.setInt(1, deptno);
			//----------------------
			
			//--- SQL 수행 및 결과 저장 ---
			rs = ps.executeQuery();
			//-----------------------------

			//--- 조회 결과 처리 ---
			while(rs.next()) {
				//각 행의 데이터를 저장할 Emp객체 생성
				Emp emp = new Emp();
				
				//각 행의 컬럼 데이터를 Emp DTO의 멤버필드로 저장
				emp.setEmpno( rs.getInt("empno") );
				emp.setEname( rs.getString("ename") );
				emp.setJob( rs.getString("job") );
				emp.setMgr( rs.getInt("mgr") );
				emp.setHiredate( rs.getDate("hiredate") );
				emp.setSal( rs.getDouble("sal") );
				emp.setComm( rs.getDouble("comm") );
				emp.setDeptno( rs.getInt("deptno") );
				
				//조회결과를 담고있는 Emp객체를 리스트에 추가하기
				list.add( emp );
			}
			//----------------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				//--- 자원 해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
		//--- 최종 조회 결과 반환 ---
		return list;
		//---------------------------
	}
	
	@Override
	public void insert(Emp insertEmp) {
		
		//--- SQL 작성 ---
		String sql = "";
		sql += "INSERT INTO emp ( empno, ename, deptno )";
		sql += " VALUES ( ?, ?, ? )";
		//----------------
		
	
		try {
			//--- SQL 수행 객체 생성 ---
			ps = conn.prepareStatement(sql);
			//--------------------------
			
			//--- SQL의 ? 채우기 ---
			ps.setInt(1, insertEmp.getEmpno());
			ps.setString(2, insertEmp.getEname());
			ps.setInt(3, insertEmp.getDeptno());
			//----------------------
			
			//--- SQL 수행 ---
			ps.executeUpdate();
			//----------------
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
				//--- 자원 해제 ---
				if(ps!=null)	ps.close();
				//-----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Emp selectByEmpno(int empno) {
		
		//--- SQL 작성 ---
		String sql = "";
		sql += "SELECT * FROM emp";
		sql += " WHERE empno = ?";
		//----------------
		
		
		//--- 조회 결과를 저장할 DTO 객체 ---
		Emp emp = null;
		//-----------------------------------
		
		
		try {
			//--- SQL 수행 객체 생성 ---
			ps = conn.prepareStatement(sql);
			//--------------------------
			
			//--- SQL의 ? 채우기 ---
			ps.setInt(1, empno);
			//----------------------
			
			//--- SQL 수행 및 결과 저장 ---
			rs = ps.executeQuery();
			//-----------------------------
			
			//--- 조회 결과 처리 ---
			while( rs.next() ) {
				emp = new Emp(); //조회 결과가 존재하면 DTO객체 생성
				
				//각 행의 컬럼 데이터를 Emp DTO의 멤버필드로 저장
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
				//--- 자원해제 ---
				if(rs!=null)	rs.close();
				if(ps!=null)	ps.close();
				//----------------
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//--- 최종 조회 결과 반환 ---
		return emp;
		//---------------------------
	}
}


















