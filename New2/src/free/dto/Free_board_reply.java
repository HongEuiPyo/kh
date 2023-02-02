package free.dto;

import free.dao.impl.Free_board_daoImpl;

import java.util.Date;

public class Free_board_reply extends Free_board_daoImpl {
	private int free_reply_no;
	private int free_board_no;
	private int user_no;
	private String user_nickname;
	private String free_reply_content;
	private Date free_reply_date;
	
	@Override
	public String toString() {
		return "FreeReply [free_reply_no=" + free_reply_no + ", free_board_no=" + free_board_no + ", user_no=" + user_no
				+ ", user_nickname=" + user_nickname + ", free_reply_content=" + free_reply_content
				+ ", free_reply_date=" + free_reply_date + "]";
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
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
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
