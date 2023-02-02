package singleton;

// 추가 작업(예외 처리)할 수 있도록 단점 보완

public class Singleton_02 {

	public String data = "Apple";
	
	//private 생성자 - 클래스 외부에서 객체 생성 금지
	private Singleton_02() {}
	
	// 자기 클래스에 대한 객체변수 선언
	private static Singleton_02 instance;
	
	//static 블록, 초기화 블록 - 클래스 변수를 초기화할 때 사용한다
	static {
		try {
			
			//싱글톤 객체 생성
			instance = new Singleton_02();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//싱글톤 객체 반환 메소드
	public static Singleton_02 getInstance() {
		return instance;
	}
	
}
