package dao.face;

import java.util.List;

import dto.User;

public interface UserDao {

	/**
	 * 전체 조회	
	 * @return 조회된 테이블의 전체 행
	 */
	public List<User> selectAll();
	
	
	/**
	 * 새로운 데이터 삽입
	 * @param insertUser - 삽입되는 User 정보 객체
	 */
	public void insertUser(User insertUser);
	
	
	/**
	 * 지정된 idx의 유저 정보 조회
	 * 
	 * @param idx - 조회하려는 유저 idx
	 * @return 조회된 사용자의 객체, 조회된 데이터가 없으면 null
	 */
	public User selectByIdx(int idx);
	
	
	/**
	 * 주어진 idx를 이용하여 유저 정보를 삭제한다
	 * 
	 * @param idx - 삭제하려는 유저의 idx 번호
	 */
	public void deleteByIdx(int idx);
	
}
