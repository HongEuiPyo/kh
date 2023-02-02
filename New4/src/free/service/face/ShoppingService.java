package free.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import free.dto.Shopping_board;
import free.util.Paging;
import free.util.ShoppingPaging;


public interface ShoppingService {

	/**
	 * shopping_board의 모든 정보를 가지고 반환하는 메소드
	 * 
	 * @return
	 */
	public List<Shopping_board> getList();

	/**
	 * req로 넘어온 category 값에 따른 list목록 반환
	 * 
	 * @param paging
	 */
	public List<Shopping_board> getList(HttpServletRequest req, ShoppingPaging paging);

	
	/**
	 * shopping board 페이징 메소드
	 * 
	 * @param req - 요청 객체
	 * @return - 페이징 결과 반환
	 */
	public ShoppingPaging getPaging(HttpServletRequest req);

	/**
	 * 선택한 기준으로 order한 dto리스트를 반환하는 메소드
	 * 
	 * @param req - 요청 객체
	 * @return - 정렬된 리스트 반환
	 */
	public List<Shopping_board> getOrderedList(HttpServletRequest req);

	
	/**
	 * 입력한 값을 토대로 검색 결과 list반환
	 * 
	 * @param req - 요청 객체
	 * @return - ArrayList반환값
	 */
	public List<Shopping_board> Search(HttpServletRequest req);

	

	
	
}
