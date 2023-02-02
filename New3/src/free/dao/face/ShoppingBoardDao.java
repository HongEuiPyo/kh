package free.dao.face;

import java.sql.Connection;
import java.util.List;

import free.dto.Shopping_board;
import free.util.ShoppingPaging;

public interface ShoppingBoardDao {

	/**
	 * shoppingboard의 전체 데이터를 가지고오는 메소드
	 * 
	 * @param conn - DB 연결 객체
	 * @return - dto타입의 ArrayList로 반환
	 */
	public List<Shopping_board> getList(Connection connection);

	/**
	 * 쇼핑 테이블에서 술과 관련된 list만 찾아 list로 반환
	 * 
	 * @param conn - DB연결 객체
	 * @return - free.dto ArrayList
	 */
	public List<Shopping_board> getAlcholList(Connection conn, ShoppingPaging paging);

	/**
	 * 쇼핑 테이블에서 도구과 관련된 list만 찾아 list로 반환
	 * 
	 * @param conn - DB연결 객체
	 * @return - free.dto ArrayList
	 */
	public List<Shopping_board> getToolList(Connection conn, ShoppingPaging paging);

	/**
	 * 쇼핑 테이블에서 음식과 관련된 list만 찾아 list로 반환
	 * 
	 * @param conn - DB연결 객체
	 * @return - free.dto ArrayList
	 */
	public List<Shopping_board> getFoodList(Connection conn, ShoppingPaging paging);

	/**
	 * category에 해당하는 상품 수를 반환하는 메소드(페이징에 필요)
	 * 
	 * @param connection - DB 연결 객체
	 * @return - 행의 수 반환
	 */
	public int selectCntAll(Connection connection, String category);

	/**
	 * 정렬된 리스트를 반환하는 메소드
	 * 
	 * @param conn - DB연결 객체
	 * @param category - 상품 카테고리
	 * @param col - 정렬 기준
	 * @param orderby - ASC / DESC
	 * @return - 결과 ArrayList
	 */
	public List<Shopping_board> getOrderedListByProductTitle(Connection conn, String category, String col, String orderby);

	/**
	 * 정렬된 리스트를 반환하는 메소드
	 * 
	 * @param conn - DB 연결 객체
	 * @param category - 상품 카테고리
	 * @param col - 정렬 기준
	 * @param orderby - ASC / DESC
	 * @return - 결과 ArrayList
	 */
	public List<Shopping_board> getOrderedListByProducPrice(Connection connection, String category, String col,
			String orderby);

	
	/**
	 * 주어진 키워드를 포함하는 쇼핑 물품 검색 하는 메소드
	 * 
	 * @param conn - DB연결 객체
	 * @param search - 키워드
	 * @return - 결과 ArrayList
	 */
	public List<Shopping_board> getSearch(Connection conn, String search);
	
	
}
