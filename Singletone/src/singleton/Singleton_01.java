package singleton;

public class Singleton_01 {
	
	// 단점
	// 1. 인스턴스를 사용하지 않아도 생성해놓게 된다

	// 2. 인스턴스를 생성할 때 추가 코드를 작성할 수 없다
	//	-> 예외처리 불가능
	
	
	public String data = "Apple"; //데이터
	
	//private 생성자 - 클래스 외부에서 객체생성할 수 없게 된다
	private Singleton_01() {}
	
	// 자신 클래스에 대한 객체 생성
	private static Singleton_01 instance = new Singleton_01();
	
	//싱글톤 객체 반환하는 메소드
	public static Singleton_01 getInstance() {
		return instance;
	}
	
	
}// class end
