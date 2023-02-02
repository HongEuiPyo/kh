package service.impl;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import common.JDBCTemplate;
import dao.face.FileDao;
import dao.impl.FileDaoImpl;
import dto.ParamData;
import dto.UploadFile;
import service.face.FileService;

public class FileServiceImpl implements FileService {

	//DAO ��ü
	private FileDao fileDao = new FileDaoImpl();
	
	@Override
	public void fileupload(HttpServletRequest req, HttpServletResponse resp) {
		System.out.println("FileService - fileupload()");
		//--------------------------------------------------------
		
		//���䰴ü �����ϱ�
		resp.setContentType("text/html; charset=UTF-8");
		
		//���� ��� ��Ʈ�� ��ü ���
		PrintWriter out = null;
		try {
			out = resp.getWriter();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//--------------------------------------------------------

		//1. ���Ͼ��ε������� �´��� �˻�
		//	-> ��û�޽����� content-type�� multipart/form-data����
		//	 Ȯ���Ѵ�
		
		boolean isMultipart = ServletFileUpload.isMultipartContent(req);
		
		//1-1. multipart/form-data�� �ƴϸ� ���Ͼ��ε� ó�� �ߴ��ϱ�
		if( !isMultipart ) {
			
			out.append("<h1>enctype�� multipart/form-data�� �ƴմϴ�</h1>");
			out.append("<a href='/commons/fileupload'>���ε��������� �̵��ϱ�</a>");
			
			//fileupload()�޼ҵ� �ߴ��ϱ�
			return;
		}
		
		//1-2. multipart/form-data�� ���۵Ǿ��� ��� ���� ó���ϱ�
		//	-> ���� ���ķ� �ۼ��� �ڵ�� ���Ͼ��ε带 ó���ϴ� �ڵ�
		//--------------------------------------------------------

		//2. ���ε�� ������ ó���ϴ� ���������丮 ��ü �����ϱ�
		
		//	FileItem
		//		Ŭ���̾�Ʈ���� ���۵� �����͸� ��ü�� ���� ��
		//		���ʵ�(input�±� ������), ���� ���θ� ��üȭ��Ų��
		
		//	FileItemFactory
		//		���ε�� ������(FileItem)�� ó���ϴ� ���(�����ϴ� ���)�� �����ϴ� Ŭ����
		
		//	DiskFileItemFactory
		//		��ũ(HDD)������� ���Ͼ������� ó���ϴ� ���丮 Ŭ����
		//		���ε�� ������ ��ũ�� �ӽ� �����Ͽ� ó���ϵ��� �Ǿ��ִ�
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		//--------------------------------------------------------
		
		//3. ���ε�� ���Ͼ������� �뷮�� ���������� ������ �޸𸮿��� ó���Ѵ�
		int maxMem = 1 * 1024 * 1024; //1MB
		factory.setSizeThreshold(maxMem);
		
		//4. ���Ͼ������� �뷮�� ���������� ũ�� �ӽ�����(HDDó��)�� ���� ó���Ѵ�
		//	->�ӽ������� ������ ������ ������ �� �ִ�
		
		//�������ؽ�Ʈ ��ü
		ServletContext context = req.getServletContext();
		
		//������ ������(��ġ��) ������ ���� ��ο��� tmp������ ��Ÿ����
		String path = context.getRealPath("tmp");
		
		//tmp���� ��� Ȯ��
		System.out.println(path);
		
		//�ӽ� ���� ���� ��ü
		File tmpRepository = new File(path);
		
		//�ӽ� ���� ���� ����
		tmpRepository.mkdir();
		
		//�ӽ������� �����ϴ� ������ factory��ü�� �����ϱ�
		factory.setRepository(tmpRepository);
		//--------------------------------------------------------
		
		//5. ���Ͼ��ε带 �����ϴ� ��ü ����
		//	-> ���ε�� ������ ���� �뷮�� ������ ���ε�����ʵ��� ���� 

		//���Ͼ��ε带 �����ϴ� ��ü ����
		//	->DiskFileItemFactory��ü�� �����س��� �������� ����Ѵ�
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//�ִ� ���ε� ��� ������
		int maxFile = 10 * 1024 * 1024; //10MB
		
		//���� ���ε� �뷮���� ������ ����
		upload.setFileSizeMax(maxFile);
		//--------------------------------------------------------
		
		//----- ���� ���ε� �غ� �Ϸ� -----
		
		//--------------------------------------------------------
		
		//6. ���ε�� ������ �����ϱ�(�Ľ�)
		//	-> �ӽ� ���� ���ε嵵 ���� ����ȴ�
		
		List<FileItem> items = null;
		
		try {
			//��û��ü(req)�� ����ִ� �����Ķ����(multipart)���� �Ľ��Ѵ�
			//	->�ӽ����Ͼ��ε���� �����
			items = upload.parseRequest(req);
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		
		//���� �Ķ���� Ȯ��
//		for(FileItem item : items) {
//			System.out.println(item);
//		}
		//--------------------------------------------------------

		//7. �Ľ̵�(�����) �����Ķ���� ������ ó���ϱ�
		//	->List<FileItem>��ü�� ���ϰ� ���ʵ嵥���Ͱ� �Ľ̵Ǿ� �������
		
		//	->��û������ 3���� ���� ����ϱ�
		//		1. �� ����(�뷮�� 0�� ����)
		//		2. form-data(���ʵ�, �����Ķ����)
		//		3. ����
		
		//���Ͼ����� �ݺ���
		Iterator<FileItem> iter = items.iterator();
		
		
		//���ʵ� ���޵����͸� ������ DTO ��ü ����
		ParamData paramData = new ParamData();
		
		//�����̸��� ������ DTO ��ü ����
		UploadFile uploadFile = new UploadFile();
		
		while( iter.hasNext() ) {
			
			FileItem item = iter.next();
			
			//--- 1) �� ���Ͽ� ���� ó�� ---
			if( item.getSize() <= 0 ) {
				continue; //�� ������ �����ϰ� ���� FileItemó���� �ѱ��
			}
			
			//--- 2) form-data�� ���� ó�� ---
			if( item.isFormField() ) {
				
				//--- �������� ó�� ��� ---
				//	FormField(form-data)�� key=value ������ ���޵ȴ�
				//
				//	key�� item.getFieldName() �޼ҵ�� ���´�
				//	value�� item.getString() �޼ҵ�� ���´�
				//
				//	** req.getCharacterEncoding("UTF-8"); �ڵ尡 ������� �ʴ´�
				//		-> req.getParameter("key");�� ����� �� �����ϴ� �ڵ�
				//		-> multipart/form-data���ڵ����� ������� �ʴ´�
				//
				//	** item.getString("UTF-8"); ������� ����ؾ� �ѱ� ���ڵ��� ����ȴ�
				//--------------------------
				
				//--- �⺻ ó�� ��� ---
//				out.println("- - - �� �ʵ� - - -<br>");
//				out.println(" Ű: " + item.getFieldName() + "<br>");
//				try {
//					out.println(" ��: " + item.getString("UTF-8") + "<br>" );
//				} catch (UnsupportedEncodingException e) {
//					e.printStackTrace();
//				}
				//----------------------
				
				
				//--- Ű��(�����Ķ������ name)�� ���� ó�� ��� ---
				//	-> ���������� ����� �����͸� DTO��ü�� �����Ѵ�
				
				//Ű �����ϱ�
				String key = item.getFieldName();
				
				//�� �����ϱ�
				String value = null;
				try {
					value = item.getString("UTF-8");
				} catch (UnsupportedEncodingException e1) {
					e1.printStackTrace();
				}
				
				//Ű(name)�� ���� value�����ϱ�
				if( "title".equals(key) ) {
					paramData.setTitle( value );
				} else if( "data1".equals(key) ) {
					paramData.setData1( value );
				} else if( "data2".equals(key) ) {
					paramData.setData2( value );
				}
				//--------------------------------------------------
				
			} //if( item.isFormField() ) end

			
			//--- 3) ���Ͽ� ���� ó�� ---
			if( !item.isFormField() ) {
				
				//--- ���ε�� ������ ó��(����)�ϴ� ��� ---
				//1. ������ �������� ���õ�ũ(HDD)�� �����Ѵ�
				//	������ ������ġ(���)�� DB�� ����Ѵ�
				//
				//2. ���̺��� �÷����� ������ ������ �����Ѵ�
				//	BLOBŸ���� �÷��� ���� ����Ѵ�
				//
				//	**�츮�� 1�� ����� ����Ѵ�
				//-------------------------------------------
				
				
				//-- ���ε�� ������ �̸��� �ð��� �̿��ؼ� �����ϱ� ---
				//	->���ε� ������ ����� �� �ߺ��� �̸��� ������� �ʵ��� �ð��� �̿��� �����Ѵ�
				//
				//	-> "����Ͻú��ʹи���.Ȯ����"�� �����Ѵ�
				
				
				//java.util.Date -> String ��ȯ
				//	-> SimpleDateFormat Ŭ���� �̿�
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
				String rename = sdf.format(new Date());
				
				
				//Ȯ���ڴ� �������� Ȯ���ڷ� ���´�
				String origin = item.getName(); //���������� �̸�
				int dotIdx = origin.lastIndexOf("."); //���ʿ��� ���� ã�� "."�� �ε���
				
				//Ȯ����
				String ext = origin.substring(dotIdx + 1);
				
				
				//������ ������ ������ �̸�
				String stored = rename + "." + ext;
				
				System.out.println("[TEST] ���� ���ϸ� : " + origin);
				System.out.println("[TEST] ����� ���ϸ� : " + stored);
				//------------------------------------------------------
				
				//--- ���ε�� �ӽ������� ���� ����(�����)�� �ű�� ---
				//	-> 1MB���� ������ �޸𸮿� �ӽ������� ����Ǿ�����
				//	-> 1MB�̻� 10MB���� ������ HDD�� �ӽ������� ����Ǿ�����
				
				File uploadFolder = new File(context.getRealPath("upload"));
				uploadFolder.mkdir(); //���� ����
				
				//������ ����� ���� ��ü
				File up = new File(uploadFolder, stored);
				
				try {
					item.write(up); //���� ���ε�(�ӽ������� ����������Ϸ� ������)
					item.delete(); //�ӽ������� ����
					
				} catch (Exception e) {
					e.printStackTrace();
				}
				//------------------------------------------------------				
				
				
				//--- ���ε�� ������ ������ DTO��ü�� �����ϱ� ---
				uploadFile.setOriginName(origin);
				uploadFile.setStoredName(stored);
				//-------------------------------------------------
				
			} //if( !item.isFormField() ) end
			
		} //while( iter.hasNext() ) end
		
		System.out.println("[TEST] " + paramData);
		System.out.println("[TEST] " + uploadFile);

		
		//--- DB�� ���� ������ �����ϱ� ---
		Connection conn = JDBCTemplate.getConnection();
		
		int res = 0;
		
		//�Ķ���� ������ ����
		res = fileDao.insertParam(conn, paramData);
		if( res > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		
		//���� ������ ����
		res = fileDao.insertFile(conn, uploadFile);
		if( res > 0 ) {
			JDBCTemplate.commit(conn);
		} else {
			JDBCTemplate.rollback(conn);
		}
		//---------------------------------		
		
	} //fileupload() end
	
	@Override
	public List<UploadFile> list() {
	
		return fileDao.selectAll(JDBCTemplate.getConnection());
	}

	
	@Override
	public void filesave(UploadFile up) {
	
		int result = fileDao.insertFile(JDBCTemplate.getConnection(), up);
		
		if( result > 0 ) {
			JDBCTemplate.commit(JDBCTemplate.getConnection());
		} else {
			JDBCTemplate.rollback(JDBCTemplate.getConnection());
		}
		
	}
	
	
	
}

















