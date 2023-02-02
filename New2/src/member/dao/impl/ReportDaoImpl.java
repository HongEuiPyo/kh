package member.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import common.JDBCTemplate;
import member.dao.face.ReportDao;
import member.dto.Report;
import member.dto.User_info;
import member.util.Paging;

public class ReportDaoImpl implements ReportDao {

	private PreparedStatement ps = null; //SQL수행 객체
	private ResultSet rs = null; //SQL조회 결과 객체
	
	@Override
	public Report selectReportByReportNo(Connection Conn, Report report) {
		
		
		//SQL 작성
			String sql = "";
			sql += "SELECT * FROM report_board";
			sql += " WHERE 1=1";
			sql += "	AND user_email = ?";
				
			//조회결과를 저장할 객체
			Report result = null;
				
				try {
					ps = Conn.prepareStatement(sql); //SQL수행 객체
					
					ps.setInt(1, report.getReport_no());
					
					rs = ps.executeQuery(); //SQL 수행 및 결과집합 저장
					
					//조회 결과 처리
					while(rs.next()) {
						result = new Report();
						
						result.setReport_no( rs.getInt("report_no") );
						result.setReport_board_link(rs.getString("report_board_link"));
						result.setReport_board_title(rs.getString("report_board_title"));
						result.setReport_board_done(rs.getInt("report_board_done"));
						
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
					//DB객체 닫기
					JDBCTemplate.close(rs);
					JDBCTemplate.close(ps);
				}
				
				//최종 결과 반환
				return result;
	}
	
	@Override
	public int selectCntAll(Connection conn) {
		
		//SQL 작성
		String sql = "";
		sql += "SELECT count(*) FROM Report_board";
		
		//총 게시글 수
		int count = 0;
		
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				count = rs.getInt(1);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(rs);
			JDBCTemplate.close(ps);
		}
		
		return count;
	}

	@Override
	public Report selectReportByReport_no(Connection Conn, Report report) {
		
		return null;
	}

	@Override
	public List<Report> selectAll(Connection connection) {
		return null;
		
	}

	@Override
	public List<Report> selectAll(Connection connection, Paging paging) {
		return null;
	}

	
}
