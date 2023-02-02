package free.service.face;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import free.dto.ShoppingBoard;

public interface ShoppingService {

	/**
	 * shopping_board의 모든 정보를 가지고 반환하는 메소드
	 * 
	 * @return
	 */
	public List<ShoppingBoard> getList();

	/**
	 * req로 넘어온 category 값에 따른 list목록 반환
	 * 
	 * @param req
	 */
	public List<ShoppingBoard> getList(HttpServletRequest req);
	
}
