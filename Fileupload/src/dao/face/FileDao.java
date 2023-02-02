package dao.face;

import java.sql.Connection;
import java.util.List;

import dto.ParamData;
import dto.UploadFile;

public interface FileDao {

	/**
	 * �����Ķ���� ������ �����ϱ�
	 * 
	 * @param conn - DB���� ��ü
	 * @param paramData - ������ ���޵����� DTO ��ü
	 * @return ���� ���� ����� (1-���� ����, 0-����)
	 */
	public int insertParam(Connection conn, ParamData paramData);

	/**
	 * ���� ���� ������ �����ϱ�
	 * 
	 * @param conn - DB���� ��ü
	 * @param uploadFile - ������ ���� ���� DTO ��ü
	 * @return ���� ���� ����� (1-���� ����, 0-����)
	 */
	public int insertFile(Connection conn, UploadFile uploadFile);

	List<UploadFile> selectAll(Connection connection);

}

