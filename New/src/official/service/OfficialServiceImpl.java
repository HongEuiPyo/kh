package official.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import common.JDBCTemplate;
import official.dao.OfficialDao;
import official.dao.OfficialDaoImpl;
import official.dto.Official;
import official.dto.OfficialComment;
import util.Paging;

public class OfficialServiceImpl implements OfficialService{
	
	//OfficialDao 객체 생성
	private OfficialDao officialDao = new OfficialDaoImpl();
	
	@Override
	public Paging getPaging(HttpServletRequest req) {
		
		//전달 파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[CAUTION] curPage값이 null 또는 비어있습니다");
		}
		
		//Offical 테이블의 총 데이터 수(레시피 숫자)를 조회
		int totalCount = officialDao.selectCntAll(JDBCTemplate.getConnection());
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;				
	}
	
	@Override
	public Paging getPaging(HttpServletRequest req, String search, String category) {
		//전달 파라미터 curPage 파싱
		String param = req.getParameter("curPage");
		int curPage = 0;
		if(param != null && !"".equals(param)) {
			curPage = Integer.parseInt(param);
		} else {
			System.out.println("[CAUTION] curPage값이 null 또는 비어있습니다");
		}
		
		int totalCount = 0;
		
		//검색어로 검색한 Offical 테이블의 반환 데이터 수(레시피 숫자)를 조회
		if( "all".equals(category) ) {
			totalCount = officialDao.selectCntSearchAll(JDBCTemplate.getConnection(), search);
		} else {
			totalCount = officialDao.selectCntSearch(JDBCTemplate.getConnection(), search, category);
		}
		
		//Paging 객체 생성
		Paging paging = new Paging(totalCount, curPage);
		
		return paging;		
	}
	
	@Override
	public List<Official> getList(Paging paging) {

		return officialDao.selectAll(JDBCTemplate.getConnection(), paging);
	}
	
	@Override
	public List<Official> getList(Paging paging, String search, String category) {
		
		List<Official> list = new ArrayList<>();
		
		if( "all".equals(category)) {
			list = officialDao.selectSearchAll(JDBCTemplate.getConnection(), paging, search);
		} else {
			list = officialDao.selectSearch(JDBCTemplate.getConnection(), paging, search, category);
		}
		
		return list;
	}
	
	@Override
	public Official getOfficial_no(HttpServletRequest req) {
		
		//Official 객체 생성
		Official officialno = new Official();
		
		//officialno 전달 파라미터 검증 - null or ""
		String param = req.getParameter("official_no");
		if(param != null && !"".equals(param)) {
			//official_no 전달 파라미터 추출
			officialno.setOfficial_cocktail_no( Integer.parseInt(param));
		}
		
		//결과 Official 객체 반환
		return officialno;
	}
	
	@Override
	public Official view(Official official_no) {
		
		Connection connection = JDBCTemplate.getConnection();
		
		//[비활성] 조회수 증가 
//		if( officialDao.updateHit(connection, official_no) == 1 ) {
//			JDBCTemplate.commit(connection);
//		} else {
//			JDBCTemplate.rollback(connection);
//		}
		
		//레시피 조회
		Official official = officialDao.selectOfficialByOfficialno(connection, official_no);
		
		return official;
	}
	
	@Override
	public List<OfficialComment> getComment(Paging paging, Official viewOfficial) {
		
		List<OfficialComment> comments = 
			officialDao.selectComment(JDBCTemplate.getConnection(), paging, viewOfficial);
		return comments;
	}
	
	@Override
	public void writeComment(OfficialComment officialComment) {
		System.out.println("writeComment() invoked");
		
		Connection conn = JDBCTemplate.getConnection();
		if( officialDao.insertComment(conn, officialComment) > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
	}
	
	@Override
	public void updateComment(OfficialComment officialComment) {
		
		Connection connection = JDBCTemplate.getConnection();
		
		int result = officialDao.updateComment(connection, officialComment);
		
		//result 결과에 따라 commit, rollback
		if(result == 1) {
			System.out.println("수정 commit");
			JDBCTemplate.commit(connection);
		} else {
			System.out.println("수정 실패");
			JDBCTemplate.rollback(connection);				
		}
		
	}
	
	@Override
	public void deleteComment(OfficialComment officialComment) {
		
		Connection connection = JDBCTemplate.getConnection();
		
		//게시글 데이터 delete
		if( officialDao.delete(connection, officialComment) > 0 ) {
			//게시글 삭제 성공 시
			System.out.println("[DELETE] 댓글 삭제 성공");
			JDBCTemplate.commit(connection);
		} else {
			System.out.println("[ERROR] 댓글 삭제 실패");
			JDBCTemplate.rollback(connection);
		}
	}
		
}
