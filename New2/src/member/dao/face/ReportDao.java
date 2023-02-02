package member.dao.face;

import java.sql.Connection;
import java.util.List;

import member.dto.Report;
import member.util.Paging;

public interface ReportDao {


	/**
	 * reportNo를 이용해 회원정보 조회
	 * 
	 * @param report - 조회할 회원
	 * @return report - 조회된 결과 객체
	 */
	public Report selectReportByReportNo(Connection Conn, Report report);

	public int selectCntAll(Connection conn);

	public Report selectReportByReport_no(Connection Conn, Report report);

	public List<Report> selectAll(Connection connection, Paging paging);

	public List<Report> selectAll(Connection connection);
	
	
}
