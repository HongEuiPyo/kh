package custom.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import custom.dto.Custom;
import custom.dto.CustomComment;
import custom.dto.CustomFile;
import official.dto.OfficialComment;
import custom.dto.Custom;
import util.Paging;

public class CustomDaoImpl implements CustomDao{
	
	PreparedStatement ps = null; //SQL 수행객체 생성
	ResultSet rs = null; //결과값을 담을 객체 생성
	
	@Override
	public int selectCntAll(Connection connection) {
		
		String sql = "";
		sql += "SELECT count(*) FROM custom_board";
		
		//총 레시피 숫자
		int cnt = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cnt = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return cnt;
	}
	
	@Override
	public int selectCntSearchAll(Connection connection, String search) {
		
		//총 레시피 숫자
		int cnt = 0;
		
		String sql = "";
		sql += "SELECT count(*) FROM custom_board";
		sql += " WHERE 1=1 AND";
		sql += "      upper(custom_board_title) LIKE upper(?)";
		sql += "    OR upper(custom_board_content) LIKE upper(?)";

		try {
			ps = connection.prepareStatement(sql);

			//변수 채우기
			ps.setString(1, "%" + search + "%");
			ps.setString(2, "%" + search + "%");

			rs = ps.executeQuery();

			while(rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return cnt;
	}
	
	public int selectCntSearch(Connection connection, String search, String category) {
				
		//총 레시피 숫자
		int cnt = 0;
		
		String sql = "";
		sql += "SELECT count(*) FROM custom_board C";
		sql += " JOIN user_info U ON U.user_no = C.user_no";
		sql += " WHERE 1=1 ";
		if( "title".equals(category) ) {
			sql += "    AND upper(C.custom_board_title) ";
		} else if ("detail".equals(category) ) {
			sql += "    AND upper(C.custom_board_content) ";
		} else { //if (category == "nickname" )
			sql += "    AND upper(U.user_nickname) ";
		}
		sql += " Like upper(?)";
		
		
		try {
			ps = connection.prepareStatement(sql);

			//변수 채우기
			ps.setString(1, "%" + search + "%");

			rs = ps.executeQuery();

			while(rs.next()) {
				cnt = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return cnt;
	}
	
	@Override
	public List<Custom> selectAll(Connection connection, Paging paging) {
		
		String sql = ""; //SQL 작성
		sql += "SELECT * FROM (";
		sql += "  SELECT ROWNUM rnum, O.* FROM (";
		sql += "    SELECT custom_board_no, C.USER_NO, U.USER_NICKNAME, CUSTOM_BOARD_TITLE, CUSTOM_BOARD_CONTENT, custom_board_date, custom_board_hit, custom_board_vote";
		sql += "	  FROM CUSTOM_BOARD C ";
		sql += "	  JOIN USER_INFO U ON U.USER_NO = C.USER_NO ";
		sql += "	  WHERE 1=1 ";
		sql += "	  ORDER BY custom_board_no ) O ";
		sql += "	) Custom_board ";
		sql += "  WHERE rnum BETWEEN ? AND ?";
	    
		//결과 저장 리스트
		List<Custom> customList = new ArrayList<>();
	    
	    try {
			ps = connection.prepareStatement(sql);
			
			//변수 채우기
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Custom custom = new Custom();
				custom.setCustom_board_no(rs.getInt("custom_board_no"));
				custom.setUser_no(rs.getInt("user_no"));
				custom.setUser_nickname(rs.getString("user_nickname"));
				custom.setCustom_board_title(rs.getString("custom_board_title"));
				custom.setCustom_board_content(rs.getString("custom_board_content"));
				custom.setCustom_board_date(rs.getDate("custom_board_date"));
				custom.setCustom_board_hit(rs.getInt("custom_board_hit"));
				custom.setCustom_board_vote(rs.getInt("custom_board_vote"));
				
				//리스트에 custom 객체로 저장
				customList.add(custom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
	    		
		return customList;
	}
	
	@Override
	public List<Custom> selectSearchAll(Connection connection, Paging paging, String search) {
		
		String sql = ""; //SQL 작성
		sql += "SELECT * FROM (";
		sql += "  SELECT ROWNUM rnum, O.* FROM (";
		sql += "    SELECT custom_board_no, C.USER_NO, U.USER_NICKNAME, CUSTOM_BOARD_TITLE, CUSTOM_BOARD_CONTENT, custom_board_date, custom_board_hit, custom_board_vote";
		sql += "	  FROM CUSTOM_BOARD C ";
		sql += "	  JOIN USER_INFO U ON U.USER_NO = C.USER_NO ";
		sql += "		WHERE 1=1";
		sql += "		AND upper(custom_board_title) LIKE upper(?)";
		sql += "		OR upper(custom_board_content) LIKE upper(?)";
		sql += "		ORDER BY custom_board_no ) O";
		sql += " 		) custom_board";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장 리스트
		List<Custom> customList = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql);
			
			//변수 채우기
			ps.setString(1, "%" + search + "%");
			ps.setString(2, "%" + search + "%");
			ps.setInt(3, paging.getStartNo());
			ps.setInt(4, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Custom custom = new Custom();
				custom.setCustom_board_no(rs.getInt("custom_board_no"));
				custom.setUser_no(rs.getInt("user_no"));
				custom.setUser_nickname(rs.getString("user_nickname"));
				custom.setCustom_board_title(rs.getString("custom_board_title"));
				custom.setCustom_board_content(rs.getString("custom_board_content"));
				custom.setCustom_board_date(rs.getDate("custom_board_date"));
				custom.setCustom_board_hit(rs.getInt("custom_board_hit"));
				custom.setCustom_board_vote(rs.getInt("custom_board_vote"));
				
				//리스트에 custom 객체로 저장
				customList.add(custom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return customList;
	}
	
	@Override
	public List<Custom> selectSearch(Connection connection, Paging paging, String search, String category) {
		
		String sql = ""; //SQL 작성
		sql += "SELECT * FROM (";
		sql += "  SELECT ROWNUM rnum, O.* FROM (";
		sql += "    SELECT custom_board_no, C.USER_NO, U.USER_NICKNAME, CUSTOM_BOARD_TITLE, CUSTOM_BOARD_CONTENT, custom_board_date, custom_board_hit, custom_board_vote";
		sql += "	  FROM CUSTOM_BOARD C ";
		sql += "	  JOIN USER_INFO U ON U.USER_NO = C.USER_NO ";
	    sql += "	  WHERE 1=1";
	    if( "title".equals(category) ) {
			sql += "		AND upper(custom_board_title) ";
	    } else if ( "detail".equals(category) ) {
			sql += "		AND upper(custom_board_content) ";
	    } else { //"nickname" 일 경우
			sql += "		AND upper(user_nickname) ";
		}
	    sql += " 			LIKE upper(?)";
	    sql += "		ORDER BY custom_board_no ) O";
		sql += " 		) custom_board";
		sql += " WHERE rnum BETWEEN ? AND ?";
	    
		//결과 저장 리스트
		List<Custom> customList = new ArrayList<>();
	    
	    try {
			ps = connection.prepareStatement(sql);
			
			//변수 채우기
			ps.setString(1, "%" + search + "%");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
				rs = ps.executeQuery();
			
			while(rs.next()) {
				Custom custom = new Custom();
				custom.setCustom_board_no(rs.getInt("custom_board_no"));
				custom.setUser_no(rs.getInt("user_no"));
				custom.setUser_nickname(rs.getString("user_nickname"));
				custom.setCustom_board_title(rs.getString("custom_board_title"));
				custom.setCustom_board_content(rs.getString("custom_board_content"));
				custom.setCustom_board_date(rs.getDate("custom_board_date"));
				custom.setCustom_board_hit(rs.getInt("custom_board_hit"));
				custom.setCustom_board_vote(rs.getInt("custom_board_vote"));
				
				//리스트에 custom 객체로 저장
				customList.add(custom);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
	    		
		return customList;
	}
	
	
	@Override
	public int updateHit(Connection connection, Custom custom_no) {

		//SQL 작성
		String sql = "";
		sql += "UPDATE custom_board";
		sql += " SET custom_board_hit = custom_board_hit + 1";
		sql += " WHERE custom_board_no = ?";

		int res = 0;

		try {
			ps = connection.prepareStatement(sql); //SQL수행 객체

			ps.setInt(1, custom_no.getCustom_board_no()); //조회할 게시글 번호 적용

			res = ps.executeUpdate(); //SQL 수행

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(ps);
		}

		return res;
	}
	
	@Override
	public Custom selectCustomByCustomno(Connection connection, Custom custom_no) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM custom_board";
		sql += " WHERE custom_board_no = ?";

		//결과 저장할 Board객체
		Custom custom = null;

		try {
			ps = connection.prepareStatement(sql); //SQL수행 객체

			ps.setInt(1, custom_no.getCustom_board_no()); //조회할 게시글 번호 적용

			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장

			//조회 결과 처리
			while(rs.next()) {
				custom = new Custom(); //결과값 저장 객체

				//결과값 한 행 처리
				custom.setCustom_board_no(rs.getInt("custom_board_no"));
				custom.setUser_no(rs.getInt("user_no"));
				custom.setCustom_board_title(rs.getString("custom_board_title"));
				custom.setCustom_board_content(rs.getString("custom_board_content"));
				custom.setCustom_board_date(rs.getDate("custom_board_date"));
				custom.setCustom_board_hit(rs.getInt("custom_board_hit"));
				custom.setCustom_board_vote(rs.getInt("custom_board_vote"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		//최종 결과 반환
		return custom;
	}
	
	@Override
	public int insert(Connection connection, Custom custom) {
		String sql = "";
		sql += "INSERT INTO CUSTOM_BOARD (custom_board_no, user_no, custom_board_title, custom_board_content";
		sql += " 						, custom_board_date, custom_board_hit, custom_board_vote)";
		sql += " VALUES (?,?,?,?,sysdate,0,0)";
		
		//첨부파일이 있을 경우 미리 만든 custom_board_no 를 삽입한다
//		sql += " VALUES (board_seq.nextval, ?, ?, ?, 0)";

		int res = 0;

		try {
			//DB작업
			ps = connection.prepareStatement(sql);

			ps.setInt(1, custom.getCustom_board_no());
			ps.setInt(2, custom.getUser_no());
			ps.setString(3, custom.getCustom_board_title());
			ps.setString(4, custom.getCustom_board_content());

			res = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}

		return res;
	}
	
	@Override
	public int selectNextCustomno(Connection connection) {
		String sql = "";
		sql += "SELECT custom_board_seq.nextval FROM dual";

		//결과 저장 변수
		int nextCustomno = 0;

		try {
			ps = connection.prepareStatement(sql);

			rs = ps.executeQuery();

			while(rs.next()) {
				nextCustomno = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		return nextCustomno;
	}
	
	@Override
	public int insertFile(Connection connection, CustomFile customFile) {

		String sql = "";
		sql += "INSERT INTO CUSTOM_BOARD_ATTACHMENT ( ATTACHMENT_NO, CUSTOM_BOARD_NO, ORIGINAL_FILE_NAME, STORED_FILE_NAME, FILE_SIZE)";
		sql += " VALUES (CUSTOM_BOARD_ATTACHMENT_seq.nextval,?,?,?,?)";

		int res = 0;

		try {
			ps = connection.prepareStatement(sql);

			ps.setInt(1, customFile.getCustom_board_no());
			ps.setString(2, customFile.getOriginal_file_name());
			ps.setString(3, customFile.getStored_file_name());
			ps.setInt(4, customFile.getFile_size());

			res = ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}

		return res;
	}
	
	@Override
	public String selectNickByUserno(Connection connection, Custom viewCustom) {
		//SQL 작성
		String sql = "";
		sql += "SELECT USER_NICKNAME FROM USER_INFO";
		sql += " WHERE user_no = ?";
		
		//결과 저장할 String 변수
		String user_nickname = null;
		
		System.out.println("[DAO] viewCustom.getUser_no() : " + viewCustom.getUser_no());
		
		try {
			ps = connection.prepareStatement(sql); //SQL수행 객체
			ps.setInt(1, viewCustom.getUser_no()); //조회할 user_no 적용
			
			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
			
			//조회 결과 처리
			while(rs.next()) {
				user_nickname = rs.getString("user_nickname");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		//최종 결과 반환
		return user_nickname;
		
	}
	
	@Override
	public CustomFile selectFile(Connection connection, Custom viewCustom) {

		String sql = "";
		sql += "SELECT * FROM CUSTOM_BOARD_ATTACHMENT";
		sql += " WHERE custom_board_no = ?";
		sql += " ORDER BY ATTACHMENT_NO";

		CustomFile customFile = null;
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1, viewCustom.getCustom_board_no());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				customFile = new CustomFile();
				
				customFile.setAttachment_no( rs.getInt("ATTACHMENT_NO") );
				customFile.setCustom_board_no( rs.getInt("CUSTOM_BOARD_NO") );
				customFile.setOriginal_file_name( rs.getString("ORIGINAL_FILE_NAME") );
				customFile.setStored_file_name( rs.getString("STORED_FILE_NAME") );
				customFile.setFile_size( rs.getInt("FILE_SIZE") );
				customFile.setFile_date( rs.getDate("FILE_DATE") );
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
				
		return customFile;
	}
	
	@Override
	public int update(Connection connection, Custom custom) {
		
		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "UPDATE custom_board";
		sql += " SET custom_board_title = ?,";
		sql += " 	 custom_board_content = ?";
		sql += " WHERE custom_board_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		int res = -1;
		
		try {
			//DB작업
			ps = connection.prepareStatement(sql);
			ps.setString(1, custom.getCustom_board_title());
			ps.setString(2, custom.getCustom_board_content());
			ps.setInt(3, custom.getCustom_board_no());

			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public int delete(Connection connection, Custom custom) {
		
		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "DELETE custom_board";
		sql += " WHERE custom_board_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		int res = -1;
		
		try {
			//DB작업
			ps = connection.prepareStatement(sql);
			ps.setInt(1, custom.getCustom_board_no());

			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public int deleteFile(Connection connection, Custom custom) {
		
		//다음 게시글 번호 조회 쿼리
		String sql = "";
		sql += "DELETE custom_board_attachment";
		sql += " WHERE custom_board_no = ?";
		
		//DB 객체
		PreparedStatement ps = null; 
		
		int res = -1;
		
		try {
			//DB작업
			ps = connection.prepareStatement(sql);
			ps.setInt(1, custom.getCustom_board_no());

			res = ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return res;
	}
	
	@Override
	public List<CustomComment> selectComment(Connection connection, Paging paging, Custom viewCustom) {
		
		int board_no = viewCustom.getCustom_board_no();
		
		String sql = ""; //SQL 작성
		sql += "SELECT * FROM (";
	    sql += " SELECT ROWNUM rnum, OC.* FROM (";
	    sql += "     SELECT OC.custom_reply_no, OC.custom_board_no, OC.user_no, U.USER_NICKNAME, OC.custom_reply_content, OC.custom_reply_date";
	    sql += "     FROM custom_reply OC";
	    sql += "     JOIN USER_INFO U ON U.user_no = OC.user_no";
	    sql += "     WHERE custom_board_no = ? ";
	    sql += "	 ORDER BY custom_reply_no ) OC";
	    sql += "   ) custom_reply";
	    sql += " WHERE rnum BETWEEN ? AND ?";
	    
		//결과 저장 리스트
		List<CustomComment> comments = new ArrayList<>();
	    
	    try {
			ps = connection.prepareStatement(sql);
			
			//변수 채우기
			ps.setInt(1, board_no);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				CustomComment comment = new CustomComment();
				comment.setCustom_reply_no(rs.getInt("custom_reply_no"));
				comment.setCustom_board_no(rs.getInt("custom_board_no"));
				comment.setUser_no(rs.getInt("user_no"));
				comment.setUser_nickname(rs.getString("user_nickname"));
				comment.setCustom_reply_content(rs.getString("custom_reply_content"));
				comment.setCustom_reply_date(rs.getDate("custom_reply_date"));
				
				//리스트에 custom 객체로 저장
				comments.add(comment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
	    		
		return comments;
	}
	
	@Override
	public int insertComment(Connection connection, CustomComment customComment) {
		
		String sql = "";
		sql += "INSERT INTO custom_reply(custom_reply_no, custom_board_no, user_no, custom_reply_content, custom_reply_date)";
		sql += " VALUES ( custom_reply_seq.nextval, ?, ?, ?, sysdate)";
		
		int res = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1, customComment.getCustom_board_no());
			ps.setInt(2, customComment.getUser_no());
			ps.setString(3, customComment.getCustom_reply_content());
			
			res = ps.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return res;
	}
	
	@Override
	public int updateComment(Connection connection, CustomComment customComment) {
		
		String sql = "";
		sql += "UPDATE custom_reply SET";
		sql += " custom_reply_content = ?";
		sql += " WHERE custom_reply_no = ?";
		
		//수행결과 변수
		int result = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, customComment.getCustom_reply_content());
			ps.setInt(2, customComment.getCustom_reply_no());
			
			result = ps.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			System.out.println("Update 수행 결과 :" + result);
			JDBCTemplate.close(ps);
		}
		
		return result;
	}
	
	@Override
	public int delete(Connection connection, CustomComment customComment) {
		String sql = "";
		sql += "DELETE FROM custom_reply";
		sql += " WHERE custom_reply_no = ?";
		
		//수행결과 변경된 row num
		int result = 0;

		try {
			ps = connection.prepareStatement(sql);

			ps.setInt(1, customComment.getCustom_reply_no());

			result = ps.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
	}
	
	
}
