package ojdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OjdbcEx_02 {
	
	//OJDBC 드라이버
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	
	//DB연결 정보
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	private static final String USERNAME = "scott";
	private static final String PASSWORD = "tiger";
	
	//OJDBC 객체
	private static Connection conn = null; //DB연결객체
	private static Statement st = null; //SQL수행객체
	private static ResultSet rs = null; //조회결과객체
	
	public static void main(String[] args) {

		//----- 드라이버 로드 -----
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		//-------------------------
		
		//----- SQL 작성 -----
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
			//----- DB연결 -----
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//------------------
			
			
			//----- SQL 수행 -----
			st = conn.createStatement(); //Statement 객체 얻기
			
			st.execute(sql1); //테이블 생성쿼리 수행
			st.execute(sql2); //시퀀스 생성쿼리 수행
			//--------------------
			
			
			//----- 테이블 생성 확인 -----
			String sql = "";
			sql += "SELECT count(*) cnt_tb FROM tabs"; 
			sql += " WHERE table_name = upper('userTest')";
			
			//SELECT 쿼리 수행 및 결과 저장
			rs = st.executeQuery(sql);
			
			//조회된 첫번째 행을 참조하도록 만든다
			rs.next();
			
			//조회결과(ResultSet)의 컬럼명이 "cnt_tb"인 값 얻어오기
			int tb_cnt = rs.getInt("cnt_tb");
			
			//조회결과를 이용한 출력
			if( tb_cnt > 0 ) {
				System.out.println("테이블 생성 완료");
			} else {
				System.out.println("테이블 생성 실패");
			}
			//----------------------------
			
			//----- 시퀀스 생성 확인 -----
			sql = "";
			sql += "SELECT count(*) cnt_seq FROM user_sequences";
			sql += " WHERE sequence_name = upper('seq_usertest')";
			
			//SQL 수행 및 결과 저장
			rs = st.executeQuery(sql);
			
			//조회결과의 첫번째 행 참조하기
			rs.next();
			
			//조회결과 중에서 첫번째 컬럼의 값을 int형으로 반환하기
			int seq_cnt = rs.getInt(1);
			
			
			if(seq_cnt > 0) {
				System.out.println("시퀀스 생성 완료");
			} else {
				System.out.println("시퀀스 생성 실패");
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















