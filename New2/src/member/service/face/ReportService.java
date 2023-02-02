package member.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import member.dto.Report;
import member.util.Paging;

public interface ReportService {

	public Report report(Report report);
	
	public List<Report> getList();
	
	/**
	 * 페이징 객체 생성
	 * 
	 * 요청파라미터 curPage를 구한다
	 * User_info테이블과 curPage값을 이용하여 Paging객체를 구하여 반환한다
	 * 
	 * @param req
	 * @return
	 */
	public Paging getPaging(HttpServletRequest req);

	/**
	 * 회원 전체 조회
	 * 	페이징 처리 추가
	 * 
	 * @param paging - 페이징 정보 객체
	 * @return List<reportList> - 게시글 전체 조회 결과 리스트
	 */
	public List<Report> getList(Paging paging);

	

	
}
