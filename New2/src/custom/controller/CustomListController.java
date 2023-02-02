package custom.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import custom.dto.Custom;
import custom.service.CustomService;
import custom.service.CustomServiceImpl;
import custom.dto.Custom;
import custom.service.CustomService;
import custom.service.CustomServiceImpl;
import util.Paging;

/**
 * Servlet implementation class CustomSearchController
 */
@WebServlet("/custom/list")
public class CustomListController extends CustomServiceImpl {
	private static final long serialVersionUID = 1L;
     
	CustomService customService = new CustomServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/custom/list [GET]");
		
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
		
		//페이징 객체 생성
		paging = customService.getPaging(req, search, category);
		
		//검색 결과 리스트생성
		List<Custom> list = customService.getList(paging, search, category); // 페이징 정보를 입력하여 조회
		
		System.out.println("CustomListController [GET] - " + paging);
			
		//조회결과 MODEL값 전달
		req.setAttribute("list", list);
		
		//페이징 정보 MODEL값 전달
		req.setAttribute("paging", paging);
		
		//검색어 / 카테고리 다시 전달
		req.setAttribute("search", search);
		req.setAttribute("category", category);
		
		//포워딩
		req.getRequestDispatcher("/WEB-INF/views/board/custom_list.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/custom/list [POST] -> redirect to doGet");
		doGet(req, resp);
	}

}
