package gson;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dto.Person;


@WebServlet("/gson/test02")
public class GsonTestServlet02 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("/gson/test02 [GET]");
		
		//	�׽�Ʈ�� ��ü ����
		Person p1 = new Person();
		System.out.println( p1 );
		
		//	Gson ��ü
		Gson gson = new Gson();
		
		System.out.println("----------");
		
		//	p1��ü -> JSON�ؽ�Ʈ (������)
		String jsonText = gson.toJson( p1 );
		System.out.println("p1 JSON�ؽ�Ʈ : " + jsonText);
		
		System.out.println("----------");
		
		//	JSON �ؽ�Ʈ -> p2 ��ü (�𸶼���)
		Person p2 = gson.fromJson( jsonText , Person.class);
		System.out.println("p2 ��ü : " + p2);
		
		System.out.println("----------");
		
		//	HashMap<String, Object>Ÿ������ DTO�� ��ü�� �� �ִ�
		HashMap<String, Object> map = new HashMap<>();
		
		map.put("name", "Bob");
		map.put("age", 30);
		map.put("addr","Busan");
		map.put("phone","01012345678");
		
		System.out.println("--- map ---");
		System.out.println( map );	//	JAVA�� MapŸ��
		
		System.out.println("--- JSON �ؽ�Ʈ ---");
		System.out.println( gson.toJson( map ));
		
		
		
	}
	
	
	

}





























