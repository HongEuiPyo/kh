package mypage.dto;

import java.util.Date;

public class Free_board_attachment {

	private int attach_no;
	private int free_board_no;
	private String original_file_name;
	private String stored_file_name;
	private int file_size;
	private Date file_date;

	@Override
	public String toString() {
		return "Free_board_attachment [attach_no=" + attach_no + ", free_board_no=" + free_board_no
				+ ", original_file_name=" + original_file_name + ", stored_file_name=" + stored_file_name
				+ ", file_size=" + file_size + ", file_date=" + file_date + "]";
	}

	public int getAttach_no() {
		return attach_no;
	}

	public void setAttach_no(int attach_no) {
		this.attach_no = attach_no;
	}

	public int getFree_board_no() {
		return free_board_no;
	}

	public void setFree_board_no(int free_board_no) {
		this.free_board_no = free_board_no;
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
