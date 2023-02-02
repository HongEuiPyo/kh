package singleton;

public class Singleton_01 {
	
	// ����
	// 1. �ν��Ͻ��� ������� �ʾƵ� �����س��� �ȴ�

	// 2. �ν��Ͻ��� ������ �� �߰� �ڵ带 �ۼ��� �� ����
	//	-> ����ó�� �Ұ���
	
	
	public String data = "Apple"; //������
	
	//private ������ - Ŭ���� �ܺο��� ��ü������ �� ���� �ȴ�
	private Singleton_01() {}
	
	// �ڽ� Ŭ������ ���� ��ü ����
	private static Singleton_01 instance = new Singleton_01();
	
	//�̱��� ��ü ��ȯ�ϴ� �޼ҵ�
	public static Singleton_01 getInstance() {
		return instance;
	}
	
	
}// class end
