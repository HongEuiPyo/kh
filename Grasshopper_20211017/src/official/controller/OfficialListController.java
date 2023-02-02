package official.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import official.dto.Official;
import official.service.OfficialService;
import official.service.OfficialServiceImpl;
import util.Paging;

/**
 * Servlet implementation class OfficialSearchController
 */
@WebServlet("/official/list")
public class OfficialListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	OfficialService officialService = new OfficialServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/official/list [GET]");
		
		Paging paging;
		
		//검색어 전달받기
		String category = req.getParameter("category");
		String search = req.getParameter("search");
				
		System.out.println("category : " + category);
		System.out.println("search : " + search);
		
		//main으로 진입할 경우 category와 search가 null일 경우 대비하여 default값 입력
		if(category == null ) {
			category = "all";
			search = "";
		}
		
		System.out.println("수정 후 파라미터 : [ " + category + " ], [ " + search + " ]");
		
		//get 메소드로 넘어온 파라미터확인
//		System.out.println("[TEST] search(get) : " + search);
		
//		List<Official> list = officialService.getList(paging, search); // 페이징 정보를 입력하여 조회
				
		//요청 파라미터를 전달하여 paging 객체생성
//		paging = officialService.getPaging(req);
//		list = officialService.getList(paging); // 페이징 정보를 입력하여 조회
		
		//페이징 객체 생성
		paging = officialService.getPaging(req, search, category);
		
		//검색 결과 리스트생성
		List<Official> list = officialService.getList(paging, search, category); // 페이징 정보를 입력하여 조회
		
		System.out.println("OfficialListController [GET] - " + paging);
			
		//조회결과 MODEL값 전달
		req.setAttribute("list", list);
		
		//페이징 정보 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//검색어 / 카테고리 다시 전달
		req.setAttribute("search", search);
		req.setAttribute("category", category);
		
		//현재 session에 저장된 key, value모두 출력
		Enumeration<String> attributes = req.getSession().getAttributeNames();
		while (attributes.hasMoreElements()) {
			String attribute = (String) attributes.nextElement();
			System.out.println(attribute+" : "+req.getSession().getAttribute(attribute));
		}	
		
		//포워딩
		req.getRequestDispatcher("/WEB-INF/views/board/official_list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/official/list [POST] -> redirect to doGet");
		doGet(req, resp);
	}

}
