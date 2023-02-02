package member.service.impl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import member.dao.face.ReportDao;
import member.dao.impl.ReportDaoImpl;
import member.dto.Report;
import member.service.face.ReportService;
import member.util.Paging;

public class ReportServiceImpl implements ReportService {
	
	//ReportDao 객체
	private ReportDao reportDao =  new ReportDaoImpl();
	
	@Override
	public Report report(Report report) {
		return reportDao.selectReportByReportNo(JDBCTemplate.getConnection(), report);
	}
	
	@Override
	public List<Report> getList() {
		
		return reportDao.selectAll(JDBCTemplate.getConnection());
		
	}
	
	@Override
	public List<Report> getList(Paging paging) {
		
		return reportDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req) {

		//전달파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[WARNING] curPage값이 null이거나 비어있습니다");
		}
		
		//회원 테이블의 총 게시글 수를 조회한다
		int totalCount = reportDao.selectCntAll(JDBCTemplate.getConnection());
		
		//Paging객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;
	}

	
	
	
}
