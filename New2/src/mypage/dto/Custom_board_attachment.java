package mypage.dto;

import mypage.dao.impl.MypageDaoImpl;

import java.util.Date;

public class Custom_board_attachment extends MypageDaoImpl {

	
	private int attachment_no;
	private int custom_board_no;
	private String original_file_name;
	private String stored_file_name;
	private int file_size;
	private Date file_date;
	@Override
	public String toString() {
		return "Custom_board_attachment [attachment_no=" + attachment_no + ", custom_board_no=" + custom_board_no
				+ ", original_file_name=" + original_file_name + ", stored_file_name=" + stored_file_name
				+ ", file_size=" + file_size + ", file_date=" + file_date + "]";
	}
	public int getAttachment_no() {
		return attachment_no;
	}
	public void setAttachment_no(int attachment_no) {
		this.attachment_no = attachment_no;
	}
	public int getCustom_board_no() {
		return custom_board_no;
	}
	public void setCustom_board_no(int custom_board_no) {
		this.custom_board_no = custom_board_no;
	}
	public String getOriginal_file_name() {
		return original_file_name;
	}
	public void setOriginal_file_name(String original_file_name) {
		this.original_file_name = original_file_name;
	}
	public String getStored_file_name() {
		return stored_file_name;
	}
	public void setStored_file_name(String stored_file_name) {
		this.stored_file_name = stored_file_name;
	}
	public int getFile_size() {
		return file_size;
	}
	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}
	public Date getFile_date() {
		return file_date;
	}
	public void setFile_date(Date file_date) {
		this.file_date = file_date;
	}
	
	
	
	
}
