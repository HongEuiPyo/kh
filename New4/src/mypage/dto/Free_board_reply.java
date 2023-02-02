package mypage.dto;

import java.util.Date;

public class Free_board_reply {

	
	private int free_reply_no;
	private int free_board_no;
	private int user_no;
	private String free_reply_content;
	private Date free_reply_date;
	
	@Override
	public String toString() {
		return "Free_board_reply [free_reply_no=" + free_reply_no + ", free_board_no=" + free_board_no + ", user_no="
				+ user_no + ", free_reply_content=" + free_reply_content + ", free_reply_date=" + free_reply_date + "]";
	}

	public int getFree_reply_no() {
		return free_reply_no;
	}

	public void setFree_reply_no(int free_reply_no) {
		this.free_reply_no = free_reply_no;
	}

	public int getFree_board_no() {
		return free_board_no;
	}

	public void setFree_board_no(int free_board_no) {
		this.free_board_no = free_board_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getFree_reply_content() {
		return free_reply_content;
	}

	public void setFree_reply_content(String free_reply_content) {
		this.free_reply_content = free_reply_content;
	}

	public Date getFree_reply_date() {
		return free_reply_date;
	}

	public void setFree_reply_date(Date free_reply_date) {
		this.free_reply_date = free_reply_date;
	}
	
	
	
	
	
}
