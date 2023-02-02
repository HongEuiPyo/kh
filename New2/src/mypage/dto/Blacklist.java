package mypage.dto;

import mypage.dao.impl.MypageDaoImpl;

public class Blacklist extends MypageDaoImpl {

	
	
	private int blacklist_no;
	private String admin_id;
	private int user_no;
	private String blacklist_reason;
	@Override
	public String toString() {
		return "Blacklist [blacklist_no=" + blacklist_no + ", admin_id=" + admin_id + ", user_no=" + user_no
				+ ", blacklist_reason=" + blacklist_reason + "]";
	}
	public int getBlacklist_no() {
		return blacklist_no;
	}
	public void setBlacklist_no(int blacklist_no) {
		this.blacklist_no = blacklist_no;
	}
	public String getAdmin_id() {
		return admin_id;
	}
	public void setAdmin_id(String admin_id) {
		this.admin_id = admin_id;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getBlacklist_reason() {
		return blacklist_reason;
	}
	public void setBlacklist_reason(String blacklist_reason) {
		this.blacklist_reason = blacklist_reason;
	}
	
	
	
	
	
}
