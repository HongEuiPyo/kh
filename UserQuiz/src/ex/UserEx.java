package ex;

import java.util.List;

import dao.face.UserDao;
import dao.impl.UserDaoImpl;
import dto.User;

public class UserEx {

	// DAO ����
//	private UserDao userDao = null; // ���۵ǵ��� �ٲټ���!!
	private static UserDao userDao = new UserDaoImpl(); // ���۵ǵ��� �ٲټ���!!

	public static void main(String[] args) {
		
		//--- ��ü ��� ---
		List<User> list = userDao.selectAll();
		for(User u : list) {
			System.out.println(u);
		}
		//-----------------

		
		
		//--- ���� ���� ---
		// ���� ��ü�� �����ϰ�
		// ���� ������ ��ü�� �Է��ϰ�
		//DB�� ���Եǵ��� �����ϼ���!!
		
		//	** idx -> userTest_SQ.nextval
		//	userId : A123
		//	name : Alice
		
		User insertUser = new User();
		insertUser.setUserid("A123");
		insertUser.setName("Alice");
		
		userDao.insertUser(insertUser);
		//-----------------
		
		
		
		//--- ���� ��ȸ ---
		User selectUser = userDao.selectByIdx(20);
		System.out.println(selectUser);
		//-----------------
		
		
		//--- ���� ���� ---
		userDao.deleteByIdx(20);
				
		// ���� ��ȸ - �����ƴ��� Ȯ���ϴ� �뵵(null���;���)
		User resultUser = userDao.selectByIdx(20);
		System.out.println(resultUser);
		//-----------------
		
	}
	
}
