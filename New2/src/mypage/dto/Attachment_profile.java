package mypage.dto;

import mypage.dao.impl.MypageDaoImpl;

public class Attachment_profile extends MypageDaoImpl {

	
	private int profile_no;
	private int user_no;
	private String profile_name;
	
	@Override
	public String toString() {
		return "Attachment_profile [profile_no=" + profile_no + ", user_no=" + user_no + ", profile_name="
				+ profile_name + "]";
	}

	public int getProfile_no() {
		return profile_no;
	}

	public void setProfile_no(int profile_no) {
		this.profile_no = profile_no;
	}

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getProfile_name() {
		return profile_name;
	}

	public void setProfile_name(String profile_name) {
		this.profile_name = profile_name;
	}
	
	
	
}
