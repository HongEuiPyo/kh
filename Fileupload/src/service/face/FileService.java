package service.face;

import java.sql.Connection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dto.UploadFile;

public interface FileService {

	/**
	 * ���� ���ε� ó��
	 * 
	 * @param req - HTTP��û ���� ��ü
	 * @param resp - HTTP���� ���� ��ü
	 */
	public void fileupload(HttpServletRequest req, HttpServletResponse resp);
	
	
	/**
	 * ���� ��ü ����� ��ȸ�Ѵ�
	 * 
	 * @return ��ȸ�� ��ü  ���� ���
	 */
	public List<UploadFile> list();
	
	
	/**
	 * ���ε�� ������ ������ �����Ѵ�
	 * 
	 * @param up - ���ε� �� ������ ���� DTO ��ü
	 */
	public void filesave(UploadFile up);
	
	
}
