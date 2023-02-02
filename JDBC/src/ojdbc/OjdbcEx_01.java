package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//JDBC 라이브러리 사용 방법
//	1. JDBC 드라이버(driver) 로드
//	2. DB 접속(연결, Connection)
//	3. SQL쿼리 수행
//	4. 결과값 처리
//	5. 연결 종료

public class OjdbcEx_01 {
	public static void main(String[] args) {
//	1. JDBC 드라이버(driver) 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
		
		//--- OJDBC 사용에 필요한 변수들 ---
		Connection conn = null; //DB연결 객체(접속 객체)
		
		Statement st = null; //SQL구문 저장 및 SQL구문 수행 객체
		ResultSet rs = null; //조회 결과 반환 객체 (결과 집합 처리)
		//----------------------------------
		
		
		
		try {

			//	2. DB 접속(연결, Connection)
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe"
					, "scott"
					, "tiger");
			
			
			//	3. SQL쿼리 수행
			
			//	3-1. SQL쿼리를 수행하는 객체 생성
			st = conn.createStatement();
			
			//	3-2. SQL쿼리 수행 및 결과(ResultSet) 저장
			rs = st.executeQuery("SELECT * FROM emp ORDER BY empno");
			

			//	4. 결과값 처리
			//	조회된 결과행이 존재하는 만큼 반복하도록 작성한다
			
			//	rs.next() 메소드
			//	 -> 조회 결과를 순차적으로 한 행씩 참조한다 (실행할 때마다 true 반환)
			//	 -> 모든 조회 결과를 참조한 이후에는 마지막으로 false를 반환한다
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
		
			//	5. 연결 종료
			try {
				//자원 해제
				if(rs!=null)	rs.close();
				if(st!=null)	st.close();
				if(conn!=null)	conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}
}














