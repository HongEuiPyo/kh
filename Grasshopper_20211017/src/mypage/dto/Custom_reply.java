package mypage.dto;

import java.util.Date;

public class Custom_reply {

	private int custom_reply_no;
	private int custom_board_no;
	private int user_no;
	private String custom_reply_content;
	private Date comment_date;
	@Override
	public String toString() {
		return "Custom_reply [custom_reply_no=" + custom_reply_no + ", custom_board_no=" + custom_board_no
				+ ", user_no=" + user_no + ", custom_reply_content=" + custom_reply_content + ", comment_date="
				+ comment_date + "]";
	}
	public int getCustom_reply_no() {
		return custom_reply_no;
	}
	public void setCustom_reply_no(int custom_reply_no) {
		this.custom_reply_no = custom_reply_no;
	}
	public int getCustom_board_no() {
		return custom_board_no;
	}
	public void setCustom_board_no(int custom_board_no) {
		this.custom_board_no = custom_board_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getCustom_reply_content() {
		return custom_reply_content;
	}
	public void setCustom_reply_content(String custom_reply_content) {
		this.custom_reply_content = custom_reply_content;
	}
	public Date getComment_date() {
		return comment_date;
	}
	public void setComment_date(Date comment_date) {
		this.comment_date = comment_date;
	}
	
	
	
	
	
	
	
}
