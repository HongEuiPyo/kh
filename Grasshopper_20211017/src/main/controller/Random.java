package main.controller;

import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import custom.dto.Custom;
import custom.service.CustomService;
import custom.service.CustomServiceImpl;
import free.dto.FreeBoard;
import free.service.face.BoardService;
import free.service.impl.BoardServiceImpl;
import official.dto.Official;
import official.service.OfficialService;
import official.service.OfficialServiceImpl;
import util.Paging;

@WebServlet("/random")
public class Random extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private CustomService customService = new CustomServiceImpl();
	private OfficialService officialService = new OfficialServiceImpl();
	private BoardService boardService = new BoardServiceImpl();
	
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   

	   String search = req.getParameter("search");
	   
		//페이징 객체 생성
	   Paging paging = officialService.getPaging(req, search, "all");
	   Paging paging2 = customService.getPaging(req, search, "all");
	   free.util.Paging paging3 = boardService.getPaging(req);
	   
	   List<Official> list = officialService.getList(paging, search, "all");
	   List<Custom> list2 = customService.getList(paging2, search, "all");
	   List<FreeBoard> boardList = boardService.getList(paging3);
	   
	   req.setAttribute("list", list);
	   req.setAttribute("list2", list2);
	   req.setAttribute("boardList",  boardList);
	   
	 //페이징 정보 MODEL값 전달
	 	req.setAttribute("paging", paging);
	 	
	 	//검색어 다시 전달
	 	req.setAttribute("search", search);
	 	
	 	//현재 session에 저장된 key, value모두 출력
	 			Enumeration<String> attributes = req.getSession().getAttributeNames();
	 			while (attributes.hasMoreElements()) {
	 				String attribute = (String) attributes.nextElement();
	 				System.out.println(attribute+" : "+req.getSession().getAttribute(attribute));
	 			}	
	   
	   req.getRequestDispatcher("/WEB-INF/views/total_search.jsp").forward(req, resp);
	   
}
   
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/official/list [POST] -> redirect to doGet");
		doGet(req, resp);
	}

}
