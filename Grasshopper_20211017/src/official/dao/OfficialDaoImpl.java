package official.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import common.JDBCTemplate;
import official.dto.Official;
import official.dto.OfficialComment;
import util.Paging;

public class OfficialDaoImpl implements OfficialDao{
	
	PreparedStatement ps = null; //SQL 수행객체 생성
	ResultSet rs = null; //결과값을 담을 객체 생성
	
	@Override
	public int selectCntAll(Connection connection) {
		
		String sql = "";
		sql += "SELECT count(*) FROM OFFICIALCOCKTAIL";
		
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
		sql += "SELECT count(*) FROM OFFICIALCOCKTAIL";
		sql += " WHERE 1=1 AND";
		sql += "      upper(official_cocktail_name) LIKE upper(?)";
		sql += "    OR upper(official_cocktail_detail) LIKE upper(?)";
		sql += "    OR upper(official_cocktail_ingred) LIKE upper(?)";

		try {
			ps = connection.prepareStatement(sql);

			//변수 채우기
			ps.setString(1, "%" + search + "%");
			ps.setString(2, "%" + search + "%");
			ps.setString(3, "%" + search + "%");

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
		sql += "SELECT count(*) FROM OFFICIALCOCKTAIL";
		sql += " WHERE 1=1 ";
		if( "name".equals(category) ) {
			sql += "    AND upper(official_cocktail_name) LIKE upper(?)";
		} else if ("detail".equals(category) ) {
			sql += "    AND upper(official_cocktail_detail) LIKE upper(?)";
		} else { //if (category == "ingred" )
			sql += "    AND upper(official_cocktail_ingred) LIKE upper(?)";
		} 
		
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
	public List<Official> selectAll(Connection connection, Paging paging) {
		
		String sql = ""; //SQL 작성
		sql += "SELECT * FROM (";
	    sql += " SELECT ROWNUM rnum, O.* FROM (";
	    sql += "    SELECT official_cocktail_no, official_cocktail_name, official_cocktail_detail, official_cocktail_ingred, official_cocktail_vote";
	    sql += "     FROM OFFICIALCOCKTAIL ORDER BY official_cocktail_no ) O";
	    sql += "   ) OFFICIALCOCKTAIL";
	    sql += " WHERE rnum BETWEEN ? AND ?";
	    
		//결과 저장 리스트
		List<Official> officialList = new ArrayList<>();
	    
	    try {
			ps = connection.prepareStatement(sql);
			
			//변수 채우기
			ps.setInt(1, paging.getStartNo());
			ps.setInt(2, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Official official = new Official();
				official.setOfficial_cocktail_no(rs.getInt("official_cocktail_no"));
				official.setOfficial_cocktail_name(rs.getString("official_cocktail_name"));
				official.setOfficial_cocktail_detail(rs.getString("official_cocktail_detail"));
				official.setOfficial_cocktail_ingred(rs.getString("official_cocktail_no"));
				official.setOfficial_cocktail_vote(rs.getInt("official_cocktail_vote"));
				
				//리스트에 official 객체로 저장
				officialList.add(official);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
	    		
		return officialList;
	}
	
	@Override
	public List<Official> selectSearchAll(Connection connection, Paging paging, String search) {
		
		String sql = ""; //SQL 작성
		sql += "SELECT * FROM (";
		sql += "	SELECT ROWNUM rnum, O.* FROM (";
		sql += "		SELECT official_cocktail_no, official_cocktail_name, official_cocktail_detail, official_cocktail_ingred, official_cocktail_vote";	                        
		sql += "		FROM OFFICIALCOCKTAIL";
		sql += "		WHERE 1=1";
		sql += "		AND upper(official_cocktail_name) LIKE upper(?)";
		sql += "		OR upper(official_cocktail_detail) LIKE upper(?)";
		sql += "		OR upper(official_cocktail_ingred) LIKE upper(?)";
		sql += "		ORDER BY official_cocktail_no ) O";
		sql += " 		) OFFICIALCOCKTAIL";
		sql += " WHERE rnum BETWEEN ? AND ?";
		
		//결과 저장 리스트
		List<Official> officialList = new ArrayList<>();
		
		try {
			ps = connection.prepareStatement(sql);
			
			//변수 채우기
			ps.setString(1, "%" + search + "%");
			ps.setString(2, "%" + search + "%");
			ps.setString(3, "%" + search + "%");
			ps.setInt(4, paging.getStartNo());
			ps.setInt(5, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Official official = new Official();
				official.setOfficial_cocktail_no(rs.getInt("official_cocktail_no"));
				official.setOfficial_cocktail_name(rs.getString("official_cocktail_name"));
				official.setOfficial_cocktail_detail(rs.getString("official_cocktail_detail"));
				official.setOfficial_cocktail_ingred(rs.getString("official_cocktail_no"));
				official.setOfficial_cocktail_vote(rs.getInt("official_cocktail_vote"));
				
				//리스트에 official 객체로 저장
				officialList.add(official);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return officialList;
	}
	
	@Override
	public List<Official> selectSearch(Connection connection, Paging paging, String search, String category) {
		
		String sql = ""; //SQL 작성
		sql += "SELECT * FROM (";
		sql += "	SELECT ROWNUM rnum, O.* FROM (";
	    sql += "		SELECT official_cocktail_no, official_cocktail_name, official_cocktail_detail, official_cocktail_ingred, official_cocktail_vote";	                        
	    sql += "		FROM OFFICIALCOCKTAIL";
	    sql += "		WHERE 1=1";
	    if( "name".equals(category) ) {
			sql += "		AND upper(official_cocktail_name) ";
	    } else if ( "detail".equals(category) ) {
			sql += "		AND upper(official_cocktail_detail) ";
	    } else {
			sql += "		AND upper(official_cocktail_ingred) ";
		}
	    sql += " 			LIKE upper(?)";
	    sql += "		ORDER BY official_cocktail_no ) O";
		sql += " 		) OFFICIALCOCKTAIL";
		sql += " WHERE rnum BETWEEN ? AND ?";
	    
		//결과 저장 리스트
		List<Official> officialList = new ArrayList<>();
	    
	    try {
			ps = connection.prepareStatement(sql);
			
			//변수 채우기
			ps.setString(1, "%" + search + "%");
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Official official = new Official();
				official.setOfficial_cocktail_no(rs.getInt("official_cocktail_no"));
				official.setOfficial_cocktail_name(rs.getString("official_cocktail_name"));
				official.setOfficial_cocktail_detail(rs.getString("official_cocktail_detail"));
				official.setOfficial_cocktail_ingred(rs.getString("official_cocktail_no"));
				official.setOfficial_cocktail_vote(rs.getInt("official_cocktail_vote"));
				
				//리스트에 official 객체로 저장
				officialList.add(official);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
	    		
		return officialList;
	}
	
	
	@Override 
	public int updateHit(Connection connection, Official official_no) { // 더미데이터

		//SQL 작성
		String sql = "";
		sql += "UPDATE OFFICIALCOCKTAIL";
		sql += " SET official_cocktail_view = official_cocktail_view + 1";
		sql += " WHERE official_cocktail_no = ?";

		int res = 0;

		try {
			ps = connection.prepareStatement(sql); //SQL수행 객체

			ps.setInt(1, official_no.getOfficial_cocktail_no()); //조회할 게시글 번호 적용

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
	public Official selectOfficialByOfficialno(Connection connection, Official official_no) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT * FROM OFFICIALCOCKTAIL";
		sql += " WHERE official_cocktail_no = ?";

		//결과 저장할 Board객체
		Official viewRecipe = null;

		try {
			ps = connection.prepareStatement(sql); //SQL수행 객체

			ps.setInt(1, official_no.getOfficial_cocktail_no()); //조회할 게시글 번호 적용

			rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장

			//조회 결과 처리
			while(rs.next()) {
				viewRecipe = new Official(); //결과값 저장 객체

				//결과값 한 행 처리
				viewRecipe.setOfficial_cocktail_no(rs.getInt("official_cocktail_no"));
				viewRecipe.setOfficial_cocktail_name(rs.getString("official_cocktail_name"));
				viewRecipe.setOfficial_cocktail_detail(rs.getString("official_cocktail_detail"));
				viewRecipe.setOfficial_cocktail_ingred(rs.getString("official_cocktail_ingred"));
				viewRecipe.setOfficial_cocktail_vote(rs.getInt("official_cocktail_vote"));

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			//DB객체 닫기
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}

		//최종 결과 반환
		return viewRecipe;
	}
	
	@Override
	public List<OfficialComment> selectComment(Connection connection, Paging paging, Official viewOfficial) {
		
		int board_no = viewOfficial.getOfficial_cocktail_no();
		
		String sql = ""; //SQL 작성
		sql += "SELECT * FROM (";
	    sql += " SELECT ROWNUM rnum, OC.* FROM (";
	    sql += "     SELECT OC.official_reply_no, OC.official_board_no, OC.user_no, U.USER_NICKNAME, OC.official_reply_content, OC.official_reply_date";
	    sql += "     FROM official_reply OC";
	    sql += "     JOIN USER_INFO U ON U.user_no = OC.user_no";
	    sql += "     WHERE official_board_no = ? ";
	    sql += "	 ORDER BY official_reply_no ) OC";
	    sql += "   ) official_reply";
	    sql += " WHERE rnum BETWEEN ? AND ?";
	    
		//결과 저장 리스트
		List<OfficialComment> comments = new ArrayList<>();
	    
	    try {
			ps = connection.prepareStatement(sql);
			
			//변수 채우기
			ps.setInt(1, board_no);
			ps.setInt(2, paging.getStartNo());
			ps.setInt(3, paging.getEndNo());
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				OfficialComment comment = new OfficialComment();
				comment.setOfficial_reply_no(rs.getInt("official_reply_no"));
				comment.setOfficial_board_no(rs.getInt("official_board_no"));
				comment.setUser_no(rs.getInt("user_no"));
				comment.setUser_nickname(rs.getString("user_nickname"));
				comment.setOfficial_reply_content(rs.getString("official_reply_content"));
				comment.setOfficial_reply_date(rs.getDate("official_reply_date"));
				
				//리스트에 official 객체로 저장
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
	public int insertComment(Connection connection, OfficialComment officialComment) {
		
		String sql = "";
		sql += "INSERT INTO official_reply(official_reply_no, official_board_no, user_no, official_reply_content, official_reply_date)";
		sql += " VALUES ( official_reply_seq.nextval, ?, ?, ?, sysdate)";
		
		int res = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setInt(1, officialComment.getOfficial_board_no());
			ps.setInt(2, officialComment.getUser_no());
			ps.setString(3, officialComment.getOfficial_reply_content());
			
			res = ps.executeUpdate();			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		return res;
	}
	
	@Override
	public int updateComment(Connection connection, OfficialComment officialComment) {
		
		String sql = "";
		sql += "UPDATE official_reply SET";
		sql += " official_reply_content = ?";
		sql += " WHERE official_reply_no = ?";
		
		//수행결과 변수
		int result = 0;
		
		try {
			ps = connection.prepareStatement(sql);
			
			ps.setString(1, officialComment.getOfficial_reply_content());
			ps.setInt(2, officialComment.getOfficial_reply_no());
			
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
	public int delete(Connection connection, OfficialComment officialComment) {
		String sql = "";
		sql += "DELETE FROM official_reply";
		sql += " WHERE official_reply_no = ?";
		
		//수행결과 변경된 row num
		int result = 0;

		try {
			ps = connection.prepareStatement(sql);

			ps.setInt(1, officialComment.getOfficial_reply_no());

			result = ps.executeUpdate();	
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(ps);
		}
		
		return result;
	}
}
