package custom.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import custom.dto.Custom;
import custom.dto.CustomComment;
import custom.dto.CustomFile;
import custom.service.CustomService;
import custom.service.CustomServiceImpl;
import official.dto.Official;
import official.dto.OfficialComment;
import official.service.OfficialService;
import official.service.OfficialServiceImpl;
import util.Paging;

/**
 * Servlet implementation class OfficialViewController
 */
@WebServlet("/custom/view")
public class CustomViewController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	//서비스 객체 생성
	CustomService customService = new CustomServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/custom/view [GET]");
		
		//전달파라미터 얻기 - custom_board_no
		Custom custom_board_no = customService.getCustom_no(req);
		
		//상세보기 결과 조회
		Custom viewCustom = customService.view(custom_board_no);
		
		//조회결과 MODEL값 전달
		req.setAttribute("viewCustom", viewCustom);
		
		//데이터 값 체크
		System.out.println("viewCustom.getUser_no() : " + viewCustom.getUser_no());
		
		//닉네임 전달
//		req.setAttribute("nick", customService.getNick(viewCustom));
		
		//첨부파일 정보 조회
		CustomFile customFile = customService.viewFile(viewCustom);
		
		//첨부파일 정보 MODEL값 전달
		req.setAttribute("customFile", customFile);
		
		//comment 관련 부분 시작
		//댓글 페이징 객체 생성
		Paging pagingComment = customService.getPaging(req);

		//검색 결과 리스트생성
		List<CustomComment> comments = customService.getComment(pagingComment, viewCustom); // 페이징 정보를 입력하여 조회

		System.out.println("CustomListController [GET] - " + pagingComment);

		//댓글 조회  MODEL결과 전달
		req.setAttribute("comments", comments);
		
		//VIEW 지정 및 응답 - forward
		req.getRequestDispatcher("/WEB-INF/views/board/custom_view.jsp").forward(req, resp);		

	}
	
}
